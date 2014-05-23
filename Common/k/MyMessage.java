package k;

import java.io.Serializable;

import org.omg.CORBA.UNKNOWN;

import k.MessageType;
/**
 * 消息的实体类
 * @author 王一多
 *  		
 */
public class MyMessage implements Serializable,MessageType{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int cmd;
	Object  ob;
	/**
	 * MyMessage构造函数
	 * @param cmd
	 *  int型的命令，指明是哪个操作
	 *  @param ob
	 *  一个封装好的随消息附带的参数，包含操作需要的全部信息
	 */
	
	public MyMessage(int cmd , Object ob) {
		this.cmd = cmd;
		this.ob = ob;
	}
	
	public MyMessage() {
		this.cmd = NULL_MESSAGE;
		this.ob = null;
	}
	public int getCmd() {
		return cmd;
	}
	public void setCmd(int cmd) {
		this.cmd = cmd;
	}
	public Object getOb() {
		return ob;
	}
	public void setOb(Object ob) {
		this.ob = ob;
	}
	public String toString() {
		return ""+cmd+ob;
	}
}
