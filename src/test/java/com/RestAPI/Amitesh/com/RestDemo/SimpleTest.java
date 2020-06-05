package com.RestAPI.Amitesh.com.RestDemo;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleTest extends Base{
	
	private Response response;
	private RequestSpecification httprequest;
	
	private String baseurl;
	
	Base bs=new Base();
	
	@Test(enabled=false)
	public void getCity() throws IOException
	{
		
		baseurl=bs.gethost("host");
		RestAssured.baseURI=baseurl;
		
		 httprequest=RestAssured.given();
		
		 response=httprequest.request(Method.GET,"/Hyderabad");
		
		String citytemp=response.getBody().asString();
		
		int statuscode=response.getStatusCode();
		
		Assert.assertEquals(statuscode,200);
		
		System.out.println("The status code is---->"+statuscode);
		
		System.out.println("The response body as string is---->"+citytemp);
		
		
	}
	
	
	@Test(enabled=false)
	public void verifyHeaders() throws IOException
	{
		
		baseurl=bs.gethost("host");
		RestAssured.baseURI=baseurl;
		
		 httprequest=RestAssured.given();
		
		 response=httprequest.request(Method.GET,"/Hyderabad");
		
		String content=response.header("Content-Type");
		
		String server=response.header("Server");
		
		String encoding=response.header("Content-Encoding");
		
		System.out.println("The content type is--->"+content);
		System.out.println("The server type is--->"+server);
		System.out.println("The encoding type is--->"+encoding);
		
		Headers head=response.headers();
		
		for(Header he:head)
		{
			System.out.println("The headers are--->"+he);
		}

	}
	@Test(enabled=false)
	public void useJsonPath() throws IOException
	{
		baseurl=bs.gethost("host");
		RestAssured.baseURI=baseurl;
		
		httprequest=RestAssured.given();
		
		JsonPath path=response.jsonPath();
		
		String city=path.get("City");
		
		System.out.println("The city is:--->"+city);
		
	}

}
