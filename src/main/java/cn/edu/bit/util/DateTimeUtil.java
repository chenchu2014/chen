package cn.edu.bit.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	public static String getDateTime() {
			String time= new SimpleDateFormat("yyyy-MM-dd kk:mm:ss").format(new Date()) ;
			String hour= time.split(" ")[1].split(":")[0];
			if(hour.equals("24")){
				time=time.replace(" 24", " 00");
			}
			return time;
	}
}
