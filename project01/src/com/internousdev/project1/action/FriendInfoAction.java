package com.internousdev.project1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.FriendReadDAO;
import com.internousdev.project1.dto.FriendReadDTO;
import com.opensymphony.xwork2.ActionSupport;

public class FriendInfoAction extends ActionSupport implements SessionAware{

	public Map<String, Object> session;
	private FriendReadDAO friendReadDAO = new FriendReadDAO();
	private List<FriendReadDTO> friendReadDTOList = new ArrayList<FriendReadDTO>();

	public String execute(){

		friendReadDTOList = friendReadDAO.getFriendRead(session.get("searchFriendId").toString());

		session.put("friendReadDTOList", friendReadDTOList);

		String ret = SUCCESS;
		return ret;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
