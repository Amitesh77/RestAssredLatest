package com.RestAPI.Amitesh.com.RestDemo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Football extends Base{
	
	Response response;
	
	
	
	
	@Test()
	public void getDetails() throws IOException
	{
		String url=gethost("host5");
		
		
		response=RestAssured.given().baseUri(url).header("X-Auth-Token","b9fbf76400a14403908405d09e4c30ae")
					.get();
		
		String body=response.getBody().prettyPrint();
		
		//System.out.println(body);
		
		JsonPath path=response.jsonPath();
		
	List<List<Object>> list=path.getList("standings.table.team");
		
	List<Object> list2=list.stream().flatMap(list1->list1.stream()).collect(Collectors.toList());
	
	for (Object object : list2) {
		
		String[] s=object.toString().split(",");
		
		for (int i = 0; i < s.length; i++) {
			
			System.out.println(s[i]);
		}
	}
		
	
	
// "standings.table.team.id"	
//	List<Integer> list2=list .stream().flatMap(list1->list1.stream()).collect(Collectors.toList());
//	
//	for (Integer string : list2) {
//		
//		System.out.println(string);
//	}
	
	
	
		
	

		

		
		
		
		
							
	}

	

}
