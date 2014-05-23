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
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.srtp.Client.bz.impl.MainFImpl;
import src.srtp.Client.bz.impl.MylibImpl;

import k.User;
import k.bookInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page_mylibrary extends JPanel {
	public JTable table;
	 
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	String cardNo;
	Vector<bookInfo> vecBi;
	int workModel ;
	Page_detail page_detail;
	Page_mylibrary ptrMylibrary;
	final JPopupMenu popupMenu;
	final JMenuItem button_1;
	final JMenuItem button_2;
	final JMenuItem button_3;
	public Page_mylibrary() throws IOException {
		ptrMylibrary = this;
		vecBi = new Vector<bookInfo>();
		this.setPreferredSize(new Dimension(1000,500));
		this.setOpaque(false);
		this.setVisible(true);
		setBackground(Color.white);
		setLayout(null);
		
		 popupMenu=new JPopupMenu(); 
		 button_1=new JMenuItem("收藏"); 
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//MainFImpl.AddCollection(book_id, cardNo)
				MainFImpl.AddCollection(vecBi.get(table.getSelectedRow()).getBook_id(), cardNo);
				
			}
		});
		
		 button_2=new JMenuItem("删除"); 
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User u = new User();
				u.setCardNo( cardNo);
				if(workModel ==1 ) {
					MainFImpl.DeleteCollection(vecBi.get(table.getSelectedRow()).getBook_id(), cardNo);
					JOptionPane.showMessageDialog(ptrMylibrary, "小的已经将这个家伙移出收藏了~");
					Vector<bookInfo> bv = MylibImpl.showCollection(u);
		 			showCollection(bv);
				}
				else if (workModel ==2) {
					MylibImpl.DeleteHaveBuy(vecBi.get(table.getSelectedRow()).getBook_id(), cardNo);
					JOptionPane.showMessageDialog(ptrMylibrary, "小的已经将这个家伙移出已买到的书籍了~");
					Vector<bookInfo> bv = MylibImpl.showHaveBuy(u);
		 			showCollection(bv);
				}	else if (workModel ==3) {
					MylibImpl.DeleteHaveSell(vecBi.get(table.getSelectedRow()).getBook_id(), cardNo);
					JOptionPane.showMessageDialog(ptrMylibrary, "小的已经将这个家伙移已出售了~");
					Vector<bookInfo> bv = MylibImpl.showHaveSell(u);
		 			showCollection(bv);
				}	else if (workModel ==4) {
					MylibImpl.DelWillSell(vecBi.get(table.getSelectedRow()).getBook_id(), cardNo);
					JOptionPane.showMessageDialog(ptrMylibrary, "小的已经将这个家伙移出代售了~");
					Vector<bookInfo> bv = MylibImpl.showHaveSell(u);
		 			showCollection(bv);
				}	
				
	 			
			}
		});
		
		 button_3=new JMenuItem("显示详情"); 
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	MainFImpl.DeleteCollection(book_id, cardNo);
				//System.out.println("显示详情");
				System.out.println("cardNo"+cardNo);
				System.out.println(vecBi.get(table.getSelectedRow()));
				 page_detail=new Page_detail(cardNo,vecBi.get(table.getSelectedRow()));
				page_detail.setBounds(0,0,1100,550);
				page_detail.setVisible(false);
				ptrMylibrary.add(page_detail);
				ptrMylibrary.setComponentZOrder(page_detail, 0);
				page_detail.setVisible(true);
				table.setVisible(false);
		 		page_detail.button_2.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent arg0) {
						//page_detail.setVisible(false);
//						contentPane.remove(page_detail);
//						panel_3.setVisible(true);
//				 		panel_1.setVisible(true);
						ptrMylibrary.remove(page_detail);
						table.setVisible(true);
						ptrMylibrary.repaint();
						//flag_back=true;
					}
				});
				
			}
		});
		
	    popupMenu.add(button_1);
	    popupMenu.add(button_2);
	    popupMenu.add(button_3);
	    
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 980, 500);
		
		table = new JTable(	)
		{
			public boolean isCellEditable(int row,int col)
			 {
				return false;
			 }
//			public void setValueAt(Object aValue,
//                    int row,
//                    int column) {
//				
//			}
			
		};
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(workModel == 1) {
					button_1.setVisible(false);
				}
				else {
					button_1.setVisible(true);
				}
				if (workModel == 4) {
					button_2.setText("下架");
				}
				else {
					button_2.setText("删除");
				}
				popupMenu.show(e.getComponent(), e.getX(), e.getY());
				//System.out.println(table.getSelectedRow());
			//	MainFImpl.AddCollection(table.getSelectedRow(), cardNo);
			}
		});
		//table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"书籍编号", "书籍名称", "作者", "出版社", "新旧等级", "价格"
			}
		));
		add(scrollPane,popupMenu);
//		table.addMouseListener(new MouseAdapter()
//		{
//		    public void mousePressed(MouseEvent e)
//		   {
//		    	    	    
//		    	popupMenu.show(e.getComponent(), e.getX(), e.getY());
//		    	        	
//		        
//		    }
//		});
		scrollPane.setViewportView(table);
		this.add(scrollPane);
		
		
		
		
	}
	void setLabelBac(String a,JLabel b) throws IOException{
			ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a + ".jpg");
			img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
		}
	public void showCollection(Vector<bookInfo> bv) {
		vecBi.clear();
		vecBi.addAll(bv);
		DefaultTableModel tableModel = new DefaultTableModel(
				null,
				new String[] {
				"书籍编号", "书籍名称", "作者", "出版社", "新旧等级", "价格"
			});
		for (int i = 0; i < bv.size(); i++) {
			tableModel.addRow(new Object[]{bv.get(i).getBook_id(),
												bv.get(i).getBook_name(),
												bv.get(i).getAuthor(),
												bv.get(i).getPress(),
												bv.get(i).getOldAndNew(),
												bv.get(i).getPrice(),
												
												});
			
		}
		int i=0;
		while(i++ <50) {
			tableModel.addRow(new Object[]{null,null,null,null,null}
			
					);
		}
		
		table.setModel(tableModel);
		
	}

}
