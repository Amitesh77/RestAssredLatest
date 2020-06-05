package com.RestAPI.Amitesh.com.RestDemo;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

public class OAuth2 extends Base{
	
	Base bs=new Base();
	
	private String baseurl;
	private Response response;
	
	@Test
	public void authTest() throws IOException
	{
		baseurl=bs.gethost("host3");
		
		System.out.println("The endpoint of the application is------>"+baseurl);
		
		
		
		String acees_response=given()
		.queryParams("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.queryParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.queryParams("redirect_uri","https://rahulshettyacademy.com/getCourse.php")
		.queryParams("grant_type","authorization_code")
		.post("https://www.googleapis.com/oauth2/v4/token").asString();
		
		
		JsonPath path=new JsonPath(acees_response);
		
		String accessToken=path.getString("access_token");
		
		
		
		
		
		
		
		
		RestAssured.baseURI=baseurl;
		
		RequestSpecification httprequest=RestAssured.given().log().all();
		
		RequestSpecification res=httprequest.queryParam("access_token", "");
		
		 String token=res.get().asString();
					
							
	}

}
