package yc.anno;

import org.springframework.stereotype.Component;

@Component(value="dao")
public class UserDao {
	
	public void add(){
		System.out.println("dao.....");
	}
}
