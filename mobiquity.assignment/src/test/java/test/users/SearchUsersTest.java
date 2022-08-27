package test.users;


import org.testng.Assert;
import org.testng.annotations.Test;
import services.UserService;

public class SearchUsersTest extends UserService {

	public static String Id;

	@Test
	public void verifySearchUserStatusCode() {
		Assert.assertEquals(getUserStatusCode(), 200);
	}

}
