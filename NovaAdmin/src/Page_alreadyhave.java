

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;

public class Page_alreadyhave extends JPanel {
	private JTable table;
	 
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Page_alreadyhave() throws IOException {
		
		this.setPreferredSize(new Dimension(800,500));
		this.setOpaque(false);
		this.setVisible(true);
		setBackground(Color.white);
		setLayout(null);
		
		final JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem item_1=new JMenuItem("删除"); 
		JMenuItem item_2=new JMenuItem("编辑"); 
		JMenuItem item_3=new JMenuItem("保存"); 
	    popupMenu.add(item_1);
	    popupMenu.add(item_2);
	    popupMenu.add(item_3);
		
	    
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10,780, 500);
		
		table = new JTable()
		{
			public boolean isCellEditable(int row,int col)
			 {
				 return false;
			 }
			
		};
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"\u7528\u6237\u540D\uFF08\u4E00\u5361\u901A\uFF09", "\u4E66\u7C4D\u7F16\u53F7", "\u4E66\u7C4D\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u65B0\u65E7\u7B49\u7EA7", "\u4EF7\u683C", "\u5DF2\u5356\u51FA\u6570\u91CF", "\u5269\u4F59\u6570\u91CF"
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

	
	
}
