package bank;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.GridBagLayout;

import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.Panel;

public class Main extends JFrame {

	private JPanel contentPane;
	public  StringBuilder s1=new StringBuilder();
    public StringBuilder s2=new StringBuilder();
    public StringBuilder s3=new StringBuilder();
    private JPanel panel;
    public static JTextArea textArea,textArea_1,textArea_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
					frame.running();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("\u94F6\u884C\u4E1A\u52A1\u8C03\u5EA6\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 400);
		contentPane=new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 3, 5, 5));
		
		panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		panel_3.setLayout(new GridLayout(1, 1, 0, 0));
		
		 textArea = new JTextArea();
		 textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		JScrollPane scrollPane = new JScrollPane(textArea);
		panel_3.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 1, 0, 0));
		
		 textArea_1 = new JTextArea();
		 textArea_1.setForeground(Color.WHITE);
		textArea_1.setBackground(Color.BLACK);
		
		JScrollPane scrollPane_1 = new JScrollPane(textArea_1);
		panel_1.add(scrollPane_1);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 1, 0, 0));
		
	 textArea_2 = new JTextArea();
	 textArea_2.setForeground(Color.WHITE);
		textArea_2.setBackground(Color.BLACK);
		
		JScrollPane scrollPane_2 = new JScrollPane(textArea_2);
		panel_2.add(scrollPane_2);
	     
	}

	public void running(){
	  
		ScheduledExecutorService timer=null;
		for(int i=1;i<=4;i++)
	     new ServiceWindow(CustomerType.GENERAL,i).start();
		 new ServiceWindow(CustomerType.QUICK,1).start();
		 new ServiceWindow(CustomerType.VIP,1).start();
		 timer=Executors.newScheduledThreadPool(1);
		 timer.scheduleAtFixedRate(new Runnable(){
			@Override
			
			public void run() {
				// TODO 自动生成的方法存根
				s3.append(NumberMachine.getinstant().generateTicket(CustomerType.GENERAL)+"\n");
				textArea.setText(s3.toString());
			
			}
			
		},1,Constants.COMMON_CUSTOMER_INTERVAL_TIME,TimeUnit.SECONDS);
		 timer = Executors.newScheduledThreadPool(1);
		          timer.scheduleAtFixedRate(
		                  new Runnable(){
		                      public void run(){
		            
		             s1.append(NumberMachine.getinstant().generateTicket(CustomerType.QUICK)+"\n");
		                         textArea_1.setText(s1.toString()); 
		                          
		                      }
		                  }, 
		                   1, 
		                  Constants.COMMON_CUSTOMER_INTERVAL_TIME*2, 
		                  TimeUnit.SECONDS);
		         
		          
		           timer = Executors.newScheduledThreadPool(1);
		          timer.scheduleAtFixedRate(
		                   new Runnable(){
		                       public void run(){
		                    	   s2.append(NumberMachine.getinstant().generateTicket(CustomerType.VIP)+"\n");
		                           textArea_2.setText(s2.toString()) ;
		                           
		                       }
		                  }, 
		                   1, 
		                   Constants.COMMON_CUSTOMER_INTERVAL_TIME*6, 
		                   TimeUnit.SECONDS);    
	}

}
