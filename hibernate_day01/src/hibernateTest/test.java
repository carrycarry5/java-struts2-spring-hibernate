package hibernateTest;

import hibernateSelectAll.CriteriaData;
import hibernateSelectAll.QueryData;
import hibernateSelectAll.SqlQueryData;

public class test {

	public static void main(String[] args) {
		//hibernateAdd.add();    //添加
		//hibernateSelect.select();     //查询
		//hibernateUpdate.update();   //修改
		//hibernateDelete.delete();         //删除
		
		//QueryData.quaryData();             //Query查询所有
		//CriteriaData.criteriaData();            //criteria查询所有
		SqlQueryData.criteriaData();             //SQLQuery查询所有
		
	}

}
