package yc;

public class User {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void add(){
		System.out.println("add.....................");
	}
	
	/*public static void main(String[] args) {
		//原始做法
		User user = new User();
		user.add();
	}*/
}
