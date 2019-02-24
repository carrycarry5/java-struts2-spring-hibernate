package yc.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class Mybook {
	
	public void before1(){
		System.out.println("前置增强：/...");
	}
	public void after1(){
		System.out.println("后置增强");
	}
	
	//环绕通知
	public void arround1(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
		//方法前
		System.out.println("方法之前执行");
		//被增强的方法
		proceedingJoinPoint.proceed();
		//方法后
		System.out.println("方法之后执行");
	}
}
