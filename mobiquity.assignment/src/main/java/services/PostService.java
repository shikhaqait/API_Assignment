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
	
	/**
	 *  To verify status code return after successful request
	 * @return status code
	 */	
	public int getPostsStatusCode() {
		return GetRequest.getResponseCode(Variables.getBaseURL() + POST_PATH, new HashMap<String, String>());
	}

	/**
	 * To get posts of specific users
	 * pass user id (fetch user id from '/users' endpoint')
	 * @return all data of posts related to that user id
	 */
	public PostsDataResponse[] getUserSpecificPosts(int userid) {
		return getAllPosts("userId",String.valueOf(userid));
	}

	/**
	 * To get post id of specific users
	 * pass user id (fetch user id from '/users' endpoint')
	 * @return all postids for specific user
	 */
	public List<Integer> getAllPostsIdofUser(int userid) {
		List<Integer> postId = new ArrayList<Integer>();
		for (PostsDataResponse post : getUserSpecificPosts(userid)) {
			postId.add(post.getId());
		}
		return postId;
	}
	
	/**
	 * Get all value based upon post query paramters
	 * @param queryParams
	 * @return
	 */
	private PostsDataResponse[] getAllPosts(Map<String,String> queryParams) {
		String postResp = GetRequest.get(Variables.getBaseURL() + POST_PATH, queryParams);
		return JsonPath.parse(postResp).read("$", PostsDataResponse[].class);
	}
	
	/**
	 * Give all post based on key values
	 * @param queryKey
	 * @param queryValue
	 * @return
	 */
	public PostsDataResponse[] getAllPosts(String queryKey,String queryValue) {
		Map<String, String> params = new HashMap<String, String>();
		params.put(queryKey, String.valueOf(queryValue));
		return getAllPosts(params);
	}

}
