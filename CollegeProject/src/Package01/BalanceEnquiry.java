package Package01;
import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.sql.ResultSet;

import javax.swing.*;

public class BalanceEnquiry extends JFrame
{
	String userId;
	public BalanceEnquiry(String userId)
	{
        this.userId=userId;
		
		setTitle("Balance Enquiry");
		setSize(500,600);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 20, 460, 500);
		panel.setBackground(new Color(0, 0, 250, 50));
		add(panel);
		
		ImageIcon imglogo=new ImageIcon("Images/pp.jpg");
		Image img1= imglogo.getImage();
		Image tempImg1= img1.getScaledInstance(150, 150, Image.SCALE_DEFAULT);
		imglogo= new ImageIcon(tempImg1);
		JLabel p= new JLabel(imglogo);
		p.setBounds(150, 30, 150, 150);
		panel.add(p);
		
		JLabel name1=new JLabel();
		JLabel user=new JLabel();
		
		
		ConnectionClass c=new ConnectionClass();
		int balance=0;
		try {
			String query="select * from bank where userId= '"+userId+"'";
			ResultSet rs=c.statement.executeQuery(query);
			while(rs.next()) {
				if(rs.getString("type").equals("deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		JLabel b=new JLabel("Your current balance is :"+balance);
		b.setBounds(25, 350, 400, 30);
		b.setFont(new Font("Serif", Font.BOLD, 20));
		panel.add(b);
		
		try {
			ConnectionClass c1=new ConnectionClass();
			String query1="select * from login where userId= '"+userId+"'";
			ResultSet rs=c1.statement.executeQuery(query1);
			while(rs.next()) {
				name1.setText("Name :"+rs.getString("name"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		name1.setBounds(130, 200, 300, 30);
		name1.setFont(new Font("Raleway", Font.BOLD, 20));
		name1.setForeground(Color.BLACK);
		panel.add(name1);
		
		try {
			ConnectionClass c2=new ConnectionClass();
			String query1="select * from login where userId= '"+userId+"'";
			ResultSet rs=c2.statement.executeQuery(query1);
			while(rs.next()) {
				user.setText("User ID :"+rs.getString("userId"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		user.setBounds(130, 240, 300, 30);
		user.setFont(new Font("Raleway", Font.PLAIN, 20));
		user.setForeground(Color.black);
		panel.add(user);
	
		setVisible(true);
	}

	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
}
