package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.SearchFriendDAO;
import com.internousdev.project1.dto.SearchFriendDTO;
import com.internousdev.project1.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class SearchFriendAction extends ActionSupport implements SessionAware {

	private String friendId;
	public Map<String, Object> session;
	private SearchFriendDAO searchFriendDAO = new SearchFriendDAO();
	private SearchFriendDTO searchFriendDTO = new SearchFriendDTO();
	private String followCheck;

	public String execute(){

		searchFriendDTO = searchFriendDAO.searchFriend(getFriendId());

		session.put("searchFriendId", searchFriendDTO.getLoginUserId().toString());
		session.put("searchFriendName", searchFriendDTO.getUserName().toString());

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM follow_list WHERE user_id = ? AND followed_user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, session.get("loginUserId").toString());
			ps.setString(2, session.get("searchFriendId").toString());
			ResultSet rs = ps.executeQuery();

			if(rs.next() == true){
				setFollowCheck("on");
			}else{
				setFollowCheck("off");

			session.put("followCheck", getFollowCheck());
			}

		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		String ret = SUCCESS;
		return ret;
	}

	public String getFriendId() {
		return friendId;
	}

	public void setFriendId(String friendId) {
		this.friendId = friendId;
	}

	public Map<String, Object> getSession() {
		return session;
	}



	public String getFollowCheck() {
		return followCheck;
	}

	public void setFollowCheck(String followCheck) {
		this.followCheck = followCheck;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
