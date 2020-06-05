package Serialization;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SerializationTest {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		// TODO Auto-generated method stub
		
		
//		AddPlace p=new AddPlace();
//		Location l=new Location();
//		
//		l.setLat(-38.383494);
//		l.setLng( 33.427362);
//		
//		p.setAccuracy(50);
//		p.setAddress("29, side layout, cohen 09");
//		p.setName("Frontline house");
//		p.setLanguage("French-IN");
//		p.setPhone_number("(+91) 983 893 3937");
//		p.setWebsite( "http://google.com");
//		
//		List<String> list=new ArrayList();
//		
//		list.add("shoe park");
//		list.add("shop");
//		
//		p.setTypes(list);
//		
//		p.setLocation(l);
		
		File file=new File(System.getProperty("user.dir")+"/testdata/"+"input.json");
		
		String p=new String(Files.readAllBytes(Paths.get(file.getCanonicalPath())));

		
		String baseurl="https://rahulshettyacademy.com";
		
		Response res=RestAssured.given().baseUri(baseurl)
					.queryParam("key", "qaclick123")
					.body(p)
					.when().post("/maps/api/place/add/json")
					.then().assertThat().statusCode(200).extract().response();
		
		Deserializationtest resb=res.getBody().as(Deserializationtest.class);
		
		//Deserializationtest ds=new Deserializationtest();
		
		String path=System.getProperty("user.dir")+"/testdata/"+"ex2.json";
		
		System.out.println(resb.getId()+"  "+resb.getPlace_id()+"   "+resb.getScope()+"   "+resb.getStatus());
		
		ObjectMapper mapper=new ObjectMapper();
		
		mapper.writeValue(new File(path), resb);

	}

}
