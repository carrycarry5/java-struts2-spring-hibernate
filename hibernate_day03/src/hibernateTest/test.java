package hibernateTest;

import hibernateManyToMany.ManyToManyTest;
import utils.HibernateUtils;

public class test {
	public static void main(String[] args) {
		//HibernateOneToMany.add1();     //��������1
		//HibernateOneToMany.add2();   //��������2
		//HibernateOneToMany.delete(); //����ɾ��
		//HibernateOneToMany.update();      //�޸Ĳ���
		
		//��Զ����
		//ManyToManyTest.MTMAdd();             //�����������
		//ManyToManyTest.MTMDelete();           //����ɾ������
		ManyToManyTest.MTMTable();
	}
}
