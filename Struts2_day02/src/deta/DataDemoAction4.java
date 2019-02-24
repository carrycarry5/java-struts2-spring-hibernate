package deta;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

//表达式封装
public class DataDemoAction4 extends ActionSupport {

	private List<User> list;
	

	public List<User> getList() {
		return list;
	}


	public void setList(List<User> list) {
		this.list = list;
	}


	public String execute() throws Exception {
		System.out.println(list);
        return NONE;
    }






}
