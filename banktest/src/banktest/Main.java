package banktest;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.ScrollPane;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Color;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import javax.swing.JButton;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.border.StandardBorderPainter;
import org.jvnet.substance.skin.EmeraldDuskSkin;
import org.jvnet.substance.skin.NebulaSkin;
import org.jvnet.substance.skin.OfficeBlue2007Skin;
import org.jvnet.substance.skin.SaharaSkin;
import org.jvnet.substance.skin.SubstanceSkin;
import org.jvnet.substance.theme.SubstanceTerracottaTheme;
import org.jvnet.substance.title.FlatTitlePainter;
import org.jvnet.substance.utils.SubstanceConstants.ImageWatermarkKind;
import org.jvnet.substance.watermark.SubstanceBinaryWatermark;
import org.jvnet.substance.watermark.SubstanceImageWatermark;
import org.jvnet.substance.watermark.SubstanceWatermark;

import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private JPanel contentPane;
	public static center centerpanel = new center();
	public CardLayout card;
	private changePanel changepanel;
	private TimePanel timepanel;
	private JButton btnNewButton_2;
	public Thread tp;
	public static JTextArea textArea,textArea_1,textArea_2;
	public static JTextArea[] textAreaArray = new JTextArea[15];
	public static JScrollPane[] scrollPaneArray = new JScrollPane[15];
	public static int genernaltunel[] = { 1, 0, 0, 0 };
	public static int quicktunel[] = { 1, 0, 0, 0 };
	public static int viptunel[] = { 1, 0, 0, 0 };
	public static int tunelCount = 1;
	public static Thread[] Stp = new Thread[15];
	public static NumberMachine NumMachine = new NumberMachine();
	public static int time1 = 1, time2 = 3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try{
				JFrame.setDefaultLookAndFeelDecorated(true);
				 UIManager.setLookAndFeel(new SubstanceLookAndFeel());
				 SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
	            SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
	            SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitlePainter());
	            SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBinaryWatermark());
			
				}catch(Exception e){}
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
		setBounds(100, 100, 550, 382);
		getContentPane().setLayout(new BorderLayout());
		card = new CardLayout(5, 5);
		contentPane = new JPanel();
		contentPane.setLayout(card);
		changepanel = new changePanel();
		timepanel = new TimePanel();
		final JPanel panelBg = new JPanel();
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(BorderFactory.createTitledBorder("<html><b><i>"
				+ "<u><font face='SansSerif' size='8' color='red'>welcome"
				+ "</font></u></i></b></html>"));
		Dimension dimension = new Dimension(550, 400);
		layeredPane.setPreferredSize(dimension);
		final JLabel bg = new JLabel(new ImageIcon("image/0.jpg"));
		final Point origin = new Point(10, 30);
		panelBg.setBounds(new Rectangle(10, 54, 492, 235));
		panelBg.add(bg);
		JToolBar toolBar = new JToolBar();
		getContentPane().add(toolBar, BorderLayout.NORTH);
		layeredPane.add(panelBg, new Integer(0));

		btnNewButton_2 = new JButton("\u7CFB\u7EDF\u7A97\u53E3");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				card.show(contentPane, "system");
			}
		});
		toolBar.add(btnNewButton_2);
		JButton btnNewButton = new JButton("\u8BBE\u7F6E");// chuangkoushu
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "change");
			}
		});
		toolBar.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("\u7EF4\u4FEE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				card.show(contentPane, "time");
			}
		});
		toolBar.add(btnNewButton_1);
		JButton btnNewButton_3 = new JButton("\u8FD4\u56DE");// tuichu
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				card.show(contentPane, "return");
			}
		});
		toolBar.add(btnNewButton_3);
	

		contentPane.add(layeredPane, "return");
		contentPane.add(centerpanel, "system");
		contentPane.add(timepanel, "time");
		centerpanel.setLayout(new GridLayout(0, 3, 5, 5));



   JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getViewport().setOpaque(false);//将JScrollPane设置为透明  
        scrollPane_1.setOpaque(false);//将中间的viewport设置为透明  
		centerpanel.add(scrollPane_1);
 
		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setBackground(Color.WHITE);
		textArea.setOpaque(false);
		scrollPane_1.setViewportView(textArea);
		textArea_2 = new JTextArea();
		textArea_2.setForeground(Color.BLACK);
		textArea_2.setBackground(Color.WHITE);
		textArea_2.setOpaque(false);
		textArea_1 = new JTextArea();
		textArea_1.setForeground(Color.BLACK);
		textArea_1.setBackground(Color.WHITE);
		textArea_1.setOpaque(false);
		textArea_1.append("无服务...");
		textArea_2.append("无服务...");
		centerpanel.add(textArea_2);
		centerpanel.add(textArea_1);
	
		contentPane.add(changepanel, "change");
		getContentPane().add(contentPane, BorderLayout.CENTER);
	}

	public void running() {
		NumMachine.start();
		tp = new Thread(new Runnable() {
			public void run() {
				while (true) {
					if (changepanel.change == true) {
						centerpanel.remove(textArea_1);
						centerpanel.remove(textArea_2);
						if (genernaltunel[changePanel.genernal] == 0) {
							
							scrollPaneArray[changePanel.genernal] = new JScrollPane();
							scrollPaneArray[changePanel.genernal].setOpaque(false);
							
							textAreaArray[changePanel.genernal] = new JTextArea();
							textAreaArray[changePanel.genernal].setOpaque(false);
							centerpanel
									.add(scrollPaneArray[changePanel.genernal]);
							textAreaArray[changePanel.genernal]
									.setForeground(Color.BLACK);
							textAreaArray[changePanel.genernal]
									.setBackground(Color.WHITE);
							scrollPaneArray[changePanel.genernal].getViewport().setOpaque(false);
							scrollPaneArray[changePanel.genernal]
									.setViewportView(textAreaArray[changePanel.genernal]);

							textAreaArray[changePanel.genernal].append("普通窗口" + changePanel.genernal
									+ "号开启\n");
							
							Stp[changePanel.genernal] = new ServiceWindow(
									textAreaArray[changePanel.genernal],
									CustomerType.GENERAL, changePanel.genernal,
									time1, time2);

							Stp[changePanel.genernal].start();
							genernaltunel[changePanel.genernal] = 1;
							tunelCount++;
						}
						if (quicktunel[changePanel.quick] == 0) {

							scrollPaneArray[changePanel.quick + 6] = new JScrollPane();
							scrollPaneArray[changePanel.quick + 6].setOpaque(false);
							textAreaArray[changePanel.quick + 6] = new JTextArea();
							textAreaArray[changePanel.quick + 6].setOpaque(false);
							centerpanel
									.add(scrollPaneArray[changePanel.quick + 6]);
							textAreaArray[changePanel.quick + 6]
									.setForeground(Color.BLACK);
							textAreaArray[changePanel.quick + 6]
									.setBackground(Color.WHITE);
							scrollPaneArray[changePanel.quick + 6].getViewport().setOpaque(false);
							scrollPaneArray[changePanel.quick + 6]
									.setViewportView(textAreaArray[changePanel.quick + 6]);

							textAreaArray[changePanel.quick + 6].append("快速窗口" + changePanel.quick
									+ "号开启\n");
							
							Stp[changePanel.quick + 6] = new ServiceWindow(
									textAreaArray[changePanel.quick + 6],
									CustomerType.QUICK, changePanel.quick,
									time1, time2);
							Stp[changePanel.quick + 6].start();
							quicktunel[changePanel.quick] = 1;
							tunelCount++;
						}
						if (viptunel[changePanel.vip] == 0) {

							scrollPaneArray[changePanel.vip + 9] = new JScrollPane();
							scrollPaneArray[changePanel.vip + 9].setOpaque(false);
							textAreaArray[changePanel.vip + 9] = new JTextArea();
							textAreaArray[changePanel.vip + 9].setOpaque(false);
							centerpanel
									.add(scrollPaneArray[changePanel.vip + 9]);
							textAreaArray[changePanel.vip + 9]
									.setForeground(Color.BLACK);
							textAreaArray[changePanel.vip + 9]
									.setBackground(Color.WHITE);
							scrollPaneArray[changePanel.vip + 9].getViewport().setOpaque(false);
							scrollPaneArray[changePanel.vip + 9].setViewportView(textAreaArray[changePanel.vip + 9]);

							textAreaArray[changePanel.vip + 9].append("VIP窗口" + changePanel.vip
									+ "号开启\n");
							
							Stp[changePanel.vip + 9] = new ServiceWindow(
									textAreaArray[changePanel.vip + 9],
									CustomerType.VIP, changePanel.vip, time1,
									time2);
							Stp[changePanel.vip + 9].start();
							viptunel[changePanel.vip] = 1;
							tunelCount++;
						}
						changepanel.change = false;

						if(tunelCount%3==2){
							centerpanel.add(textArea_2);
						}
						if(tunelCount%3==1){
							centerpanel.add(textArea_2);
							centerpanel.add(textArea_1);
						}
						
					}
					if (timepanel.changetime == true) {
						int x = Integer.parseInt(timepanel.comboBox
								.getSelectedItem().toString().trim());
						String Fcolor =  timepanel.comboBox_5.getSelectedItem().toString();
						if(JImage.ch==true){
							repaint();
							JImage.ch=false;
						}
						if (timepanel.comboBox_3.getSelectedItem().toString() == "普通") {
							if (genernaltunel[x] != 1) {
								JOptionPane.showMessageDialog(null,
										"窗口未开启修改失败！");
								timepanel.changetime = false;
							} else {
						
								if(Fcolor!="")
									textAreaArray[x]
											.setForeground(ChangeColor.getChangeColor(Fcolor));
								textArea.append("普通窗口"
										+ timepanel.comboBox.getSelectedItem()
												.toString()
										+ "重启!!!!!!!!!!!!!!!!!" + "\n");
								((ServiceWindow) Stp[x]).set(Integer
										.parseInt(timepanel.comboBox_1
												.getSelectedItem().toString()),
										Integer.parseInt(timepanel.comboBox_2
												.getSelectedItem().toString()));
								JOptionPane.showMessageDialog(null, "修改成功！");
							}
						}
						if (timepanel.comboBox_3.getSelectedItem().toString() == "快速") {
							if (quicktunel[x] != 1) {
								JOptionPane.showMessageDialog(null,
										"窗口未开启修改失败！");
							} else {
			
								if(Fcolor!="")
									textAreaArray[x + 6]
											.setForeground(ChangeColor.getChangeColor(Fcolor));
								
								textArea.append("快速窗口"
										+ timepanel.comboBox.getSelectedItem()
												.toString()
										+ "重启!!!!!!!!!!!!!!!!!" + "\n");
								((ServiceWindow) Stp[x + 6]).set(Integer
										.parseInt(timepanel.comboBox_1
												.getSelectedItem().toString()),
										Integer.parseInt(timepanel.comboBox_2
												.getSelectedItem().toString()));
								JOptionPane.showMessageDialog(null, "修改成功！");
							}
						}
						if (timepanel.comboBox_3.getSelectedItem().toString() == "VIP") {
							if (viptunel[x] != 1) {
								JOptionPane.showMessageDialog(null,
										"窗口未开启修改失败！");
								timepanel.changetime = false;
							} else {
							
								if(Fcolor!="")
									textAreaArray[x + 9]
											.setForeground(ChangeColor.getChangeColor(Fcolor));
								
								textArea.append("VIP窗口"
										+ timepanel.comboBox.getSelectedItem()
												.toString()
										+ "重启!!!!!!!!!!!!!!!!!" + "\n");
								((ServiceWindow) Stp[x + 9]).set(Integer
										.parseInt(timepanel.comboBox_1
												.getSelectedItem().toString()),
										Integer.parseInt(timepanel.comboBox_2
												.getSelectedItem().toString()));
								JOptionPane.showMessageDialog(null, "修改成功！");
							}
						}
						timepanel.changetime = false;
					}
					try {
						tp.sleep(500);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}

			}
		});
		tp.start();
	}
	
}
