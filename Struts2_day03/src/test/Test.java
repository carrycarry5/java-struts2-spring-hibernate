package test;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import yc.entity.User;

public class Test extends ActionSupport  implements ModelDriven<User>{
	private User user= new User();
	
	public User getUser() {
		return user;
	}

	@Override
	public String execute() throws Exception {
		System.out.println(user);
		return "haha";
	}

	@Override
	public User getModel() {
		
		return user;
	}
}
