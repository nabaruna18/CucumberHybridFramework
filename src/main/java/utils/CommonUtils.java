package utils;

import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT = 10;
	public static final int PAGE_LOAD_TIME_OUT = 15;
	public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
	
	public String getEmailTimeStamp() {
		Date date = new Date();
		return "xyz" + date.toString().replace(" ", "_").replace(":", "_") + "@yopmail.com";
	}

}
