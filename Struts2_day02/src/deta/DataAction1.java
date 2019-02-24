package deta;

import com.opensymphony.xwork2.ActionSupport;

import entity.User;

public class DataAction1 extends ActionSupport{

	private String user;
	private String password;
	

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String execute() throws Exception {
		System.out.println("user:"+this.user +"    password:" +this.password);
		
		return NONE;
	}
}
