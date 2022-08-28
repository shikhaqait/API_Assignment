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
		softassert.assertEquals(userService.getAllUserDataForEmail("Sincere@april.biz").length, 1,
				"Searched user is not valid");
		softassert.assertAll();
	}
	
	@Test
	public void verifyUserSearchWithInavalidQueryParam() {
		String[] queryParam = {"xyz", "absas"};
		softassert.assertEquals(userService.geAllUserData(queryParam[0],queryParam[1]).length, 0,
				"Noexisting query param "+queryParam[0]+"="+queryParam[1]+" user search has given serarch results");
		softassert.assertAll();
	}

}
