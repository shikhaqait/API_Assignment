package test.users;

import java.util.Scanner;

import org.testng.annotations.Test;

import httpclient.GetRequest;
import io.restassured.response.Response;

public class SearchUsers {

	String Id;
	public String getUrl() {
		Scanner myObj = new Scanner(System.in); // Create a Scanner object
		System.out.println("Enter URL");

		String url = myObj.nextLine(); // Read user input
		return url;
	}

	@Test
	public void verifySearchUser() {	
	GetRequest.getUserResponse(getUrl()+"/users");
		
	}
	
	@Test
	public void verifySpecificUser() {
		Id = GetRequest.getSpecificUserIdResponse(getUrl()+"/users", "Delphine");
		System.out.println("*******"+Id);	
	}
	
	
	
}
