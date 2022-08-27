package test.posts;

import org.testng.Assert;
import org.testng.annotations.Test;

import services.PostService;

public class SearchPostsTest extends PostService {

	@Test
	public void verifySearchPostsStatusCode() {
		Assert.assertEquals(getPostsStatusCode(), 200);
	}

}
