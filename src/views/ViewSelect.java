package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import modelController.Model;
import java.awt.Color;

public class ViewSelect extends JFrame {

	private JPanel contentPane;
	private JList<?> lstAccounts;
	private Model model;
	private JButton btnCancel;
	private JButton btnOk;
	private JLabel lblError;
	
	/**
	 * Create the frame.
	 */
	public ViewSelect(Model myModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lstAccounts = new JList();
		lstAccounts.setSelectedIndex(0);
		lstAccounts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JLabel lblSelect = new JLabel("Select Account:");
		
		btnOk = new JButton("Ok");
		
		btnCancel = new JButton("Cancel");
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblSelect)
							.addGap(32)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addGap(28)
									.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE))
								.addComponent(lstAccounts, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(26, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lstAccounts, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSelect))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(lblError))
		);
		contentPane.setLayout(gl_contentPane);
		model = myModel;
	}
	
	
	//------------------PUBLIC METHODS
	public void populateList(DefaultListModel myModel)
	{
		lstAccounts.setModel(myModel);
	}
	
	//return list selected index
	public int getAccountSelectedIndex()
	{
		return lstAccounts.getSelectedIndex();
	}
	
	public void setError(String myMessage)
	{
		lblError.setText(myMessage);
	}
	
	
	
	//--------------------LISTENERS
	public void addOkActionListener(ActionListener okActionListener) 
	{
		btnOk.addActionListener(okActionListener);
	}
	
	public void addCancelActionListener(ActionListener cancelActionListener) 
	{
		btnCancel.addActionListener(cancelActionListener);
	}
	
	
}
