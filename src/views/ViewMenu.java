package views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelController.*;
public class ViewMenu extends JFrame {

	private JPanel contentPane;
	private JButton btnCreate;

	private Model model;
	private JButton btnDeposit;
	private JButton btnView;
	private JButton btnSelect;
	private JButton btnDelete;
	private JButton btnWithdraw;
	private JButton btnQuit;
	
	public ViewMenu(Model myModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSelect = new JButton("select");
		
		btnDeposit = new JButton("deposit");
		
		btnWithdraw = new JButton("withdraw");
		
		btnCreate = new JButton("create");
		
		btnDelete = new JButton("delete");
		
		btnView = new JButton("view");
		
		btnQuit = new JButton("quit");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnDeposit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnWithdraw, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnCreate, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnView, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnQuit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnSelect, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(296, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addComponent(btnSelect)
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addComponent(btnDeposit)
					.addGap(18)
					.addComponent(btnWithdraw)
					.addGap(18)
					.addComponent(btnCreate)
					.addGap(18)
					.addComponent(btnDelete)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnView)
					.addGap(18)
					.addComponent(btnQuit)
					.addGap(41))
		);
		contentPane.setLayout(gl_contentPane);
		
		model = myModel; 
	}

	//-------------------------------PUBLIC METHODS
	public void addCreateListener(ActionListener createActionListener) 
	{
		btnCreate.addActionListener(createActionListener);
	}
	public void addDepositActionListener(ActionListener depositActionListener) 
	{
		btnDeposit.addActionListener(depositActionListener);
	}
	public void addViewActionListener(ActionListener viewActionListener) 
	{
		btnView.addActionListener(viewActionListener);
	}
	public void addSelectActionListener(ActionListener selectActionListener) 
	{
		btnSelect.addActionListener(selectActionListener);
	}
	public void addDeleteActionListener(ActionListener deleteActionListener) 
	{
		btnDelete.addActionListener(deleteActionListener);
	}
	public void addWithdrawActionListener(ActionListener withdrawActionListener) 
	{
		btnWithdraw.addActionListener(withdrawActionListener);
	}
	public void addQuitActionListener(ActionListener quitActionListener) 
	{
		btnQuit.addActionListener(quitActionListener);
	}
}
