package test.users;

import org.testng.Assert;
import org.testng.annotations.Test;
import services.UserService;

public class SearchUsersTest extends UserService {

	@Test
	public void verifySearchUserStatusCode() {
		Assert.assertEquals(getUserStatusCode(), 200);
	}
	
	@Test
	public void verifyUserId() {
		System.out.println(getUserId("Delphine"));
	}

}
