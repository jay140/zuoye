package net;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class userDao {
	private DBUtil dbutil;
	private Connection conn;
	private Statement stmt;
	public userDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public void init() throws ClassNotFoundException, IOException, SQLException {
		dbutil=new DBUtil();
		dbutil.init("DBConfig.properties");
		conn=dbutil.getConnection();
		stmt=conn.createStatement();
	}
	public ResultSet chaxun(String sql) throws ClassNotFoundException, SQLException{
		// ִ�в�ѯ
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}

	// �޸�����
	public int updateData(String sql) throws SQLException{
		if((stmt.executeUpdate(sql)!=0)) {
			return 1;
		}
		return 0;
	}

	// ɾ������
	public int deleteDate(String sql) throws SQLException{
		stmt.executeUpdate(sql);
		return 1;
	}
	
	//��������
	public int addData(String sql) throws SQLException {
		if((stmt.executeUpdate(sql)!=0)) {
			return 1;
		}
		return 0;
	}

	
	/*//��ҳ��ѯ
	public ResultSet pageFind(String table,int page,int num) throws SQLException {
		ResultSrs=stmt.executeQuery("select * from "+table+"limit "+(page-1)*num+","+num);
		return rs;
	}
	//��ѯ��������
	public ResultSet objectFind(people peo,String table) throws SQLException {
		rs= stmt.executeQuery("select * from"+table+"where name='"+peo.getName()+"'and psw='"+peo.getPsw()+"'");
		return rs;			
	}
	//��ѯ��������
	public ResultSet DataFind(String name,String table) throws SQLException {
		rs= stmt.executeQuery("select * from"+table+"where name='"+name+"'");
		return rs;			
	}*/
}
