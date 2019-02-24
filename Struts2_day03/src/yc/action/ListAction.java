package yc.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import yc.entity.User;

public class ListAction extends ActionSupport{
	private List<User> list = new ArrayList<>();
	
	public List<User> getList() {
		return list;
	}

	@Override
	public String execute() throws Exception {
		User user1 = new User();
		user1.setAge("15");
		user1.setUserName("lin");
		User user2 = new User();
		user2.setAge("16");
		user2.setUserName("miku");
		list.add(user1);
		list.add(user2);
		return "ok";
	}
}
