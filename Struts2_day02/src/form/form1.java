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
		
		//�������������(request,session,servletContext)
		//1.request��(���)
		HttpServletRequest req = ServletActionContext.getRequest();
		req.setAttribute("req", "reqValue");
		
		//2.session��
		HttpSession session = req.getSession();
		session.setAttribute("session", "sessionValue");
		
		//3.servletContext��
		ServletContext context = ServletActionContext.getServletContext();
		context.setAttribute("context", "contextValue");
		
		
		return NONE;
	}

	public void method2() {
		//�ڶ��ַ���
		//1,ʹ��ServletActionContext���ȡrequest����
		HttpServletRequest req = ServletActionContext.getRequest();
		//2.����get����
		String user = req.getParameter("user");
		String password = req.getParameter("password");
		System.out.println(user+"    "+password);
	}

	public void method1() {
		//��һ�ַ�����ʹ��ActionContext��ȡ
		//1.��ȡActionContext�����
		ActionContext ac = ActionContext.getContext();
		//2.���÷�����ȡ������
		//key�Ǳ��������name����ֵ��value�Ǳ�����
		Map<String, Object>map = ac.getParameters();
		Set<String >keys = map.keySet();
		for (String string : keys) {
			//����key�õ�value(����,��Ϊ��������������и�ѡ��)
			Object[] obj = (Object[]) map.get(string);
			System.out.println(Arrays.toString(obj));
		}
	}
}
