package Package01;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.*;
import com.mysql.cj.protocol.Resultset;

public class Login extends JFrame implements ActionListener
{
	private JLabel wel, login, userId, pin, arg, footer;
	private JTextField userText;
	private JPasswordField passText;
	Font font1=new Font("Serif", Font.BOLD, 25);
	Font font2=new Font("Raleway", Font.BOLD, 20);
	Font font3=new Font("Serif", Font.BOLD, 15);
	JButton signIn, signup;
	public Login()
	{
		setTitle("Login Portal");
		setSize(1000,750);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon bgImage=new ImageIcon("Images/bg2.jpg");
		Image img= bgImage.getImage();
		Image tempImg= img.getScaledInstance(1000, 750, Image.SCALE_SMOOTH);
		bgImage= new ImageIcon(tempImg);
		JLabel bglabel=new JLabel("", bgImage, JLabel.CENTER);
		bglabel.setBounds(0, 0, 1000, 750);
		add(bglabel);
		
		ImageIcon imglogo=new ImageIcon("Images/logo.jpg");
		Image img1= imglogo.getImage();
		Image tempImg1= img1.getScaledInstance(100, 60, Image.SCALE_DEFAULT);
		imglogo= new ImageIcon(tempImg1);
		JLabel bglabel1= new JLabel(imglogo);
		bglabel1.setBounds(10, 0, 80, 80);
		
		JMenuBar jmenuBar=new JMenuBar();
		jmenuBar.setBounds(0, 0, 980, 70);
		jmenuBar.setBorderPainted(false);
		JMenu page=new JMenu("Home");
		page.setForeground(Color.WHITE);
		page.setFont(font2);
		
		jmenuBar.setBackground(new Color(0, 0, 0, 100));
		bglabel.add(jmenuBar);
		jmenuBar.add(bglabel1);
		jmenuBar.add(page);
		
		wel = new JLabel("WELCOME to our FnP E-banking");
		wel.setBounds(300, 100, 600, 30);
		wel.setFont(font1);
		wel.setForeground(Color.white);
		bglabel.add(wel);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(15, 200, 350, 450);
		panel.setBackground(new Color(0, 0, 0, 130));
		bglabel.add(panel);
		
		login=new JLabel("LOGIN");
		login.setBounds(85,  10,  200, 30);
		login.setFont(font1);
		login.setForeground(Color.WHITE);
		panel.add(login);
		
		userId=new JLabel("User ID");
		userId.setBounds(25, 100, 100, 20);
		userId.setForeground(Color.WHITE);
		panel.add(userId);
		
		userText=new JTextField(20);
		userText.setFont(font3);
		userText.setBounds(25, 130, 200, 50);
		userText.setForeground(Color.BLACK);
		userText.setBackground(Color.WHITE);
		panel.add(userText);
		
		pin=new JLabel("Password");
		pin.setBounds(25, 210, 100, 20);
		pin.setFont(font2);
		pin.setForeground(Color.WHITE);
		panel.add(pin);
		
		passText=new JPasswordField(20);
		passText.setFont(font3);
		passText.setBounds(25, 240, 200, 50);
		passText.setBackground(Color.WHITE);
		passText.setForeground(Color.BLACK);
		panel.add(passText);

		signIn=new JButton("Login");
		signIn.setBounds(25, 315, 100, 30);
		signIn.setBackground(Color.BLACK);
		signIn.setForeground(Color.WHITE);
		panel.add(signIn);
		signIn.addActionListener(this);
		
		arg=new JLabel("If not register then signup.");
		arg.setBounds(25, 390, 300, 20);
		arg.setFont(font3);
		arg.setForeground(Color.WHITE);
		panel.add(arg);
		
		footer=new JLabel("Privacy policy"+" "+"|"+" "+"Cookie policy"+" "+"|"+" "+"Terms & Conditions");
		footer.setBounds(340, 685, 1000, 20);
		footer.setFont(font3);
		footer.setForeground(Color.black);
	    bglabel.add(footer);
	    
		signup=new JButton("SignUp");
		signup.setBounds(25, 350, 100, 30);
		signup.setBackground(Color.BLACK);
		signup.setForeground(Color.WHITE);
		panel.add(signup);
		signup.addActionListener(this);
		
		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==signup)
		{
			setVisible(false);
			new SignUp();
		}	
		if(e.getSource()==signIn)
		{
			ConnectionClass conn=new ConnectionClass();
			String userId=userText.getText();
			String pin=passText.getText();
			String query="select * from login where userId ='"+userId+"' and pin ='"+pin+"'";
			try {
				ResultSet rs =conn.statement.executeQuery(query);
				if(rs.next()) {
					setVisible(true);
					new Dashboard(userId, pin).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect User ID or Password");
					return;
				}
			}catch(Exception e1) {
				System.out.println(e1);
			}
		}
	}
	public static void main(String[] args) {
		new Login();
	}
}
