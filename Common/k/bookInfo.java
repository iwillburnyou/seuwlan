package k;

import java.io.Serializable;
import java.util.Vector;

public class bookInfo  implements Serializable{
	private static final long serialVersionUID = 1L;
	String book_name;
	String book_id;
	String author;
	String press;
	String version;
	String oldAndNew;
	String price;
	int intClass;
	public int getIntClass() {
		return intClass;
	}
	public void setIntClass(int intClass) {
		this.intClass = intClass;
	}
	int  num_sell;
	int num_left;
	
	public bookInfo () {
		
	}
	public bookInfo (String book_name1,
								String book_id1,
								String author1,
								String press1,
								String version1,
								String oldAndNew1,
								String price1,
								int  num_sell1,
								int num_left1) {
		
		book_name = book_name1;
		book_id = book_id1;
		author = author1;
		press = press1;
		version = version1;
		oldAndNew = oldAndNew1;
		price =  price1;
		num_sell =  num_sell1;
		num_left = num_left1;
		
	}
	public bookInfo(Vector vector) {
		// TODO Auto-generated constructor stub
		
		book_name = (String) (vector.get(1));
		book_id = (String) vector.get(2);
		author = (String) vector.get(3);
		oldAndNew = (String) vector.get(4);
		press = (String) vector.get(5);
		version = (String) vector.get(6);
	
		price = (String) vector.get(7);
		num_sell = Integer.parseInt((String) vector.get(8));
		num_left = Integer.parseInt((String) vector.get(9));

		
	}
	public String getOldAndNew() {
		return oldAndNew;
	}
	public void setOldAndNew(String oldAndNew) {
		this.oldAndNew = oldAndNew;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getNum_sell() {
		return num_sell;
	}
	public void setNum_sell(int num_sell) {
		this.num_sell = num_sell;
	}
	public int getNum_left() {
		return num_left;
	}
	public void setNum_left(int num_left) {
		this.num_left = num_left;
	}
	
	
}
