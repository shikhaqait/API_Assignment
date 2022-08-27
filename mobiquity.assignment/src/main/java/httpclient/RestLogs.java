package httpclient;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class RestLogs {

	public static void setLog() throws FileNotFoundException {
		if(System.getProperty("debug")==null) {
			File file =  new File(System.getProperty("user.dir")+File.separator+"target"+File.separator+"logs.log");
			if(file.exists()) {
				file.delete();
			}
			PrintStream print = new PrintStream(file);
			RestAssured.filters(new RequestLoggingFilter(print), new ResponseLoggingFilter(print));
		}else {
			RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
		}
		
	}
	
}
