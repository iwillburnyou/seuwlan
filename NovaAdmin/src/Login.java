import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import src.srtp.Client.bz.impl.LoginImpl;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import k.MessageType;
import k.MyMessage;
import k.User;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	
	User user;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param mfAdmin 
	 */
	public Login(final Mainframe_admin mfAdmin) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 359, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("用户名：");
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label.setBounds(61, 30, 68, 33);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码：");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		label_1.setBounds(61, 86, 50, 33);
		contentPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(121, 28, 146, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(121, 87, 146, 33);
		contentPane.add(passwordField);
		
		JButton button = new JButton("登陆");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyMessage  mm = LoginImpl.logIn(textField.getText(), passwordField.getText()) ;
			
				//	JOptionPane.showMessageDialog(contentPane, "登陆成功","登陆成功！", JOptionPane.INFORMATION_MESSAGE);
			//	System.out.println(mm.getCmd());
				//&&
					if (mm.getCmd() ==MessageType.SERVER_OPERATION_SUCC   ) {
						user = (User)mm.getOb();
						if (	 user.getRole().equals("admin")) {
							JOptionPane.showMessageDialog(contentPane, "Welcome "+( (User)mm.getOb()).getName() +"！");
							
							user = (User)mm.getOb();
							mfAdmin.u.setUser(user);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(contentPane, "用户名或密码错误！");
							passwordField.setText("");
						}

					}
					else {
						JOptionPane.showMessageDialog(contentPane, "用户名或密码错误！");
						passwordField.setText("");
					}
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
			}
		});
		button.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button.setBounds(61, 143, 93, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				dispose();
			}
		});
		button_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		button_1.setBounds(174, 143, 93, 23);
		contentPane.add(button_1);
	}
}
