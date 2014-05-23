package src.srtp.Client.view;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.TableRowSorter;

import sun.nio.cs.HistoricallyNamedCharset;
import sun.security.x509.IPAddressName;

import k.MessageType;


//import view.admin.lib.LibAdminView;
/**
 * 选课模块管理员界面
 * @author kidd
 *
 */
public class AdminView extends JFrame implements ActionListener,MessageType {

	// 顶部面板
	private JPanel jp = new JPanel();
	ImageIcon icon = new ImageIcon(this.getClass().getResource("/image/返回.png"));
	
	private JButton jbReturn = new JButton(icon);
	private JButton jbSeeAllSubject = new JButton("所有课程");
	
	private JButton jbAddSubject = new JButton("添加课程");
	private JButton jbModifySubject = new JButton("修改课程");
	private JButton jbDelSubject = new JButton("删除课程");
	private ImageIcon background;
	
//	private JPanel imagePanel;
	Font font = new Font("微软雅黑", Font.ROMAN_BASELINE, 15);




	public AdminView() {

		
		
     	background = new ImageIcon(this.getClass().getResource("/image/选课系统管理员.jpg"));// 背景图片
     	JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
     	label.setBounds(0,0, background.getIconWidth(),background.getIconHeight());// 把标签的大小位置设置为图片刚好填充整个面板
     	// 把内容窗格转化为JPanel，否则不能用方法setOpaque()来使内容窗格透明
     	jp = (JPanel) this.getContentPane();
     	this.getLayeredPane().setLayout(null);
     	jp.setOpaque(false);
     	// 内容窗格默认的布局管理器为BorderLayout
     	jp.setLayout(null);
     	
 
     	
     	jbReturn.setBounds(450, 10, 30, 30);

     	jbReturn.setBorder(null);
     	jbReturn.setContentAreaFilled(false);
        jp.add(jbReturn);
     	
     	
     	jbAddSubject.setBounds(150, 190, 80, 30);
     	jbAddSubject.setFont(font);
     	jbAddSubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbAddSubject.setBorder(null);
     	jbAddSubject.setContentAreaFilled(false);
     	jbAddSubject.setBorder(BorderFactory.createRaisedBevelBorder());
        jp.add(jbAddSubject);
        
     	jbModifySubject.setBounds(250, 190, 80, 30);
     	jbModifySubject.setFont(font);
     	jbModifySubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbModifySubject.setBorder(null);
     	jbModifySubject.setContentAreaFilled(false);
     	jbModifySubject.setBorder(BorderFactory.createRaisedBevelBorder());
     	jp.add(jbModifySubject);
     	
     	jbDelSubject.setBounds(150, 230, 80, 30);
     	jbDelSubject.setFont(font);
     	jbDelSubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbDelSubject.setBorder(null);
     	jbDelSubject.setContentAreaFilled(false);
     	jbDelSubject.setBorder(BorderFactory.createRaisedBevelBorder());
     	jp.add(jbDelSubject );
     	
     	jbSeeAllSubject.setBounds(250, 230, 80, 30);
     	jbSeeAllSubject.setFont(font);
     	jbSeeAllSubject.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
     	jbSeeAllSubject.setBorder(null);
     	jbSeeAllSubject.setContentAreaFilled(false);
     	jbSeeAllSubject.setBorder(BorderFactory.createRaisedBevelBorder());
     	jp.add(jbSeeAllSubject);
     	
     	 this.getLayeredPane().setLayout(null);
     	// 把背景图片添加到分层窗格的最底层作为背景
     	 this.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
     	 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	 this.setLocation(400, 200);
     	 this.setSize(background.getIconWidth(), background.getIconHeight());
     	 this.setResizable(false);
     	
     	 this.setUndecorated(true); 
     	 this.setVisible(true);
     	 
     	  jbSeeAllSubject.addActionListener(this);
		  jbAddSubject.addActionListener(this);
		  jbModifySubject.addActionListener(this);
		  jbDelSubject.addActionListener(this);
		  jbReturn.addActionListener(this);
	
	

		
			
			
			 try {
				UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (UnsupportedLookAndFeelException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 *选课模块管理员界面各种按钮响应函数
	 * @author kidd
	 *
	 */

	public void actionPerformed(ActionEvent e) {


	}
	public static void main(String[] args) {
		AdminView f1=new AdminView();}
}