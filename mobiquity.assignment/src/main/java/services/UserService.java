package services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import constant.Variables;
import httpclient.GetRequest;

public class UserService {

	private final String USER_PATH = "/users";

	public int getUserStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + USER_PATH, new HashMap<String, String>());
	}

	public int getUserId(String userName) {
		Map<String, String> user = new HashMap<String, String>();
		user.put("username", userName);
		String respBody = GetRequest.get(Variables.getBaseURL() + USER_PATH, user);
		List<Integer> list = JsonPath.parse(respBody).read("$.*.id");
		return list.get(0);

	}

}
