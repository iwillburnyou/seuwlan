

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Page_buy extends JPanel {
	private JTable table;
	 
	/**
	 * Create the panel.
	 * @throws IOException 
	 */
	public Page_buy() throws IOException {
		
		this.setPreferredSize(new Dimension(800,500));
		this.setOpaque(false);
		this.setVisible(true);
		setBackground(Color.white);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10,780, 500);
		
		table = new JTable()
		{
			public boolean isCellEditable(int row,int col)
			 {
				 return false;
			 }
			
		};
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\u7528\u6237\u540D\uFF08\u4E00\u5361\u901A\uFF09", "\u4E66\u7C4D\u540D\u79F0", "\u4F5C\u8005", "\u51FA\u7248\u793E"
			}
		));
	
		table.addMouseListener(new MouseAdapter()
		{
		    public void mouseClicked(MouseEvent e)
		   {
		    	if(e.getClickCount() == 2)
		    	{
		    		Handle_buy handle_buy=new Handle_buy();
		        	handle_buy.show();
		    	}
		        	
		        
		    }
		});
		scrollPane.setViewportView(table);
		this.add(scrollPane);
		
		
		
		
	}
	 
}
