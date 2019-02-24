package hibernateTest;

import hibernateManyToMany.ManyToManyTest;
import utils.HibernateUtils;

public class test {
	public static void main(String[] args) {
		//HibernateOneToMany.add1();     //级联保存1
		//HibernateOneToMany.add2();   //级联保存2
		//HibernateOneToMany.delete(); //级联删除
		//HibernateOneToMany.update();      //修改操作
		
		//多对多操作
		//ManyToManyTest.MTMAdd();             //级联保存操作
		//ManyToManyTest.MTMDelete();           //级联删除操作
		ManyToManyTest.MTMTable();
	}
}
