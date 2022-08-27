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
	public void verifySearchUserStatusCode() {
		softassert.assertEquals(userService.getUserStatusCode(), 200);
		softassert.assertAll();
		
	}


}
