package yc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class JdbcReview {
	@Test
	public void test() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//��������
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn = DriverManager.getConnection("jdbc:mysql://localhost/springday_03", "root","123");
			String sql = "select * from user";
			ps=conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				//�õ����صĽ��ֵ
				String name = rs.getString("username");
				String password = rs.getString("password");
				System.out.println(name+"      "+password);
			}
			
			
		} catch (Exception e) {
			if (conn!=null) {
				conn.rollback();
			}
			e.printStackTrace();
		} finally {
			if (conn!=null) {
				conn.close();
			}
			if (ps!=null) {
				ps.close();
			}
			if (rs!=null) {
				rs.close();
			}
		}
	}
}
