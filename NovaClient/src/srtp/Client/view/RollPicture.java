package src.srtp.Client.view;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RollPicture extends JLabel implements Runnable {
	private int index;
	private int size;
	private ImageIcon[] images;
	public RollPicture(int size, String path) {
		this.size = size;
		images = new ImageIcon[size];
		for (int i = 0; i < size; i++) {
			images[i] = new ImageIcon(path + File.separator + i + ".jpg");
			images[i].setImage(images[i].getImage().getScaledInstance(125,120,Image.SCALE_DEFAULT));
			}
		this.index = 0;
		this.setIcon(images[index]);
		}
	
	public void changeIndex() {
		this.index++;
		if (index >= size) {
			index = 0;
			}
		this.setIcon(images[index]);
		}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			this.changeIndex();
			try {
				Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
		}
	}
