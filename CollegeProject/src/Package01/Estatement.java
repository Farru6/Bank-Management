package Package01;

import java.awt.*;

import java.sql.ResultSet;

import javax.swing.*;

public class Estatement extends JFrame
{
	JLabel accno, mini, b;
	String userId;
	public Estatement(String userId)
	{
        this.userId=userId;
		
		setTitle("E-Statement");
		setSize(500,600);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.white);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 20, 460, 100);
		panel.setBackground(new Color(0, 0, 250, 50));
		add(panel);
		
		JPanel panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(10, 140, 460, 300);
		panel1.setBackground(new Color(0, 0, 250, 50));
		add(panel1);
		
		JPanel panel2=new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(10, 460, 460, 50);
		panel2.setBackground(new Color(0, 0, 250, 50));
		add(panel2);
		
		accno=new JLabel();
		accno.setFont(new Font("Serif", Font.BOLD, 15));
		
		mini=new JLabel();
		
		
		ConnectionClass c=new ConnectionClass();
		int balance=0;
		try {
			String query1="select * from bank where userId= '"+userId+"'";
			ResultSet rs=c.statement.executeQuery(query1);
			
			while(rs.next()) {
				accno.setText("Account Number :"+"XXXXXX"+rs.getString("accountNo").substring(6));
				
				mini.setText(mini.getText()+ "<html>" + rs.getString("date")+ " "+" " +rs.getString("type")+ " "+" " +rs.getString("amount")+ "<br><br> <html>");
				
				if(rs.getString("type").equals("deposit")) {
					balance+=Integer.parseInt(rs.getString("amount"));
				}else {
					balance-=Integer.parseInt(rs.getString("amount"));
				}
			}
		    b=new JLabel("Your current balance is :"+balance);
			b.setBounds(20, 465, 300, 30);
			b.setForeground(Color.black);
			b.setFont(new Font("Serif", Font.BOLD, 20));
			add(b);
		}catch(Exception e) {
			e.printStackTrace();
		}
		accno.setBounds(15, 50, 300, 30);
		accno.setForeground(Color.black);
		panel.add(accno);
		mini.setBounds(15, 150, 1000, 200);
		mini.setFont(new Font("Serif", Font.BOLD, 15));
		mini.setForeground(Color.black);
		add(mini);
		
		
		setVisible(true);
	}
}
