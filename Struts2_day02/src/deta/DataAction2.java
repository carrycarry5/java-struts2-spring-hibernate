package deta;

import javax.servlet.ServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.xml.internal.bind.v2.runtime.Name;

import entity.User;

//Ä£ÐÍÇý¶¯
public class DataAction2 extends ActionSupport implements ModelDriven<User>{
	private User user  = new User();
	@Override
	public User getModel() {
		
		return user;
	}
	
	public String execute() throws Exception {
		System.out.println(user);
		ServletRequest request = ServletActionContext.getRequest();
		String username = request.getParameter("name");
		System.out.println(username);
		
		return NONE;
	}
}
