package yc.jdbc;

import java.sql.DriverManager;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.jdbc.PreparedStatement;

public class JDBCTemplateDemo1 {
	@Test
	public void query(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost/springday_03");
		dm.setUsername("root");
		dm.setPassword("123");
		//����JDBCTemplate������������Դ
		JdbcTemplate template = new JdbcTemplate(dm);
		
		/*String sql = "select count(*) from user";
		//����jdbcTemplate�ķ���
		int count = template.queryForObject(sql, Integer.class);
		System.out.println(count);*/
		
		String sql = "select * from user";
		
	}
	
	
	public void update(){
		//�������ݿ���Ϣ
				DriverManagerDataSource dm = new DriverManagerDataSource();
				dm.setDriverClassName("com.mysql.jdbc.Driver");
				dm.setUrl("jdbc:mysql://localhost/springday_03");
				dm.setUsername("root");
				dm.setPassword("123");
				//����JDBCTemplate������������Դ
				JdbcTemplate template = new JdbcTemplate(dm);
				
				/*String sql  = "update user set password=? where username=?";
				template.update(sql,"12345" ,"carry");*/
				
				/*String sql = "delete from user where username=?";
				template.update(sql,"carry");*/
				
	}
	public void add(){
		//�������ݿ���Ϣ
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setDriverClassName("com.mysql.jdbc.Driver");
		dm.setUrl("jdbc:mysql://localhost/springday_03");
		dm.setUsername("root");
		dm.setPassword("123");
		
		//����JDBCTemplate������������Դ
		JdbcTemplate template = new JdbcTemplate(dm);
		
		String sql = "insert into user values(?,?)";
		template.update(sql,"carry","123");
	}
}
