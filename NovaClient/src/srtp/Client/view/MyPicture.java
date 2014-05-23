package src.srtp.Client.view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class MyPicture extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int index;
	public MyPicture(String path) {
		this.index=Integer.valueOf(path).intValue();
		
		try {
			setLabelBac(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	void setLabelBac(String a) throws IOException{
		ImageIcon img = new ImageIcon(new File("").getAbsolutePath().replace('\\', '/')
                + "/" +"image"+ File.separator + a + ".jpg");
		img.setImage(img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT));
		//Icon icon=new ImageIcon(img);
		this.setIcon(img);
	}
}
