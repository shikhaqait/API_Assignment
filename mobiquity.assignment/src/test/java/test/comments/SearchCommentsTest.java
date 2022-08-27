package test.comments;

import org.testng.Assert;
import org.testng.annotations.Test;

import services.CommentsService;

public class SearchCommentsTest extends CommentsService {

	@Test
	public void verifySearchCommentStatusCode() {
		Assert.assertEquals(getCommentStatusCode(), 200);
	}

}
