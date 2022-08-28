package services;

import java.util.HashMap;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import constant.Variables;
import httpclient.GetRequest;
import objects.comments.CommentsDataResponse;

public class CommentsService {

	private final String COMMENT_PATH = "/comments";

	public int getCommentStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + COMMENT_PATH, new HashMap<String, String>());
	}

	public CommentsDataResponse[] getPostsSpecificComments(int postid) {
		Map<String, String> param_postsid = new HashMap<String, String>();
		param_postsid.put("postId", String.valueOf(postid));
		String commResp = GetRequest.get(Variables.getBaseURL() + COMMENT_PATH, param_postsid);
		CommentsDataResponse[] commentData = JsonPath.parse(commResp).read("$", CommentsDataResponse[].class);
		return commentData;
	}

	public CommentsDataResponse[] getAllComments() {
		String commResp = GetRequest.get(Variables.getBaseURL() + COMMENT_PATH);
		CommentsDataResponse[] commentData = JsonPath.parse(commResp).read("$", CommentsDataResponse[].class);
		return commentData;
	}

}
