

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

public class Page_user extends JPanel {
	private JTable table;
	 
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Page_user() throws IOException {
		
		this.setPreferredSize(new Dimension(800,500));
		this.setOpaque(false);
		this.setVisible(true);
		setBackground(Color.white);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10,780, 500);
		
		final JPopupMenu popupMenu=new JPopupMenu();
		JMenuItem item_1=new JMenuItem("删除"); 
		JMenuItem item_2=new JMenuItem("编辑"); 
		JMenuItem item_3=new JMenuItem("保存"); 
	    popupMenu.add(item_1);
	    popupMenu.add(item_2);
	    popupMenu.add(item_3);
		
		table = new JTable()
		{
			public boolean isCellEditable(int row,int col)
			 {
				 return false;
			 }
			
		};
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
				"\u4E00\u5361\u901A", "\u5B66\u53F7", "\u59D3\u540D", "\u5BC6\u7801", "\u8D26\u6237\u4F59\u989D", "\u90AE\u7BB1"
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
