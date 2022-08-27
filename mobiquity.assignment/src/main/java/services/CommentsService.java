package services;

import java.util.HashMap;

import constant.Variables;
import httpclient.GetRequest;

public class CommentsService {

	private final String COMMENT_PATH = "/comments";

	public int getCommentStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + COMMENT_PATH, new HashMap<String, String>());
	}

}
