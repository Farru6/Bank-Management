package Package01;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;


public class SignUp extends JFrame implements ActionListener
{
	private JLabel heading, accountNo, name, fname, mobile, gender, maritalStatus, dob, email, address, city, state, pincode; 
	private JTextField accountText, nameText, fnameText, mobText, emailText, addressText, cityText, stateText, pincodeText;
	JDateChooser datechooser;
	Font f=new Font("Serif", Font.BOLD, 20);
	Font font=new Font("Raleway", Font.BOLD, 13);
	JButton back, next, clear;
	JRadioButton male, female, married, unmarried, other;
	JPanel panel;
	
	public SignUp()
	{
		setTitle("SignUp Page 1 of 3");
		setSize(900,730);
		setLayout(null);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon bgImage=new ImageIcon("Images/pagebg.jpg");
		Image img= bgImage.getImage();
		Image tempImg= img.getScaledInstance(900, 730, Image.SCALE_SMOOTH);
		bgImage= new ImageIcon(tempImg);
		JLabel bglabel=new JLabel("", bgImage, JLabel.CENTER);
		bglabel.setBounds(0, 0, 900, 730);
		add(bglabel);
		
		panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(25, 10, 840, 660);
		panel.setBackground(new Color(0, 0, 0, 150));
		bglabel.add(panel);	

		heading=new JLabel("APPLICATION FORM");
		heading.setFont(f);
		heading.setBounds(325, 0, 200, 40);
		heading.setForeground(Color.WHITE);
		panel.add(heading);
		
		accountNo=new JLabel("Enter Account Number");
		accountNo.setBounds(35, 65, 300, 30);
		accountNo.setFont(font);
		accountNo.setForeground(Color.WHITE);
		panel.add(accountNo);
		
		accountText=new JTextField(30);
		accountText.setBounds(400, 65, 300, 30);
		accountText.setFont(font);
		accountText.setForeground(Color.BLACK);
		panel.add(accountText);
		
		name=new JLabel("Account Holder Name");
		name.setBounds(35, 110, 200, 30);
		name.setFont(font);
		name.setForeground(Color.WHITE);
		panel.add(name);
		
		nameText=new JTextField(30);
		nameText.setBounds(400, 110, 300, 30);
		nameText.setFont(font);
		nameText.setForeground(Color.BLACK);
		panel.add(nameText);
		
		fname=new JLabel("Father's Name");
		fname.setBounds(35, 155, 200, 30);
		fname.setFont(font);
		fname.setForeground(Color.WHITE);
		panel.add(fname);
		
		fnameText=new JTextField(30);
		fnameText.setBounds(400, 155, 300, 30);
		fnameText.setFont(font);
		fnameText.setForeground(Color.BLACK);
		panel.add(fnameText);
		
		mobile=new JLabel("Mobile Number");
		mobile.setBounds(35, 200, 100, 30);
		mobile.setFont(font);
		mobile.setForeground(Color.WHITE);
		panel.add(mobile);
		
		mobText=new JTextField(30);
		mobText.setBounds(400, 200, 300, 30);
		mobText.setFont(font);
		mobText.setForeground(Color.BLACK);
		panel.add(mobText);
		
		//if(mobText.isPreferredSizeSet())
		
		gender=new JLabel("Gender");
		gender.setBounds(35, 245, 100, 30);
		gender.setFont(font);
		gender.setForeground(Color.WHITE);
		panel.add(gender);
		
		male=new JRadioButton("Male");
		male.setBounds(400, 245, 100, 30);
		panel.add(male);
		
		female=new JRadioButton("Female");
		female.setBounds(600, 245, 100, 30);
		panel.add(female);
		
		ButtonGroup groupgender=new ButtonGroup();
		groupgender.add(male);
		groupgender.add(female);
		
		maritalStatus=new JLabel("Marital Status");
		maritalStatus.setBounds(35, 290, 200, 30);
		maritalStatus.setFont(font);
		maritalStatus.setForeground(Color.WHITE);
		panel.add(maritalStatus);
		
		married=new JRadioButton("Married");
		married.setBounds(400, 290, 90, 30);
		panel.add(married);
		
		unmarried=new JRadioButton("Unmarried");
		unmarried.setBounds(505, 290, 90, 30);
		panel.add(unmarried);
		
		other=new JRadioButton("Other");
		other.setBounds(610, 290, 90, 30);
		panel.add(other);
		
		ButtonGroup groupstatus=new ButtonGroup();
		groupstatus.add(married);
		groupstatus.add(unmarried);
		groupstatus.add(other);
		
		dob=new JLabel("Date Of Birth");
		dob.setBounds(35, 335, 200, 30);
		dob.setFont(font);
		dob.setForeground(Color.WHITE);
		panel.add(dob);
		
		datechooser=new JDateChooser();
		datechooser.setBounds(400, 335, 300, 30);
		datechooser.setForeground(Color.WHITE);
		datechooser.setBackground(null);
		panel.add(datechooser);
		
		email=new JLabel("Email");
		email.setBounds(35, 380, 200, 30);
		email.setFont(font);
		email.setForeground(Color.WHITE);
		panel.add(email);
		
		emailText=new JTextField(30);
		emailText.setBounds(400, 380, 300, 30);
		emailText.setFont(font);
		emailText.setForeground(Color.BLACK);
		panel.add(emailText);
		
		address=new JLabel("Address");
		address.setBounds(35, 425, 200, 30);
		address.setFont(font);
		address.setForeground(Color.WHITE);
		panel.add(address);
		
		addressText=new JTextField(30);
		addressText.setBounds(400, 425, 300, 30);
		addressText.setFont(font);
		addressText.setForeground(Color.BLACK);
		panel.add(addressText);
		
		city=new JLabel("City");
		city.setBounds(35, 470, 200, 30);
		city.setFont(font);
		city.setForeground(Color.WHITE);
		panel.add(city);
		
		cityText=new JTextField(30);
		cityText.setBounds(400, 470, 300, 30);
		cityText.setFont(font);
		cityText.setForeground(Color.BLACK);
		panel.add(cityText);
		
		state=new JLabel("State");
		state.setBounds(35, 515, 200, 30);
		state.setFont(font);
		state.setForeground(Color.WHITE);
		panel.add(state);
		
		stateText=new JTextField(30);
		stateText.setBounds(400, 515, 300, 30);
		stateText.setFont(font);
		stateText.setForeground(Color.BLACK);
		panel.add(stateText);
		
		pincode=new JLabel("Pincode");
		pincode.setBounds(35, 560, 200, 30);
		pincode.setFont(font);
		pincode.setForeground(Color.WHITE);
		panel.add(pincode);
		
		pincodeText=new JTextField(30);
		pincodeText.setBounds(400, 560, 300, 30);
		pincodeText.setFont(font);
		pincodeText.setForeground(Color.BLACK);
		panel.add(pincodeText);
		
		next=new JButton("Next");
		next.setBounds(400, 610, 140, 40);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		panel.add(next);
		
		clear=new JButton("Clear");
		clear.setBounds(560, 610, 140, 40);
		clear.setBackground(Color.BLACK);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		panel.add(clear);
		
		back=new JButton("Back");
		back.setBounds(35, 610, 140, 40);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		panel.add(back);
		
		setVisible(true);
	    }
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==back) {
			new Login();
		}
		if(e.getSource()==clear)
		{
			accountText.setText("");
			nameText.setText("");
			fnameText.setText(""); 
			mobText.setText("");
			emailText.setText("");
			addressText.setText("");
			cityText.setText("");
			stateText.setText("");
			pincodeText.setText("");
		}
		else if(e.getSource()==next)
		{
			ConnectionClass conn=new ConnectionClass();
			String mobile1=""+mobText.getText();
			String query="select * from signup where mobile ='"+mobile1+"'";
			try {
				ResultSet rs =conn.statement.executeQuery(query);
				if(rs.next()) {
					setVisible(true);
					Thread.sleep(1000);
					JOptionPane.showMessageDialog(null, "User ID with this number is already registered");
					return;
			     }
			}catch(Exception e1) {
				System.out.println(e1);
			}
			String accountNo=accountText.getText();
			String name=nameText.getText();
			String fname=fnameText.getText();
			String mobile=""+mobText.getText();
			String gender=null;
			if(male.isSelected())
			{
				gender="Male";
			}else if(female.isSelected())
			{
				gender="Female";
			}
			String maritalStatus=null;
			if(married.isSelected())
			{
				maritalStatus="Married";
			}else if(unmarried.isSelected())
			{
				maritalStatus="Unmarried";
			}else if(other.isSelected())
			{
				maritalStatus="Other";
			}
			String dob=((JTextField)datechooser.getDateEditor().getUiComponent()).getText();
			String email=emailText.getText();
			String address=addressText.getText();
			String city=cityText.getText();
			String state=stateText.getText();
		    String pincode=pincodeText.getText();

		    try {
		    	if(mobile.equals("")){
		    		JOptionPane.showMessageDialog(null, "Mobile Number is required");return;
		    	}else if(accountNo.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please enter Account Number."+" "+"It is required");return;
		    	}else if(fname.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please enter Father Name.");return;
		    	}else if(dob.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please fill DOB.");return;
		    	}else if(email.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please enter Email.");return;
		    	}else if(address.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please enter Address.");return;
		    	}else if(city.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please enter City.");return;
		    	}else if(state.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please fill State field.");return;
		    	}else if(pincode.equals("")) {
		    		JOptionPane.showMessageDialog(null, "Please fill Pincode.");return;
		    	}else if(!male.isSelected() && !female.isSelected()) {
		    		JOptionPane.showMessageDialog(null, "Please select Gender.");return;
		    	}else if(!married.isSelected() && !unmarried.isSelected() && !other.isSelected()) {
			    		JOptionPane.showMessageDialog(null, "Please select Marital Status.");return;
		    	}
		    	else {
		    		ConnectionClass c=new ConnectionClass();
		    		String Q="insert into signup values('"+accountNo+"', '"+name+"', '"+fname+"', '"+mobile+"', '"+gender+"', '"+maritalStatus+"', '"+dob+"', '"+email+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
		    		c.statement.executeUpdate(Q);
		    	}
		    }catch(Exception e1) {
		    	System.out.println(e1);
		    }
		    setVisible(false);
			new SignUpNext(accountNo, name);
		}
	}
	
	public static void main(String[] args) {
		new SignUp();
	}
}
