package src.srtp.Client.vo;

import java.io.Serializable;


public class StudentInfo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String StudentNo;
	public String Name;
	public String Gender;
	public String Grade;
	public String Department;
	public String Major;
	public String ID;
	/**
	 * 一次性设置学籍信息实体类所有数据成员的函数
	 * @param stuno
	 * 学号
	 * @param name
	 * 姓名
	 * @param gender
	 * 性别
	 * @param grade
	 * 成绩
	 * @param depart
	 * 院系
	 * @param major
	 * 专业
	 * @param id
	 * 身份证号码
	 */
	public void setAll(String stuno,String name,String gender , String grade, String depart ,String major ,String id){
		this.StudentNo = stuno;
		this.Name = name;
		this.Gender =gender ;
		this.Grade = grade;
		this.Department = depart;
		this.Major = major;
		this.ID = id;
		
	}
	
	
//	学号", "Two" }, { "姓名", "Four" }, { "性别", "Four" }, { "年级", "Four" }
//	, { "院系", "Four" }, { "专业", "Four" }, { "身份证号", "Four" }

}
