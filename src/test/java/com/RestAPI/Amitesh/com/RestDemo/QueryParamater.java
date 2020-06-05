package com.RestAPI.Amitesh.com.RestDemo;

import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParamater extends Base{
	
	Base bs=new Base();
	
	private Response response;
	private RequestSpecification httprequest;
	
	private String baseurl;
	
	@Test(enabled=false)
	public void getQuery() throws IOException
	{
		baseurl=bs.gethost("host1");
		
		//System.out.println("The endpoint of the application is------>"+baseurl);
		
		
		response=RestAssured.given()
				.baseUri(baseurl)
				.queryParam("q", "London,UK")
				.queryParam("appid", "2b1fd2d7f77ccf1b7de9b441571b39b8")
				.get("/weather");
		
		String weather=response.body().prettyPrint();
		
		//System.out.println("The weather is ---->"+weather);
		
	}				
	
	

}
