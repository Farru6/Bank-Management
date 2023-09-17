package Package01;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener
{
	JButton deposit, withdraw, ministatement, pinchange, balanceenq, transfer;
	Font font=new Font("Serif", Font.BOLD, 20);
	Font f=new Font("Raleway", Font.BOLD, 15);
    String pin, userId;

	public Dashboard(String userId, String pin)
	{
		this.userId=userId;
		this.pin=pin;
		
		setTitle("Dashboard");
		setSize(900,710);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon bgImage=new ImageIcon("Images/bg1.jpg");
		Image img= bgImage.getImage();
		Image tempImg= img.getScaledInstance(900, 710, Image.SCALE_DEFAULT);
		bgImage= new ImageIcon(tempImg);
		JLabel bglabel=new JLabel("", bgImage, JLabel.CENTER);
		bglabel.setBounds(0, 0, 900, 710);
		add(bglabel);
		
		ImageIcon imglogo=new ImageIcon("Images/logo.jpg");
		Image img1= imglogo.getImage();
		Image tempImg1= img1.getScaledInstance(90, 60, Image.SCALE_DEFAULT);
		imglogo= new ImageIcon(tempImg1);
		JLabel bglabel1= new JLabel(imglogo);
		bglabel1.setBounds(10, 0, 80, 80);
		
		JMenuBar jmenuBar=new JMenuBar();
		jmenuBar.setBounds(0, 0, 880, 70);
		jmenuBar.setBorderPainted(false);
		
		JMenu accounts=new JMenu("Dashboard");
		accounts.setForeground(Color.WHITE);
		accounts.setFont(font);
		
		JMenu logout=new JMenu("LogOut");
		logout.setForeground(Color.black);
		logout.setFont(font);
		
		accounts.add(logout);
		
		jmenuBar.setBackground(new Color(0, 0, 0, 100));
		bglabel.add(jmenuBar);
		jmenuBar.add(accounts);
		jmenuBar.add(Box.createHorizontalGlue());
		jmenuBar.add(bglabel1);
		
		JLabel name1=new JLabel();
		
		ImageIcon depologo=new ImageIcon("Images/deposit1.jpg");
		Image depo= depologo.getImage();
		Image tempdepo= depo.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
		depologo= new ImageIcon(tempdepo);
		JLabel bglabel2= new JLabel(depologo);
		bglabel2.setBounds(10, 120, 200, 200);
		bglabel.add(bglabel2);
		
		deposit=new JButton("Deposit Amount");
		deposit.setBounds(35, 260, 150, 30);
		deposit.setBorderPainted(false);
		deposit.setBackground(Color.white);
		deposit.setForeground(Color.black);
		deposit.addActionListener(this);
		bglabel.add(deposit);
		
		ImageIcon wdrlogo=new ImageIcon("Images/withdraw.jpg");
		Image wdr= wdrlogo.getImage();
		Image tempwdr= wdr.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
		wdrlogo= new ImageIcon(tempwdr);
		JLabel bglabel3= new JLabel(wdrlogo);
		bglabel3.setBounds(220, 120, 200, 200);
		bglabel.add(bglabel3);
		
		withdraw=new JButton("Withdraw Amount");
		withdraw.setBounds(245, 260, 150, 30);
		withdraw.setBorderPainted(false);
		withdraw.setBackground(Color.white);
		withdraw.setForeground(Color.black);
		withdraw.addActionListener(this);
		bglabel.add(withdraw);
		
		ImageIcon minilogo=new ImageIcon("Images/ministatement.jpg");
		Image mini= minilogo.getImage();
		Image tempmini= mini.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
		minilogo= new ImageIcon(tempmini);
		JLabel bglabel4= new JLabel(minilogo);
		bglabel4.setBounds(10, 300, 200, 200);
		bglabel.add(bglabel4);
		
		ministatement=new JButton("Mini Statement");
		ministatement.setBounds(35, 440, 150, 30);
		ministatement.setBorderPainted(false);
		ministatement.setBackground(Color.white);
		ministatement.setForeground(Color.black);
		ministatement.addActionListener(this);
		bglabel.add(ministatement);
		
		ImageIcon pinlogo=new ImageIcon("Images/pinchange.jpg");
		Image pinn= pinlogo.getImage();
		Image temppin= pinn.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
		pinlogo= new ImageIcon(temppin);
		JLabel bglabel5= new JLabel(pinlogo);
		bglabel5.setBounds(220, 300, 200, 200);
		bglabel.add(bglabel5);
		
		pinchange=new JButton("Pin Change");
		pinchange.setBounds(245, 440, 150, 30);
		pinchange.setBorderPainted(false);
		pinchange.setBackground(Color.white);
		pinchange.setForeground(Color.black);
		pinchange.addActionListener(this);
		bglabel.add(pinchange);
		
		ImageIcon balncelogo=new ImageIcon("Images/enquiry.jpg");
		Image balnce= balncelogo.getImage();
		Image tempbalnce= balnce.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
		balncelogo= new ImageIcon(tempbalnce);
		JLabel bglabel6= new JLabel(balncelogo);
		bglabel6.setBounds(10, 470, 200, 200);
		bglabel.add(bglabel6);
		
		balanceenq=new JButton("Balance Enquiry");
		balanceenq.setBounds(35, 610, 150, 30);
		balanceenq.setBorderPainted(false);
		balanceenq.setBackground(Color.white);
		balanceenq.setForeground(Color.black);
		balanceenq.addActionListener(this);
		bglabel.add(balanceenq);
		
		ImageIcon exitlogo=new ImageIcon("Images/exit.jpg");
		Image ex= exitlogo.getImage();
		Image tempex= ex.getScaledInstance(150, 100, Image.SCALE_DEFAULT);
		exitlogo= new ImageIcon(tempex);
		JLabel bglabel7= new JLabel(exitlogo);
		bglabel7.setBounds(220, 470, 200, 200);
		bglabel.add(bglabel7);
		
		transfer=new JButton("Transfer Amount");
		transfer.setBounds(245, 610, 150, 30);
		transfer.setBorderPainted(false);
		transfer.setBackground(Color.white);
		transfer.setForeground(Color.black);
		transfer.addActionListener(this);
		bglabel.add(transfer);
		
		logout.addActionListener(e ->{
			System.exit(0);
		});
		
		try {
			ConnectionClass c = new ConnectionClass();
			String query = "select * from login where userId ='"+userId+"'";
			ResultSet rs = c.statement.executeQuery(query);
			while (rs.next()) {
				name1.setText("Hi" + " " + rs.getString("name") +"," +" "+ "Welcome to FnP E-banking.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		name1.setBounds(180, 80, 600, 30);
		name1.setFont(new Font("", Font.BOLD, 20));
		name1.setForeground(Color.white);
		bglabel.add(name1);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==deposit) {
			new DepositAmnt(userId, pin);
		}else if(e.getSource()==withdraw) {
			new WithdrawAmnt(userId, pin);
		}else if(e.getSource()==ministatement) {
			new Estatement(userId);
		}else if(e.getSource()==pinchange) {
			new PinChange(pin).setVisible(true);
		}else if(e.getSource()==balanceenq) {
			new BalanceEnquiry(userId);
		}else if(e.getSource()==transfer) {
			new TransferClass(userId);
		}
	}
	public static void main(String[] args) {
		new Dashboard("", "");
	}
}
