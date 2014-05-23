package k;

import java.io.Serializable;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;


/**
 * 无参数构造函数的特征是 u.getRole()=="none"
 * @author kidd
 *
 */
public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	String cardNo;  //key value?
	String studentNo;
	String name;		
	String psd;	
	String role;
	
	String emailAdd;
	
	int accounts;
	

	public User(String str1,String str2,String str3,String str4,String str5,String str6, int acc){
		cardNo = str1;
		studentNo = str2;
		name = str3;
		psd = str4;
		role = str5;
		emailAdd = str6;
		accounts = acc ;
	}

	public String getEmailAdd() {
		return emailAdd;
	}

	public void setEmailAdd(String emailAdd) {
		this.emailAdd = emailAdd;
	}

	public int getAccounts() {
		return accounts;
	}

	public void setAccounts(int accounts) {
		this.accounts = accounts;
	}

	public User(User user){
		this.cardNo = user.cardNo;
		this.name = user.name;
		this.studentNo = user.studentNo;
		this.psd = user.psd;
		this.role = user.role;
		this.emailAdd = user.emailAdd;
		this.accounts = user.accounts;
	}
	public User() {
		// TODO Auto-generated constructor stub
		this.role ="none";
		this.accounts =100;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

	public void setUser(User user) {
		// TODO Auto-generated method stub
		this.cardNo = user.cardNo;
		this.name = user.name;
		this.studentNo = user.studentNo;
		this.psd = user.psd;
		this.role = user.role;
		this.emailAdd = user.emailAdd;
		this.accounts = user.accounts;
		
	}






	



}


