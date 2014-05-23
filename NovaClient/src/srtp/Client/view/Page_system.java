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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.srtp.Client.bz.impl.MyBag;
import srtp.server.bz.impl.MyBagImpl;

import k.bookInfo;


public class Page_system extends JPanel {
	private JTable table;
	 
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Page_system() throws IOException {
		
		this.setPreferredSize(new Dimension(1000,500));
		this.setOpaque(false);
		this.setVisible(true);
		setBackground(Color.white);
		setLayout(null);
		
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
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"\u4E66\u7C4D\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E"
			}
		));
		
		scrollPane.setViewportView(table);
		this.add(scrollPane);
	
//		DefaultTableModel tableModel = new DefaultTableModel(
//				null,
//				new String[] {
//						"书籍名称",  "作者", "出版社"
//			});
//		Vector<bookInfo> bv = MyBag.showNeedBook();
//		for (int i = 0; i < bv.size(); i++) {
//			tableModel.addRow(new Object[]{
//												bv.get(i).getBook_name(),
//												bv.get(i).getAuthor(),
//												bv.get(i).getPress(),
//												
//												});
//			
//		}
//		int i=0;
//		while(i++ <50) {
//			tableModel.addRow(new Object[]{null,null,null}
//			
//					);
//		}
//		
//		table.setModel(tableModel);
		
		
		
	}
	void setLabelBac(String a,JLabel b) throws IOException{
			ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
	                + "/" +"image"+ File.separator + a + ".jpg");
			img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
		}
	public void showNeedBook() {
		// TODO Auto-generated method stub
		DefaultTableModel tableModel = new DefaultTableModel(
				null,
				new String[] {
						"书籍名称",  "作者", "出版社"
			});
		Vector<bookInfo> bv = MyBag.showNeedBook();
		for (int i = 0; i < bv.size(); i++) {
			tableModel.addRow(new Object[]{
												bv.get(i).getBook_name(),
												bv.get(i).getAuthor(),
												bv.get(i).getPress(),
												
												});
			
		}
		int i=0;
		while(i++ <50) {
			tableModel.addRow(new Object[]{null,null,null}
			
					);
		}
		
		table.setModel(tableModel);
		
	}
}
