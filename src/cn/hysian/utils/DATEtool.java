package cn.hysian.tool;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DATEtool {
	final static SimpleDateFormat  DF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String GetTime(){
		Date now = new Date();
		String date = DF.format(now);
		return date;
	}
	
	public static String GetJump(String uptime){
		String n = null;
		Date now = new Date();
		try {
			Date date = DF.parse(uptime);
			long l=now.getTime()-date.getTime();   
		    long day=l/(24*60*60*1000);  
		    long month = day/30;
		    long hour=(l/(60*60*1000)-day*24);
		    long min=((l/(60*1000))-day*24*60-hour*60);   
		    long s=(l/1000-day*24*60*60-hour*60*60-min*60);
		    if(month == 0){
		    	if(day == 0){
		    		if(hour == 0){
		    			if(min == 0){
			    			n = s+"秒";
			    		}else{
			    			n = min+"分钟";
			    		}
		    		}else{
			    		n = hour+"小时";
		    		}
		    	}else{
		    		n = day+"天";
		    	}
		    }else{
		    	n = month+"月";
		    }
		    
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return n;
	}
}
