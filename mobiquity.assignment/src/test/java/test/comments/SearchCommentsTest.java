package test.comments;

import java.util.List;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import objects.comments.CommentsDataResponse;
import objects.users.UserDataResponse;
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
	public void verifyCommentEmailidFormat() {
		String useName = "Delphine";

		List<Integer> postids = new PostService()
				.getAllPostsIdofUser(new UserService().getUserDetails(useName).getId());
		for (Integer post_id : postids) {
			CommentsDataResponse[] comments = commentsService.getSpecificPostComments(post_id);
			for (CommentsDataResponse comment : comments) {
				softassert.assertTrue(ValidateEmail.emailValidator(comment.getEmail()),
						"Email is invalid " + comment.getEmail() + " for comment " + comment.getId() + " on post "
								+ comment.getPostId() + " for user " + useName);
				Reporter.log("Email is " + comment.getEmail() + " for comment Id" + comment.getId() + " on post id "
						+ comment.getPostId() + " for user " + useName, true);
			}

		}
		softassert.assertAll();
	}

	@Test
	public void verifyCommentEmailIdInUserDetailServer() {
		CommentsDataResponse[] postComments = commentsService.getAllComments();
		for (CommentsDataResponse comment : postComments) {
			UserDataResponse[] userAccount = new UserService().getAllUserDataForEmail(comment.getEmail());
			softassert.assertTrue(userAccount.length > 0,
					"the owner of comment" + comment.getEmail() + " did not have a valid account in user db");
			if (userAccount.length > 0) {
				Reporter.log("the owner of comment " + comment.getEmail() + " has a valid account in user db", true);
			} else {
				Reporter.log("the owner of comment " + comment.getEmail() + " did not have a valid account in user db",
						true);
			}
		}
		softassert.assertAll();

	}
	
	@Test
	public void verifyCommentSearchWithInavalidQueryParam() {
		String[] queryParam = {"comment", "absas"};
		softassert.assertEquals(commentsService.getAllComments(queryParam[0],queryParam[1]).length, 0,
				"Noexisting query param "+queryParam[0]+"="+queryParam[1]+" comment search has given serarch results");
		softassert.assertAll();
	}

}
