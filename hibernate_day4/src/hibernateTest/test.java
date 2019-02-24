package hibernateTest;

import utils.HibernateUtils;

public class test {
	public static void main(String[] args) {
		//HibernateSelect.select1();                        //对象导航查询
		//HibernateSelect.select2();                        //hql
		//HibernateSelect.select3();                          //QBC查询
		HibernateManyTable.select2();
	}
}
