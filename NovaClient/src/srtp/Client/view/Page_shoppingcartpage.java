package src.srtp.Client.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.srtp.Client.bz.impl.MainFImpl;
import src.srtp.Client.bz.impl.MyBag;

import k.bookInfo;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Page_shoppingcartpage extends JPanel {
	private JTable table;
	public String cardNo;
	 

	final Vector<bookInfo> vecBi;
	int workModel ;
	Page_detail page_detail;
	
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Page_shoppingcartpage() throws IOException {
		vecBi = new Vector<bookInfo>();
		this.setPreferredSize(new Dimension(1000,500));
		this.setOpaque(false);
		this.setVisible(true);
		setBackground(Color.white);
		setLayout(null);
		
		final JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem item_1=new JMenuItem("结算"); 

		JMenuItem item_2=new JMenuItem("收藏"); 
		JMenuItem item_3=new JMenuItem("删除"); 
		
		item_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				System.out.println(" "+JOptionPane.showConfirmDialog(table.getParent(), "确定要结算这本书吗？"));
//				System.out.println(cardNo);
				if (MyBag.buyOneBook(vecBi.get(table.getSelectedRow()).getPrice(), cardNo)) {
					JOptionPane.showMessageDialog(table.getParent(), "恭喜，购买成功~");
				} else {
					JOptionPane.showMessageDialog(table.getParent(), "结算失败~");
				}
			}
		});
		
		item_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainFImpl.AddCollection(vecBi.get(table.getSelectedRow()).getBook_id(), cardNo);
				JOptionPane.showMessageDialog(table.getParent(), "加入收藏夹成功~");
			}
		});
		
		item_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyBag.delCart(vecBi.get(table.getSelectedRow()).getBook_id(), cardNo);
				JOptionPane.showMessageDialog(table.getParent(), "移出购物车成功~");
				table.repaint();
			}
		});
	    popupMenu.add(item_1);
	    popupMenu.add(item_2);
	    popupMenu.add(item_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 980, 500);
		
		table = new JTable()
		{
			public boolean isCellEditable(int row,int col)
			 {
				 return false;
			 }
			
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
					"书籍编号", "书籍名称", "作者", "出版社", "新旧等级", "价格"
					,"已卖出数量","剩余数量"
			}
		));
		add(scrollPane,popupMenu);
		table.addMouseListener(new MouseAdapter()
		{
		    public void mousePressed(MouseEvent e)
		   {
		    	    	    
		    	popupMenu.show(e.getComponent(), e.getX(), e.getY());
		    	        	
		        
		    }
		});
		scrollPane.setViewportView(table);
		this.add(scrollPane);
		
		
		
		
	}

	public void showCollection(Vector<bookInfo> bv) {
		// TODO Auto-generated method stub
		vecBi.clear();
		vecBi.addAll(bv);
		DefaultTableModel tableModel = new DefaultTableModel(
				null,
				new String[] {
						"书籍编号", "书籍名称", "作者", "出版社", "新旧等级", "价格"
						,"已卖出数量","剩余数量"
			});
		for (int i = 0; i < bv.size(); i++) {
			tableModel.addRow(new Object[]{bv.get(i).getBook_id(),
												bv.get(i).getBook_name(),
												bv.get(i).getAuthor(),
												bv.get(i).getPress(),
												bv.get(i).getOldAndNew(),
												bv.get(i).getPrice(),
												bv.get(i).getNum_sell(),
												bv.get(i).getNum_left()
												
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
