package deta;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import entity.User;

//ģ�ͷ�װ
public class DataDemo2Action extends ActionSupport implements ModelDriven<User>{
	//��������
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
