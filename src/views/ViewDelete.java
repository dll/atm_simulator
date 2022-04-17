package views;

import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;

import modelController.Model;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ViewDelete extends JFrame {

	private JPanel contentPane;
	private JButton btnDelete;
	private Model model;
	private JButton btnCancel;
	private JLabel lblCurrentAccount;
	private JLabel lblTitle;
	
	public ViewDelete(Model myModel) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDelete = new JLabel("Delete Current Account?");
		
		lblCurrentAccount = new JLabel("");
		lblCurrentAccount.setForeground(Color.ORANGE);
		
		btnDelete = new JButton("Delete");
		
		btnCancel = new JButton("Cancel");
		
		lblTitle = new JLabel("Bank Machine Simulation v1.0 >");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDelete)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblDelete, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
								.addGap(27)
								.addComponent(lblCurrentAccount, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))))
					.addGap(18)
					.addComponent(btnCancel)
					.addContainerGap(116, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDelete)
						.addComponent(lblCurrentAccount))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(btnCancel))
					.addContainerGap(175, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		model = myModel;
	}

	//--------------------PUBLIC METHODS
	public void setDescription(String newDescription)
	{
		lblCurrentAccount.setText(newDescription);
	}
	
	//--------------------LISTENERS
	public void addDeleteActionListener(ActionListener deleteActionListener) 
	{
		btnDelete.addActionListener(deleteActionListener);
	}
	
	public void addCancelActionListener(ActionListener cancelActionListener) 
	{
		btnCancel.addActionListener(cancelActionListener);
	}
	
}
