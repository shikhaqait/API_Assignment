package test.posts;

import org.testng.Assert;
import org.testng.annotations.Test;

import services.PostService;
import services.UserService;

public class SearchPostsTest extends PostService {

	@Test
	public void verifySearchPostsStatusCode() {
		Assert.assertEquals(getPostsStatusCode(), 200);
	}

	@Test
	public void verifyPostIds() {
		getAllPostsIdofUser(new UserService().getUserData("Delphine").getId());
	}

}
