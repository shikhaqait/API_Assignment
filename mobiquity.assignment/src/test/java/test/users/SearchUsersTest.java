package test.users;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import services.UserService;
import test.BaseTest;

public class SearchUsersTest extends BaseTest {

	private UserService userService;

	@BeforeClass
	public void setSession() {
		userService = new UserService();
	}

	@Test
	public void verifyUserStatusCode() {
		softassert.assertEquals(userService.getUserStatusCode(), 200, "Invalid status code");
		softassert.assertAll();
	}

	@Test
	public void verifyNonExistingUserDetails() {
		softassert.assertEquals(userService.geAllUserData(String.valueOf((System.currentTimeMillis()))).length, 0,
				"Searched user detail found");
		softassert.assertAll();
	}

	@Test
	public void verifyValidEmailId() {
		softassert.assertEquals(userService.geAllUserDataForEmail("Sincere@april.biz").length, 1,
				"Searched user is not valid");
		softassert.assertAll();
	}

}
