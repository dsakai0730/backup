package com.internousdev.project1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.project1.dao.LoginDAO;
import com.internousdev.project1.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private String loginUserId;
	private String loginPassword;
	public Map<String, Object> session;
	private LoginDAO loginDAO = new LoginDAO();
	private LoginDTO loginDTO = new LoginDTO();
	private String ret;

	public String execute(){
		ret = ERROR;

		loginDTO = loginDAO.getUserInfo(loginUserId, loginPassword);

		if(!(loginDTO.getUserId().toString().equals("")) &&
				!(loginDTO.getLoginUserId().toString().equals("")) &&
				!(loginDTO.getLoginPassword().toString().equals(""))){

			session.put("loginDTO", loginDTO);

			session.put("userId", loginDTO.getUserId());
			session.put("loginUserId", loginDTO.getLoginUserId());
			session.put("loginPassword", loginDTO.getLoginPassword());
			session.put("userName", loginDTO.getUserName());

			ret = SUCCESS;
		}else{
			ret = ERROR;
		}
		return ret;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
