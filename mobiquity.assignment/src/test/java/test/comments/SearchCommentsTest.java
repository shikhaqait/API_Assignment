package test.comments;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.comments.CommentsDataResponse;
import services.CommentsService;
import services.PostService;
import services.UserService;

public class SearchCommentsTest extends CommentsService {

	@Test
	public void verifySearchCommentStatusCode() {
		Assert.assertEquals(getCommentStatusCode(), 200);
	}
	
	@Test
	public void verifyCommentEmailid() {
	 List<Integer> postids =	new PostService().getAllPostsIdofUser(new UserService().getUserData("Delphine").getId());
	 for (Integer post_id : postids) {
		CommentsDataResponse[] comments = getPostsSpecificComments(post_id);
		for(CommentsDataResponse comment : comments) {
			System.out.println(comment.getEmail());
		}
	}
	}

}
