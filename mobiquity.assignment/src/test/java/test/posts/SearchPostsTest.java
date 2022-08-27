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
	public void verifySearchPostsStatusCode() {
		softassert.assertEquals(postService.getPostsStatusCode(), 200);
		softassert.assertAll();
	}

	@Test
	public void verifyPostIds() {
		softassert.assertTrue(postService.getAllPostsIdofUser(new UserService().getUserData("Delphine").getId()).size()>1);
		softassert.assertAll();
	}

}
