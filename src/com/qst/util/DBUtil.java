package com.qst.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 数据库工具类
 * @author qst
 *
 */
public class DBUtil {
	
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	
	static { //类加载得时候执行一次，对类进行初始化
		Properties props=new Properties();
		InputStream inStream=DBUtil.class.getClassLoader().getResourceAsStream("db.properties");//读取数据文件的数据到输入流
		try {
			props.load(inStream);//将数据加载到属性对象中
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//从属性文件中获取数据库配置信息
		driver=props.getProperty("driver");
		url=props.getProperty("url");
		username=props.getProperty("username");
		password=props.getProperty("password");
	}
	
	//获取数据库得连接
	public static Connection getConn() throws ClassNotFoundException,SQLException{
		Class.forName(driver);//1. 加载驱动
		Connection conn=DriverManager.getConnection(url, username, password); //2.获取连接
		return conn;
	}
	
	
	//释放资源
	public static void closeAll(Connection conn,Statement stmt, ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();//首先关闭数据集
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally { //在rs的finally代码块中关闭处理对象，是为了无论rs的关闭情况如何，处理对象的关闭代码一定能被执行
			try {
				if(stmt!=null) {
					stmt.close(); //然后关闭处理对象
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					if(conn!=null) {
						conn.close(); //最后关闭连接
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
