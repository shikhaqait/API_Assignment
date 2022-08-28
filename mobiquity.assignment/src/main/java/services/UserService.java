package services;

import java.util.HashMap;
import java.util.Map;
import com.jayway.jsonpath.JsonPath;
import constant.Variables;
import httpclient.GetRequest;
import objects.users.UserDataResponse;

public class UserService {

	private final String USER_PATH = "/users";

	/**
	 *  To verify status code return after successful request
	 * @return status code
	 */
	public int getUserStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + USER_PATH, new HashMap<String, String>());
	}

	/**
	 * To get all users details
	 */
	public UserDataResponse[] getAllUsersDetails() {
		return getAllUsers(new HashMap<String,String>());
	}

	/**
	 * Get all details of specific user
	 */
	public UserDataResponse getUserDetails(String userName) {
		return geAllUserData(userName)[0];
	}

	/**
	 * get all details of users with specific username 
	 */
	public UserDataResponse[] geAllUserData(String userName) {
		return geAllUserData("username", userName);
	}

	/**
	 * get all details of users with given query parameter
	 */
	public UserDataResponse[] geAllUserData(String paramkey, String paramValue) {
		Map<String, String> user = new HashMap<String, String>();
		user.put(paramkey, paramValue);
		return getAllUsers(user);
	}
	/**
	 * Get Email ids of all users
	 */
	public UserDataResponse[] getAllUserDataForEmail(String email) {
		return geAllUserData("email", email);
	}
	
	/**
	 * Private method to get user detail on the basis of query parameter passed
	 */
	private UserDataResponse[] getAllUsers(Map<String, String> queryParams) {
		String res = GetRequest.get(Variables.getBaseURL() + USER_PATH, queryParams);
		return JsonPath.parse(res).read("$", UserDataResponse[].class);
	}

}
