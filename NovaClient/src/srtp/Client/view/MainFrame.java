package src.srtp.Client.view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.TableColumn;
import javax.swing.UIManager;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JSeparator;

import k.User;
import k.bookInfo;

import src.srtp.Client.bz.impl.CommonImpl;
import src.srtp.Client.bz.impl.MainFImpl;
import src.srtp.Client.bz.impl.MylibImpl;
import srtp.server.bz.impl.MainFrameImpl;

public class MainFrame extends JFrame {
	public static FeedBack feed;
	
	public final User u;
	 Login_no a;
	private JPanel contentPane;
	private Point pressedPoint;
	private JTextField textField;
	int i=0;
	final MyPicture rollPicture_0;
	final MyPicture rollPicture_1;
	final MyPicture rollPicture_2;
	final MyPicture rollPicture_3;
	final MyPicture rollPicture_4;
	final MainFrame mf;
	 
	 final Page_entertainment page_entertainment;
	 final Page_healthylife page_healthylife;
	 final Page_profession page_profession;
	 final Page_mylibrary page_mylibrary;
	 final Page_shoppingcartpage page_shoppingcartpage;  
	 final Page_wantbuy page_wantbuy;  
	 final Page_wantsell page_wantsell;  
	 final Page_system page_system; 
	 
	Vector<String > guessArr;
	Vector<String> rollPlace;
	String currentHotIndex ; // also serve as recommended  book index
	final Vector<bookInfo> vb;
	final Vector<bookInfo> vecHot;
	
	public static void main(String[] args) {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					MainFrame frame = new MainFrame();
					//Thread a=new Thread(rollPicture_1);
					/*Thread b=new Thread(rollPicture_2);
					Thread c=new Thread(rollPicture_3);
					Thread d=new Thread(rollPicture_4);
					Thread e=new Thread(rollPicture_5);*/
					
				    //a.start();
					//frame.setVisible(false);
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
	public MainFrame() throws IOException {
		
		/**
		 * connect to server
		 */
		CommonImpl.initSocket();
		currentHotIndex = "1";
		
		vb = new Vector<bookInfo>();
		vecHot = new Vector<bookInfo>();
		guessArr = new Vector<String >();
		guessArr.add("0");
		guessArr.add("1");
		guessArr.add("2");
		guessArr.add("3");
		guessArr.add("4");
		guessArr.add("5");
		guessArr.add("6");
		guessArr.add("7");
		guessArr.add("8");
		guessArr.add("9");
		final Vector<String> rollPlace = new Vector<String>();
		rollPlace.add("0");
		rollPlace.add("1");
		rollPlace.add("2");
		rollPlace.add("3");
		rollPlace.add("4");
		final JButton btnLogin = new JButton("\u672A\u767B\u5F55");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		mf = this;
		u = new User();
		setBackground(Color.WHITE);
		this.setUndecorated(true);  
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);     
		this.setBounds(200,20, 1000, 700);    
		this.setVisible(true);
		
		final JLabel ShadowLabel = new JLabel("");
		ShadowLabel.setOpaque(false);
		
		/**
		 * show book name and author!!!!
		 * !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		 */
		
		final JButton button_name = new JButton("book_name");
		button_name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		
		
		button_name.setForeground(Color.white);
		button_name.setFocusPainted(false);
		button_name.setContentAreaFilled(false);
		button_name.setBounds(10,65,100, 20);	
		button_name.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));
		
		
		final JButton button_author = new JButton("作者");
		button_author.addMouseListener(new MouseAdapter() {
			
			String strAuthor;
			public void mouseEntered(MouseEvent e) {
				strAuthor = button_author.getText();
				button_author.setText("<HTML><U>"+strAuthor+"</U></HTML>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_author.setText(strAuthor);
			}
		});
		
		button_author.setForeground(Color.white);
		button_author.setBounds(10,90,100,20);
		button_author.setFocusPainted(false);
		button_author.setContentAreaFilled(false);
		button_author.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));
	
		
		//this.setOpacity(1);
	
		//�����
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY, Color.DARK_GRAY));
		contentPane.setLayout(null);
		this.setContentPane(contentPane);
		
		
		 final MyPanel panel_1=new MyPanel();
		 final JPanel panel_3 = new JPanel();
		 MyPanel topPanel=new MyPanel();
		 final JLabel lblA = new JLabel("");	
		 page_profession=new Page_profession();
	
		 page_entertainment=new Page_entertainment();
		
		 page_healthylife	=new Page_healthylife();
		
		 page_mylibrary=new Page_mylibrary();
		  page_shoppingcartpage=new Page_shoppingcartpage();  
		  page_wantbuy=new Page_wantbuy();  
		  page_wantsell=new Page_wantsell();  
		  page_system=new Page_system(); 
		 
		
		//������
		
		topPanel.setBounds(0, 0, 1000, 121);
		setPanelBac("nav_bg.png", topPanel);
		topPanel.addMouseMotionListener(new  MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){   
				topPanel_mouseDragged(e);    
				} 
			});
		topPanel.addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){  
				topPanel_mousePressed(e);     
				}      
			});
		contentPane.add(topPanel);
		
		
		//��Ǳ�ǩ
		
		lblA.setBounds(283,61, 71, 37);
		setLabelBac_1("nav_checked_arrow.png",lblA);
		lblA.setLocation(320, 61);
		topPanel.setLayout(null);
		topPanel.add(lblA);
		
		
		//������ ��� ��С �ر�
		JPanel controlJP=new JPanel();
		controlJP.setBounds(930, 7, 60, 22);
		controlJP.setBorder(null);
		controlJP.setPreferredSize(new Dimension(60,22));
		controlJP.setOpaque(false);
		controlJP.setLayout(new GridLayout(1,0,0,0));
		topPanel.add(controlJP);
		//��С��
		JButton minJB=new JButton();
		controlJP.add(minJB);
		minJB.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"nav_minimize_click.png"));
		minJB.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				minJB_actionPerformed(e);
			}
		 });
		 minJB.setFocusPainted(false);
		 minJB.setBorderPainted(false);
		 minJB.setContentAreaFilled(false);
		 minJB.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_minimize.png"));
		 
		 //���
		 JToggleButton maxJB=new JToggleButton();
		 controlJP.add(maxJB);
		 maxJB.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_maximize_click.png"));
		 maxJB.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				maxJB_itemStateChanged(e);
			}
		 });
		 
		 maxJB.setRolloverSelectedIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_maximize_click.png"));
		 maxJB.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_maximize.png"));
		 maxJB.setFocusPainted(false);
		 maxJB.setBorderPainted(false);
		 maxJB.setContentAreaFilled(false);
		 	 
		 //�ر�
		 JButton closeJB=new JButton();
		 controlJP.add(closeJB);
		 closeJB.addActionListener(new ActionListener(){
    		 public void actionPerformed(ActionEvent e){
    			 closeJB_actionPerformed(e);
    		 }
		 });
		 closeJB.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_close_click.png"));
		 closeJB.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_close.png"));
		 closeJB.setFocusPainted(false);
		 closeJB.setBorderPainted(false);
		 closeJB.setContentAreaFilled(false);
		 
		 //�˵����
		 JPanel panel = new JPanel();
		 panel.setBounds(0, 84, 1000, 37);
		 panel.setBackground(new Color(42, 42, 66));
		 topPanel.add(panel);
		 panel.setLayout(null);
		
		 final JLabel bacLabel_3 = new JLabel("");
		 setLabelBac_1("btn.png",bacLabel_3);
		 bacLabel_3.setBounds(280, 8, 115, 23);
		 
		 //��ҳ ��һ�� �鵥���Ƽ�
		 
		 panel_1.setBackground(Color.WHITE);
		 setPanelBac("f.jpg",panel_1);
		 panel_1.setBounds(0, 120, 1000, 250);
		 contentPane.add(panel_1);
		 panel_1.setLayout(null);
		 ShadowLabel.setBounds(340, 95, 120, 120);
		 panel_1.add(ShadowLabel);
		 ShadowLabel.add(button_name);
		 ShadowLabel.add(button_author);
		 //��ҳ�ڶ���  ����
		 
		 panel_3.setBackground(Color.WHITE);
		 panel_3.setBounds(0, 370, 1000, 300);
		 contentPane.add(panel_3);
		 panel_3.setLayout(null);	
		 
		 
		
		
		 
		 page_profession.setBounds(0,120,1100,550);

		 page_profession.setVisible(false);
	 	 contentPane.add(page_profession);
	 	 //��������
	 	 //page_entertainment_0.page_1.setVisible(false);
		 page_entertainment.setBounds(0,120,1100,550);
		/* page_entertainment.setHorizontalScrollBarPolicy( 
		 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		 page_entertainment.setVerticalScrollBarPolicy( 
		 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		 JScrollBar bar_2 = page_entertainment.getVerticalScrollBar();
		 //bar.setBackground(Color.WHITE);
		 page_entertainment.getVerticalScrollBar().setUnitIncrement(30);*/
		 page_entertainment.setVisible(false);
	 	 contentPane.add(page_entertainment);
	 	 //�������
	 	 
		 page_healthylife.setBounds(0,120,1100,550);
		/* page_healthylife.setHorizontalScrollBarPolicy( 
		 JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		 page_healthylife.setVerticalScrollBarPolicy( 
		 JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		 JScrollBar bar_3 = page_healthylife.getVerticalScrollBar();
		 //bar.setBackground(Color.WHITE);
		 page_healthylife.getVerticalScrollBar().setUnitIncrement(30);*/
		 page_healthylife.setVisible(false);
	 	 contentPane.add(page_healthylife);
	 	 //�������
	 	
	 	 page_mylibrary.setBounds(0,120,1100,550);
		 page_mylibrary.setVisible(false);
	 	 contentPane.add(page_mylibrary);
	 	//�������
	 	
		 page_shoppingcartpage.setBounds(0,120,1100,550);
		 page_shoppingcartpage.setVisible(false);
	 	 contentPane.add(page_shoppingcartpage);
	 	 //
	 	 
		 page_wantbuy.setBounds(0,120,1100,550);
		 page_wantbuy.setVisible(false);
	 	 contentPane.add(page_wantbuy);
	 	//
	 	
		 page_wantsell.setBounds(0,120,1100,550);
		 page_wantsell.setVisible(false);
	 	 contentPane.add(page_wantsell);
	 	//
	 	
		 page_system.setBounds(0,120,1100,550);
		 page_system.setVisible(false);
	 	 contentPane.add(page_system);
		//
	 	
	 	 
	 	
	 	button_name.addMouseListener(new MouseAdapter() {
			
			String strBookName;
			
			public void mouseEntered(MouseEvent e) {
				strBookName = button_name.getText();
				button_name.setText("<HTML><U>"+strBookName+"</U></HTML>");
				
			}
		
			public void mouseExited(MouseEvent e) {
				button_name.setText(strBookName);
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (btnLogin.getText().equals("未登录")) {
					try {
						a = new Login_no(mf,btnLogin, u);
						a.show();
					//	u = new User(a.user);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return ;
				}
		 		else {
		 			//猜你喜欢 按钮响应
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
			 		page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
			 		page_mylibrary.setVisible(false);
			 		page_shoppingcartpage.setVisible(false);
			 		page_wantbuy.setVisible(false);
			 		page_wantsell.setVisible(false);
			 		page_system.setVisible(false);

			 		
			 		final Page_detail page_detail;
			 		page_detail=new Page_detail(u.getCardNo(),vb.get(Integer.parseInt(currentHotIndex)));
					page_detail.setBounds(0,120,1100,550);
					page_detail.setVisible(false);
				 	contentPane.add(page_detail);
			 		page_detail.setBi(vb.get(Integer.parseInt(currentHotIndex)));
			 		page_detail.setVisible(true);
			 		page_detail.button_2.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent arg0) {
							//page_detail.setVisible(false);
							contentPane.remove(page_detail);
							panel_3.setVisible(true);
					 		panel_1.setVisible(true);
							//flag_back=true;
						}
					});
			 		
				}
				
				
			}
		});

		 final JButton button_1 = new JButton("New button");
		 button_1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		 button_1.setForeground(Color.WHITE);
		 button_1.setFocusPainted(false);
		 button_1.setBorderPainted(false);
		 button_1.setContentAreaFilled(false);
		 button_1.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(280,8);
		 		if(button_1.getText()=="首页"){
		 			panel_1.setVisible(true);
			 		panel_3.setVisible(true);
			 		page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
			 		page_mylibrary.setVisible(false);
			 		page_shoppingcartpage.setVisible(false);
			 		page_wantbuy.setVisible(false);
			 		page_wantsell.setVisible(false);
			 		page_system.setVisible(false);
			 		//page_detail.setVisible(false);
		 		}
		 		else if(button_1.getText()=="已收藏书籍"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(true);
		 			page_shoppingcartpage.setVisible(false);
		 			page_wantbuy.setVisible(false);
		 			page_wantsell.setVisible(false);
		 			page_system.setVisible(false);
		 			//page_detail.setVisible(false);
		 			
		 			//System.out.println(u.getName());
		 			page_mylibrary.workModel = 1;
		 			Vector<bookInfo> bv = MylibImpl.showCollection(u);
		 			page_mylibrary.showCollection(bv);
		 		}
		 		else if(button_1.getText()=="购物车"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(false);
		 			page_shoppingcartpage.setVisible(true);
		 			page_wantbuy.setVisible(false);
		 			page_wantsell.setVisible(false);
		 			page_system.setVisible(false);
		 			//page_detail.setVisible(false);
		 			
		 			Vector<bookInfo> bv = MylibImpl.showWillBuy(u);
		 			page_shoppingcartpage.showCollection(bv);
		 		}
		 		
		 	}
		 });
		 button_1.setBounds(275, 8, 110, 23);
		 button_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
		 	}
		 });
		 
		 final JButton button_3 = new JButton("New button");
		 button_3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		 button_3.setForeground(Color.WHITE);
		 button_3.setFocusPainted(false);
		 button_3.setBorderPainted(false);
		 button_3.setContentAreaFilled(false);
		 button_3.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(520,8);
		 		if(button_3.getText()=="休闲娱乐"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
			 		page_profession.setVisible(false);
			 		page_entertainment.setVisible(true);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
			 		page_mylibrary.setVisible(false);
			 		page_shoppingcartpage.setVisible(false);
			 		page_wantbuy.setVisible(false);
			 		page_wantsell.setVisible(false);
			 		page_system.setVisible(false);
			 		//page_detail.setVisible(false);
		 		}
		 		else if(button_3.getText()=="已售出书籍"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(true);
		 			page_shoppingcartpage.setVisible(false);
		 			page_wantbuy.setVisible(false);
		 			page_wantsell.setVisible(false);
		 			page_system.setVisible(false);
		 			//page_detail.setVisible(false);
		 			
		 			page_mylibrary.workModel = 3;
		 			Vector<bookInfo> bv = MylibImpl.showHaveSell(u);
		 			page_mylibrary.showCollection(bv); // same method ,badly named
		 			
		 		}
		 		else if(button_3.getText()=="我要卖书"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(false);
		 			page_wantsell.setVisible(true);
		 			page_shoppingcartpage.setVisible(false);
		 			page_wantbuy.setVisible(false);
		 			page_system.setVisible(false);
		 			//page_detail.setVisible(false);
		 			
		 		}
		 		
		 	
		 		
		 	}
		 });
		 button_3.setBounds(520, 8, 110, 23);
		 
		 final JButton button_2 = new JButton("New button");
		 button_2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		 button_2.setForeground(Color.WHITE);
		 button_2.setFocusPainted(false);
		 button_2.setBorderPainted(false);
		 button_2.setContentAreaFilled(false);
		 button_2.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(400,8);
		 		if(button_2.getText()=="专业学习"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
			 		page_profession.setVisible(true);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		
			 		page_healthylife.setVisible(false);
			 		page_mylibrary.setVisible(false);
			 		page_shoppingcartpage.setVisible(false);
			 		page_wantbuy.setVisible(false);
			 		page_wantsell.setVisible(false);
			 		page_system.setVisible(false);
			 		//page_detail.setVisible(false);
		 		}
		 		else if(button_2.getText()=="已买到书籍"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(true);
		 			page_shoppingcartpage.setVisible(false);
		 			page_wantbuy.setVisible(false);
		 			page_wantsell.setVisible(false);
		 			page_system.setVisible(false);
		 			//page_detail.setVisible(false);
		 			page_mylibrary.workModel = 2;
		 			Vector<bookInfo> bv = MylibImpl.showHaveBuy(u);
		 			page_mylibrary.showCollection(bv); // same method ,badly named
		 			
		 		}
		 		else if(button_2.getText()=="我要买书"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_entertainment_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(false);
		 			page_shoppingcartpage.setVisible(false);
		 			page_wantbuy.setVisible(true);
		 			page_wantsell.setVisible(false);
		 			page_system.setVisible(false);
		 			//page_detail.setVisible(false);
		 		}
		 		
		 		
		 	}
		 		
		 	
		 });
		 button_2.setBounds(400, 8, 110, 23);
		 
		 final JButton button_4 = new JButton("New button");
		 button_4.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		 button_4.setForeground(Color.WHITE);
		 button_4.setFocusPainted(false);
		 button_4.setBorderPainted(false);
		 button_4.setContentAreaFilled(false);
		 button_4.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		bacLabel_3.setLocation(640,8);
		 		if(button_4.getText()=="健康生活"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
			 		page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		page_healthylife.setVisible(true);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_mylibrary.setVisible(false);
			 		page_shoppingcartpage.setVisible(false);
			 		page_wantbuy.setVisible(false);
			 		page_wantsell.setVisible(false);
			 		page_system.setVisible(false);
			 		//page_detail.setVisible(false);
		 		}
		 		else if(button_4.getText()=="待售书籍"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(true);
		 			page_shoppingcartpage.setVisible(false);
		 			page_wantbuy.setVisible(false);
		 			page_wantsell.setVisible(false);
		 			page_system.setVisible(false);
		 			//page_detail.setVisible(false);
		 			page_mylibrary.workModel = 4;
		 			Vector<bookInfo> bv = MylibImpl.showWillSell(u);
		 			page_mylibrary.showCollection(bv); // same method ,badly named
		 		}
		 		else if(button_4.getText()=="系统求书"){
		 			panel_1.setVisible(false);
			 		panel_3.setVisible(false);
		 			page_profession.setVisible(false);
			 		page_entertainment.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_healthylife_0.page_1.setVisible(false);
			 		//page_profession.page_1.setVisible(false);
			 		page_healthylife.setVisible(false);
		 			page_mylibrary.setVisible(false);
		 			page_system.setVisible(true);
		 			page_wantbuy.setVisible(false);
		 			page_wantsell.setVisible(false);
		 			page_shoppingcartpage.setVisible(false);
		 			page_system.showNeedBook();
		 			//page_detail.setVisible(false);
		 		}
		 		
		 		
		 		
		 	}
		 });
		 button_4.setBounds(640, 8, 110, 23);
		 
		 
		 button_1.setText("\u9996\u9875");
	 	 button_2.setText("\u4E13\u4E1A\u5B66\u4E60");
	 	 button_3.setText("\u4F11\u95F2\u5A31\u4E50");
	 	 button_4.setText("\u5065\u5EB7\u751F\u6D3B");
	 	 panel.add(button_1);
		 panel.add(button_3);
		 panel.add(button_2);
		 panel.add(button_4);
		 panel.add(bacLabel_3);
		 
	 	 
	 	
		 
		 
		 JButton btnNova = new JButton();
		 btnNova.addMouseListener(new MouseAdapter() {
				 	@Override
				 	public void mousePressed(MouseEvent arg0) {
				 		lblA.setLocation(320,61);
				 		bacLabel_3.setLocation(280,8);
				 		button_1.setText("首页");
				 		button_2.setText("专业学习");
				 		button_3.setText("休闲娱乐");
				 		button_4.setText("健康生活");
				 		//page_healthylife_0.page_1.setVisible(false);
				 		//page_healthylife_0.page_1.setVisible(false);
				 		//page_profession.page_1.setVisible(false);
				 		panel_1.setVisible(true);
				 		panel_3.setVisible(true);
				 		page_profession.setVisible(false);
				 		page_entertainment.setVisible(false);
				 		page_healthylife.setVisible(false);
				 		page_mylibrary.setVisible(false);
				 		page_shoppingcartpage.setVisible(false);
				 		page_wantbuy.setVisible(false);
				 		page_wantsell.setVisible(false);
				 		page_system.setVisible(false);
				 		//page_detail.setVisible(false);
				 	}
				 });
			 
		 btnNova.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_nova_on.png"));
		 btnNova.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_nova.png"));
		 btnNova.setFocusPainted(false);
		 btnNova.setBorderPainted(false);
		 btnNova.setContentAreaFilled(false);
		 btnNova.setBounds(285,25,90,50);
		 
		 
		 final JButton btnMylib = new JButton();
		 btnMylib.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		
		 	}
		 });
		 btnMylib.setFocusPainted(false);
		 btnMylib.setBorderPainted(false);
		 btnMylib.setContentAreaFilled(false);
		 btnMylib.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_mylib_on.png"));
		 btnMylib.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_mylib.png"));
		 btnMylib.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		if (btnLogin.getText().equals("未登录")) {
					btnMylib.setEnabled(false);
					try {
						a = new Login_no(mf,btnLogin, u);
						a.show();
					//	u = new User(a.user);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return ;
				}
		 		else {
		 			btnMylib.setEnabled(true);
				}
		 		lblA.setLocation(437,61);
		 		bacLabel_3.setLocation(280,8);
		 		//page_healthylife_0.page_1.setVisible(false);
		 		//page_healthylife_0.page_1.setVisible(false);
		 		//page_profession.page_1.setVisible(false);
		 		button_1.setText("已收藏书籍");
		 		button_2.setText("已买到书籍");
		 		button_3.setText("已售出书籍");
		 		button_4.setText("待售书籍");
		 		panel_1.setVisible(false);
		 		panel_3.setVisible(false);
		 		page_profession.setVisible(false);
		 		page_entertainment.setVisible(false);
		 		page_healthylife.setVisible(false);
		 		page_mylibrary.setVisible(true);
		 		page_shoppingcartpage.setVisible(false);
		 		page_wantbuy.setVisible(false);
		 		page_wantsell.setVisible(false);
		 		page_system.setVisible(false);
		 		//page_detail.setVisible(false);
		 	}
		 });
		 btnMylib.setBounds(402,25,90,50);
		 
		 final JButton btnMypocket = new JButton();
		 btnMypocket.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
	
		 	}
		 });
		 btnMypocket.setFocusPainted(false);
		 btnMypocket.setBorderPainted(false);
		 btnMypocket.setContentAreaFilled(false);
		 btnMypocket.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_mybag_on.png"));
		 btnMypocket.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"icon_mybag.png"));
		 btnMypocket.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		if (btnLogin.getText().equals("未登录")) {
					btnMypocket.setEnabled(false);
					try {
						a = new Login_no(mf,btnLogin, u);
						a.show();
					//	u = new User(a.user);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return ;
				}
		 		else {
		 			btnMypocket.setEnabled(true);
				}
		 		lblA.setLocation(554,61);
		 		bacLabel_3.setLocation(280,8);
		 		//page_healthylife_0.page_1.setVisible(false);
		 		//page_healthylife_0.page_1.setVisible(false);
		 		//page_profession.page_1.setVisible(false);
		 		button_1.setText("购物车");
		 		button_2.setText("我要买书");
		 		button_3.setText("我要卖书");
		 		button_4.setText("系统求书");
		 		panel_1.setVisible(false);
		 		panel_3.setVisible(false);
		 		page_profession.setVisible(false);
		 		page_entertainment.setVisible(false);
		 		page_healthylife.setVisible(false);
		 		page_mylibrary.setVisible(false);
		 		page_shoppingcartpage.setVisible(true);
		 		page_wantbuy.setVisible(false);
		 		page_wantsell.setVisible(false);
		 		page_system.setVisible(false);
		 		//page_shoppingcartpage.repaint();
		 		mf.repaint();
		 		//page_detail.setVisible(false);
		 	}
		 });
		 btnMypocket.setBounds(516,25,90,50);
		 //menupanel.setBounds(0, 0, 1000, 121); 
		 Image[] array_1 = new Image[10];
	     Image backimg  = ImageIO.read(new File(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"volume_bg.png"));//�����ʵ��������ļ�·����
		 array_1[0] = backimg;
		 Dimension dim=new  Dimension(backimg.getWidth(this),backimg.getHeight(this));
		
		 topPanel.add(btnNova);
		 topPanel.add(btnMylib);
		 topPanel.add(btnMypocket);
		 
		 JLabel lblSuper = new JLabel("Supernova");
		 lblSuper.setFont(new Font("微软雅黑", Font.BOLD, 18));
		 lblSuper.setForeground(Color.WHITE);
		 lblSuper.setBounds(10, 10, 105, 22);
		 topPanel.add(lblSuper);
		 
		 JButton button_back_1 = new JButton("");
		 button_back_1.setBounds(20, 50, 32, 23);
		 topPanel.add(button_back_1);
		 button_back_1.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back_click.png"));
		 button_back_1.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back.png"));
		 button_back_1.setFocusPainted(false);
		 button_back_1.setBorderPainted(false);
		 button_back_1.setContentAreaFilled(false);
		 
		 
		 JButton button_back_2 = new JButton("");
		 button_back_2.setBounds(55, 50, 32, 23);
		 topPanel.add(button_back_2);
		 button_back_2.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back_click_1.png"));
		 button_back_2.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"back_1.png"));
		 button_back_2.setFocusPainted(false);
		 button_back_2.setBorderPainted(false);
		 button_back_2.setContentAreaFilled(false);
		 
		 JButton searchButton = new JButton("");
		 searchButton.setBounds(165, 50, 23, 23);
		 topPanel.add(searchButton);
		 searchButton.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_srch_btn_click.png"));
		 searchButton.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_srch_btn.png"));
		 searchButton.setFocusPainted(false);
		 searchButton.setBorderPainted(false);
		 searchButton.setContentAreaFilled(false);
		 
		 textField = new JTextField();
		 textField.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		 textField.setForeground(Color.LIGHT_GRAY);
		 textField.setText("\u8BF7\u8F93\u5165\u4E66\u540D");
		 textField.setBounds(102, 53, 82, 19);
		 topPanel.add(textField);
		 textField.setColumns(10);
		 textField.setBorder(BorderFactory.createEmptyBorder());
		 
		 JLabel searchLabel = new JLabel("");
		 searchLabel.setBounds(94, 44, 150, 36);
		 topPanel.add(searchLabel);
		 setLabelBac_1("nav_srch_filter.png", searchLabel);
		 
		 JLabel lblNewLabel = new JLabel("\u4E1C\u5927\u5728\u7EBF\u4E8C\u624B\u4E66\u5E02\u573A");
		 lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 9));
		 lblNewLabel.setForeground(Color.WHITE);
		 lblNewLabel.setBounds(110, 17, 87, 15);
		 topPanel.add(lblNewLabel);
		 
		 
		 btnLogin.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mousePressed(MouseEvent arg0) {
		 		if (btnLogin.getText().equals("未登录")) {
					try {
						a = new Login_no(mf,btnLogin, u);
						a.show();
					//	u = new User(a.user);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 		} else {
		 			feed.setVisible(true);
		 		}
		 	}
		 });
		 btnLogin.setFont(new Font("微软雅黑", Font.PLAIN, 12));
		 btnLogin.setForeground(Color.WHITE);
		 btnLogin.setBounds(882, 50, 70, 23);
		 btnLogin.setFocusPainted(false);
		 btnLogin.setContentAreaFilled(false);
		 //loginButton.setBorder(new LineBorder(Color.gray, 1, true));
		 topPanel.add(btnLogin);
		 
		 JButton setButton = new JButton("");
		 setButton.setBounds(956, 50, 35, 23);
		 setButton.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_icon_setting_click.png"));
		 setButton.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator+"nav_icon_setting.png"));
		 setButton.setFocusPainted(false);
		 setButton.setBorderPainted(false);
		 setButton.setContentAreaFilled(false);
		 topPanel.add(setButton);
		
		
		/**
		 * 初始化猜你喜欢
		 */
		int index;
		//Vector<bookInfo> vb = MainFImpl.initGuess(u.getCardNo());
		rollPicture_0 = new MyPicture("0");
		rollPicture_0.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",ShadowLabel);
					ShadowLabel.setLocation(340,95);
					
					if (vb.size()==0) {
						return;
					}
					int index = Integer.parseInt(rollPlace.get(0));
					currentHotIndex = String.valueOf(index);
					button_name.setText (vb.get(index).getBook_name());
					button_author.setText (vb.get(index).getAuthor());
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});
		
		rollPicture_1 = new MyPicture("1");
		rollPicture_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",ShadowLabel);
					ShadowLabel.setLocation(460,95);
					if (vb.size()==0) {
						return;
					}
					int index = Integer.parseInt(rollPlace.get(1));
					currentHotIndex = String.valueOf(index);
					button_name.setText (vb.get(index).getBook_name());
					button_author.setText (vb.get(index).getAuthor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		rollPicture_2 = new MyPicture("2");
		rollPicture_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",ShadowLabel);
					ShadowLabel.setLocation(580,95);
					if (vb.size()==0) {
						return;
					}
					int index = Integer.parseInt(rollPlace.get(2));
					currentHotIndex = String.valueOf(index);
					button_name.setText (vb.get(index).getBook_name());
					button_author.setText (vb.get(index).getAuthor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		 rollPicture_3 = new MyPicture("3");
		rollPicture_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",ShadowLabel);
					ShadowLabel.setLocation(700,95);
					if (vb.size()==0) {
						return;
					}
					int index = Integer.parseInt(rollPlace.get(3));
					currentHotIndex = String.valueOf(index);
					button_name.setText (vb.get(index).getBook_name());
					button_author.setText (vb.get(index).getAuthor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		
		rollPicture_4 = new MyPicture("4");
		rollPicture_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				try {
					setLabelBac_1("trans.png",ShadowLabel);
					ShadowLabel.setLocation(820,95);
					if (vb.size()==0) {
						return;
					}
					int index = Integer.parseInt(rollPlace.get(4));
					currentHotIndex = String.valueOf(index);
					button_name.setText (vb.get(index).getBook_name());
					button_author.setText (vb.get(index).getAuthor());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
	
		/*setLabelBac("0",rollPicture_1);
		setLabelBac("1",rollPicture_2);
		setLabelBac("2",rollPicture_3);
		setLabelBac("3",rollPicture_4);
		setLabelBac("4",rollPicture_5);*/
		
		rollPicture_0.setText("a");
		rollPicture_0.setBounds(340, 95, 120, 120);
		panel_1.add(rollPicture_0);
		
		
		rollPicture_1.setText("b");
		rollPicture_1.setBounds(460, 95, 120, 120);
		panel_1.add(rollPicture_1);
		
		
		rollPicture_2.setText("a");
		rollPicture_2.setBounds(580, 95, 120, 120);
		panel_1.add(rollPicture_2);
		
		
		rollPicture_3.setText("b");
		rollPicture_3.setBounds(700, 95, 120, 120);
		panel_1.add(rollPicture_3);
		
		
		rollPicture_4.setText("b");
		rollPicture_4.setBounds(820, 95, 120, 120);
		panel_1.add(rollPicture_4);
		
		JButton button_back_3 = new JButton("");
		button_back_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_back_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				    
					try {
						setLabelBac_1("null",ShadowLabel);
						button_name.setText("");
						button_author.setText("");
						if(i>0){
							i--;
							rollPlace.set(0, guessArr.get(i));
							rollPlace.set(1, guessArr.get(i+1));
							rollPlace.set(2, guessArr.get(i+2));
							rollPlace.set(3, guessArr.get(i+3));
							rollPlace.set(4, guessArr.get(i+4));
							rollPicture_0.setLabelBac(guessArr.get(i));
							rollPicture_1.setLabelBac(guessArr.get(i+1));
							rollPicture_2.setLabelBac(guessArr.get(i+2));
							rollPicture_3.setLabelBac(guessArr.get(i+3));
							rollPicture_4.setLabelBac(guessArr.get(i+4));
							}
						else{i=0;}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				
			}
		});
		button_back_3.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"previous.png"));
		button_back_3.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"previous.png"));
		button_back_3.setFocusPainted(false);
		button_back_3.setBorderPainted(false);
		button_back_3.setContentAreaFilled(false);
		button_back_3.setBounds(300, 140, 25, 23);
		panel_1.add(button_back_3);
		
		
		JButton button_back_4 = new JButton("");
		button_back_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_back_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				try {
					setLabelBac_1("null",ShadowLabel);
					if(i<5){
						i++;
						button_name.setText("");
						button_author.setText("");
						rollPlace.set(0, guessArr.get(i));
						rollPlace.set(1, guessArr.get(i+1));
						rollPlace.set(2, guessArr.get(i+2));
						rollPlace.set(3, guessArr.get(i+3));
						rollPlace.set(4, guessArr.get(i+4));
						rollPicture_0.setLabelBac(guessArr.get(i));
						rollPicture_1.setLabelBac(guessArr.get(i+1));
						rollPicture_2.setLabelBac(guessArr.get(i+2));
						rollPicture_3.setLabelBac(guessArr.get(i+3));
						rollPicture_4.setLabelBac(guessArr.get(i+4));
						}
					else{i=5;}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		button_back_4.setRolloverIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"next.png"));
		button_back_4.setIcon(new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator+"next.png"));
		button_back_4.setFocusPainted(false);
		button_back_4.setBorderPainted(false);
		button_back_4.setContentAreaFilled(false);
		button_back_4.setBounds(950, 140, 25, 23);
		panel_1.add(button_back_4);
		
		JLabel bacLabel_1 = new JLabel("");
		bacLabel_1.setBounds(316, 51, 626, 130);
		panel_1.add(bacLabel_1);
		
		JLabel label = new JLabel("\u731C\u4F60\u559C\u6B22");
		label.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		label.setForeground(Color.WHITE);
		label.setBounds(340, 35, 81, 24);
		panel_1.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\u9082\u9005\u7F8E\u597D\uFF0C\u603B\u5728\u4E0D\u7ECF\u610F\u95F4\uFF01");
		lblNewLabel_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(340, 65, 180, 15);
		panel_1.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\u4F60\u7684\u4E66\u5355");
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 18));
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(34, 35, 81, 24);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u6839\u636E\u60A8\u7684\u4FE1\u606F\uFF0C\u4E3A\u4F60\u5B9A\u5236\u7684\u4E66\u5355\uFF01");
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		label_2.setForeground(Color.WHITE);
		label_2.setBounds(34, 66, 219, 14);
		panel_1.add(label_2);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		panel_2.setBounds(0, 670, 1000, 33);
		contentPane.add(panel_2);
		
		
		
		final JLabel label_3 = new JLabel("");
		label_3.setBounds(69,0, 130, 140);
		setLabelBac_1("trans.png",label_3);
		label_3.setVisible(false);
		panel_3.add(label_3);
		
		/**
		 * 购物车暗面
		 */
		final JButton button_bag = new JButton("放入购物车");
		button_bag.setBounds(10,80,100,20);
		button_bag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (u.getCardNo() != null) {
					MainFImpl.AddCart(currentHotIndex,u.getCardNo());
					button_bag.setText("<HTML><U>放入成功~</U></HTML>");
				}
				
			}
		});
		button_bag.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_bag.setText("<HTML><U>放入购物车</U></HTML>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_bag.setText("放入购物车");
			}
		});
		button_bag.setForeground(Color.white);
		button_bag.setFocusPainted(false);
		button_bag.setContentAreaFilled(false);	
		button_bag.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));
		label_3.add(button_bag);
		
		final JButton button_enter = new JButton("前往购买");
		button_enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
			
		});
		button_enter.setBounds(10,105,100,20);
		button_enter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				button_enter.setText("<HTML><U>前往购买</U></HTML>");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				button_enter.setText("前往购买");
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
				panel_1.setVisible(false);
		 		panel_3.setVisible(false);
		 		page_profession.setVisible(false);
		 		page_entertainment.setVisible(false);
		 		page_healthylife.setVisible(false);
		 		page_mylibrary.setVisible(false);
		 		page_shoppingcartpage.setVisible(false);
		 		page_wantbuy.setVisible(false);
		 		page_wantsell.setVisible(false);
		 		page_system.setVisible(false);
		 		
		 		//System.out.println(currentHotIndex);
		 		final Page_detail page_detail;
		 		page_detail=new Page_detail(u.getCardNo(),vecHot.get(Integer.parseInt(currentHotIndex)));
				page_detail.setBounds(0,120,1100,550);
				page_detail.setVisible(false);
			 	contentPane.add(page_detail);
		 		page_detail.setBi(vecHot.get(Integer.parseInt(currentHotIndex)));
		 		page_detail.setVisible(true);
		 		page_detail.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						//page_detail.setVisible(false);
						contentPane.remove(page_detail);
						panel_3.setVisible(true);
				 		panel_1.setVisible(true);
						//flag_back=true;
					}
				});
			}
		});
		button_enter.setForeground(Color.white);
		button_enter.setFocusPainted(false);
		button_enter.setContentAreaFilled(false);
		button_enter.setBorder(BorderFactory.createEmptyBorder(0,0, 0, 0));
		label_3.add(button_enter);
		
		JLabel label_4 = new JLabel("\u70ED\u95E8\u4E66\u7C4D");
		label_4.setForeground(new Color(255, 69, 0));
		label_4.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(33, 27, 70, 30);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("\u4ECA\u65E5\u70ED\u95E8\u4E66\u7C4D\u63A8\u8350");
		label_5.setForeground(Color.DARK_GRAY);
		label_5.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		label_5.setBounds(113, 37, 139, 15);
		panel_3.add(label_5);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(33, 62, 936, 1);
		panel_3.add(separator);
		
		
		showHotBook();
		JLabel booklabel_1 = new JLabel("");
		booklabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);	
				label_3.setText(vecHot.get(0).getBook_id());
				label_3.setLocation(33,92);
				currentHotIndex = "0";
			}
		});
		booklabel_1.setBounds(33, 92, 130, 140);
		panel_3.add(booklabel_1);
		
		setLabelBac(vecHot.get(0).getBook_id(),booklabel_1);
		
		JLabel bookname1 = new JLabel(vecHot.get(0).getBook_name());
		JLabel bookPrice1 = new JLabel("￥"+vecHot.get(0).getPrice());
		
		bookname1.setForeground(Color.DARK_GRAY);
		bookname1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		bookname1.setBounds(43, 242, 87, 22);
		panel_3.add(bookname1);
		
		
		bookPrice1.setForeground(Color.DARK_GRAY);
		bookPrice1.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		bookPrice1.setBounds(43, 263, 81, 15);
		panel_3.add(bookPrice1);
		
		JLabel booklname2 = new JLabel(vecHot.get(1).getBook_name());
		JLabel bookPrice2 = new JLabel("￥"+vecHot.get(1).getPrice());
		
		
		booklname2.setForeground(Color.DARK_GRAY);
		booklname2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		booklname2.setBounds(204, 242, 87, 22);
		panel_3.add(booklname2);
		
		
		bookPrice2.setForeground(Color.DARK_GRAY);
		bookPrice2.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		bookPrice2.setBounds(204, 263, 81, 15);
		panel_3.add(bookPrice2);
		
		
		JLabel booklname3 = new JLabel(vecHot.get(2).getBook_name());
		JLabel bookPrice3 = new JLabel("￥"+vecHot.get(2).getPrice());
		
		booklname3.setForeground(Color.DARK_GRAY);
		booklname3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		booklname3.setBounds(364, 242, 87, 22);
		panel_3.add(booklname3);
		
		
		bookPrice3.setForeground(Color.DARK_GRAY);
		bookPrice3.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		bookPrice3.setBounds(364, 263, 81, 15);
		panel_3.add(bookPrice3);
		
		JLabel booklabel_2 = new JLabel("");
		booklabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setText(vecHot.get(1).getBook_id());
				label_3.setBackground(Color.gray);
				label_3.setLocation(194, 92);
				currentHotIndex = "1";
			}
		});
		booklabel_2.setBounds(194, 92, 130, 140);
		panel_3.add(booklabel_2);
		setLabelBac(vecHot.get(1).getBook_id(),booklabel_2);
		
		JLabel booklabel_3 = new JLabel("");
		booklabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setText(vecHot.get(2).getBook_id());
				label_3.setBackground(Color.gray);
				label_3.setLocation(352, 92);
				currentHotIndex = "2";
			}
		});
		booklabel_3.setBounds(354, 92, 130, 140);
		panel_3.add(booklabel_3);
		setLabelBac(vecHot.get(2).getBook_id(),booklabel_3);
		
		JLabel booklabel_4 = new JLabel("");
		booklabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setText(vecHot.get(3).getBook_id());
				label_3.setBackground(Color.gray);
				label_3.setLocation(514, 92);
				currentHotIndex = "3";
			}
		});
		booklabel_4.setBounds(514, 92, 130, 140);
		panel_3.add(booklabel_4);
		setLabelBac(vecHot.get(3).getBook_id(),booklabel_4);
		
		
		JLabel booklname4 = new JLabel(vecHot.get(3).getBook_name());
		JLabel bookPrice4 = new JLabel("￥"+vecHot.get(3).getPrice());
		
		
		booklname4.setForeground(Color.DARK_GRAY);
		booklname4.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		booklname4.setBounds(524, 242, 87, 22);
		panel_3.add(booklname4);
		
		
		bookPrice4.setForeground(Color.DARK_GRAY);
		bookPrice4.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		bookPrice4.setBounds(524, 263, 81, 15);
		panel_3.add(bookPrice4);
		
		
		JLabel booklname5 = new JLabel(vecHot.get(4).getBook_name());
		JLabel bookPrice5 = new JLabel("￥"+vecHot.get(4).getPrice());
		

		booklname5.setForeground(Color.DARK_GRAY);
		booklname5.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		booklname5.setBounds(687, 242, 87, 22);
		panel_3.add(booklname5);
		
		
		bookPrice5.setForeground(Color.DARK_GRAY);
		bookPrice5.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		bookPrice5.setBounds(687, 263, 81, 15);
		panel_3.add(bookPrice5);
		
		
		
		JLabel booklname6 = new JLabel(vecHot.get(5).getBook_name());
		JLabel bookPrice6 = new JLabel("￥"+vecHot.get(5).getPrice());
		
		
		bookPrice6.setForeground(Color.DARK_GRAY);
		bookPrice6.setFont(new Font("΢���ź�", Font.PLAIN, 12));
		bookPrice6.setBounds(849, 263, 81, 15);
		panel_3.add(bookPrice6);
		

		booklname6.setForeground(Color.DARK_GRAY);
		booklname6.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		booklname6.setBounds(849, 242, 87, 22);
		panel_3.add(booklname6);
		
		JLabel booklabel_5 = new JLabel("");
		booklabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				label_3.setVisible(true);
				label_3.setText(vecHot.get(4).getBook_id());
				label_3.setBackground(Color.gray);
				label_3.setLocation(677, 92);
				currentHotIndex = "4";
			}
		});
		booklabel_5.setBounds(677, 92, 130, 140);
		panel_3.add(booklabel_5);
		setLabelBac(vecHot.get(4).getBook_id(),booklabel_5);
		
		JLabel booklabel_6 = new JLabel("");
		booklabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				label_3.setVisible(true);
				label_3.setText(vecHot.get(5).getBook_id());
				label_3.setBackground(Color.gray);
				label_3.setLocation(839, 92);
				currentHotIndex = "5";
			}
		});
		booklabel_6.setBounds(839, 92, 130, 140);
		panel_3.add(booklabel_6);
		setLabelBac(vecHot.get(5).getBook_id(),booklabel_6);
		
		
		
    	 }
   
     private void showHotBook() {
		// TODO Auto-generated method stub
    	vecHot.addAll(MainFImpl.showHot()) ;
		
	}

	private static Color getMixedColor(Color c1, float pct1, Color c2, float pct2) {
    	 float[] clr1 = c1.getComponents(null);
    	 float[] clr2 = c2.getComponents(null);
    	 for (int i = 0; i < clr1.length; i++) {
    		 clr1[i] = (clr1[i] * pct1) + (clr2[i] * pct2);
    		 }
    	 return new Color(clr1[0], clr1[1], clr1[2], clr1[3]);
    	 }
	   void topPanel_mouseDragged(MouseEvent e){
		 
		 Point point=e.getPoint();
		 Point localPoint=this.getLocation();
		 
		 int x=point.x+localPoint.x-pressedPoint.x;
		 int y=point.y+localPoint.y-pressedPoint.y;
		 
		 setLocation(x,y);    	 
    	 
      }
	   
	   void topPanel_mousePressed(MouseEvent e){
		   pressedPoint=e.getPoint();
	   }
	   
	   void minJB_actionPerformed(ActionEvent e){
		   this.setExtendedState(ICONIFIED);
	   }
	   
	   void maxJB_itemStateChanged(ItemEvent e){
		   if(e.getStateChange()==ItemEvent.SELECTED){
			   this.setExtendedState(MAXIMIZED_BOTH);
		   }else{
			   this.setExtendedState(NORMAL);
		   }
	   }
	   
	   void closeJB_actionPerformed(ActionEvent e){
		   if(CommonImpl.os != null)
			   CommonImpl.closeSocket();
		   this.dispose();
	   }
	  
	   void setPanelBac(String a,MyPanel b) throws IOException{
			Image[] array = new Image[10];
			Image topimg = ImageIO.read(new File(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a));//�����ʵ��������ļ�·����
			array[0] = topimg;
			b.setPreferredSize(new Dimension(1000, 105));       
			b.setImg(topimg);
		}
	   void setLabelBac(String a,JLabel b) throws IOException{
			ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a + ".jpg");
			img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
			//Icon icon=new ImageIcon(img);
			b.setIcon(img);
		}
	   void setLabelBac_1(String a,JLabel b) throws IOException{
		    Toolkit toolkit = Toolkit.getDefaultToolkit();
		    Dimension scmSize = toolkit.getScreenSize();
		    Image img = toolkit.getImage("image" + File.separator + a);
		    Icon icon=new ImageIcon(img);
			b.setIcon(icon);
		}
	  
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void showGuessBook(User u2) {
		// TODO Auto-generated method stub
		
		 vb.addAll( MainFImpl.showGuessBook(u2));
		// System.out.println(vb);
		Vector<String> vec = new Vector<String>();
		if (vb.size()!=10) {  //数据可能不完整
			vec.add("1");
			vec.add("2");
			vec.add("3");
			vec.add("4");
			vec.add("5");
			vec.add("6");
			vec.add("7");
			vec.add("8");
			vec.add("9");
			vec.add("0");
		}
		else {
			for (int i = 0; i < 10; i++) {
				vec.add(vb.get(i).getBook_id());
			}
		}
		
		
		guessArr.clear();
		for (int i = 0; i < vec.size(); i++) {
			guessArr.add(vec.get(i));
			
		}
		try {

			rollPicture_0.setLabelBac(vec.get(0));
			rollPicture_1.setLabelBac(vec.get(1));
			rollPicture_2.setLabelBac(vec.get(2));
			rollPicture_3.setLabelBac(vec.get(3));
			rollPicture_4.setLabelBac(vec.get(4));
		//	rollPicture_5.setLabelBac(vec.get(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void setFeed(User u2) {
		// TODO Auto-generated method stub
		feed = new FeedBack(u2);
	}
}


