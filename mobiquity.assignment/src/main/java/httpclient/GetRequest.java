package httpclient;

import static io.restassured.RestAssured.given;

import java.util.List;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetRequest {
	
	public static Response getUserResponse(String url) {
		System.out.println("Inside Get Request"+url);
		Response response = given().when().get(url).then().extract().response();
		return response;
	}
	
	public static String getSpecificUserIdResponse(String url, String parameter)
	{
		String id = null;
		Response response = given().queryParam("username", parameter).when()
				.get(url).then().extract().response();
		JsonPath jsonPathEvaluator = response.jsonPath();

		List<Integer> idlist = jsonPathEvaluator.getList("id");
		for (int userid : idlist) {
			id = String.valueOf(userid);
		}
		
		return id;
		
	}

}
