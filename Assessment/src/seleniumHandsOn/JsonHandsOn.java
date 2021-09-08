package seleniumHandsOn;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class JsonHandsOn {

	//JSON File write using JSONSimple libraries(JSON Object)
	@Test
	public void jsonFileWrite() throws IOException {
		
		JSONObject Jobj = new JSONObject();
		
		Jobj.put("Name", "John");
		Jobj.put("LastName", "Snow");
		
		JSONArray JArry = new JSONArray();
		
		JArry.add("House");
		JArry.add("Stark");
		JArry.add("WinterFell");
		
		Jobj.put("Family", JArry);
		
		FileWriter JsonFile = new FileWriter("JsonWrite.json");
		JsonFile.write(Jobj.toJSONString());
		JsonFile.close();
		
	}
	
	//JSON File Read using JSONSimple libraries(JSON Parser)
	@AfterTest
	public void JsonFileRead() throws IOException, ParseException {
		
		JSONParser jParser = new JSONParser();
		
		FileReader JsonRead = new FileReader("JsonWrite.json");
		
		Object ParsedData = jParser.parse(JsonRead);
		
		JSONObject ConvertedObj = (JSONObject) ParsedData;
		
		String GetNanme = (String) ConvertedObj.get("Name");
		
		String LastName = (String) ConvertedObj.get("LastName");
		
		System.out.println("Name => " +GetNanme );
		System.out.println("LastName => "+LastName);
		
		JSONArray Arry = (JSONArray) ConvertedObj.get("Family");
		Iterator iterate = Arry.iterator();
		
		while(iterate.hasNext()) {
			System.out.println("Family Details => "+iterate.next());
		}
		
	}
}
