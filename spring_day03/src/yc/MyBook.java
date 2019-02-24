package yc;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyBook {
	@Before(value = "execution(* yc.Book.*(..))")
	public void before1(){
		System.out.println("before");
	}
}
