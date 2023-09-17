package Package01;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;

public class WithdrawAmnt extends JFrame implements ActionListener
{
	private JLabel amount, account, footer;
	private JTextField amnt, accnt;
	JButton submit;
	Font f = new Font("Serif", Font.BOLD, 20);
	String userId, pin;
	
	public WithdrawAmnt(String userId, String pin)
	{
		this.userId=userId;
		this.pin=pin;
		
		setTitle("Withdarawl Section");
		setSize(500, 600);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(15, 20, 450, 400);
		panel.setBackground(new Color(0, 0, 250, 50));
		add(panel);

		JLabel userID = new JLabel();
		userID.setBounds(35, 50, 200, 30);
		userID.setFont(f);
		userID.setForeground(Color.black);
		panel.add(userID);

		amount = new JLabel("Enter Amount");
		amount.setBounds(35, 120, 200, 30);
		amount.setFont(f);
		amount.setBackground(Color.black);
		panel.add(amount);

		amnt = new JTextField(30);
		amnt.setBounds(35, 155, 200, 30);
		amnt.setBackground(Color.white);
		panel.add(amnt);

		account = new JLabel("Enter Account Number");
		account.setBounds(35, 215, 200, 30);
		account.setFont(f);
		account.setBackground(Color.black);
		panel.add(account);

		accnt = new JTextField(30);
		accnt.setBounds(35, 250, 200, 30);
		accnt.setBackground(Color.white);
		panel.add(accnt);

		submit = new JButton("SUBMIT");
		submit.setBounds(35, 340, 100, 40);
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		panel.add(submit);
		
		footer=new JLabel("Privacy policy"+" "+"|"+" "+"Cookie policy"+" "+"|"+" "+"Terms & Conditions");
		footer.setBounds(55, 535, 500, 20);
		footer.setFont(new Font("", Font.BOLD, 15));
		footer.setForeground(Color.black);
	    add(footer);

		setVisible(true);
		
		try {
			ConnectionClass c=new ConnectionClass();
			String query="select * from login where userId='"+userId+"'";
			ResultSet rs=c.statement.executeQuery(query);
			while(rs.next()) {
				userID.setText("User ID :"+ " "+ rs.getString("userId"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==submit) {
			String account=accnt.getText();
			String amount=amnt.getText();
			Date date=new Date();
			
			ConnectionClass con=new ConnectionClass();
			String q="select * from bank where userId ='"+userId+"'";
			int balance=0;
			try {
				ResultSet rs=con.statement.executeQuery(q);
				while(rs.next()) {
					if(rs.getString("type").equals("deposit")) {
						balance+=Integer.parseInt(rs.getString("amount"));
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}if(balance<Integer.parseInt(amount)) {
						JOptionPane.showMessageDialog(null, "Insufficient balance.");
						return;
					}
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			try {
				ConnectionClass c=new ConnectionClass();
				String query1="select * from login where accountNo='"+account+"'";
				ResultSet rs=c.statement.executeQuery(query1);
				if(rs.next()) {
					Thread.sleep(5000);
					JOptionPane.showMessageDialog(null, "Rs" + " " + amount + " " + "debited successfully!");
				}else {
					JOptionPane.showMessageDialog(null, "Account Number is not valid.");
				}
				
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			try {
				ConnectionClass conn=new ConnectionClass();
				String query2 = "insert into bank values('"+userId+"', '"+account+"', 'withdraw', '"+date+"', '"+amount+"')";
				conn.statement.executeUpdate(query2);
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
		}
		setVisible(false);
	}

}
