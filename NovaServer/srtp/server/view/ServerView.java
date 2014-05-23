package srtp.server.view;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.net.ServerSocket;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListModel;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;

import com.sun.org.apache.bcel.internal.generic.NEW;

import srtp.server.bz.thread.MainThread;
import srtp.server.bz.thread.SerChatSocket;
import srtp.server.dao.DbHelper;



/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
/**
 * 服务器的视类，也是服务器的启动类
 * @author 王一多
 */
public class ServerView extends javax.swing.JFrame {
	private JButton btnStartSer;
	private JButton btnExitSer;
	public static int count = 0;	//统计在线数
	private MainThread mth = null;			// 开启服务器线程
	private SerChatSocket chat = null;
	private String str = "";             //更新jTextField的字符串
	private JLabel jLabel2;
	private JLabel jLabel1;
	private JList jLServerInfo;
	private TimerTask tt;
	private Timer t;
	private JLabel dbReady;
	private DefaultComboBoxModel cbm = null;
	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ServerView inst = new ServerView();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ServerView() {
		super();
		initGUI();
		
		tt=new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				jLabel2.setText(""+count);
			}
		};
		
		t = new Timer();
		t.schedule(tt, 0, 3000);
		String db = ""+DbHelper.getConnection();
		DbHelper.close();
		System.out.println(db);
		if(!db.equals("null"))
		{
			dbReady.setText("datebase connected!");
			dbReady.setEnabled(false);
			
		}
		
			
	}
	/**
	 * 服务器视类界面的初始化函数
	 */
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			getContentPane().setLayout(null);
			
			btnStartSer = new JButton();
			getContentPane().add(btnStartSer, "Center");
			btnStartSer.setText("start");
			btnStartSer.setBounds(252, 21, 87, 75);
			btnStartSer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnStartSerActionPerformed(evt);
				}
			});
			btnExitSer = new JButton();
			getContentPane().add(btnExitSer);
			btnExitSer.setText("quit");
			btnExitSer.setBounds(252, 107, 87, 70);
			{
				 cbm = 
						new DefaultComboBoxModel(
								new String[] { "server 界面启动" });
				jLServerInfo = new JList();
				getContentPane().add(jLServerInfo);
				jLServerInfo.setModel(cbm);
				jLServerInfo.setBounds(22, 21, 172, 203);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u5f53\u524d\u5728\u7ebf\u4eba\u6570:");
				jLabel1.setBounds(216, 228, 84, 22);
			}
			{
				jLabel2 = new JLabel();
				getContentPane().add(jLabel2);
				jLabel2.setText("0");
				jLabel2.setBounds(305, 231, 34, 17);
			}
			{
				dbReady = new JLabel();
				getContentPane().add(dbReady);
				dbReady.setBounds(3, 236, 191, 16);
			}
			btnExitSer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					btnExitSerActionPerformed(evt);
				}
			});

			
			//this.setUndecorated(true); 
			pack();
			this.setSize(381, 296);
			this.setResizable(true);
			this.setTitle("服务器端界面");
			this.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					thisWindowClosing(evt);
				}
			});
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}
	/**
	 * 服务器退出按钮的响应函数
	 */
	private void btnExitSerActionPerformed(ActionEvent evt) {
		if(chat != null) {
			chat.close();
			chat = null;
		}
		if(mth!=null) {
			mth.close();
			mth.interrupt();
			mth = null;
			
			btnStartSer.setVisible(true);
			btnExitSer.setVisible(false);
		}
		
		cbm.addElement(new String("服务器关闭！"));
		jLServerInfo.setModel(cbm);
		count = 0;
		System.exit(0);
		
	}
	
	/**
	 * 服务器启动按钮的响应函数
	 */
	private void btnStartSerActionPerformed(ActionEvent evt) {

		//TODO add your code for btnStartSer.actionPerformed
		System.out.println("btnStartSer.actionPerformed, event="+evt.getActionCommand());

		chat = new SerChatSocket();
		mth = new MainThread();
		
		cbm.addElement(new String("服务器启动！"));
		jLServerInfo.setModel(cbm);
		count = 0;
		btnExitSer.setVisible(true);
		btnStartSer.setVisible(false);
		
		 
	}
	/**
	 * 服务器红叉按钮的响应函数
	 */
	private void thisWindowClosing(WindowEvent evt) {
		System.out.println("this.windowClosing, event="+evt.getID());
		//mth.close();
		btnExitSerActionPerformed(null);
		t.cancel();
		this.dispose();
		
		
		//TODO add your code for this.windowClosing
	}

}
