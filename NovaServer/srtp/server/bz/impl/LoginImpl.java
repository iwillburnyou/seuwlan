package srtp.server.bz.impl;

import java.sql.SQLException;
import java.util.Vector;

import srtp.server.dao.DbHelper;
import k.MessageType;
import k.User;
/**
 * 服务器端登陆模块的功能函数
 * @author
 */
public class LoginImpl implements MessageType{
	/**
	 * 按指定的sql语句获得一个用户实体类的信息
	 * @param ob
	 * 一条指定的sql语句
	 * @return User
	 * 用户实体类
	 */
	public static User getMessage(String ob) {
		User tempUser = new User();
		Vector<Vector<String>> vVector = DbHelper.executeQuery(ob);
		Vector<String> vector =  vVector.firstElement();
		if(vector.size()>0){
			tempUser.setCardNo((String)vector.get(0));
			tempUser.setPsd((String)vector.get(1));
			tempUser.setStudentNo((String)vector.get(2));
			tempUser.setName((String)vector.get(3));
			tempUser.setRole((String)vector.get(4));	
			return tempUser;
		}
		else{
			return null;
		}
	}
	/**
	 * 注册的服务器端操作
	 * @throws SQLException
	 */
	public static void registerNew(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}
	/**
	 * 修改密码功能的服务器端操作
	 */
	public static void changePSD(String ob) throws SQLException {
		DbHelper.executeUpdate(ob);
	}
	/**
	 * 登陆
	 */
	public static boolean Login(User ob) {
		// TODO Auto-generated method stub
		String sql = "select * from userInfo where u_cardNo='" + ob.getCardNo()+"'";
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		
		if(vec.size()!=0){
			Vector<String> re = vec.firstElement();
			
			//System.out.println(re.get(1));
			ob.setCardNo(re.get(1));
			ob.setStudentNo(re.get(2));
			ob.setName(re.get(3));
			ob.setRole(re.get(5));
			ob.setAccounts(Integer.parseInt(re.get(6)));
			ob.setEmailAdd(re.get(7));
			if (ob.getPsd().equals(re.get(4)))
				return true;
			else
				return false;
		}
		return false;
		
	}
	public static void registerNew(User ob) {
		// TODO Auto-generated method stub
		String sql="insert into userInfo (u_cardNo,u_StuNo,u_name,u_psd,u_role,u_accounts,u_emailAdd)values ('"
				+ob.getCardNo()+"','"
				+ob.getStudentNo()+"','"
				+ob.getName()+"','"
				+ob.getPsd()+"','"
				+ob.getRole()+"',"
				+ob.getAccounts()+",'"
				+ob.getEmailAdd()+"')";
		
		DbHelper.executeUpdate(sql);
		
	}

}
;