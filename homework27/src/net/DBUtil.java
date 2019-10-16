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
	 * �������ݿ������ļ�
	 * 
	 * @param pFile
	 * @throws IOException
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public void init(String pFile) throws IOException, ClassNotFoundException, SQLException {
		// ����Properties����
		Properties prop = new Properties();
		//���������ļ�
		prop.load(DBUtil.class.getClassLoader()
				.getResourceAsStream(pFile));
		DRIVER= prop.getProperty("DRIVER");
		CONN_STR= prop.getProperty("CONN_STR");
		USER = prop.getProperty("USER");
		PWD = prop.getProperty("PWD");
		//���ݻ�ȡ������Ϣ�������Ӷ���
		Class.forName(DRIVER);
		conn = DriverManager.getConnection(
				CONN_STR, 
				USER, 
				PWD);
		
	}

	// ��ȡ���Ӷ���
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		if (null == conn || conn.isClosed()) {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(CONN_STR, USER, PWD);
		}
		return conn;
	}
	// �ر�����
		public int  closeConnection() throws SQLException {
			if (null != conn && !conn.isClosed()) {
				conn.close();
			}
			return 1;
		}

	// ��ѯ����
}
