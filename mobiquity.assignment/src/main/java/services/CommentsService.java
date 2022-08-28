package services;

import java.util.HashMap;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import constant.Variables;
import httpclient.GetRequest;
import objects.comments.CommentsDataResponse;

public class CommentsService {

	private final String COMMENT_PATH = "/comments";

	/**
	 *  To verify status code return after successful request
	 * @return status code
	 */	
	public int getCommentStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + COMMENT_PATH, new HashMap<String, String>());
	}

	/**
	 * To get Comments of specific post
	 * pass post id (fetch post id from /posts endpoint) 
	 * @return all comment related to that post id
	 */
	public CommentsDataResponse[] getSpecificPostComments(int postid) {
		Map<String, String> param_postsid = new HashMap<String, String>();
		param_postsid.put("postId", String.valueOf(postid));
		String commResp = GetRequest.get(Variables.getBaseURL() + COMMENT_PATH, param_postsid);
		CommentsDataResponse[] commentData = JsonPath.parse(commResp).read("$", CommentsDataResponse[].class);
		return commentData;
	}

	/**
	 * To get all comments on all posts
	 */
	public CommentsDataResponse[] getAllComments() {
		String commResp = GetRequest.get(Variables.getBaseURL() + COMMENT_PATH);
		CommentsDataResponse[] commentData = JsonPath.parse(commResp).read("$", CommentsDataResponse[].class);
		return commentData;
	}

}
