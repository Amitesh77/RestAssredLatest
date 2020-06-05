package ComplexJson;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class Sumvalidation {
	
	
	@Test
	public void validateSum() throws IOException
	{
		File file=new File(System.getProperty("user.dir")+"/testdata/"+"Mockdata.json");
		
		String data=new String(Files.readAllBytes(Paths.get(file.getCanonicalPath())));
		
		JsonPath path=new JsonPath(data);
		
		int arraysize=path.getInt("courses.size()");
		
		int total=0;
		for (int i = 0; i <arraysize; i++) {
			
			total+=path.getInt("courses["+i+"].price") *path.getInt("courses["+i+"].copies");
			
		}
		
		
		System.out.println(total);
		
		Assert.assertEquals(total, 910);
	}

}
