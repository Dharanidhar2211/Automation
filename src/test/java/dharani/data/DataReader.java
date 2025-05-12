package dharani.data;

import java.util.List;
import java.util.HashMap;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader 
{
	
	public List<HashMap<String, String>> GetJsonDataToMap() throws IOException 
	{
		//json to string
		String jsonfile=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\dharani\\data\\PurchaseOrder.json"),StandardCharsets.UTF_8); 
		//String to hash map
		ObjectMapper mapper=new ObjectMapper();
		List<HashMap<String , String>> data=mapper.readValue(jsonfile, new TypeReference<List<HashMap<String, String >>>() {});
		return data;
		
		
		
	}

}
