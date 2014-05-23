package srtp.server.bz.impl;

import java.security.Key;
import java.sql.SQLException;
import java.util.Vector;

import k.MessageType;
import k.MyMessage;
import k.User;
import k.bookInfo;


import src.srtp.Client.view.Page_detail;
import srtp.server.bz.impl.StuInfoImpl;
import srtp.server.dao.DbHelper;


public class CommonImpl implements k.MessageType {

	public static boolean executeCmd(MyMessage mm) throws SQLException {
		String sql;
		System.out.println("server executeCmd:" + mm.getCmd());
		switch (mm.getCmd()) {
		case BYE_BYE:
			return false;
		/**
		 * 登陆模块消息处理
		 */
		case  LOGIN :
			if (LoginImpl.Login( (User) mm.getOb() ) )
				return true;
			else 
				return false;
		
		case REGISTER_NEW :
			
			sql="select * from userInfo where u_cardNo='"+ ((User)mm.getOb()).getCardNo()+"'";
			
			Vector<Vector> vec = DbHelper.executeQuery(sql);
			
			if(vec.size()!=0){
				mm.setOb("注册的一卡通号已经存在~");
				return false;
			}
			LoginImpl.registerNew((User)mm.getOb());
			return true;
			
		/**
		 * 我的书院模块消息处理
		 */
		case SHOW_COLLECTION:
			mm.setOb(MylibImpl.showCollection( (User)mm.getOb()));
			return true;
			
		case SHOW_HAVE_BUY :
			mm.setOb(MylibImpl.showHaveBuy( (User)mm.getOb()));
			return true;
		
		case SHOW_WILL_SELL :
			mm.setOb(MylibImpl.showWillSell( (User)mm.getOb()));
			return true;
		
		case SHOW_HAVE_SELL :
			mm.setOb(MylibImpl.showHaveSell( (User)mm.getOb()));
			return true;
		case DELETE_COLLECTION :
			MylibImpl.delCollection((String)mm.getOb());
			return true;
		case DEL_HAVEBUY:
			MylibImpl.delHaveBuy((String)mm.getOb());
			return true;
		case DEL_HAVESELL :
			MylibImpl.delHaveSell((String)mm.getOb());
			return true;
		case DEL_WILLSELL:
			MylibImpl.delWillSell((String)mm.getOb());
			return true;
		/**
		 * 我的书包
		 */
		case SHOW_WILL_BUY:
			mm.setOb(MylibImpl.showWillBuy( (User)mm.getOb()));
			return true;
		
		case ADD_WANT_BUY:
			if (MyBagImpl.addWantBuy((bookInfo)mm.getOb())) {
				return true;
			}
			else {
				return  false;
			}
		case ADD_WANT_SELL:
			if (MyBagImpl.addWantSell((bookInfo)mm.getOb())) {
				return true;
			}
			else {
				return  false;
			}
		case SHOW_NEED_BOOK:
			mm.setOb(MyBagImpl.showNeedBook());
			return true;
		case DEL_CART:
			MyBagImpl.delCart((String)mm.getOb());
			return true;
		case BUY_ONE_BOOK:
			mm.setOb(MyBagImpl.buyOneBook((String)mm.getOb()));
			return true;
			/**
			 * 主界面消息处理
			 */
		case SHOW_GUESSBOOK :
			mm.setOb(MainFrameImpl.showGuessBook( (User)mm.getOb() ) );
			return true;
		case SHOW_HOT :
			mm.setOb(MainFrameImpl.showHot()) ;
			return true;
		case INIT_HEALTH:
			mm.setOb(MainFrameImpl.initHealth()) ;
			return true;
		case INIT_ENTERTAINMENT:
			mm.setOb(MainFrameImpl.initEntertainment()) ;
			return true;
		case INIT_ACADEMIC:
			mm.setOb(MainFrameImpl.intAcademic()) ;
			return true;
		case ADD_CART :
			MainFrameImpl.addCart( (String) mm.getOb());
			return true;
		
		case ADD_COLLECTION:
			MainFrameImpl.addCollection( (String) mm.getOb());
			return true;
		case INIT_DETAIL :
			MainFrameImpl.initDetail( (Page_detail) mm.getOb());
			return true;
			
			
		


		
		default:
			System.out.println("command not found!");
			return false;

		}
	}
}
