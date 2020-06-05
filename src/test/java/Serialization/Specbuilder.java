package Serialization;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specbuilder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
File file=new File(System.getProperty("user.dir")+"/testdata/"+"input.json");
		
		String p=new String(Files.readAllBytes(Paths.get(file.getCanonicalPath())));
		
		String baseurl="https://rahulshettyacademy.com";
		
	RequestSpecification req=	new RequestSpecBuilder().setBaseUri(baseurl).addQueryParam("key", "qaclick123").setContentType(ContentType.JSON).build();
	
		ResponseSpecification resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
	
	Response res=RestAssured.given().spec(req).body(p).when().post("/maps/api/place/add/json")
				.then().spec(resspec).extract().response();
	
		String resstring=res.asString();
		
		System.out.println(resstring);
	}

}
