package deta;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

//模型封装
public class DataDemo2Action extends ActionSupport implements ModelDriven<User>{
	//创建对象
    private User user = new User();

    public String execute() throws Exception {

        System.out.println(user);
        return NONE;
    }

    @Override
    public User getModel() {
        return user;
    }

}
