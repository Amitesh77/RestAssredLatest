package ComplexJson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class ComplexJsonParse {

	
	@Test
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file=new File(System.getProperty("user.dir")+"/testdata/"+"Mockdata.json");
		
		String data=new String(Files.readAllBytes(Paths.get(file.getCanonicalPath())));
		
		JsonPath path=new JsonPath(data);
		
		
		List<Object> list=path.getList("courses");
		
		System.out.println("Total cources are  :"+list.size());
		
		int arraysize=path.getInt("courses.size()");
		
		System.out.println(arraysize);
		
		//int size=path.getInt("cources.price");
		
		int totalamount=path.getInt("dashboard.purchaseAmount");
		
		System.out.println(totalamount);
		
		String firsttitle=path.get("courses[0].title");
		
		System.out.println("The title of first course is  : "+firsttitle);
		
		
		for (int i = 0; i <arraysize; i++) {
			
			String title=path.get("courses["+i+"].title");
			
			int price=path.getInt("courses["+i+"].price");
			
			System.out.println(title +"  :  " +price);
			
		}
		
		int total=0;
		for (int i = 0; i <arraysize; i++) {
			
			total+=path.getInt("courses["+i+"].price") *path.getInt("courses["+i+"].copies");
			
		}
		
		
		System.out.println(total);
		
		Assert.assertEquals(total, 910);

	}

}
