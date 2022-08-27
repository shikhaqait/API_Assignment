package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;

import constant.Variables;
import httpclient.GetRequest;
import objects.posts.PostsDataResponse;

public class PostService {

	private final String POST_PATH = "/posts";

	public int getPostsStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + POST_PATH, new HashMap<String, String>());
	}

	public PostsDataResponse[] getUserSpecificPosts(int userid) {
		Map<String, String> param_id = new HashMap<String, String>();
		param_id.put("userId", String.valueOf(userid));
		String postResp = GetRequest.get(Variables.getBaseURL() + POST_PATH, param_id);
		PostsDataResponse[] postData = JsonPath.parse(postResp).read("$", PostsDataResponse[].class);
		return postData;
	}

	public List<Integer> getAllPostsIdofUser(int userid) {
		List<Integer> postId = new ArrayList<Integer>();
		for (PostsDataResponse post : getUserSpecificPosts(userid)) {
			postId.add(post.getId());
		}
		return postId;
	}

}
