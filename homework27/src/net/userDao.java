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
		// 执行查询
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}

	// 修改数据
	public int updateData(String sql) throws SQLException{
		if((stmt.executeUpdate(sql)!=0)) {
			return 1;
		}
		return 0;
	}

	// 删除数据
	public int deleteDate(String sql) throws SQLException{
		stmt.executeUpdate(sql);
		return 1;
	}
	
	//增加数据
	public int addData(String sql) throws SQLException {
		if((stmt.executeUpdate(sql)!=0)) {
			return 1;
		}
		return 0;
	}

	
	/*//分页查询
	public ResultSet pageFind(String table,int page,int num) throws SQLException {
		ResultSrs=stmt.executeQuery("select * from "+table+"limit "+(page-1)*num+","+num);
		return rs;
	}
	//查询单个对象
	public ResultSet objectFind(people peo,String table) throws SQLException {
		rs= stmt.executeQuery("select * from"+table+"where name='"+peo.getName()+"'and psw='"+peo.getPsw()+"'");
		return rs;			
	}
	//查询单个数据
	public ResultSet DataFind(String name,String table) throws SQLException {
		rs= stmt.executeQuery("select * from"+table+"where name='"+name+"'");
		return rs;			
	}*/
}
