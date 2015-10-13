package org.cx.test;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class JDBCTest {
	public static void main(String[] args) {
		try {
		   Class.forName("com.mysql.jdbc.Driver");
		   String url = "jdbc:mysql://localhost:3306/alfred1.0.18?generateSimpleParameterMetadata=true";
		   Connection conn  = DriverManager.getConnection(url,"root","123123");
		   DatabaseMetaData dbmd = conn.getMetaData(); 
		   ResultSet rs=dbmd.getTables(null,null,"%",null); 
		   while(rs.next()){ 
		  	 String str = rs.getString(3).substring(0,1);
		  	 str = str.toUpperCase();
		  	 System.out.println("<table schema=\"\" tableName=\""+rs.getString(3)+"\" domainObjectName=\""+str+rs.getString(3).substring(1)+"\" enableDeleteByPrimaryKey=\"false\" enableCountByExample=\"false\" enableUpdateByExample=\"false\" enableDeleteByExample=\"false\"></table>");
		   }
	  } catch (Exception e) {
	   e.printStackTrace();		  
	  }
	}
}
