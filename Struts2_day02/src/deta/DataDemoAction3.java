package deta;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

//表达式封装
public class DataDemoAction3 extends ActionSupport {
	//创建对象
    private User user ;
    private User user1;

    public User getUser() {
		return user;
	}
    HttpServletRequest request = ServletActionContext.getRequest();

	public void setUser(User user) {
		this.user = user;
	}
	


	public User getUser1() {
		return user1;
	}


	public void setUser1(User user1) {
		this.user1 = user1;
	}


	public String execute() throws Exception {
		System.out.println(user1);
        System.out.println(user);
        return NONE;
    }

}
