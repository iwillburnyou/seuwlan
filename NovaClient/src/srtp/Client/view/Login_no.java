package src.srtp.Client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;

import src.srtp.Client.bz.impl.CommonImpl;
import src.srtp.Client.bz.impl.LoginImpl;
import src.srtp.Client.util.SocketHelper;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import k.MessageType;
import k.MyMessage;
import k.User;

public class Login_no extends JFrame {

	private MyPanel contentPane;
	private JTextField text_name;
	private JPasswordField text_psd;
	private JButton btnFather;
	RegisterView rv;
	User  user;
	MainFrame mf;
	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public Login_no(MainFrame mfFrame ,JButton loginButton, final User u) throws IOException {

		
		mf = mfFrame;
		btnFather = loginButton;
		setBackground(Color.WHITE);
		this.setUndecorated(true);  
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);     
		this.setVisible(true);
		setBounds(500, 200, 450, 300);
		contentPane = new MyPanel();
		setContentPane(contentPane);
		setPanelBac("topbg.png",contentPane);
		contentPane.setLayout(null);
		
		JButton button_1 = new JButton("");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				close();
			}
		});
		button_1.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator +"nav_close_click.png"));
		button_1.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator +"nav_close.png"));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		button_1.setBounds(418, 0, 32, 23);
		contentPane.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 89, 200, 201);
		contentPane.add(panel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(220, 89, 220, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("\u7528\u6237\u540D\uFF1A");
		label.setFont(new Font("华文细黑", Font.PLAIN, 12));
		label.setBounds(10, 25, 58, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setFont(new Font("华文细黑", Font.PLAIN, 12));
		label_1.setBounds(10, 50, 58, 15);
		panel.add(label_1);
		
		text_name = new JTextField();
		text_name.setBounds(78, 22, 132, 21);
		panel.add(text_name);
		text_name.setColumns(10);
		
		JButton btnlogin = new JButton("\u767B\u9646");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MyMessage  mm = LoginImpl.logIn(text_name.getText(), text_psd.getText()) ;
			//	JOptionPane.showMessageDialog(contentPane, "登陆成功","登陆成功！", JOptionPane.INFORMATION_MESSAGE);
				if (mm.getCmd() ==MessageType.SERVER_OPERATION_SUCC) {
					JOptionPane.showMessageDialog(contentPane, "Welcome "+( (User)mm.getOb()).getName() +"！");
					btnFather.setText(  ( (User)mm.getOb()).getName() );
					user = (User)mm.getOb();
					u.setUser(user);
					mf.showGuessBook(u);
					mf.page_profession.cardNo = u.getCardNo();
					mf.page_entertainment.cardNo = u.getCardNo();
					mf.page_healthylife.cardNo  = u.getCardNo();
					mf.page_mylibrary.cardNo = u.getCardNo();
					mf.page_shoppingcartpage.cardNo = u.getCardNo();
					/**
					 * ASDF
					 */
			//		mf.setFeed(u);
					//mf.page_detail.setCardNo(u.getCardNo());
					///mf.page_profession.page_1.setCardNo(u.getCardNo());
					//mf.page_entertainment_0.page_1.setCardNo(u.getCardNo());
					//mf.page_healthylife_0.page_1.setCardNo(u.getCardNo());
					close();
					
				}
					
				else {
					JOptionPane.showMessageDialog(contentPane, "用户名或密码错误！");
					text_psd.setText("");
				}
				
			}
		});
		btnlogin.setBounds(20, 80, 67, 23);
		panel.add(btnlogin);
		
		JButton btnRegister = new JButton("\u6CE8\u518C");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 rv = new RegisterView();
					rv.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRegister.setBounds(58, 148, 93, 23);
		panel.add(btnRegister);
		
		JButton btnLostpsd = new JButton("\u5FD8\u8BB0\u5BC6\u7801");
		btnLostpsd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLostpsd.setBounds(97, 80, 93, 23);
		panel.add(btnLostpsd);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 130, 200, 2);
		panel.add(separator);
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBackground(Color.WHITE);
		
		text_psd = new JPasswordField();
		text_psd.setBounds(78, 47, 132, 21);
		panel.add(text_psd);
	}







	void setPanelBac(String a,MyPanel b) throws IOException{
		Image[] array = new Image[10];
		Image topimg = ImageIO.read(new File(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator + a));//�����ʵ��������ļ�·����
		array[0] = topimg;
		b.setPreferredSize(new Dimension(1000, 105));       
		b.setImg(topimg);
	}
	private void close() {
		// TODO Auto-generated method stub
		
		this.dispose();
	}
}
