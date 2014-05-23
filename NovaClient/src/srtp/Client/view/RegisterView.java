package src.srtp.Client.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import src.srtp.Client.bz.impl.LoginImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import k.User;

public class RegisterView extends JFrame {

	private MyPanel contentPane;
	private JTextField strCardNo;
	private JTextField strStuNo;
	private JTextField strName;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField strEmAdd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterView frame = new RegisterView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegisterView() {
		setBackground(Color.WHITE);
		this.setUndecorated(true);  
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);     
		this.setVisible(true);
		setBounds(500, 200, 450, 300);
		contentPane = new MyPanel();
		setContentPane(contentPane);
		try {
			setPanelBac("topbg.png",contentPane);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		panel_1.setBounds(10, 89, 430, 201);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("一卡通号：");
		label.setBounds(10, 10, 72, 22);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("学号：");
		label_1.setBounds(10, 40, 72, 22);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("姓名：");
		label_2.setBounds(10, 70, 72, 22);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("输入密码：");
		label_3.setBounds(10, 130, 72, 22);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("确认密码");
		label_4.setBounds(10, 160, 72, 22);
		panel_1.add(label_4);
		
		strCardNo = new JTextField();
		strCardNo.setBounds(90, 10, 120, 22);
		panel_1.add(strCardNo);
		strCardNo.setColumns(10);
		
		strStuNo = new JTextField();
		strStuNo.setColumns(10);
		strStuNo.setBounds(90, 40, 120, 22);
		panel_1.add(strStuNo);
		
		strName = new JTextField();
		strName.setColumns(10);
		strName.setBounds(90, 70, 120, 22);
		panel_1.add(strName);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(90, 130, 120, 22);
		panel_1.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(90, 160, 120, 22);
		panel_1.add(passwordField_1);
		
		JButton btnConfirm = new JButton("确认注册");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				if (strCardNo.getText().isEmpty() 
						|| strEmAdd.getText().isEmpty() 
						|| strName.getText().isEmpty() 
						|| strStuNo.getText().isEmpty() 
						
						) {
					JOptionPane.showMessageDialog(contentPane, "请填完整的注册信息~");
					return ;
				}
				if(!passwordField.getText().equals(passwordField_1.getText())) {
					JOptionPane.showMessageDialog(contentPane, "两次输入密码不一致~");
					passwordField_1.setText("");
					return ;
				}
				u.setCardNo(strCardNo.getText());
				u.setName(strName.getText());
				u.setStudentNo(strStuNo.getText());
				u.setEmailAdd(strEmAdd.getText());
				u.setPsd(passwordField.getText());
				u.setRole("平民");
				if(LoginImpl.registerNew(u)) {
					JOptionPane.showMessageDialog(contentPane, "注册成功~");
					close();
					return ;
				}
				else {
					JOptionPane.showMessageDialog(contentPane, "Oops，注册失败了，我也不知道怎么回事~");
					return ;
				}
				
			}
		});
		btnConfirm.setBounds(269, 44, 93, 23);
		panel_1.add(btnConfirm);
		
		JButton btnReWrite = new JButton("重新填写");
		btnReWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				strCardNo.setText("");
				strEmAdd.setText("");
				strName.setText("");
				strStuNo.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
			
			}
		});
		btnReWrite.setBounds(269, 79, 93, 23);
		panel_1.add(btnReWrite);
		
		JLabel label_5 = new JLabel("电子邮箱：");
		label_5.setBounds(10, 100, 72, 22);
		panel_1.add(label_5);
		
		strEmAdd = new JTextField();
		strEmAdd.setColumns(10);
		strEmAdd.setBounds(90, 100, 120, 22);
		panel_1.add(strEmAdd);
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
