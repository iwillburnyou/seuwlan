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
	 * һ��������ѧ����Ϣʵ�����������ݳ�Ա�ĺ���
	 * @param stuno
	 * ѧ��
	 * @param name
	 * ����
	 * @param gender
	 * �Ա�
	 * @param grade
	 * �ɼ�
	 * @param depart
	 * Ժϵ
	 * @param major
	 * רҵ
	 * @param id
	 * ���֤����
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
	
	
//	ѧ��", "Two" }, { "����", "Four" }, { "�Ա�", "Four" }, { "�꼶", "Four" }
//	, { "Ժϵ", "Four" }, { "רҵ", "Four" }, { "���֤��", "Four" }

}
