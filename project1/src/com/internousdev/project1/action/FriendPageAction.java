package com.internousdev.project1.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dto.FollowListDTO;
import com.internousdev.project1.util.DBConnector;
import com.opensymphony.xwork2.ActionSupport;

public class FriendPageAction extends ActionSupport implements SessionAware{

	private String retMessage;
	private String flexistMessage;
	private List<FollowListDTO>followList = new ArrayList<FollowListDTO>();
	public Map<String, Object> session;

	public String execute(){
		String ret = SUCCESS;

		DBConnector db = new DBConnector();
		Connection con = db.getConnection();

		String sql = "SELECT * FROM follow_list WHERE user_id = ?";
		try{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, session.get("loginUserId").toString());
			ResultSet rs = ps.executeQuery();

			while(rs.next()){
				FollowListDTO dto = new FollowListDTO();
				dto.setFollowUserId(rs.getString("followed_user_id"));
				dto.setFollowUserName(rs.getString("followed_user_name"));
				followList.add(dto);
			}

			if(followList.isEmpty()){
				setFlexistMessage("none");
			}else{
				setFlexistMessage("exist");
			}

			session.put("followList", followList);
			session.put("flexistMessage" ,getFlexistMessage());


		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			con.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return ret;
	}



	public String getRetMessage() {
		return retMessage;
	}



	public void setRetMessage(String retMessage) {
		this.retMessage = retMessage;
	}




	public String getFlexistMessage() {
		return flexistMessage;
	}



	public void setFlexistMessage(String flexistMessage) {
		this.flexistMessage = flexistMessage;
	}



	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
