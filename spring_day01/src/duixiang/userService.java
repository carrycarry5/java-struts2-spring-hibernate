package duixiang;

public class userService {
	private userDao u;
	
	public void setU(userDao u) {
		this.u = u;
	}


	public void add(){
		System.out.println("service.....................");
		u.add();
		
	}
}
