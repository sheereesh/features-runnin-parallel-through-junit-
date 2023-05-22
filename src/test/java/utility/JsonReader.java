package utility;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JsonReader {

	private static JSONObject jsonObject;

/*
	public static JSONObject getJSONObject() {
		return jsonObject;
	}
*/

	public static JSONObject readJsonFile(String JSONFileName) {


		//creating the jsonparsar object
		JSONParser jsonParser=new JSONParser();


		//parsing the content of json file

		try {
			jsonObject=(JSONObject)jsonParser.parse(new FileReader(System.getProperty("user.dir")+"/src/test/resources/json/"+JSONFileName+".json"));
		} catch (IOException | ParseException e) {
			System.out.println(e);
		}

		return jsonObject;

	}

	public static String getValue(String JSONFileName, String key) {

		return readJsonFile(JSONFileName).get(key).toString();

	}
/*
	public static JSONObject getJSONList(String JSONFileName, String key) {

		JSONObject elements=(JSONObject)readJsonFile(JSONFileName).get(key);
		Map<String,String> options=new HashMap<String,String>();
		Iterator iterator=(Iterator)elements;
		if

	}
	public static String getValue(String key) {
		for (iterable_type iterable_element : iterable) {

		}
	}
*/
}
