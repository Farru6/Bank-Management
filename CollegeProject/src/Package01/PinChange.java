package Package01;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class PinChange extends JFrame implements ActionListener
{
	JLabel user, opin, spin, cpin, footer;
	JTextField userText;
	JPasswordField opint, spint, cpint;
	String pin;
	JButton enter;
	Font f=new Font("Serif", Font.BOLD, 20);
	Font fon=new Font("", Font.BOLD, 15);
	
	public PinChange(String pin) 
	{
		this.pin=pin;
		setTitle("Pinchange Section");
		setSize(500,650);
		setLayout(null);
		setLocationRelativeTo(null);
		getContentPane().setBackground(Color.WHITE);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(15, 20, 450, 520);
		panel.setBackground(new Color(0, 0, 250, 50));
		add(panel);
		
		user=new JLabel("Enter User ID ");
		user.setBounds(35, 50, 200, 30);
		user.setFont(f);
		user.setForeground(Color.black);
		panel.add(user);
		
		userText=new JTextField(30);
		userText.setBounds(35, 85, 200, 30);
		userText.setForeground(Color.BLACK);
		panel.add(userText);
		
		opin=new JLabel("Enter Old Pin ");
		opin.setBounds(35, 135, 200, 30);
		opin.setFont(f);
		opin.setForeground(Color.black);
		panel.add(opin);
		
		opint=new JPasswordField(30);
		opint.setBounds(35, 170, 200, 30);
		opint.setForeground(Color.BLACK);
		panel.add(opint);

		
		spin=new JLabel("Enter Pin ");
		spin.setBounds(35, 250, 200, 30);
		spin.setFont(f);
		spin.setForeground(Color.black);
		panel.add(spin);
		
		spint=new JPasswordField(30);
		spint.setBounds(35, 285, 200, 30);
		spint.setForeground(Color.BLACK);
		panel.add(spint);
		
		cpin=new JLabel("Confirm Pin ");
		cpin.setBounds(35, 335, 200, 30);
		cpin.setFont(f);
		cpin.setForeground(Color.black);
		panel.add(cpin);
		
		cpint=new JPasswordField(30);
		cpint.setBounds(35, 370, 200, 30);
		cpint.setForeground(Color.BLACK);
		panel.add(cpint);
		
		enter=new JButton("ENTER");
		enter.setBounds(35, 460, 100, 40);
		enter.setBackground(Color.BLACK);
		enter.setForeground(Color.WHITE);
		enter.addActionListener(this);
		panel.add(enter);
		
		footer=new JLabel("Privacy policy"+" "+"|"+" "+"Cookie policy"+" "+"|"+" "+"Terms & Conditions");
		footer.setBounds(55, 580, 1000, 20);
		footer.setFont(fon);
		footer.setForeground(Color.black);
	    add(footer);

		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==enter) {
				String user=userText.getText();
				String opin=opint.getText();
				String spin=spint.getText();
				String cpin=cpint.getText();
				
				if(spin.equals(" ")) {
					JOptionPane.showMessageDialog(null, "New Pin field is Empty");return;
				}else if(cpin.equals(" ")) {
					JOptionPane.showMessageDialog(null, "Confirm Pin field is Empty");return;
				}else if(!spin.equals(cpin)) {
					JOptionPane.showMessageDialog(null, "Entered New Pin does not match");return;
				}else if(user.equals(" ")) {
					JOptionPane.showMessageDialog(null, "User ID is Empty");return;
				}
				
				try {
				ConnectionClass c=new ConnectionClass();
				String q="select * from login where pin='"+opin+"'";
				ResultSet rs=c.statement.executeQuery(q);
				if(rs.next()) {
					setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Entered Old Pin doesn't match!");return;
				}
				}catch(Exception e1){
					e1.printStackTrace();
				}
				
				try {
				ConnectionClass conn=new ConnectionClass();
				String q1="update login set pin ='"+spin+"' where userId ='"+user+"'";
				String q2="update signupend set pin ='"+spin+"' where userId ='"+user+"'";
				
				conn.statement.execute(q1);
				conn.statement.execute(q2);
				Thread.sleep(1000);
				JOptionPane.showMessageDialog(null, "Pin Changed Successfully!!");
				new Login().setVisible(true);;
			}catch (Exception e1){
				System.out.println(e1);
			}
		}	
	}
	public static void main(String[] args) {
		new PinChange("");
	}
}
