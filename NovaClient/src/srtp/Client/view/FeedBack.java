package src.srtp.Client.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import k.FeedBackMMS;
import k.User;
import src.srtp.Client.bz.impl.ChatSocketHelper;
import javax.swing.JTextField;

public class FeedBack extends JFrame implements ActionListener {

	private JPanel contentPane;
	JTextArea sendMms = new JTextArea();
	private static JTextArea textArea = new JTextArea();
	private static User user;
	private JTextField txtToWhom;
	
	/**
	 * Create the frame.
	 */

	public FeedBack(User user) {
		setResizable(false);
		this.user = user;
		setBounds(100, 100, 531, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(this);
		btnNewButton.setBounds(412, 402, 93, 23);
		contentPane.add(btnNewButton);

		JLabel lbe_name = new JLabel(user.getName());
		lbe_name.setBounds(124, 14, 104, 23);
		contentPane.add(lbe_name);
		textArea.setEditable(false);

		textArea.setBounds(10, 43, 393, 283);
		contentPane.add(textArea);

		sendMms.setBounds(10, 349, 393, 76);
		contentPane.add(sendMms);

		JLabel lbe_No = new JLabel(user.getCardNo());
		lbe_No.setBounds(10, 14, 104, 23);
		contentPane.add(lbe_No);
		
		txtToWhom = new JTextField();
		txtToWhom.setText("to whom");
		txtToWhom.setBounds(412, 371, 93, 21);
		contentPane.add(txtToWhom);
		txtToWhom.setColumns(10);

		ChatSocketHelper.getConection();
		ChatSocketHelper.Send(new FeedBackMMS(1, user.getCardNo())); // to regist
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getActionCommand() == "Send") {
			FeedBackMMS mms = new FeedBackMMS(user.getCardNo(), txtToWhom.getText(), sendMms.getText());
			System.out.println("send b...");
			ChatSocketHelper.Send(mms);
			sendMms.setText(null);
		}
	}
	
	public static void closed() {
		if (user != null) {
			FeedBackMMS mms = new FeedBackMMS(-1, user.getCardNo());
			System.out.println("chat client closed...");
			ChatSocketHelper.Send(mms);
			ChatSocketHelper.close();
		}
		
	}

	public static JTextArea getTextArea() {
		return textArea;
	}

	public static void setTextArea(JTextArea textArea) {
		FeedBack.textArea = textArea;
	}
}
