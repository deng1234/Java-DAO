package DB;

import java.sql.Connection;
public interface DatabaseConnection {
//	取得数据库的连接
	public Connection getConnection();
//	关闭数据库的连接
	public void close();
}
