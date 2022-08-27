package test.comments;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.comments.CommentsDataResponse;
import services.CommentsService;
import services.PostService;
import services.UserService;
import test.BaseTest;
import test.utilities.ValidateEmail;

public class SearchCommentsTest extends BaseTest {
	
	private CommentsService commentsService;
	
	@BeforeClass
	public void setSession() {
		commentsService = new CommentsService();
	}

	@Test
	public void verifySearchCommentStatusCode() {
		softassert.assertEquals(commentsService.getCommentStatusCode(), 200);
		softassert.assertAll();
	}

	@Test
	public void verifyCommentEmailid() {
		String useName = "Delphine";
		
		List<Integer> postids = new PostService()
				.getAllPostsIdofUser(new UserService().getUserData(useName).getId());
		for (Integer post_id : postids) {
			CommentsDataResponse[] comments = commentsService.getPostsSpecificComments(post_id);
			for (CommentsDataResponse comment : comments) {
				softassert.assertTrue(ValidateEmail.emailValidator(comment.getEmail()), "Email is invalid "+comment.getEmail()+" for comment "+
						comment.getId()+" on post "+comment.getPostId()+ " for user "+useName);
				Reporter.log("Email is "+comment.getEmail()+" for comment Id"+
						comment.getId()+" on post id "+comment.getPostId()+ " for user "+useName, true);
			}
			
		}
		softassert.assertAll();
	}

}
