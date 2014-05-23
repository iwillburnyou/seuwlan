package k;

import java.io.Serializable;

public class FeedBackMMS implements Serializable {
	private static final long serialVersionUID = 1L;
	private int flag = 0; // regist
	private String cardNo; // from
	private String text; // contain
	private String to; // to
	
	public FeedBackMMS(String from, String string) {
		this.cardNo = from;
		this.text = string;
	}
	
	public FeedBackMMS(int i, String from) {
		this.setFlag(i);
		this.cardNo = from;
	}
	public FeedBackMMS(String from, String to, String string) {
		this.cardNo = from;
		this.text = string;
		this.to= to;
	}
	
	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	
}
