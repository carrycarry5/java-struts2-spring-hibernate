package yc.action;

import javax.servlet.http.HttpServletRequest;
import java.*;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import yc.entity.User;

public class ObjectAction extends ActionSupport{
	//1.����һ������
	private User user = new User();
	//2.����get����
	public User getUser() {
		return user;
	}
	public String execute() throws Exception {
		//3.��ֵջ��user��ֵ
		
		
		user.setAge("19");
		user.setUserName("carry");
		return "ok";
	}
}
