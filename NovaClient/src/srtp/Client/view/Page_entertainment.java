package src.srtp.Client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.LayoutManager;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

import javax.swing.JPanel;

import src.srtp.Client.bz.impl.MainFImpl;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import k.bookInfo;

public class Page_entertainment extends JPanel {

	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	
	final Vector<bookInfo> vecBook;
	final Vector<bookInfo> vecClassOne;
	final Vector<bookInfo> vecClassTwo;
	final Vector<bookInfo> vecClassThree;
	final Vector<bookInfo> tempVector;
	
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	String  cardNo;
	Page_detail page_1;
	Page_entertainment ptr;
	public Page_entertainment() throws IOException {
		ptr=this;
		vecClassOne = new Vector<bookInfo>();
		vecClassTwo = new Vector<bookInfo>();
		vecClassThree = new Vector<bookInfo>();
		
		 
		vecBook = new Vector<bookInfo>();
		tempVector = new Vector<bookInfo>();

		java.util.Random r = new java.util.Random();
		int randomInt = r.nextInt();
		int tempSize;
		
		this.setPreferredSize(new Dimension(1000, 607));
		setLayout(null);
		setBackground(Color.white);
		
		//page_1.setBounds(0,20,1100,550);
		//page_1.setVisible(false);
	 	//add(page_1);
	 	
		JSeparator separator = new JSeparator();
		separator.setBounds(30, 50, 940, 2);
		add(separator);
		
		JLabel corse_label_1 = new JLabel("\u65F6\u5C1A\u6742\u5FD7");
		corse_label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				    
				
			}
		});
		corse_label_1.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		corse_label_1.setBounds(40, 25, 110, 20);
		add(corse_label_1);
		
		JLabel corse_label_2 = new JLabel("\u6587\u5B66\u540D\u8457");
		corse_label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		corse_label_2.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		corse_label_2.setBounds(40, 200, 120, 20);
		add(corse_label_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 225, 940, 2);
		add(separator_1);
		
		JLabel corse_label_3 = new JLabel("\u4F11\u95F2\u5C0F\u8BF4");
		corse_label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		corse_label_3.setFont(new Font("΢���ź�", Font.PLAIN, 16));
		corse_label_3.setBounds(40, 375, 141, 20);
		add(corse_label_3);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(30, 400, 940, 2);
		add(separator_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(30, 50, 940, 143);
		add(panel);
		panel.setLayout(null);
		
		final JLabel booklabel_1 = new JLabel("");
		booklabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassOne.get(0));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
			}
		});
		booklabel_1.setBounds(40, 0, 130, 140);
		panel.add(booklabel_1);
		
		final JLabel booklabel_2 = new JLabel("");
		booklabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassOne.get(1));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_2.setBounds(190, 0, 130, 140);
		panel.add(booklabel_2);
		
		final JLabel booklabel_3 = new JLabel("");
		booklabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassOne.get(2));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_3.setBounds(340, 0, 130, 140);
		panel.add(booklabel_3);
		
		final JLabel booklabel_4 = new JLabel("");
		booklabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassOne.get(3));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_4.setBounds(490, 0, 130, 140);
		panel.add(booklabel_4);
		
		final JLabel booklabel_5 = new JLabel("");
		booklabel_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassOne.get(4));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_5.setBounds(640, 0, 130, 140);
		panel.add(booklabel_5);
		
		final JLabel booklabel_6 = new JLabel("");
		booklabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassOne.get(5));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_6.setBounds(800, 0, 130, 140);
		panel.add(booklabel_6);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(30, 230, 940, 143);
		add(panel_1);
		
		final JLabel booklabel_7 = new JLabel("");
		booklabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassTwo.get(0));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_7.setBounds(40, 0, 130, 140);
		panel_1.add(booklabel_7);
		
		final JLabel booklabel_8 = new JLabel("");
		booklabel_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassTwo.get(1));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_8.setBounds(190, 0, 130, 140);
		panel_1.add(booklabel_8);
		
		final JLabel booklabel_9 = new JLabel("");
		booklabel_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassTwo.get(2));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_9.setBounds(340, 0, 130, 140);
		panel_1.add(booklabel_9);
		
		final JLabel booklabel_10 = new JLabel("");
		booklabel_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassTwo.get(3));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_10.setBounds(490, 0, 130, 140);
		panel_1.add(booklabel_10);
		
		final JLabel booklabel_11 = new JLabel("");
		booklabel_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassTwo.get(4));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_11.setBounds(640, 0, 130, 140);
		panel_1.add(booklabel_11);
		
		final JLabel booklabel_12 = new JLabel("");
		booklabel_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassTwo.get(5));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_12.setBounds(800, 0, 130, 140);
		panel_1.add(booklabel_12);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(30, 405, 940, 143);
		add(panel_2);
		
		final  JLabel booklabel_13 = new JLabel("");
		booklabel_13.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassThree.get(0));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_13.setBounds(40, 0, 130, 140);
		panel_2.add(booklabel_13);
		
		final  JLabel booklabel_14 = new JLabel("");
		booklabel_14.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassThree.get(1));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_14.setBounds(190, 0, 130, 140);
		panel_2.add(booklabel_14);
		
		final JLabel booklabel_15 = new JLabel("");
		booklabel_15.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassThree.get(2));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_15.setBounds(340, 0, 130, 140);
		panel_2.add(booklabel_15);
		
		final JLabel booklabel_16 = new JLabel("");
		booklabel_16.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassThree.get(3));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_16.setBounds(490, 0, 130, 140);
		panel_2.add(booklabel_16);
		
		final JLabel booklabel_17 = new JLabel("");
		booklabel_17.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassThree.get(4));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_17.setBounds(640, 0, 130, 140);
		panel_2.add(booklabel_17);
		
		final JLabel booklabel_18 = new JLabel("");
		booklabel_18.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				page_1 =new Page_detail(cardNo,vecClassThree.get(5));
				page_1.setBounds(0,20,1100,550);  
				page_1.setVisible(false);
				ptr.add(page_1);
				ptr.setComponentZOrder(page_1, 0);
				//setVisible(false);
				page_1.setVisible(true);
				page_1.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						ptr.remove(page_1);
						ptr.repaint();
					}
				});
				
			}
		});
		booklabel_18.setBounds(800, 0, 130, 140);
		panel_2.add(booklabel_18);
		
		
		/**
		 * init entertaiment
		 */
		vecBook.addAll(MainFImpl.initEntertainment());
		/**
		 * init class 1;
		 */
		tempVector.clear();
		for (int i = 0; i < vecBook.size(); i++) {
			if (vecBook.get(i).getIntClass() == 1) {
				tempVector.add(vecBook.get(i));
				//vecClassOne.add(vecBook.get(i));
			}

		}
		randomInt = Math.abs(randomInt);
		tempSize = tempVector.size();
		randomInt %= tempSize;
		vecClassOne.clear();
		for(int i=0;i<6;i++) {
			vecClassOne.add(tempVector.get( (randomInt+i)%tempSize ));
		}
		
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_1);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_2);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_3);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_4);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_5);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_6);

		randomInt = r.nextInt();
		
		
		/**
		 * init class 2;
		 */
		tempVector.clear();
		for (int i = 0; i < vecBook.size(); i++) {
			if (vecBook.get(i).getIntClass() == 2) {
				tempVector.add(vecBook.get(i));
			//	vecClassTwo.add(vecBook.get(i));
			}

		}
		randomInt = Math.abs(randomInt);
		tempSize = tempVector.size();
		randomInt %= tempSize;
		
		vecClassTwo.clear();
		for(int i=0;i<6;i++) {
			vecClassTwo.add(tempVector.get( (randomInt+i)%tempSize ));
		}
		
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_7);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_8);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_9);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_10);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_11);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_12);

		randomInt = r.nextInt();
		
		/**
		 * init class 3;
		 */
		tempVector.clear();
		for (int i = 0; i < vecBook.size(); i++) {
			if (vecBook.get(i).getIntClass() == 3) {
				tempVector.add(vecBook.get(i));
			//	vecClassThree.add(vecBook.get(i));
			}

		}
		randomInt = Math.abs(randomInt);
		tempSize = tempVector.size();
		randomInt %= tempSize;
		
		vecClassThree.clear();
		for(int i=0;i<6;i++) {
			vecClassThree.add(tempVector.get( (randomInt+i)%tempSize ));
		}
		
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_13);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_14);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_15);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_16);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_17);
		randomInt++;
		randomInt %= tempSize;
		setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_18);

		randomInt = r.nextInt();
		
		
//		setLabelBac("7",booklabel_1);
//		setLabelBac("8",booklabel_2);
//		setLabelBac("9",booklabel_3);
//		setLabelBac("7",booklabel_4);
//		setLabelBac("8",booklabel_5);
//		setLabelBac("9",booklabel_6);
//		
//		setLabelBac("7",booklabel_7);
//		setLabelBac("8",booklabel_8);
//		setLabelBac("9",booklabel_9);
//		setLabelBac("7",booklabel_10);
//		setLabelBac("8",booklabel_11);
//		setLabelBac("9",booklabel_12);
//		
//		setLabelBac("1",booklabel_13);
//		setLabelBac("2",booklabel_14);
//		setLabelBac("3",booklabel_15);
//		setLabelBac("4",booklabel_16);
//		setLabelBac("5",booklabel_17);
//		setLabelBac("6",booklabel_18);
//		
//		setLabelBac("1",booklabel_19);
//		setLabelBac("2",booklabel_20);
//		setLabelBac("3",booklabel_21);
//		setLabelBac("4",booklabel_22);
//		setLabelBac("5",booklabel_23);
//		setLabelBac("6",booklabel_24);
//		
//		setLabelBac("1",booklabel_25);
//		setLabelBac("2",booklabel_26);
//		setLabelBac("3",booklabel_27);
//		setLabelBac("4",booklabel_28);
//		setLabelBac("5",booklabel_29);
//		setLabelBac("6",booklabel_30);
		
		JButton button = new JButton("\u6362\u4E00\u6279");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempVector.clear();
				for (int i = 0; i < vecBook.size(); i++) {
					if (vecBook.get(i).getIntClass() == 1) {
						tempVector.add(vecBook.get(i));
					}

				}
				java.util.Random r = new java.util.Random();
				int randomInt = r.nextInt();
				int tempSize;
				randomInt = Math.abs(randomInt);
				tempSize = tempVector.size();
				randomInt %= tempSize;
				
				vecClassOne.clear();
				for(int i=0;i<6;i++) {
					vecClassOne.add(tempVector.get( (randomInt+i)%tempSize ));
				}
				
				try {
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_1);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_2);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_3);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_4);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_5);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_6);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button.setBounds(877, 25,80,20);
		add(button);
		button.setForeground(Color.black);
		button.setFocusPainted(false);
		button.setContentAreaFilled(false);
		
		JButton button_1 = new JButton("\u6362\u4E00\u6279");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tempVector.clear();
				for (int i = 0; i < vecBook.size(); i++) {
					if (vecBook.get(i).getIntClass() == 2) {
						tempVector.add(vecBook.get(i));
					}

				}
				java.util.Random r = new java.util.Random();
				int randomInt = r.nextInt();
				int tempSize;
				randomInt = Math.abs(randomInt);
				tempSize = tempVector.size();
				randomInt %= tempSize;
				
				vecClassTwo.clear();
				for(int i=0;i<6;i++) {
					vecClassTwo.add(tempVector.get( (randomInt+i)%tempSize ));
				}
				
				try {
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_7);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_8);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_9);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_10);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_11);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_12);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_1.setBounds(877, 200,80,20);
		add(button_1);
		button_1.setForeground(Color.black);
		button_1.setFocusPainted(false);
		button_1.setContentAreaFilled(false);
		
		JButton button_2 = new JButton("\u6362\u4E00\u6279");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tempVector.clear();
				for (int i = 0; i < vecBook.size(); i++) {
					if (vecBook.get(i).getIntClass() == 3) {
						tempVector.add(vecBook.get(i));
					}

				}
				java.util.Random r = new java.util.Random();
				int randomInt = r.nextInt();
				int tempSize;
				randomInt = Math.abs(randomInt);
				tempSize = tempVector.size();
				randomInt %= tempSize;
				
				vecClassThree.clear();
				for(int i=0;i<6;i++) {
					vecClassThree.add(tempVector.get( (randomInt+i)%tempSize ));
				}
				
				try {
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_13);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_14);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_15);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_16);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_17);
					randomInt++;
					randomInt %= tempSize;
					setLabelBac("" + tempVector.get(randomInt).getBook_id(), booklabel_18);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		button_2.setBounds(877, 375,80,20);
		add(button_2);
		button_2.setForeground(Color.black);
		button_2.setFocusPainted(false);
		button_2.setContentAreaFilled(false);
		
		
	}
	 void setLabelBac(String a,JLabel b) throws IOException{
			ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a + ".jpg");
			img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
			//Icon icon=new ImageIcon(img);
			b.setIcon(img);
		}
}

