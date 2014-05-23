package src.srtp.Client.view;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

public class MyPanel extends JPanel {

	private Image img;
	/**
	 * Create the panel.
	 */
	public MyPanel(){
		super();
		this.setOpaque(false);
		this.setLayout(null);
	}

	public void setImg(Image img){
		this.img=img;
	}
	public void paintComponent(Graphics g){
		if(img!=null){
			int width=this.getWidth(); 
			int height=this.getHeight();
			g.drawImage(img,0,0,width,height,this);
			}
		super.paintComponent(g);
		}

}
