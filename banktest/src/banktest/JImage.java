package banktest;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.utils.icon.RadioButtonMenuItemIcon;
import org.jvnet.substance.watermark.SubstanceBinaryWatermark;

public class JImage extends JFrame {

	public JPanel contentPane;
    public JRadioButton t1,t2,t3,t4,t5,t6;
    Image[] theImages=new Image[6];
    public static center centerpanel=new center();
    public int x;
    public static volatile boolean ch=false;
 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

				try{
					JFrame.setDefaultLookAndFeelDecorated(true);
					 UIManager.setLookAndFeel(new SubstanceLookAndFeel());
					 SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
		            SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
		            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());
		            SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBinaryWatermark());
					}catch(Exception e){}
				try {
					JImage frame = new JImage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	/**
	 * Create the frame.
	 */
	public JImage() {
		setTitle("\u80CC\u666F\u9009\u62E9");
		
		  for(int i=1;i<=5;i++){
	        	theImages[i] =Toolkit.getDefaultToolkit().createImage("image/"+Integer.toString(i)+ ".jpg");
	        			//getImage(getDocumentBase(), "pic" + Integer.toString(i) + ".jpg");
	        } 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setOpaque(false);
		contentPane.setLayout(new BorderLayout());
		centerpanel.setLayout(null);
		contentPane.add(centerpanel,BorderLayout.CENTER);
		
		t1 = new JRadioButton("\u56FE\u72471");
		t1.setOpaque(false);
		t1.setBounds(21, 24, 103, 23);
		t1.setSelected(true);
		t1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(t1.isSelected()){
					center.setX(1);
					x=1;
					repaint();
				}
			}
		});
		
		centerpanel.add(t1);
		
		t2= new JRadioButton("\u56FE\u72472");
		t2.setBounds(21, 57, 103, 23);
		t2.setOpaque(false);
		t2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(t2.isSelected()){
					center.setX(2);
					x=2;
					repaint();
				}
			}
		});
		centerpanel.add(t2);
		
		t3 = new JRadioButton("\u56FE\u72473");
		t3.setBounds(21, 96, 103, 23);
		t3.setOpaque(false);
		t3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(t3.isSelected()){
					center.setX(3);
					x=3;
					repaint();
				}
			}
		});
		centerpanel.add(t3);
		
		t4 = new JRadioButton("\u56FE\u72474");
		t4.setBounds(21, 134, 103, 23);
		t4.setOpaque(false);
		t4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(t4.isSelected()){
					center.setX(4);
					repaint();
				}
			}
		});
		centerpanel.add(t4);
		
		t5 = new JRadioButton("\u56FE\u72475");
		t5.setBounds(21, 169, 103, 23);
		t5.setOpaque(false);
		t5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(t5.isSelected()){
					center.setX(5);
					x=5;
					repaint();
				}
			}
		});
		centerpanel.add(t5);
		
		t6 = new JRadioButton("\u56FE\u72476");
		t6.setBounds(21, 205, 103, 23);
		t6.setOpaque(false);
		t6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(t6.isSelected()){
					center.setX(6);
					x=6;
					repaint();
				}
			}
		});
		centerpanel.add(t6);
		ButtonGroup ss=new ButtonGroup();
		ss.add(t1);
		ss.add(t2);
		ss.add(t3);
		ss.add(t4);
		ss.add(t5);
		ss.add(t6);
		JButton btnNewButton = new JButton("\u786E\u5B9A");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main.centerpanel.setX(x);
				ch=true;
				dispose();
			}
		});
		btnNewButton.setBounds(175, 228, 93, 23);
		centerpanel.add(btnNewButton);
	}

	
}
