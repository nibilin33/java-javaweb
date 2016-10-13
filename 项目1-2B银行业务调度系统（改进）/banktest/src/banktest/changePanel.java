package banktest;


import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Color;

public class changePanel extends JPanel {
	public  volatile boolean change=false;
	public int normalwin=1;
	public int min,max;
	public static int genernal,quick,vip; 
	JComboBox<String> comboBox_4,comboBox_5,comboBox_6;
	ImageIcon icon;  
	Image img; 
	 ImageIcon	icon1=new ImageIcon("image/2.jpg");
	/**
	 * Create the panel.
	 */
	public changePanel() {
	
		setLayout(null);
		JLabel lblNewLabel = new JLabel("\u666E\u901A\u7A97\u53E3\u670D\u52A1\u53F7\uFF1A");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel.setBounds(66, 43, 128, 36);
		add(lblNewLabel);
		JButton btnNewButton = new JButton("确定");
		btnNewButton.putClientProperty(
				   "Quaqua.Button.style", "bevel"
				);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				change=true;
				JOptionPane.showMessageDialog(null,"启动新窗口");
				
			}
		});

		btnNewButton.setBounds(101, 216, 93, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("初始化");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			}
		});
		btnNewButton_1.setBounds(275, 216, 93, 23);
		add(btnNewButton_1);
		JLabel lblNewLabel_7 = new JLabel("\u7279\u5FEB\u7A97\u53E3\u670D\u52A1\u53F7\uFF1A");
		lblNewLabel_7.setForeground(Color.BLACK);
		lblNewLabel_7.setBackground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(66, 89, 138, 33);
		add(lblNewLabel_7);
		JLabel lblNewLabel_8 = new JLabel("VIP\u7A97\u53E3\u670D\u52A1\u53F7\uFF1A");
		lblNewLabel_8.setForeground(Color.BLACK);
		lblNewLabel_8.setBackground(Color.WHITE);
		lblNewLabel_8.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		lblNewLabel_8.setBounds(72, 141, 125, 27);
		add(lblNewLabel_8);
		
		comboBox_4 = new JComboBox<String>();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		comboBox_4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_4.getSelectedItem().toString()=="")
					genernal=0;
				else
					genernal=Integer.parseInt(comboBox_4.getSelectedItem().toString());
				if(comboBox_5.getSelectedItem().toString()=="")
					quick=0;
				else
					quick=Integer.parseInt(comboBox_5.getSelectedItem().toString());
				if(comboBox_6.getSelectedItem().toString()=="")
					vip=0;
				else
					vip=Integer.parseInt(comboBox_6.getSelectedItem().toString());
			}
		});
		comboBox_4.setBounds(229, 47, 128, 21);
		comboBox_4.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO 自动生成的方法存根
				
				if(arg0.getStateChange()==ItemEvent.SELECTED){
				normalwin=Integer.parseInt(comboBox_4.getSelectedItem().toString());
			
				}
			}
		});
	
		add(comboBox_4);	
		comboBox_5 = new JComboBox<String>();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		comboBox_5.setBounds(229, 96, 128, 21);
		comboBox_5.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_5.getSelectedItem().toString()=="")
					quick=0;
				else
					quick=Integer.parseInt(comboBox_5.getSelectedItem().toString());
			}
		});
		add(comboBox_5);
		
		comboBox_6 = new JComboBox<String>();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3"}));
		comboBox_6.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(comboBox_6.getSelectedItem().toString()=="")
					vip=0;
				else
					vip=Integer.parseInt(comboBox_6.getSelectedItem().toString());
			}
		});
		comboBox_6.setBounds(229, 147, 128, 21);
		add(comboBox_6);
	}
	
	    
}
