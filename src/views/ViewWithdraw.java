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

public class ViewWithdraw extends JFrame {

	private Model model;
	private JPanel contentPane;
	private JTextField txtAmount;
	private JTextField txtDescription;
	private JButton btnOk;
	private JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public ViewWithdraw(Model myModel) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
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
						.addComponent(txtDescription, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
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
					.addContainerGap(124, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		model = myModel;
	}
	
	//----------------------PUBLIC METHODS
		public String getAmount()
		{
			return txtAmount.getText();
		}
		public String getDescription()
		{
			return txtDescription.getText();
		}
		
		public void reset()
		{
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
