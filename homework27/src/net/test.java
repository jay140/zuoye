package net;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		Userservice test=new Userservice();
		test.init();
		System.out.println(test.peopleall());
	}

}
