package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.commons.io.IOUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

	public static String id;
	public static String img;

	public static void main(String[] args) throws IOException{


		URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=東野圭吾");
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader reader = new BufferedReader(isr);
		String contents = IOUtils.toString(reader);

		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(contents);
			id = root.get("items").get(0).get("id").asText();
			img = root.get("items").get(0).get("volumeInfo").get("imageLinks").get("smallThumbnail").asText();

			System.out.println(id);
			System.out.println(img);

		}catch(IOException e){
			e.printStackTrace();
		}

	}

}
