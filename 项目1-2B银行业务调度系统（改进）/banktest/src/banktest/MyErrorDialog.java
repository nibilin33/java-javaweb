package banktest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Menu;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.watermark.SubstanceBinaryWatermark;

import contrib.com.blogofbug.swing.components.JCarouselMenu.MenuItem;

public class MyErrorDialog extends JFrame {

  private JPanel contentPane;
  private JLabel la=new JLabel();
  private JPopupMenu pmw;
  JMenuItem getsure=null;
  JMenuItem stop=null;
  ImageIcon icon;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		 try {
			UIManager.setLookAndFeel(new SubstanceLookAndFeel());
		} catch (UnsupportedLookAndFeelException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		 SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
        SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
        SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());
        SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBinaryWatermark());
			
			}
		


	/**
	 * Create the frame.
	 */
	public MyErrorDialog(String filename) {
		 Menu popul=new Menu();
		 
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		this.addMouseListener(new myAdapter());
			
	    stop=new JMenuItem("退出");
	    stop.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			dispose();
		}
	});
	   getsure=new JMenuItem("上传");
	   getsure.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO 自动生成的方法存根
			 center.theImages[7]=icon.getImage();
			 center.setX(7);
			 dispose();
		}
	});
	   pmw=new JPopupMenu();
	   pmw.add(stop);
	   pmw.add(getsure);
		File file=new File(filename);
		Image itemp;
		try{
			BufferedImage bi=ImageIO.read(file);
			itemp=bi.getScaledInstance(350, 300, bi.SCALE_SMOOTH);
               icon=new ImageIcon(itemp);
              la.setIcon(icon);
            
		}catch(Exception e){
			e.printStackTrace();
		}
		contentPane.add(la,BorderLayout.CENTER);
	}
class myAdapter extends MouseAdapter{
	public void mouseClicked(MouseEvent e){
		pmw.show(e.getComponent(), e.getX(), e.getY());
	}
}



}
