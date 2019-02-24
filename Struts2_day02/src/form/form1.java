package form;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class form1  extends ActionSupport{
	@Override
	public String execute() throws Exception {
		//method1();
		
		//method2();
		
		//操作三个域对象(request,session,servletContext)
		//1.request域(最多)
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("req", "reqValue");
		
		//2.session域
		HttpSession session = req.getSession();
		session.setAttribute("session", "sessionValue");
		
		//3.servletContext域
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("context", "contextValue");
		
		
		return NONE;
	}

	public void method2() {
		//第二种方法
		//1,使用ServletActionContext类获取request方法
		HttpServletRequest req = ServletActionContext.getRequest();
		//2.调用get方法
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		System.out.println(user+"    "+password);
	}

	public void method1() {
		//第一种方法：使用ActionContext获取
		//1.获取ActionContext类对象
		ActionContext ac = ActionContext.getContext();
		//2.调用方法获取表单数据
		//key是表单输入项的name属性值，value是表单内容
		Map<String, Object>map = ac.getParameters();
		Set<String >keys = map.keySet();
		for (String string : keys) {
			//根据key得到value(数组,因为输入项里面可能有复选框)
			Object[] obj = (Object[]) map.get(string);
			System.out.println(Arrays.toString(obj));
		}
	}
}
