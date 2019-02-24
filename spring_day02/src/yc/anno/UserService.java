package yc.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component(value="service")
public class UserService {
	//得到dao对象
	//在属性上面使用注解完成注入
	//@Autowired   //(自动注入)
	@Resource(name="dao")
	private UserDao  userDao ;
	//使用注解注入时不需要set方法
	
	
	public void add(){
		userDao.add();
		System.out.println("service............");
	}
}
