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
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

import modelController.Model;
import java.awt.Color;
import java.awt.Font;

public class ViewWithdraw extends JFrame {

	private Model model;
	private JPanel contentPane;
	private JTextField txtAmount;
	private JTextField txtDescription;
	private JButton btnOk;
	private JButton btnCancel;
	private JLabel lblError;
	private JLabel lblTitle;

	/**
	 * Create the frame.
	 */
	public ViewWithdraw(Model myModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAmount = new JLabel("Enter Amount to withdraw: $");
		
		JLabel lblTransaction = new JLabel("Transaction Description:");
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		
		btnOk = new JButton("Ok");
		
		btnCancel = new JButton("Cancel");
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		
		lblTitle = new JLabel("Bank Machine Simulation v1.0 >");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblError, GroupLayout.DEFAULT_SIZE, 568, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblTransaction, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblAmount, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addGap(31)
									.addComponent(btnCancel))
								.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDescription, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTransaction)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addGap(34)
					.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		model = myModel;
	}
	
	//----------------------PUBLIC METHODS
		public JTextField getAmount()
		{
			return txtAmount;
		}
		public JTextField getDescription()
		{
			return txtDescription;
		}
		
		public void setError(String myMessage)
		{
			lblError.setText(myMessage);
		}
		
		public void reset()
		{
			lblError.setText("");
			txtAmount.setText("");
			txtDescription.setText("");
		}
		//---------------------EVENT LISTENERS
		public void addOkActionListener(ActionListener okActionListener)
		{
			btnOk.addActionListener(okActionListener);
		}
		
		public void addCancelActionListener(ActionListener cancelActionListener)
		{
			btnCancel.addActionListener(cancelActionListener);
		}
}
