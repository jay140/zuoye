package net;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {
	private String DRIVER="";
	private String CONN_STR="";
	private String USER="";
	private String PWD="";
	private Connection conn;

	/**
	 * 加载数据库配置文件
	 * 
	 * @param pFile
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void init(String pFile) throws IOException, ClassNotFoundException, SQLException {
		// 创建Properties对象
		Properties prop = new Properties();
		//加载配置文件
		prop.load(DBUtil.class.getClassLoader()
				.getResourceAsStream(pFile));
		DRIVER= prop.getProperty("DRIVER");
		CONN_STR= prop.getProperty("CONN_STR");
		USER = prop.getProperty("USER");
		PWD = prop.getProperty("PWD");
		//根据获取到的信息创建连接对象
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(
				CONN_STR, 
				USER, 
				PWD);
		
	}

	// 获取连接对象
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if (null == conn || conn.isClosed()) {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONN_STR, USER, PWD);
		}
		return conn;
	}
	// 关闭连接
		public int  closeConnection() throws SQLException {
			if (null != conn && !conn.isClosed()) {
				conn.close();
			}
			return 1;
		}

	// 查询数据
}
