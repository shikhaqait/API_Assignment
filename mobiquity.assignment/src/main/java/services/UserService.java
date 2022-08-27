package services;

import java.util.HashMap;
import constant.Variables;
import httpclient.GetRequest;

public class UserService {


	private final String USER_PATH = "/users";
	
	public int getUserStatusCode()
	{
		return GetRequest.getResponseCode(Variables.getBaseURL()+USER_PATH,new HashMap<String, String>());
	}
	
}
