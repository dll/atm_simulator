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
import java.awt.Font;
import javax.swing.JScrollPane;

public class ViewSelect extends JFrame {

	private JPanel contentPane;
	private JList<?> lstAccounts;
	private Model model;
	private JButton btnCancel;
	private JButton btnOk;
	private JLabel lblError;
	private JLabel lblTitle;
	private JScrollPane scrollPane;
	
	/**
	 * Create the frame.
	 */
	public ViewSelect(Model myModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 314);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblSelect = new JLabel("Select Account:");
		
		btnOk = new JButton("Ok");
		
		btnCancel = new JButton("Cancel");
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		
		lblTitle = new JLabel("Bank Machine Simulation v1.0 >");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		scrollPane = new JScrollPane();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 349, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(208, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSelect)
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
							.addGap(312))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(scrollPane)
							.addGap(296))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(7)
							.addComponent(lblSelect))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addPreferredGap(ComponentPlacement.RELATED, 220, Short.MAX_VALUE)
					.addComponent(lblError))
		);
		
		lstAccounts = new JList();
		scrollPane.setViewportView(lstAccounts);
		lstAccounts.setSelectedIndex(0);
		lstAccounts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
