package test.users;

import org.testng.Assert;
import org.testng.annotations.Test;

import objects.users.UserDataResponse;
import services.UserService;

public class SearchUsersTest extends UserService {

	@Test
	public void verifySearchUserStatusCode() {
		Assert.assertEquals(getUserStatusCode(), 200);
	}

	@Test
	public void verifyUserId() {
		UserDataResponse user = getUserData("Delphine");
		int id = user.getId();
		
		System.out.println("****"+id);
	}

}
