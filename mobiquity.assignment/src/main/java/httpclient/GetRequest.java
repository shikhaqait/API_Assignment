package httpclient;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.response.Response;

public class GetRequest {

	public static String get(String url) {
		System.out.println("Inside Get Request" + url);
		Response response = given().when().get(url).then().extract().response();
		return response.body().asString();
	}

	public static String get(String url, Map<String, String> parameter) {
		return given().queryParams(parameter).when().get(url).then().extract().response().getBody().asString();
	}

	public static int getResponseCode(String url, Map<String, String> parameter) {
		return given().queryParams(parameter).when().get(url).then().extract().response().getStatusCode();
	}

}
