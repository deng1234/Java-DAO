package DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	//数据库连接驱动
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	//数据库连接地址，我这里直接将数据库名字web放在后面了
	private static final String DBULR = "jdbc:mysql://localhost:3306/web";
	// 数据库用户名	
	private static final String USERNAME = "root";
	// 数据库密码	
	private static final String PASSWORD = "root";
	private Connection conn;
	// 取得数据库连接
	public Connection getConnection() throws Exception{
		try {
			// 加载驱动程序
			Class.forName(DBDRIVER);
			// 取得数据库连接，获得资源句柄
			this.conn = DriverManager.getConnection(DBULR,USERNAME,PASSWORD);
		}catch(Exception e) {
			throw e;
		}
		return this.conn;
	}
	// 关闭数据库连接	
	public void close() throws Exception{
		if(this.conn != null) {
			try{
				this.conn.close();
			}catch(Exception e) {
				throw e;
			}
		}
	}
}
