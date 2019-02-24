package yc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
//获取值栈的三种方法
public class action1 extends ActionSupport {
	private String username;
	
	public String getUsername() {
		return username;
	}
	

	
	@Override
	public String execute() throws Exception {
		//第一种:使用值栈对象的set方法
		//method1();
		//第二种：使用值栈对象的push方法
		//method2();
		//第三种：在action里定义一个变量，生成变量的get方法（主要）
		username="miku";
		return "ok";
	}

	public void method2() {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		stack.push("carry");
	}

	public void method1() {
		ActionContext context = ActionContext.getContext();
		ValueStack stack = context.getValueStack();
		stack.set("username", "carry");
	}
}
