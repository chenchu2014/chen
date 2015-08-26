package cn.edu.bit.communicate;

import cn.edu.bit.controller.ControlController;
import cn.edu.bit.model.*;
import cn.edu.bit.repository.*;
import cn.edu.bit.util.BeanUtils;
import cn.edu.bit.util.DataTypeConverter;
import cn.edu.bit.util.DateTimeUtil;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.nio.ByteBuffer;


/**
 * Created by chu on 2015/5/28.
 */

public class CommService extends Thread {

    private Socket socket;

    /*
        mysql repository
     */
    private LogEntityRepository logEntityRepository;
    private AddressInfoEntityRepository addressInfoEntityRepository;
    private Ade7758ContinousEntityRepository ade7758ContinousEntityRepository;
    private Ade7758DotEntityRepository ade7758DotEntityRepository;
    private InteliTableContinousEntityRepository inteliTableContinousEntityRepository;
    private InteliTableDotEntityRepository inteliTableDotEntityRepository;
    private ControlController controlController;

    /*
        redis repository
     */
//    private DotDataRedisDao dotDataRedisDao;
//    private StreamDataRedisDao streamDataRedisDao;

    public CommService(Socket socket) {
        this.socket = socket;
        this.logEntityRepository = (LogEntityRepository) BeanUtils.getApplicationContext().getBean("logEntityRepository");
        this.addressInfoEntityRepository = (AddressInfoEntityRepository) BeanUtils.getApplicationContext().getBean("addressInfoEntityRepository");
        this.ade7758ContinousEntityRepository = (Ade7758ContinousEntityRepository) BeanUtils.getApplicationContext().getBean("ade7758ContinousEntityRepository");
        this.ade7758DotEntityRepository = (Ade7758DotEntityRepository) BeanUtils.getApplicationContext().getBean("ade7758DotEntityRepository");
        this.inteliTableContinousEntityRepository = (InteliTableContinousEntityRepository) BeanUtils.getApplicationContext().getBean("inteliTableContinousEntityRepository");
        this.inteliTableDotEntityRepository = (InteliTableDotEntityRepository) BeanUtils.getApplicationContext().getBean("inteliTableDotEntityRepository");

        this.controlController = (ControlController) BeanUtils.getApplicationContext().getBean("controlController");
    }

    public void run() {

        try {
            socket.setSoTimeout(30000);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        byte[] buffer = new byte[4000];
        String timestramp = DateTimeUtil.getDateTime();

        while (true) {
            try {
                int length = socket.getInputStream().read(buffer);
                dataProcessing(buffer, length, timestramp);
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    @Transactional
    public void dataProcessing(byte[] buffer, int length, String timestramp) {

        ByteBuffer byteBuffer = ByteBuffer.allocate(4000);
        byteBuffer.put(buffer);
        byteBuffer.flip();

        if (length < 4 || byteBuffer.getInt(0) != 0xaabbccdd) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }

        int address;
        String type;

        LogEntity logEntity;

        int index = 0;

        switch (length) {
            case 516:
                int data_type = DataTypeConverter.convertUnsignedShort2Int(byteBuffer.get(6),
                        byteBuffer.get(7));
                switch (data_type) {
                    case 41001:
                        type = "ADE7758-位移";
                        break;
                    case 41251:
                        type = "ADE7758-载荷";
                        break;
                    case 41501:
                        type = "ADE7758-电流";
                        break;
                    case 42251:
                        type = "ADE7758-加速度x";
                        break;
                    case 42501:
                        type = "ADE7758-加速度y";
                        break;
                    case 42751:
                        type = "智能电表-位移";
                        break;
                    case 43001:
                        type = "智能电表-载荷";
                        break;
                    case 43251:
                        type = "智能电表-电流";
                        break;
                    case 44001:
                        type = "智能电表-加速度x";
                        break;
                    case 44251:
                        type = "智能电表-加速度y";
                        break;
                    default:
                        return;
                }

                address = (int) byteBuffer.get(4);


                String data = "";
                for (int j = 0; j < 250; j++) {
                    data += byteBuffer.getShort(10 + j * 2) + ",";
                }
                byteBuffer.clear();

                if (data_type == 41001 || data_type == 41251 || data_type == 41501 || data_type == 42501 || data_type == 42251) {

                    Ade7758ContinousEntity ade7758ContinousEntity = new Ade7758ContinousEntity();
                    ade7758ContinousEntity.setAddress(address);
                    ade7758ContinousEntity.setData(data);
                    ade7758ContinousEntity.setType(type);
                    ade7758ContinousEntity.setTimestramp(timestramp);
                    ade7758ContinousEntityRepository.save(ade7758ContinousEntity);

                    logEntity = new LogEntity();
                    logEntity.setAddress(address);
                    logEntity.setTimestramp(timestramp);
                    logEntity.setType(type);
                    logEntity.setMessage("成功");
                    logEntityRepository.save(logEntity);

                } else {
                    InteliTableContinousEntity inteliTableContinousEntity = new InteliTableContinousEntity();
                    inteliTableContinousEntity.setAddress(address);
                    inteliTableContinousEntity.setData(data);
                    inteliTableContinousEntity.setType(type);
                    inteliTableContinousEntity.setTimestramp(timestramp);
                    inteliTableContinousEntityRepository.save(inteliTableContinousEntity);

                    logEntity = new LogEntity();
                    logEntity.setAddress(address);
                    logEntity.setTimestramp(timestramp);
                    logEntity.setType(type);
                    logEntity.setMessage("成功");
                    logEntityRepository.save(logEntity);
                }
                break;

            case 1016:
                address = (int) byteBuffer.get(4);

                data = "";
                for (int j = 0; j < 250; j++) {
                    data += byteBuffer.getInt(10 + j * 4) + ",";
                }

                if (DataTypeConverter.convertUnsignedShort2Int(byteBuffer.get(6),
                        byteBuffer.get(7)) == 41751) {

                    Ade7758ContinousEntity ade7758ContinousEntity = new Ade7758ContinousEntity();
                    ade7758ContinousEntity.setAddress(address);
                    ade7758ContinousEntity.setType("ADE7758-有功功率");
                    ade7758ContinousEntity.setTimestramp(timestramp);
                    ade7758ContinousEntity.setData(data);
                    ade7758ContinousEntityRepository.save(ade7758ContinousEntity);

                    logEntity = new LogEntity();
                    logEntity.setAddress(address);
                    logEntity.setMessage("成功");
                    logEntity.setTimestramp(timestramp);
                    logEntity.setType("ADE7758-有功功率");
                    logEntityRepository.save(logEntity);

                } else if (DataTypeConverter.convertUnsignedShort2Int(byteBuffer.get(6),
                        byteBuffer.get(7)) == 43501) {

                    InteliTableContinousEntity inteliTableContinousEntity = new InteliTableContinousEntity();
                    inteliTableContinousEntity.setAddress(address);
                    inteliTableContinousEntity.setType("智能电表-有功功率");
                    inteliTableContinousEntity.setTimestramp(timestramp);
                    inteliTableContinousEntity.setData(data);
                    inteliTableContinousEntityRepository.save(inteliTableContinousEntity);

                    logEntity = new LogEntity();
                    logEntity.setAddress(address);
                    logEntity.setMessage("成功");
                    logEntity.setTimestramp(timestramp);
                    logEntity.setType("智能电表-有功功率");
                    logEntityRepository.save(logEntity);
                }
                break;

            case 106:
                boolean isInteliTable = false;
                if (byteBuffer.get(7) == (byte) 0xf3)
                    isInteliTable = true;
                else if (byteBuffer.get(7) == (byte) 0x9f) ;
                else
                    return;

                address = (int) byteBuffer.get(4);

                index = 10;
                if (!isInteliTable) {
                    Ade7758DotEntity ade7758DotEntity = new Ade7758DotEntity();

                    ade7758DotEntity.setAddress(address);
                    ade7758DotEntity.setTimestramp(timestramp);

                    ade7758DotEntity.setCurrenta((int) byteBuffer.getShort(index));
                    index += 2;
                    ade7758DotEntity.setCurrentb((int) byteBuffer.getShort(index));
                    index += 2;
                    ade7758DotEntity.setCurrentc((int) byteBuffer.getShort(index));
                    index += 2;


                    ade7758DotEntity.setVoltagea((int) byteBuffer.getShort(index));
                    index += 2;
                    ade7758DotEntity.setVoltageb((int) byteBuffer.getShort(index));
                    index += 2;
                    ade7758DotEntity.setVoltagec((int) byteBuffer.getShort(index));
                    index += 2;

                    ade7758DotEntity.setActivePower1(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setActivePower2(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setActivePower3(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setActivePower4(byteBuffer.getInt(index));
                    index += 4;

                    ade7758DotEntity.setReactivePower1(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setReactivePower2(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setReactivePower3(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setReactivePower4(byteBuffer.getInt(index));
                    index += 4;

                    ade7758DotEntity.setApparentPower1(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setApparentPower2(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setApparentPower3(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setApparentPower4(byteBuffer.getInt(index));
                    index += 4;


                    ade7758DotEntity.setPowerfactor1((int) byteBuffer.getShort(index));
                    index += 2;
                    ade7758DotEntity.setPowerfactor2((int) byteBuffer.getShort(index));
                    index += 2;
                    ade7758DotEntity.setPowerfactor3((int) byteBuffer.getShort(index));
                    index += 2;
                    ade7758DotEntity.setPowerfactor4((int) byteBuffer.getShort(index));
                    index += 2;

                    ade7758DotEntity.setPositiveActiveEnergy(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setReverseActiveEnergy(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setPositiveReactiveEnergy(byteBuffer.getInt(index));
                    index += 4;
                    ade7758DotEntity.setReverseReactiveEnergy(byteBuffer.getInt(index));

                    ade7758DotEntityRepository.save(ade7758DotEntity);

                    logEntity = new LogEntity();
                    logEntity.setTimestramp(timestramp);
                    logEntity.setAddress(address);
                    logEntity.setType("ADE7758-点数据");
                    logEntity.setMessage("成功");
                    logEntityRepository.save(logEntity);

//                    版本更新

                    byte[] version_bytes = new byte[6];
                    for (index = 94; index < 100; index++)
                        version_bytes[index - 94] = byteBuffer.get(index);
                    String verision = new String(version_bytes);

                    AddressInfoEntity addressInfoEntity = new AddressInfoEntity();
                    addressInfoEntity.setAddress(address);
                    addressInfoEntity.setLastTime(timestramp);
                    addressInfoEntity.setVersion(verision);

                    addressInfoEntityRepository.save(addressInfoEntity);

                    ByteBuffer returnByteBuffer;

                    String softwareUpdateVersion = controlController.getSoftwareUpdateVersion();
                    byte[] softwareUpdateFile = controlController.getSoftwareUpdateFile();

                    if (softwareUpdateFile != null && !verision.equals(softwareUpdateVersion)) {
                        returnByteBuffer = ByteBuffer.allocate(20 * 1024);

                        returnByteBuffer.putInt(0xaabbccdd).putInt(1).putInt(softwareUpdateFile.length)
                                .put(softwareUpdateFile);

                        returnByteBuffer.put((byte) 0xaa);
                        returnByteBuffer.put((byte) 0xbb);

                    } else {
                        returnByteBuffer = ByteBuffer.allocate(8);
                        returnByteBuffer.putInt(0xaabbccdd).putInt(0);
                    }

                    try {
                        socket.getOutputStream().write(returnByteBuffer.array(), 0, returnByteBuffer.position());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else {
                    InteliTableDotEntity inteliTableDotEntity = new InteliTableDotEntity();

                    inteliTableDotEntity.setAddress(address);
                    inteliTableDotEntity.setTimestramp(timestramp);

                    inteliTableDotEntity.setCurrenta((int) byteBuffer.getShort(index));
                    index += 2;
                    inteliTableDotEntity.setCurrentb((int) byteBuffer.getShort(index));
                    index += 2;
                    inteliTableDotEntity.setCurrentc((int) byteBuffer.getShort(index));
                    index += 2;


                    inteliTableDotEntity.setVoltagea((int) byteBuffer.getShort(index));
                    index += 2;
                    inteliTableDotEntity.setVoltageb((int) byteBuffer.getShort(index));
                    index += 2;
                    inteliTableDotEntity.setVoltagec((int) byteBuffer.getShort(index));
                    index += 2;

                    inteliTableDotEntity.setActivePower1(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setActivePower2(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setActivePower3(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setActivePower4(byteBuffer.getInt(index));
                    index += 4;

                    inteliTableDotEntity.setReactivePower1(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setReactivePower2(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setReactivePower3(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setReactivePower4(byteBuffer.getInt(index));
                    index += 4;

                    inteliTableDotEntity.setApparentPower1(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setApparentPower2(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setApparentPower3(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setApparentPower4(byteBuffer.getInt(index));
                    index += 4;


                    inteliTableDotEntity.setPowerfactor1((int) byteBuffer.getShort(index));
                    index += 2;
                    inteliTableDotEntity.setPowerfactor2((int) byteBuffer.getShort(index));
                    index += 2;
                    inteliTableDotEntity.setPowerfactor3((int) byteBuffer.getShort(index));
                    index += 2;
                    inteliTableDotEntity.setPowerfactor4((int) byteBuffer.getShort(index));
                    index += 2;

                    inteliTableDotEntity.setPositiveActiveEnergy(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setReverseActiveEnergy(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setPositiveReactiveEnergy(byteBuffer.getInt(index));
                    index += 4;
                    inteliTableDotEntity.setReverseReactiveEnergy(byteBuffer.getInt(index));
                    inteliTableDotEntityRepository.save(inteliTableDotEntity);

                    logEntity = new LogEntity();
                    logEntity.setTimestramp(timestramp);
                    logEntity.setAddress(address);
                    logEntity.setType("智能电表-点数据");
                    logEntity.setMessage("成功");
                    logEntityRepository.save(logEntity);
                }
                break;

            default:
                logEntity = new LogEntity();
                logEntity.setAddress(0);
                logEntity.setTimestramp(timestramp);
                logEntity.setType("无");
                logEntity.setMessage("包长度错误:" + length);
                logEntityRepository.save(logEntity);
        }
    }
}

