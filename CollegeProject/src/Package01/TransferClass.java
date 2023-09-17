package Package01;
import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.swing.*;

public class TransferClass extends JFrame implements ActionListener
{
	private JLabel header, amnt, acnt, acnt2, captcha, footer;
	private JTextField amntText, acntText, acntText2, capText;
	JButton submit;
	Font f = new Font("Serif", Font.BOLD, 20);
	String userId;
	
	public TransferClass(String userId)
	{
		this.userId=userId;
		setTitle("Transfer Amount Section");
		setSize(900, 500);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		
		header=new JLabel("FnP E-banking Money Transfer Section");
		header.setBounds(190, 0, 700, 30);
		header.setFont(new Font("Serif", Font.BOLD, 25));
		header.setForeground(Color.black);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(15, 20, 850, 400);
		panel.setBackground(new Color(0, 0, 250, 50));
		add(panel);
		panel.add(header);

		JLabel userID = new JLabel();
		userID.setBounds(35, 50, 200, 30);
		userID.setFont(f);
		userID.setForeground(Color.black);
		panel.add(userID);
		
		acnt = new JLabel("Enter Your Account Number");
		acnt.setBounds(35, 120, 400, 30);
		acnt.setFont(f);
		acnt.setBackground(Color.black);
		panel.add(acnt);

		acntText = new JTextField(30);
		acntText.setBounds(35, 155, 300, 30);
		acntText.setBackground(Color.white);
		panel.add(acntText);

		amnt = new JLabel("Enter Amount");
		amnt.setBounds(35, 215, 300, 30);
		amnt.setFont(f);
		amnt.setBackground(Color.black);
		panel.add(amnt);

		amntText = new JTextField(30);
		amntText.setBounds(35, 250, 300, 30);
		amntText.setBackground(Color.white);
		panel.add(amntText);
		
		acnt2 = new JLabel("Enter Receiver Account Number");
		acnt2.setBounds(470, 120, 400, 30);
		acnt2.setFont(f);
		acnt2.setBackground(Color.black);
		panel.add(acnt2);

		acntText2 = new JTextField(30);
		acntText2.setBounds(470, 155, 300, 30);
		acntText2.setBackground(Color.white);
		panel.add(acntText2);
		
		JLabel captch=new JLabel("Captcha :");
		captch.setBounds(470, 215, 100, 30);
		captch.setFont(f);
		captch.setForeground(Color.black);
		panel.add(captch);
		
		captcha = new JLabel(""+UUID.randomUUID().toString().toLowerCase().toUpperCase().replace("-", "").subSequence(0, 8));
		captcha.setBounds(580, 215, 400, 30);
		captcha.setFont(f);
		captcha.setBackground(Color.black);
		panel.add(captcha);
		
		capText = new JTextField(30);
		capText.setBounds(470, 245, 300, 30);
		capText.setBackground(Color.white);
		panel.add(capText);

		submit = new JButton("SUBMIT");
		submit.setBounds(35, 340, 100, 40);
		submit.setBackground(Color.black);
		submit.setForeground(Color.WHITE);
		submit.addActionListener(this);
		panel.add(submit);
		
		footer=new JLabel("Privacy policy"+" "+"|"+" "+"Cookie policy"+" "+"|"+" "+"Terms & Conditions");
		footer.setBounds(250, 435, 500, 20);
		footer.setFont(new Font("", Font.BOLD, 15));
		footer.setForeground(Color.black);
	    add(footer);

		setVisible(true);
		try {
			ConnectionClass c = new ConnectionClass();
			String query = "select * from login where userId ='"+userId+"'";
			ResultSet rs = c.statement.executeQuery(query);
			while (rs.next()) {
				userID.setText("User ID :" + " " + rs.getString("userId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		ConnectionClass c = new ConnectionClass();
		int balance=0;
		try {
			String query = "select * from bank where userId ='"+userId+"'";
			ResultSet rs = c.statement.executeQuery(query);
			while (rs.next()) {
				if(rs.getString("type").equals("deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JLabel bal=new JLabel("Your current balance is :"+balance);
		bal.setBounds(35, 35, 400, 20);
		bal.setFont(new Font("", Font.ITALIC, 14));
		panel.add(bal);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String amnt=amntText.getText();
			String acnt=acntText.getText();
			String acnt2=acntText2.getText();
			Date date=new Date();
			
			try {
				ConnectionClass c=new ConnectionClass();
				String que="select * from login where userId ='"+userId+"'";
				ResultSet rs=c.statement.executeQuery(que);
				while(rs.next()) {
					if(!acnt.equals(rs.getString("accountNo"))) {
						JOptionPane.showMessageDialog(null, "Account Number doesn't match.");
						return;
					}
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
			
			ConnectionClass c = new ConnectionClass();
			int balance=0;
			try {
				String query = "select * from bank where userId ='"+userId+"'";
				ResultSet rs = c.statement.executeQuery(query);
				while (rs.next()) {
					if(rs.getString("type").equals("deposit")) {
						balance+=Integer.parseInt(rs.getString("amount"));
					}else {
						balance-=Integer.parseInt(rs.getString("amount"));
					}if(balance<Integer.parseInt(amnt)) {
						JOptionPane.showMessageDialog(null, "Insufficient balance.");
						return;
				}
			  } 
			}catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			try {
				ConnClass con=new ConnClass();
				String query="insert into balance values('"+userId+"', '"+acnt+"', '"+acnt2+"', '"+amnt+"', '"+date+"')";
				con.statement.executeUpdate(query);
				
				Thread.sleep(5000);
				JOptionPane.showMessageDialog(null, "Rs"+" "+ amnt + " " + "Transferred successfully!");
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		setVisible(false);
	}
}
