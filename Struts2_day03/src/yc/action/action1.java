package yc.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
//��ȡֵջ�����ַ���
public class action1 extends ActionSupport {
	private String username;
	
	public String getUsername() {
		return username;
	}
	

	
	@Override
	public String execute() throws Exception {
		//��һ��:ʹ��ֵջ�����set����
		//method1();
		//�ڶ��֣�ʹ��ֵջ�����push����
		//method2();
		//�����֣���action�ﶨ��һ�����������ɱ�����get��������Ҫ��
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
