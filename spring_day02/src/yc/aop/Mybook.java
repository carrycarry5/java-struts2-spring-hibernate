package yc.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Mybook {
	
	public void before1(){
		System.out.println("ǰ����ǿ��/...");
	}
	public void after1(){
		System.out.println("������ǿ");
	}
	
	//����֪ͨ
	public void arround1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//����ǰ
		System.out.println("����֮ǰִ��");
		//����ǿ�ķ���
		proceedingJoinPoint.proceed();
		//������
		System.out.println("����֮��ִ��");
	}
}
