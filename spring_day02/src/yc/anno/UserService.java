package yc.anno;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

@Component(value="service")
public class UserService {
	//�õ�dao����
	//����������ʹ��ע�����ע��
	//@Autowired   //(�Զ�ע��)
	@Resource(name="dao")
	private UserDao  userDao ;
	//ʹ��ע��ע��ʱ����Ҫset����
	
	
	public void add(){
		userDao.add();
		System.out.println("service............");
	}
}
