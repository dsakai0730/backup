package com.internousdev.project1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.AlReadCheckDAO;
import com.internousdev.project1.dto.SearchBookDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CheckAction extends ActionSupport implements SessionAware {

	private String bookId;
	private List<String> check;
	public Map<String, Object> session;
	private int checkNum;
	private AlReadCheckDAO alReadCheckDAO = new AlReadCheckDAO();
	private List<String> alReadDTO = new ArrayList<String>();
	private String alReadCheckMessage;

	public String execute(){
		String ret = SUCCESS;

		// List<DTO>をキャスト(=変換)する方法です。
		List<SearchBookDTO> bookList = (List<SearchBookDTO>) session.get("searchBookDTOList");


		session.put("checkNum", checkNum);
		session.put("check", bookList.get(checkNum));
		session.put("checkId", bookList.get(checkNum).getBookId());
		session.put("checkImg", bookList.get(checkNum).getImg());
		session.put("checkTitle", bookList.get(checkNum).getTitle());
		session.put("checkAuthor", String.join(" ", bookList.get(checkNum).getAuthorsList()));
		session.put("checkPublishedDate", bookList.get(checkNum).getPublishedDate());
		session.put("checkDescription", bookList.get(checkNum).getDescription());

		System.out.println(session.get("checkId").toString());
		System.out.println(session.get("checkImg").toString());
		System.out.println(session.get("checkTitle").toString());
		System.out.println(session.get("checkAuthor").toString());
		System.out.println(session.get("checkPublishedDate").toString());
		System.out.println(session.get("checkDescription").toString());

		alReadDTO.addAll(alReadCheckDAO.getAlReadCheck(session.get("loginUserId").toString()));


		if(alReadDTO.contains(bookList.get((int)session.get("checkNum")).getBookId().toString())){
			alReadCheckMessage = "on";

		}else{
			alReadCheckMessage = "off";
		}

		session.put("alReadCheck", alReadCheckMessage);


		return ret;
	}



	public String getBookId() {
		return bookId;
	}



	public void setBookId(String bookId) {
		this.bookId = bookId;
	}



	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<String> getCheck() {
		return check;
	}



	public void setCheck(List<String> check) {
		this.check = check;
	}



	public int getCheckNum() {
		return checkNum;
	}



	public void setCheckNum(int checkNum) {
		this.checkNum = checkNum;
	}



	public AlReadCheckDAO getAlReadCheckDAO() {
		return alReadCheckDAO;
	}



	public void setAlReadCheckDAO(AlReadCheckDAO alReadCheckDAO) {
		this.alReadCheckDAO = alReadCheckDAO;
	}



	public List<String> getAlReadDTO() {
		return alReadDTO;
	}



	public void setAlReadDTO(List<String> alReadDTO) {
		this.alReadDTO = alReadDTO;
	}





}
