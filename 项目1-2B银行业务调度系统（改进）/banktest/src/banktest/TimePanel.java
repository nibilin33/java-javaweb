package banktest;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;


import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;

public class TimePanel extends JPanel {
	public static JComboBox comboBox,comboBox_1,comboBox_2, comboBox_3,comboBox_5;
	public  volatile boolean changetime=false;
	ImageIcon icon1=new ImageIcon("image/2.jpg");
	String filename;
	/**
	 * Create the panel.
	 */
	public TimePanel() {
		setBackground(Color.WHITE);
		setLayout(null);
		JLabel lblNewLabel = new JLabel("\u670D\u52A1\u7A97\u53E3\uFF1A");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(77, 32, 117, 32);
		add(lblNewLabel);
		
	   comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3"}));
		comboBox.setBounds(300, 40, 66, 21);
		add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u670D\u52A1\u65F6\u95F4\uFF1A");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(77, 74, 99, 32);
		add(lblNewLabel_1);
		
	     comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_1.setBounds(204, 82, 64, 21);
		add(comboBox_1);
		
		JLabel lblNewLabel_2 = new JLabel(" ~");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 19));
		lblNewLabel_2.setBounds(270, 88, 32, 18);
		add(lblNewLabel_2);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6"}));
		comboBox_2.setBounds(300, 82, 64, 21);
		add(comboBox_2);
		
		JButton btnNewButton = new JButton("\u91CD\u7F6E");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changetime=true;
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(153, 234, 152, 23);
		add(btnNewButton);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u666E\u901A", "\u5FEB\u901F", "VIP"}));
		comboBox_3.setBounds(204, 40, 60, 21);
		add(comboBox_3);
		
		JLabel label = new JLabel("\u80CC\u666F\u76AE\u80A4\uFF1A");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("宋体", Font.PLAIN, 18));
		label.setBounds(77, 116, 117, 32);
		add(label);
		
		JLabel label_1 = new JLabel("\u5B57\u4F53\u989C\u8272\uFF1A");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("宋体", Font.PLAIN, 18));
		label_1.setBounds(77, 166, 117, 32);
		add(label_1);
		
		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"", "\u9ED1\u8272", "\u84DD\u8272", "\u9752\u8272", "\u6697\u7070", "\u7070\u8272", "\u7EFF\u8272", "\u4EAE\u7070", "\u54C1\u7EA2", "\u6A59\u8272", "\u7C89\u8272", "\u7EA2\u8272", "\u767D\u8272", "\u9EC4\u8272"}));
		comboBox_5.setBounds(204, 174, 162, 21);
		add(comboBox_5);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u770B");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			         JImage i=new JImage();
			         i.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(204, 123, 66, 23);
		add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u81EA\u5B9A\u4E49");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser=new JFileChooser();
				chooser.setCurrentDirectory(new File("."));
				chooser.addChoosableFileFilter(new FileFilter() {
					
					@Override
					public String getDescription() {
						// TODO 自动生成的方法存根
						return "jpg(*.jpg)";
					}
					
					@Override
					public boolean accept(File arg0) {
						// TODO 自动生成的方法存根
						return arg0.getName().toLowerCase().endsWith(".jpg")||arg0.isDirectory();
					}
				});
				int r=chooser.showOpenDialog(getParent());
				if(r==JFileChooser.APPROVE_OPTION){
					filename=chooser.getSelectedFile().getPath();
					try{
						if(filename.endsWith("jpg")){
							MyErrorDialog di=new MyErrorDialog(filename);
							di.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "不能打开该文件格式");
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
				
		});
		btnNewButton_2.setBounds(300, 123, 69, 23);
		add(btnNewButton_2);

	}
}
