package test01;

import java.util.ArrayList;
import java.util.List;

public class TestDTO {

	private String id;
	private String img;
	private String title;
	private List<String> authorsList = new ArrayList<String>();
	private String publishedDate;
	private String description;
	private List<String> idList = new ArrayList<String>();

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
	public String getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(String publishedDate) {
		this.publishedDate = publishedDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getIdList() {
		return idList;
	}
	public void setIdList(List<String> idList) {
		this.idList = idList;
	}



}
