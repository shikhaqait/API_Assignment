package services;

import java.util.HashMap;

import constant.Variables;
import httpclient.GetRequest;

public class PostService {

	private final String POST_PATH = "/posts";

	public int getPostsStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + POST_PATH, new HashMap<String, String>());
	}

}
