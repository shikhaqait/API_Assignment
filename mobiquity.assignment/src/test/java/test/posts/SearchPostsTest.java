package test.posts;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import services.PostService;
import services.UserService;
import test.BaseTest;

public class SearchPostsTest extends BaseTest {
	
	private PostService postService;
	
	@BeforeClass
	public void setSession() {
		postService = new PostService();
	}

	@Test
	public void verifyPostsStatusCode() {
		softassert.assertEquals(postService.getPostsStatusCode(), 200, "Invalid status code");
		softassert.assertAll();
	}

	@Test
	public void verifySpecificUserPostIds() {
		softassert.assertTrue(postService.getAllPostsIdofUser(new UserService().getUserDetails("Delphine").getId()).size()>1, "User has no posts");
		softassert.assertAll();
	}

}
