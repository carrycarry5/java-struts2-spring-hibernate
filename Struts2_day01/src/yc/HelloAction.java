package yc;

public class HelloAction {
	/*
	 * 1.每次访问servlet时，都会执行service方法
	 * 		创建一个类继承httpservlet，重写里面的方法
	 * 		在web。xml里面配置访问路径
	 * 2.每次访问action时，都会执行execute方法
	 * 		配置action的访问路径
	 */
	public  String execute(){
		return "ok";
	}
	public String add(){
		return "ok";
	}
	
	
}
