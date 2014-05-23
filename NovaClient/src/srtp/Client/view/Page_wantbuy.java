package src.srtp.Client.view;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import src.srtp.Client.bz.impl.MyBag;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import k.bookInfo;

public class Page_wantbuy extends JPanel {
	private JTextField tfBookName;
	private JTextField tfAuthor;
	private JTextField tfPress;
	
	bookInfo bi;
	/**
	 * Create the panel.
	 */
	public Page_wantbuy() {
		final JPanel jPane = this;
		this.setPreferredSize(new Dimension(1000,500));
		setBackground(Color.white);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(37, 50, 372, 278);
		panel.setOpaque(false);
		add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("书名：");
		label.setBounds(10, 32, 54, 15);
		panel.add(label);
		
		JLabel label_1 = new JLabel("作者：");
		label_1.setBounds(10, 67, 54, 15);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("出版社：");
		label_2.setBounds(10, 92, 54, 15);
		panel.add(label_2);
		
		tfBookName = new JTextField();
		tfBookName.setBounds(70, 29, 66, 21);
		panel.add(tfBookName);
		tfBookName.setColumns(10);
		
		tfAuthor = new JTextField();
		tfAuthor.setColumns(10);
		tfAuthor.setBounds(70, 58, 66, 21);
		panel.add(tfAuthor);
		
		tfPress = new JTextField();
		tfPress.setColumns(10);
		tfPress.setBounds(70, 89, 66, 21);
		panel.add(tfPress);
		
		JButton button = new JButton("提交信息");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bi = new bookInfo();
				bi.setAuthor(tfAuthor.getText());
				bi.setBook_name(tfBookName.getText());
				bi.setPress(tfPress.getText());
				
				boolean succ = MyBag.addWantBuy(bi);
				if (succ) {
					JOptionPane.showMessageDialog(jPane, "求书信息发布成功~");
					
				} else {
					JOptionPane.showMessageDialog(jPane, "求书信息发布失败~");
				}
			}
		});
		button.setBounds(10, 137, 93, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("clear");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfAuthor.setText("");
				tfBookName.setText("");
				tfPress.setText("");
				
			}
		});
		button_1.setBounds(10, 170, 93, 23);
		panel.add(button_1);
		
		JLabel lblNewLabel = new JLabel("显示照片");
		lblNewLabel.setBounds(224, 15, 93, 118);
		panel.add(lblNewLabel);
		
		JButton button_2 = new JButton("上传照片");
		button_2.setBounds(224, 137, 93, 23);
		panel.add(button_2);

	}
}
