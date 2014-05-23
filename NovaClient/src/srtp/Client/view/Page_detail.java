package src.srtp.Client.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JButton;

import java.io.File;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import src.srtp.Client.bz.impl.MainFImpl;

import k.User;
import k.bookInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page_detail extends JPanel {

	/**
	 * Create the panel.
	 */
	bookInfo bi;
//	MainFrame ptrMf;
	String cardNo;
	boolean isCollected;
	boolean isInCart;
	Page_detail ptrThis;
	public JButton button_2 = new JButton("");//返回上级
	public boolean isCollected() {
		return isCollected;
	}
	public void setCollected(boolean isCollected) {
		this.isCollected = isCollected;
	}
	public boolean isInCart() {
		return isInCart;
	}
	public void setInCart(boolean isInCart) {
		this.isInCart = isInCart;
	}

	//public boolean flag_back=false;
	public bookInfo getBi() {
		return bi;
	}
	public void setBi(bookInfo bi) {
		this.bi = bi;
		setId(bi.getBook_id());
		update();
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	String book_id;
	JLabel label_show_id = new JLabel("");
	JLabel label_show_name = new JLabel("数字逻辑与数字系统");
	JLabel label_show_author = new JLabel("王永军");
	JLabel label_show_press = new JLabel("电子工业出版社");
	JLabel lblA = new JLabel("A(全新)");
	JLabel show_price = new JLabel("20");
	
	JLabel label_repertory = new JLabel("库存：10\r\n");
	JLabel label_havesell = new JLabel("卖出：100\r\n");
	JLabel label_rank = new JLabel("9.2");
	
	JLabel label = new JLabel("显示图片");
	JPanel panel = new JPanel();
	public Page_detail(String no, final bookInfo bi) {
		ptrThis = this;
		isCollected = false;
		isInCart = false;
		cardNo = no;
		this.setBi(bi);
	
		this.setPreferredSize(new Dimension(1000,900));
		setLayout(null);
		setBackground(Color.white);	
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(25, 25, 112));
		separator.setBounds(30, 245, 944, 2);
		add(separator);
		panel.setBackground(Color.WHITE);
		
		
		panel.setBounds(30, 2, 944, 243);
		add(panel);
		panel.setLayout(null);
		
		
		label.setBounds(30, 0,230, 230);
		panel.add(label);
		
		MyPicture_big book_pic=new MyPicture_big(bi.getBook_id());	
		book_pic.setBounds(0,0, 230, 220);
		label.add(book_pic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(260, 25, 230, 157);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_2 = new JLabel("书籍编号：");
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		label_2.setBounds(10, 32, 80, 20);
		panel_1.add(label_2);
		
		JLabel label_4 = new JLabel("作者：");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_4.setBounds(10,60, 68,20);
		panel_1.add(label_4);
		
		JLabel label_5 = new JLabel("出版社：");
		label_5.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_5.setBounds(10,85,68,20);
		panel_1.add(label_5);
		
		JLabel label_6 = new JLabel("新旧等级：");
		label_6.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_6.setBounds(10, 110, 68,20);
		panel_1.add(label_6);
		
		JLabel label_7 = new JLabel("价格：");
		label_7.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		label_7.setBounds(10, 135, 68,20);
		panel_1.add(label_7);
		label_show_id.setForeground(Color.LIGHT_GRAY);
		label_show_id.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		
		
		label_show_id.setBounds(80, 32, 140,20);
		label_show_id.setText(book_id);
		panel_1.add(label_show_id);
		label_show_name.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		
		label_show_name.setBounds(10, 8, 210,20);
		panel_1.add(label_show_name);
		label_show_author.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		label_show_author.setBounds(90,60, 90, 20);
		panel_1.add(label_show_author);
		label_show_press.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		label_show_press.setBounds(90,85, 112,20);
		panel_1.add(label_show_press);
		lblA.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		lblA.setBounds(90, 110, 118, 25);
		panel_1.add(lblA);
		show_price.setFont(new Font("微软雅黑", Font.PLAIN, 13));
		
		show_price.setBounds(90,135, 80, 20);
		panel_1.add(show_price);
		
		/**
		 * init detail 
		 */
		if(cardNo!=null)
			MainFImpl.initDetail(this);
		
		
		final JButton button = new JButton("");//加入购物车

		button.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if (!isInCart) { // if not InCart
					MainFImpl.AddCart(bi.getBook_id(), cardNo);
					isInCart = true;
					JOptionPane.showMessageDialog(ptrThis, "加入购物车成功~");
				//	button.setEnabled(false);
				}
				else {
//					MainFImpl.DelCart(bi.getBook_id(), cardNo);
//					isInCart = false;
				//	button.setEnabled(true);
				}
			}
		});

		button.setBounds(450, 190, 110, 40);
		button.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_add_to_cart.png"));
		button.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"icon_add_to_cart_move.png"));
		button.setFocusPainted(false);
		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		panel.add(button);
		
		final JButton button_1 = new JButton("");//加入收藏夹
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (!isCollected) { // if not collected
					MainFImpl.AddCollection(bi.getBook_id(), cardNo);
					isCollected = true;
					button_1.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
			                + "/" +"image"+ File.separator+"icon_fav_active.png"));
				}
				else {
					MainFImpl.DeleteCollection(bi.getBook_id(), cardNo);
					isCollected = false;
					button_1.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
			                + "/" +"image"+ File.separator+"icon_fav_inactive.png"));
					
				}
					
			}
		});
		button_1.setBounds(570, 190, 110, 40);
	//	System.out.println(bi.getBook_id()+" "+isCollected);
		if (isCollected) {
			button_1.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_fav_active.png"));
		}
		else 
			button_1.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"icon_fav_inactive.png"));
		button_1.setFocusPainted(false);
		button_1.setBorderPainted(false);
		button_1.setContentAreaFilled(false);
		panel.add(button_1);
		
		
		
		button_2.setBounds(690, 190, 110, 40);
		button_2.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"icon_back.png"));
		button_2.setFocusPainted(false);
		button_2.setBorderPainted(false);
		button_2.setContentAreaFilled(false);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");//联系客服
		button_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
		});
		button_3.setBounds(810, 190, 110, 40);
		button_3.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"icon_cservice.png"));
		button_3.setFocusPainted(false);
		button_3.setBorderPainted(false);
		button_3.setContentAreaFilled(false);
		panel.add(button_3);
		

		label_rank.setFont(new Font("微软雅黑", Font.BOLD | Font.ITALIC, 50));
		label_rank.setForeground(new Color(255, 140, 0));
		label_rank.setBounds(827, 50, 93, 62);
		panel.add(label_rank);
		

		label_havesell.setFont(new Font("微软雅黑", Font.PLAIN, 11));
		label_havesell.setBounds(837, 117, 58, 28);
		panel.add(label_havesell);
		
		
		label_repertory.setFont(new Font("微软雅黑", Font.PLAIN, 11));
		label_repertory.setBounds(837, 142, 58, 22);
		panel.add(label_repertory);
		
		JPanel panel_2 =  new JPanel();
		panel_2.setBackground(new Color(248, 248, 255));
		panel_2.setBounds(30, 257, 944, 276);
		add(panel_2);
		

	}

	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public void update()
	{
		 
		 
		label_show_id.setText(book_id);
		 
		 label_show_name.setText(bi.getBook_name());
		 label_show_author.setText(bi.getAuthor());
		 label_show_press.setText(bi.getPress());
			 lblA.setText(bi.getOldAndNew());
			 show_price.setText(bi.getPrice());
			 label_havesell.setText("卖出："+bi.getNum_sell());
			 label_repertory.setText("库存 : "+bi.getNum_left());
		MyPicture_big book_pic_2=new MyPicture_big(book_id);	
		book_pic_2.setBounds(0,0, 230, 250);
	//	label.remove(0);
		label.add(book_pic_2);
		panel.add(label);
	
	}
	public void setId(String a){
		this.book_id=a;
		
	}
}
