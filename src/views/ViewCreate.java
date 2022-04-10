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
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;

import modelController.*;
import javax.swing.ListSelectionModel;
import java.awt.Color;

public class ViewCreate extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescription;
	private JTextField txtStartingBalance;
	private JButton btnCancel;
	

	//the Model object of the MVC design pattern
	private Model model;
	private JButton btnOk;
	private JList lstAccountType;
	private JLabel lblError;
	

	/**
	 * Create the frame.
	 */
	public ViewCreate(Model myModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnOk = new JButton("OK");
		
		btnCancel = new JButton("Cancel");
		
		lstAccountType = new JList();
		lstAccountType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstAccountType.setModel(new AbstractListModel() {
			String[] values = new String[] {"Air Miles Account", "Savings Account"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		lstAccountType.setSelectedIndex(0);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		
		txtStartingBalance = new JTextField();
		txtStartingBalance.setColumns(10);
		
		JLabel lblAccountType = new JLabel("Account Type:");
		
		JLabel lblAccountDescription = new JLabel("Account Description:");
		
		JLabel lblStartBalance = new JLabel("Stariting Balance: $");
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAccountType, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(18))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblStartBalance, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
							.addComponent(lblAccountDescription, GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(38)
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancel))
						.addComponent(txtStartingBalance, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)
						.addComponent(lstAccountType, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
					.addGap(36))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addComponent(lblError, GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAccountType)
						.addComponent(lstAccountType, GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartBalance)
								.addComponent(txtStartingBalance, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnOk)
								.addComponent(btnCancel)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblAccountDescription)
							.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
		model = myModel;
	}
	
	//-------------------------------PUBLIC METHODS
	
	public JTextField getDescription()
	{
		//String description = txtDescription.getText();
		//txtDescription.requestFocusInWindow();
		return txtDescription;
	}
	
	public JTextField getStartingBalance()
	{
		//String balance = txtStartingBalance.getText();
		//txtStartingBalance.requestFocusInWindow();
		return txtStartingBalance;
	}
	
	public String getAccountType()
	{
		return (String)lstAccountType.getSelectedValue();
	}
	
	public void setError(String myMessage)
	{
		lblError.setText(myMessage);
	}
	
	public void reset()
	{
		lblError.setText("");
		lstAccountType.setSelectedIndex(0);
		txtDescription.setText("");
		txtStartingBalance.setText("");
	}
	
	
	//--------------------Listeners
	public void addOkListener(ActionListener okActionListener) 
	{
		btnOk.addActionListener(okActionListener);
	}
	
	
	public void addCancelListener(ActionListener cancelActionListener) 
	{
		btnCancel.addActionListener(cancelActionListener);
	}
}
