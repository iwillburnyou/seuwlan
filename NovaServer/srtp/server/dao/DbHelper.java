/**
 * 功能：封装与数据库的连接以及对数据库的操作
 */
package srtp.server.dao;

import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.Vector;



import sun.misc.IOUtils;



/**
 * 连接数据库的帮助类，采用odbc桥接连接相对路径下的数据库 MydateBase.mdb
 * @author 王一多
 */
public class DbHelper {
	//private static UserReader ur = new UserReader(); // 辅助类，用于从文件读取服务端数据库的用户名和密码
	public static void main(String[] args) {
		//System.out.println(getConnection());
		close();
	}
	private static final String DB_DRIVER_NAME = "sun.jdbc.odbc.JdbcOdbcDriver";
//	private static final String DB_PWD = ur.getUserPwd(); // 连接数据库的密码
//	private static final String DB_UNAME = ur.getUserName(); // 连接数据库的帐号
	private static  String url;
	public static String dbpath = "";
	public static Connection conn = null;
	private static Statement stt = null;
	private static ResultSet result = null;

	public DbHelper() {
		
	}

	/**
	 * 获取连接数据库的Connection
	 * 
	 * @return Connection
	 */
	public static Connection getConnection() {
		try {
			// 加载驱动
			Class.forName(DB_DRIVER_NAME);
			
//			File tempDir = new File(System.getProperty("java.io.tmpdir"));
//			File temporaryFile = new File(tempDir, "my.mdb");
//			InputStream templateStream = DbHelper.class.getResourceAsStream("db/my.mdbt");
//			IOUtils.copy(templateStream, new FileOutputStream(temporaryFile));
//			String absolutePath = temporaryFile.getAbsolutePath();
			URL u = new DbHelper().getClass().getProtectionDomain().getCodeSource().getLocation();
			
			
			try {
				dbpath = u.toURI().getPath();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//dbpath = dbpath.replace("server.jar", "datebase/");
			//dbpath = dbpath.replace("CampusServer/", "datebase/");
			dbpath+="NovaDatabase.accdb";
			dbpath = dbpath.substring(1);
			//System.out.println(dbpath);
			//String dbpath = new File("").getAbsolutePath().replace('\\', '/') + "/MyDateBase.mdb";
			// 获得连接
			url = "jdbc:odbc:DRIVER={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+dbpath;
			conn = DriverManager.getConnection(url, "", null);
			conn.setAutoCommit(true);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		return null;
	}

	/**
	 * 执行更新数据库操作
	 * 
	 * @param sql
	 *            数据库操作命令语句
	 * 
	 * @return 是否操作成功
	 * @throws SQLException 
	 */
	public static boolean executeUpdate(String sql) {
		
			getConnection();
			System.out.println("executeUpdate\n"+sql);
			try {
				stt = conn.createStatement();
				stt.executeUpdate(sql);
				System.out.println("update talbe!");
				return true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			finally{
				close();
			}
			
			
			
			
	}
	/**
	 * 执行查询操作
	 * 
	 * @param sql
	 *            数据库操作命令语句
	 * 
	 * @return 返回存放有结果集中数据的vector ,这是个二维数组
	 */
	public static Vector executeQuery(String sql) {
		System.out.println("executeQuery\n"+sql);
		Vector rowData = new Vector();
		try {
			getConnection();
			stt = conn.createStatement();
			result = stt.executeQuery(sql);
			ResultSetMetaData rsmd = result.getMetaData();

			while (result.next()) {
				Vector record = new Vector();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					record.add(result.getString(i));
				}
				rowData.add(record);
			}
			return rowData;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rowData;
	}

	/**
	 * 关闭连接
	 */
	public static void close() {
		try {
			if (result!=null ) {
				
					result.close();
					result = null;
		
			}
				
			if (stt!=null )
				stt.close();
			if (conn!=null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
