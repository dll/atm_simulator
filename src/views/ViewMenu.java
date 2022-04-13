package views;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import modelController.*;
import javax.swing.JLabel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Color;
import java.awt.Font;
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
	private JLabel lblNewLabel;
	private JLabel lblDepositSumTo;
	private JLabel lblWithdrawSumFrom;
	private JLabel lblCreateAccount;
	private JLabel lblDeleteAccount;
	private JLabel lblViewAccountTransactions;
	private JLabel lblSaveAndQuit;
	
	public ViewMenu(Model myModel) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				if(model.loadAccounts())
				{
					enableButtons();
				};
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 379);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSelect = new JButton("select");
		btnSelect.setEnabled(false);
		
		btnDeposit = new JButton("deposit");
		btnDeposit.setEnabled(false);
		
		btnWithdraw = new JButton("withdraw");
		btnWithdraw.setEnabled(false);
		
		btnCreate = new JButton("create");
		
		btnDelete = new JButton("delete");
		btnDelete.setEnabled(false);
		
		btnView = new JButton("view");
		btnView.setEnabled(false);
		
		btnQuit = new JButton("quit");
		
		
		
		lblNewLabel = new JLabel("Select Account");
		
		lblDepositSumTo = new JLabel("Deposit sum to account");
		
		lblWithdrawSumFrom = new JLabel("Withdraw sum from account");
		
		lblCreateAccount = new JLabel("Create account");
		
		lblDeleteAccount = new JLabel("Delete account");
		
		lblViewAccountTransactions = new JLabel("View account transactions");
		
		lblSaveAndQuit = new JLabel("Save and Quit");
		
		JLabel lblTitle = new JLabel("Bank Machine Simulation v1.0 >");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setForeground(Color.BLUE);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDepositSumTo, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblWithdrawSumFrom, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCreateAccount, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDeleteAccount, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblViewAccountTransactions, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSaveAndQuit, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblTitle)))
					.addContainerGap(97, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblTitle)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSelect)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDeposit)
						.addComponent(lblDepositSumTo))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnWithdraw)
						.addComponent(lblWithdrawSumFrom))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate)
						.addComponent(lblCreateAccount))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnDelete)
						.addComponent(lblDeleteAccount))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnView)
						.addComponent(lblViewAccountTransactions))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnQuit)
						.addComponent(lblSaveAndQuit))
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
	
	public void addLoadListener(WindowListener loadWindowsListener)
	{
		this.addWindowListener(loadWindowsListener);
	}
	
	public void enableButtons()
	{
		btnSelect.setEnabled(true);
		btnDeposit.setEnabled(true);
		btnWithdraw.setEnabled(true);
		btnDelete.setEnabled(true);
		btnView.setEnabled(true);
	}
	
	public void disableButtons()
	{
		btnSelect.setEnabled(false);
		btnDeposit.setEnabled(false);
		btnWithdraw.setEnabled(false);
		btnDelete.setEnabled(false);
		btnView.setEnabled(false);
	}
}
