package src.srtp.Client.view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;

import javax.swing.JWindow;

public class SplashWithImage extends JWindow{
    private String imageUrl = "/image/login1.jpg";
    public SplashWithImage() {
        //this.setBackground(Color.GRAY);
        this.setBounds(new Rectangle(800,600));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    @Override
	public void paint(Graphics g) {
       
        Image image = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource(imageUrl));
        
      
        g.setColor(Color.DARK_GRAY);
        Font font = new Font("华文细黑",Font.LAYOUT_RIGHT_TO_LEFT,25);
        g.setFont(font);
        
      
        int i = 0;
        while (i < 5) {
        	 
            try {
            	if(i == 0) {
            		g.setColor(new Color(200,0,0));
            	} else if (i == 1) {
            		g.setColor(new Color(200,100,0));
				} else if (i == 2) {
					g.setColor(new Color(100,200,0));
				}	else if (i == 3) {
					g.setColor(new Color(0,255,100));
				}	else if (i == 4) {
					g.setColor(new Color(0,100,200));
				}
            	
            	 g.drawImage(image, 0, 0, 800,600,this);
            	  
            	g.drawString("Welcome to NovaLibray", 30, 500);
            	Thread.sleep(1000);
              
              
                
            
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            i++;
            if (i == 5) {
            	
                this.dispose();
            }
        }
    }
   
	public static void main(String[] args) throws InterruptedException 
	{
	      new SplashWithImage();
         Thread.sleep(5000);
		
  
	}

}
