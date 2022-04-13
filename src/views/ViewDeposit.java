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
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import modelController.*;
import java.awt.Color;
import java.awt.Font;

public class ViewDeposit extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmount;
	private JTextField txtDescription;
	private JButton btnCancel;
	private JButton btnOk;
	
	Model model;
	private JLabel lblError;
	private JLabel lblTitle;

	
	public ViewDeposit(Model myModel) {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 630, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblAmount = new JLabel("Enter Amount to deposit: $");
		
		JLabel lblNewLabel_1 = new JLabel("Transaction Description:");
		
		btnOk = new JButton("OK");
		
		btnCancel = new JButton("Cancel");
		
		txtAmount = new JTextField();
		txtAmount.setColumns(10);
		
		txtDescription = new JTextField();
		txtDescription.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setForeground(Color.RED);
		
		lblTitle = new JLabel("Bank Machine Simulation v1.0 >");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 558, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblAmount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnOk)
									.addGap(18)
									.addComponent(btnCancel))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(19, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAmount)
						.addComponent(txtAmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addGap(18)
					.addComponent(lblError, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(72, Short.MAX_VALUE))
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
	
	//------------------------PUBLIC METHODS
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
