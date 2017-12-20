package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.struts2.interceptor.SessionAware;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport implements SessionAware{

	private String id;
	private String img;
	private String title;
	private List<String> authorsList = new ArrayList<String>();
	private String publishedDate;
	private String description;
	private String searchWord;
	private List<TestDTO> testDTOList = new ArrayList<TestDTO>();
	public Map<String, Object> session;
	private List<String> idList = new ArrayList<String>();

	public String execute() throws IOException{
		String ret = SUCCESS;


		URL url = new URL("https://www.googleapis.com/books/v1/volumes?q=" + getSearchWord());
		InputStream is = url.openStream();
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader reader = new BufferedReader(isr);
		String contents = IOUtils.toString(reader);

		try{
			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(contents);
			id = root.get("items").get(0).get("id").asText();

			JsonNode items = root.get("items");

			for(int i=0; i<items.size(); i++){
				idList.add(root.get(i).get("id").asText());
			}

			System.out.println((int)items.size());

			img = root.get("items").get(0).get("volumeInfo").get("imageLinks").get("smallThumbnail").asText();
			title = root.get("items").get(0).get("volumeInfo").get("title").asText();

			JsonNode authors = root.get("items").get(0).get("volumeInfo").get("authors");

			for(int i=0; i<authors.size(); i++){
				authorsList.add(authors.get(i).asText());
			}

			description = root.get("items").get(0).get("volumeInfo").get("description").asText();
			publishedDate = root.get("items").get(0).get("volumeInfo").get("publishedDate").asText();

			TestDTO testDTO = new TestDTO();
			testDTO.setIdList(idList);
			testDTOList.add(testDTO);

			session.put("testDTOList", testDTOList);


		}catch(IOException e){
			e.printStackTrace();
		}

		return ret;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public List<String> getAuthorsList() {
		return authorsList;
	}

	public void setAuthorsList(List<String> authorsList) {
		this.authorsList = authorsList;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}


	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}



}