import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;

import src.srtp.Client.bz.impl.CommonImpl;
import src.srtp.Client.util.SocketHelper;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import k.User;


public class Mainframe_admin extends JFrame {

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainframe_admin frame = new Mainframe_admin();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	User u;
	Mainframe_admin mfAdmin;
	public Mainframe_admin() throws IOException {
		
		mfAdmin = this;
		u = new User();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				 if(CommonImpl.os != null)
					   CommonImpl.closeSocket();
			}
		});

		
		CommonImpl.initSocket();
		
		setBounds(100, 100,800, 532);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		final Page_alreadyhave page_alreadyhave =new Page_alreadyhave();
		page_alreadyhave.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		page_alreadyhave.setVisible(false);
		page_alreadyhave.setBounds(-9,20,791,500);	
		getContentPane().add(page_alreadyhave);
		
		final Page_user page_user =new Page_user();
		page_user.setVisible(false);
		page_user.setBounds(-9,20,791,500);	
		getContentPane().add(page_user);
		
		final Page_buy page_buy =new Page_buy();
		page_buy.setVisible(false);
		page_buy.setBounds(-9,20,791,500);	
		getContentPane().add(page_buy);
		
		final Page_sell page_sell =new Page_sell();
		page_sell.setVisible(false);
		page_sell.setBounds(-9,20,791,500);	
		getContentPane().add(page_sell);
		
		final Page_alreadybuy page_alreadybuy =new Page_alreadybuy();
		page_alreadybuy.setVisible(false);
		page_alreadybuy.setBounds(-9,20,791,500);	
		getContentPane().add(page_alreadybuy);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 669, 32);
		getContentPane().add(menuBar);
		
		JMenu menu_book = new JMenu("已有书籍");
		menu_book.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0){
				page_alreadyhave.setVisible(true);
				page_user.setVisible(false);
				page_sell.setVisible(false);
				page_buy.setVisible(false);
				page_alreadybuy.setVisible(false);
			}
		});
		menu_book.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		menuBar.add(menu_book);
		
		JMenu menu_user = new JMenu("已有用户");
		menu_user.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_alreadyhave.setVisible(false);
				page_user.setVisible(true);
				page_sell.setVisible(false);
				page_buy.setVisible(false);
			}
		});
		menu_user.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		menuBar.add(menu_user);
		
		JMenu menu_sell = new JMenu("用户卖书");
		menu_sell.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_alreadyhave.setVisible(false);
				page_user.setVisible(false);
				page_sell.setVisible(true);
				page_buy.setVisible(false);
				page_alreadybuy.setVisible(false);
			}
		});
		
		JMenu menu_alreadybuy = new JMenu("用户买书");
		menu_alreadybuy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				page_alreadyhave.setVisible(false);
				page_user.setVisible(false);
				page_sell.setVisible(false);
				page_buy.setVisible(false);
				page_alreadybuy.setVisible(true);
			}
		});
		menu_alreadybuy.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		menuBar.add(menu_alreadybuy);
		menu_sell.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		menuBar.add(menu_sell);
		
		JMenu menu_buy = new JMenu("用户求书");
		menu_buy.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_alreadyhave.setVisible(false);
				page_user.setVisible(false);
				page_sell.setVisible(false);
				page_buy.setVisible(true);
				page_alreadybuy.setVisible(false);
			}
		});
		menu_buy.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		menuBar.add(menu_buy);
		
		JButton btnNewButton = new JButton("未登录");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				 if (u.getRole()=="none") {
					 Login login=new Login(mfAdmin);
						login.show();
				}
				 else {
					JOptionPane.showMessageDialog(mfAdmin, "请不要重复登陆");
				}
			}
		});
		btnNewButton.setBounds(669, 0, 113, 32);
		getContentPane().add(btnNewButton);

	}
}
