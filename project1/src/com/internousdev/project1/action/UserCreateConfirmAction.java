package com.internousdev.project1.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class UserCreateConfirmAction extends ActionSupport implements SessionAware{

	private String  loginUserId;
	private String userName;
	private String loginPassword;
	public Map<String, Object> session;
	private String result;
	private String errorMessage;

	public String execute(){
		result = SUCCESS;

		if(!(loginUserId.equals("")) && !(userName.equals("")) && !(loginPassword.equals(""))){
			session.put("loginUserId", loginUserId);
			session.put("userName", userName);
			session.put("loginPassword", loginPassword);
		}else{
			setErrorMessage("未入力項目があります");
			result = ERROR;
		}

		return result;
	}

	public String getLoginUserId() {
		return loginUserId;
	}

	public void setLoginUserId(String loginUserId) {
		this.loginUserId = loginUserId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public void setSession(Map<String, Object> session){
		this.session = session;
	}
}
