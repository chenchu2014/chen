package cn.edu.bit.controller;

import cn.edu.bit.model.*;
import cn.edu.bit.repository.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


/**
 * Created by 初 on 2015/8/20.
 */

@Controller
public class ControlController {

    @Autowired
    private Ade7758DotEntityRepository ade7758DotEntityRepository;

    @Autowired
    private LogEntityRepository logEntityRepository;

    @Autowired
    private InteliTableDotEntityRepository inteliTableDotEntityRepository;

    @Autowired
    private Ade7758ContinousEntityRepository ade7758ContinousEntityRepository;

    @Autowired
    private InteliTableContinousEntityRepository inteliTableContinousEntityRepository;

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private AddressInfoEntityRepository addressInfoEntityRepository;

    private byte[] softwareUpdateFile;
    private String softwareUpdateVersion;

    @ResponseBody
    @RequestMapping(value = "/findAde7758DotData.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findAde7758DotData(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<Ade7758DotEntity> page = null;

        try {
            if (isAddress(search)) {
                int address = Integer.parseInt(search);
                page = ade7758DotEntityRepository.findByAddress(address, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
            } else {
                page = ade7758DotEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
            }

            assert page != null;
            List<Ade7758DotEntity> content = page.getContent();

            JSONArray jsonArray = new JSONArray();
            Map<String, String> map = new HashMap<>();
            for (Ade7758DotEntity ade7758DotEntity : content) {
                map.put("address", "" + ade7758DotEntity.getAddress());
                map.put("timestramp", "" + ade7758DotEntity.getTimestramp());
                map.put("current", "" + ade7758DotEntity.getCurrenta() + "， " + ade7758DotEntity.getCurrentb() + "， " + ade7758DotEntity.getCurrentc());
                map.put("voltage", "" + ade7758DotEntity.getVoltagea() + "， " + ade7758DotEntity.getVoltageb() + "， " + ade7758DotEntity.getVoltagec());
                map.put("activePower", "" + ade7758DotEntity.getActivePower1() + "， " + ade7758DotEntity.getActivePower2() + "， " + ade7758DotEntity.getActivePower3() + "， " + ade7758DotEntity.getActivePower4());
                map.put("reactivePower", "" + ade7758DotEntity.getReactivePower1() + "， " + ade7758DotEntity.getReactivePower2() + "， " + ade7758DotEntity.getReactivePower3() + "， " + ade7758DotEntity.getReactivePower4());
                map.put("apparentPower", "" + ade7758DotEntity.getApparentPower1() + "， " + ade7758DotEntity.getApparentPower2() + "， " + ade7758DotEntity.getApparentPower3() + "， " + ade7758DotEntity.getApparentPower4());
                map.put("powerfactor", "" + ade7758DotEntity.getPowerfactor1() + "， " + ade7758DotEntity.getPowerfactor2() + "， " + ade7758DotEntity.getPowerfactor3() + "， " + ade7758DotEntity.getPowerfactor4());
                map.put("positiveActiveEnergy", ade7758DotEntity.getPositiveActiveEnergy() + "");
                map.put("reverseActiveEnergy", ade7758DotEntity.getReverseActiveEnergy() + "");
                map.put("positiveReactiveEnergy", ade7758DotEntity.getPositiveReactiveEnergy() + "");
                map.put("reverseReactiveEnergy", ade7758DotEntity.getReverseReactiveEnergy() + "");

                jsonArray.add(map);
            }
            result.put("rows", jsonArray);
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findInteliTableDotData.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findInteliTableDotData(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        try {
            Page<InteliTableDotEntity> page;

            if (isAddress(search)) {
                int address = Integer.parseInt(search);
                page = inteliTableDotEntityRepository.findByAddress(address, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
            } else {
                page = inteliTableDotEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
            }

            assert page != null;
            List<InteliTableDotEntity> content = page.getContent();

            JSONArray jsonArray = new JSONArray();
            Map<String, String> map = new HashMap<>();
            for (InteliTableDotEntity inteliTableDotEntity : content) {
                map.put("address", "" + inteliTableDotEntity.getAddress());
                map.put("timestramp", "" + inteliTableDotEntity.getTimestramp());
                map.put("current", "" + inteliTableDotEntity.getCurrenta() + "， " + inteliTableDotEntity.getCurrentb() + "， " + inteliTableDotEntity.getCurrentc());
                map.put("voltage", "" + inteliTableDotEntity.getVoltagea() + "， " + inteliTableDotEntity.getVoltageb() + "， " + inteliTableDotEntity.getVoltagec());
                map.put("activePower", "" + inteliTableDotEntity.getActivePower1() + "， " + inteliTableDotEntity.getActivePower2() + "， " + inteliTableDotEntity.getActivePower3() + "， " + inteliTableDotEntity.getActivePower4());
                map.put("reactivePower", "" + inteliTableDotEntity.getReactivePower1() + "， " + inteliTableDotEntity.getReactivePower2() + "， " + inteliTableDotEntity.getReactivePower3() + "， " + inteliTableDotEntity.getReactivePower4());
                map.put("apparentPower", "" + inteliTableDotEntity.getApparentPower1() + "， " + inteliTableDotEntity.getApparentPower2() + "， " + inteliTableDotEntity.getApparentPower3() + "， " + inteliTableDotEntity.getApparentPower4());
                map.put("powerfactor", "" + inteliTableDotEntity.getPowerfactor1() + "， " + inteliTableDotEntity.getPowerfactor2() + "， " + inteliTableDotEntity.getPowerfactor3() + "， " + inteliTableDotEntity.getPowerfactor4());
                map.put("positiveActiveEnergy", inteliTableDotEntity.getPositiveActiveEnergy() + "");
                map.put("reverseActiveEnergy", inteliTableDotEntity.getReverseActiveEnergy() + "");
                map.put("positiveReactiveEnergy", inteliTableDotEntity.getPositiveReactiveEnergy() + "");
                map.put("reverseReactiveEnergy", inteliTableDotEntity.getReverseReactiveEnergy() + "");

                jsonArray.add(map);
            }
            result.put("rows", jsonArray);
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findCommLogData.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findCommLogData(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<LogEntity> page = null;

        try {
            if (search != null) {
                Integer address = null;
                String type = null;

                String[] searches = search.split("，");
                for (String searchStr : searches) {
                    if (isAddress(searchStr)) {
                        address = Integer.parseInt(searchStr);
                    } else if (isAde7758Type(searchStr) || isInteliTableType(searchStr)) {
                        type = searchStr;
                    }
                }

                if (address != null && type != null) {
                    page = logEntityRepository.findByAddressAndType(address, type, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else if (address != null) {
                    page = logEntityRepository.findByAddress(address, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else if (type != null) {
                    page = logEntityRepository.findByType(type, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else {
                    page = logEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                }
            } else {
                page = logEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
            }
            assert page != null;
            result.put("rows", page.getContent());
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findAde7758ContinousData.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findAde7758ContinousData(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<Ade7758ContinousEntity> page = null;

        try {
            if (search != null) {
                Integer address = null;
                String type = null;

                String[] searches = search.split("，");
                for (String searchStr : searches) {
                    if (isAddress(searchStr)) {
                        address = Integer.parseInt(searchStr);
                    } else if (isAde7758Type(searchStr)) {
                        type = searchStr;
                    }
                }


                if (address != null && type != null) {
                    page = ade7758ContinousEntityRepository.findByAddressAndType(address, type, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else if (address != null) {
                    page = ade7758ContinousEntityRepository.findByAddress(address, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else if (type != null) {
                    page = ade7758ContinousEntityRepository.findByType(type, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else {
                    page = ade7758ContinousEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                }
            } else {
                page = ade7758ContinousEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
            }

            assert page != null;
            result.put("rows", page.getContent());
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    @ResponseBody
    @RequestMapping(value = "/findinteliTableContinousData.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findinteliTableContinousData(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<InteliTableContinousEntity> page = null;

        try {
            if (search != null) {

                Integer address = null;
                String type = null;

                String[] searches = search.split("，");
                for (String searchStr : searches) {
                    if (isAddress(searchStr)) {
                        address = Integer.parseInt(searchStr);
                    } else if (isInteliTableType(searchStr)) {
                        type = searchStr;
                    }
                }

                if (address != null && type != null) {
                    page = inteliTableContinousEntityRepository.findByAddressAndType(address, type, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else if (address != null) {
                    page = inteliTableContinousEntityRepository.findByAddress(address, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else if (type != null) {
                    page = inteliTableContinousEntityRepository.findByType(type, new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                } else {
                    page = inteliTableContinousEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
                }
            } else {
                page = inteliTableContinousEntityRepository.findAll(new PageRequest(offset / limit, limit, new Sort(Sort.Direction.DESC, "timestramp")));
            }
            assert page != null;
            result.put("rows", page.getContent());
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findUsers.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findUsers(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<MyUserEntity> page = null;

        try {
            page = myUserRepository.findByRole("ROLE_USER", new PageRequest(offset / limit, limit));
            result.put("rows", page.getContent());
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findInteliTableShifts.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findInteliTableShifts(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<InteliTableContinousEntity> page = null;

        try {
            page = inteliTableContinousEntityRepository.findByType("智能电表-位移", new PageRequest(offset / limit, limit));
            result.put("rows", page.getContent());
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findInteliTablePayload.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findInteliTablePayload(Integer address, String timestramp) {
        JSONObject result = new JSONObject();
        try {
            result.put("payload", inteliTableContinousEntityRepository.findByAddressAndTimestrampAndType(address, timestramp, "智能电表-载荷"));
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findAde7758Info.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findAde7758Info(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<AddressInfoEntity> page;
        try {
            page = addressInfoEntityRepository.findOrderByLastTimeDesc(new PageRequest(offset / limit, limit));
            result.put("rows", page.getContent());
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/findAde7758Shifts.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
    public String findAde7758Shifts(Integer offset, Integer limit, String search) {
        JSONObject result = new JSONObject();
        Page<Ade7758ContinousEntity> page = null;

        try {
            page = ade7758ContinousEntityRepository.findByType("ADE7758-位移", new PageRequest(offset / limit, limit));
            result.put("rows", page.getContent());
            result.put("total", page.getTotalElements());
            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/clearSoftwareFile.do", method = RequestMethod.GET)
    public void clearSoftwareFile() {
        softwareUpdateFile = null;
        softwareUpdateVersion = null;
    }

    @ResponseBody
    @RequestMapping(value = "/getSoftwareInfo.do", method = RequestMethod.GET)
    public String getSoftwareVersion() {
        JSONObject result = new JSONObject();
        if (softwareUpdateFile != null)
            result.put("size", softwareUpdateFile.length);
        else
            result.put("size", null);
        result.put("version", softwareUpdateVersion);
        return result.toString();
    }

    @RequestMapping(value = "/ade7758SoftwareFileUpload.do", method = RequestMethod.POST)
    public ModelAndView ade7758SoftwareFileUpload(MultipartFile software, ModelAndView modelAndView) {
        if (software != null) {
            Pattern pattern = Pattern.compile("^\\d{6}\\.bin");
            if (pattern.matcher(software.getOriginalFilename()).matches()) {
                try {
                    softwareUpdateFile = software.getBytes();
                } catch (IOException e) {
                    e.printStackTrace();
                    modelAndView.setViewName("template/control/software-update-result-error");
                    return modelAndView;
                }
                softwareUpdateVersion = software.getOriginalFilename().split("\\.")[0];
                modelAndView.setViewName("template/control/software-update-result-success");
            } else {
                modelAndView.setViewName("template/control/software-update-result-error");
            }
        } else {
            modelAndView.setViewName("template/control/software-update-result-error");
        }

        return modelAndView;
    }

    public boolean isAddress(String addressStr) {
        try {
            int address = Integer.parseInt(addressStr);
            if (address > 0 && address < 41) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    public boolean isAde7758Type(String typeStr) {
        return typeStr.equals("ade7758-电流") || typeStr.equals("ade7758-电压") || typeStr.equals("ade7758-加速度x") || typeStr.equals("ade7758-加速度y") || typeStr.equals("ade7758-载荷") || typeStr.equals("ade7758-位移");
    }

    public boolean isInteliTableType(String typeStr) {
        return typeStr.equals("智能电表-电流") || typeStr.equals("智能电表-有功功率") || typeStr.equals("智能电表-加速度x") || typeStr.equals("智能电表-加速度y") || typeStr.equals("智能电表-载荷") || typeStr.equals("智能电表-位移");
    }

    public byte[] getSoftwareUpdateFile() {
        return softwareUpdateFile;
    }

    public String getSoftwareUpdateVersion() {
        return softwareUpdateVersion;
    }
}
