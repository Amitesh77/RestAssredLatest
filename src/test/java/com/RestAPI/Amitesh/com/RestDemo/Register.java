package com.RestAPI.Amitesh.com.RestDemo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class Register extends Base{
	
	private Response response;
	private RequestSpecification httprequest;
	
	private String baseurl;
	
	
	Base bs=new Base();
	
	@Test()
	public void registerCustomer() throws IOException
	{
		baseurl=bs.gethost("host2");
		
		JSONObject object=new JSONObject();
		
		object.put("FirstName", "Amri");
		object.put("LastName","Shrar");
		object.put("UserName","agrft@gmail.com");
		object.put("Password", "12r");
		object.put("Email", "Amirtgfarma@gmail.com");
		
		
		
		
		
		response=RestAssured.given().baseUri(baseurl)
							.header("Content-Type","application/json")
							.body(object.toJSONString())
							.post("/register");
		
		ResponseBody body=response.getBody();
		
		RegistrationSuccess tr=body.as(RegistrationSuccess.class);
		
		//System.out.println(tr.Message);
//		System.out.println(tr.SuccessCode);
		
		int statuscode=response.getStatusCode();
		
		String pretty=response.prettyPrint();
		
		//Assert.assertEquals(statuscode, 201);
		
		//System.out.println("The Status code is ---->"+statuscode);
		
		//String successcode=response.jsonPath().get("SuccessCode");
		
		//String successmessage=response.jsonPath().get("Message");
		
		//System.out.println("The Success code is ---->"+successcode);
		
		//System.out.println("The Success message is ---->"+successmessage);
		
		
		//String filename="output.json";
		

		
		
	}
	
	@Test(enabled=false)
	public void registerfromFile() throws IOException
	{
		File requestFile = new File("/Users/568650/Documents/Selenium/com.RestDemo/testdata/register.json");
		String requestData = new String(Files.readAllBytes(Paths.get(requestFile.getCanonicalPath())));
		
		HashMap<String,String> map=new HashMap<>();
		map.put("FirstName", "Amite3sdsh");
		map.put("LastName", "Shard23sma");
		map.put("UserName", "amid23stesh");
		map.put("Password", "12ds34");
		map.put("Email", "amds2332it@gmail.com");
	
		
		
		
		
		
		baseurl=bs.gethost("host1");
		response=RestAssured.given().baseUri(baseurl)
						.header("Content-Type", "application/json")
						.body(requestData)
						.post("/register");
		
		
		int statuscode=response.getStatusCode();
		
		//Assert.assertEquals(statuscode, 201);
		
		System.out.println("The Status code is ---->"+statuscode);
		
		String successcode=response.jsonPath().get("SuccessCode");
		
		String successmessage=response.jsonPath().get("Message");
		
		System.out.println("The Success code is ---->"+successcode);
		
		System.out.println("The Success message is ---->"+successmessage);
		
		
		
		
		
						
	}
	


}
