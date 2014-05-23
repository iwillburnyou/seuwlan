package k;


/**
 * MESSAGE TYPE
 * 
 * 常量定义
 * 
 * @author 全体成员
 *
 */
public interface MessageType {
	
	final int BYE_BYE = -1;
	final int NULL_MESSAGE = 666;
	/**
	 * Login
	 */
	final int STU_LOG_IN = 0;
	final int MANAGER_LOG_IN = 1;
	
	/**
	 * 服务器端操作成功与否，通知客户端
	 */
	final int SERVER_OPERATION_SUCC =3290;
	final int SERVER_OPERATION_FAIL = 3291;
	

	/***
	 * 我的书院界面
	 */
	final int SHOW_COLLECTION =10;
	final int SHOW_HAVE_BUY = 11;
	final int SHOW_WILL_SELL = 12;
	final int SHOW_HAVE_SELL =13;
	
	final int DEL_HAVEBUY = 14;
	final int DEL_HAVESELL = 15;
	final int DEL_WILLSELL =16;
	/**
	 * 我的书包界面
	 */
	final int SHOW_WILL_BUY = 20;
	final int ADD_WANT_BUY = 21;
	final int ADD_WANT_SELL = 22;
	final int SHOW_NEED_BOOK = 23;
	final int BUY_ONE_BOOK = 24;
	/***
	 *MainFrame界面
	 */
	
	final int SHOW_GUESSBOOK = 30;
	final int SHOW_HOT = 31;
	final int INIT_HEALTH = 32;
	final int INIT_ENTERTAINMENT = 33;
	final int INIT_ACADEMIC = 34;
	final int ADD_CART = 35;
	final int ADD_COLLECTION = 36;
	final int INIT_DETAIL = 37;
	final int DELETE_COLLECTION = 38;
	final int DEL_CART = 39;

	

	
	/**
	 * 信息反馈，注册
	 */
	final int STU_REGISTER = 71;	//学生请求注册
	final int FEEDBACK = 72;		//信息反馈，留言板

	
	////liuyuchen
	final int GET_MESSAGE = 500;
	final int REGISTER_NEW = 501;
	final int CHANGE_PSD = 502;
	final int LOGIN = 503;






	

	

	
	
	

	
	
	

}
