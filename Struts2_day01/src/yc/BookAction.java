package yc;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport{
	public String add(){
		System.out.println("addAction");
		return NONE;
	}
	
	public String delete(){
		System.out.println("deleteAction");
		return NONE;
	}
}
