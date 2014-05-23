package srtp.server.bz.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.sun.org.apache.regexp.internal.recompile;


import srtp.server.dao.DbHelper;
import k.MessageType;
import k.MyMessage;
import src.srtp.Client.vo.*;
/**
 * 服务器端学籍管理模块的功能函数
 * @author 王一多
 */	
public class StuInfoImpl implements MessageType{
	/**
	 * 服务器端更新一名学生信息的函数
	 * @author 王一多
	 * @param ob
	 * 学生信息实体类对象
	 */	
	static void updateStu(StudentInfo ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql;
		sql="delete from tblStudentInfo where StudentNo ='"+ob.StudentNo+"'";
		DbHelper.executeUpdate(sql);
		 sql="insert into tblStudentInfo (StudentNo,StuName,Gender,Grade,Department,Major,IDNumber)values ('"
				+ob.StudentNo+"','"
				+ob.Name+"','"
				+ob.Gender+"','"
				+ob.Grade+"','"
				+ob.Department+"','"
				+ob.Major+"','"
				+ob.ID+"')";
		DbHelper.executeUpdate(sql);
	}
	/**
	 * 按学号来进行查询
	 * @param No
	 * 学号
	 */
	static StudentInfo queryByNo(String No) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "select * from tblStudentInfo where StudentNo='"+No+"'";

		StudentInfo si = new StudentInfo();
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		if(vec.size()!=0){
			Vector<String> re = vec.firstElement();
			si.setAll(re.get(1), re.get(2) , re.get(3), re.get(4), re.get(5), re.get(6), re.get(7));
		}
		else {
			//查无此人？？
			return null;
		}
		//可以重用
//		if( rs.next() )
//			si.setAll(rs.getString("StudentNo"), rs.getString("StuName"), rs.getString("Gender"), rs.getString("Grade"), rs.getString("Department"), rs.getString("Major"), rs.getString("IDNumber"));
		return si;
	}
/**
 * 按学生姓名来查询
 */
	static StudentInfo queryByName(String Name) {
		// TODO Auto-generated method stub
		String sql = "select * from tblStudentInfo where StuName='"+Name+"'";
		//System.out.println("in queryByName");
		StudentInfo si = new StudentInfo();
		Vector<Vector> vec = DbHelper.executeQuery(sql);
		System.out.println(vec.size());
		if(vec.size()!=0){
			Vector<String> re = vec.firstElement();
			si.setAll(re.get(1), re.get(2) , re.get(3), re.get(4), re.get(5), re.get(6), re.get(7));
		}
		else {
			//查无此人？？
			return null;
		}
		return si;
	}

	static void addStu(StudentInfo ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql="insert into tblStudentInfo (StudentNo,StuName,Gender,Grade,Department,Major,IDNumber)values ('"
				+ob.StudentNo+"','"
				+ob.Name+"','"
				+ob.Gender+"','"
				+ob.Grade+"','"
				+ob.Department+"','"
				+ob.Major+"','"
				+ob.ID+"')";
		
		DbHelper.executeUpdate(sql);
		
	}
	/**
	 * 删除一个学生学籍信息的服务器端操作
	 */
	public static void delStu(String ob) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "delete from tblStudentInfo where StudentNo = '"+ob+"'";
		DbHelper.executeUpdate(sql);
	}
}
