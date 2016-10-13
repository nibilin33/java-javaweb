package banktest;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class center extends JPanel {
	    // The Image to store the background image in.
	
	public static Image[] theImages=new Image[20];
	 public static int x=1;
	    public center()
	    {
	        // Loads the background image and stores in img object.
	    	
	        for(int i=1;i<=6;i++){
	        	
	        	theImages[i] =Toolkit.getDefaultToolkit().createImage("image/"+Integer.toString(i)+ ".jpg");
	        			//getImage(getDocumentBase(), "pic" + Integer.toString(i) + ".jpg");
	        } 
	           
	     
	    }

	    public int getX() {
			return x;
		}

		public static void setX(int x) {
			center.x = x;
		}

		public void paintComponent(Graphics g)
	    {
	        // Draws the img to the BackgroundPanel.
	    	
	        g.drawImage(theImages[center.x],0,0, getWidth(),getHeight(), null);
	        //super.paint(g);
	    }
   

}
