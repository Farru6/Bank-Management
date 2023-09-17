package Package01;
import java.awt.*;
import javax.swing.*;

public class WelcomeClass extends JFrame
{
	JLabel wel, log, sign, footer;
	JButton login, signup;
	Font font=new Font("Raleway", Font.BOLD, 20);
	Font f=new Font("Serif", Font.BOLD, 25);
	Font fon=new Font("", Font.BOLD, 15);

	WelcomeClass()
	{
		setTitle("Welcome Page");
		setSize(900,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon bgImage=new ImageIcon("Images/bg1.jpg");
		Image img= bgImage.getImage();
		Image tempImg= img.getScaledInstance(900, 700, Image.SCALE_DEFAULT);
		bgImage= new ImageIcon(tempImg);
		JLabel bglabel=new JLabel("", bgImage, JLabel.CENTER);
		bglabel.setBounds(0, 0, 900, 700);
		add(bglabel);
		
		ImageIcon imglogo=new ImageIcon("Images/logo.jpg");
		Image img1= imglogo.getImage();
		Image tempImg1= img1.getScaledInstance(100, 60, Image.SCALE_DEFAULT);
		imglogo= new ImageIcon(tempImg1);
		JLabel bglabel1= new JLabel(imglogo);
		bglabel1.setBounds(10, 0, 80, 80);
		
		JMenuBar jmenuBar=new JMenuBar();
		jmenuBar.setBounds(0, 0, 880, 70);
		jmenuBar.setBorderPainted(false);
		JMenu page=new JMenu("Home");
		JMenu acc=new JMenu("Accounts");
		page.setForeground(Color.WHITE);
		page.setFont(font);
		acc.setForeground(Color.WHITE);
		acc.setFont(font);
		
		JMenuItem item1=new JMenuItem("LOGIN");
		JMenuItem item2=new JMenuItem("SIGNUP"); 
		item1.setFont(font);
		item1.setForeground(Color.WHITE);
		item1.setBackground(Color.BLACK);
		item2.setFont(font);
		item2.setForeground(Color.WHITE);
		item2.setBackground(Color.BLACK);
		
		acc.add(item1);
		acc.add(item2);
		jmenuBar.setBackground(new Color(0, 0, 0, 100));
		bglabel.add(jmenuBar);
		jmenuBar.add(bglabel1);
		jmenuBar.add(page);
		jmenuBar.add(Box.createHorizontalGlue());
		jmenuBar.add(acc);
		
		wel = new JLabel("WELCOME To OUR FnP eBANKING");
		wel.setBounds(200, 100, 600, 30);
		wel.setFont(f);
		wel.setForeground(Color.white);
		bglabel.add(wel);
		
		log = new JLabel("Click the LOGIN button if you are already registered.");
		log.setBounds(40, 250, 600, 30);
		log.setFont(font);
		log.setForeground(Color.white);
		bglabel.add(log);
		
		login=new JButton("LOGIN");
		login.setBounds(40, 290, 100, 40);
		login.setFont(fon);
		login.setBackground(Color.black);
		login.setForeground(Color.white);
		bglabel.add(login);
		
		sign = new JLabel("Click the SIGNUP button if you want to register.");
		sign.setBounds(40, 370, 600, 30);
		sign.setFont(font);
		sign.setForeground(Color.white);
		bglabel.add(sign);
		
		signup=new JButton("SIGNUP");
		signup.setBounds(40, 410, 100, 40);
		signup.setFont(fon);
		signup.setBackground(Color.black);
		signup.setForeground(Color.white);
		bglabel.add(signup);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 600, 900, 60);
		panel.setBackground(new Color(0, 0, 0, 200));
		
		footer=new JLabel("Privacy policy"+" "+"|"+" "+"Cookie policy"+" "+"|"+" "+"Terms & Conditions");
		footer.setBounds(250, 600, 1000, 30);
		footer.setFont(fon);
		footer.setForeground(Color.white);
		bglabel.add(footer);
		bglabel.add(panel);
		
		login.addActionListener(e ->{
			new Login().setVisible(true);
		});
		
		signup.addActionListener(e ->{
			new SignUp().setVisible(true);
		});
		
		
		setLayout(null);
		setVisible(true);
	}
	
	public static void main(String[] args) 
	{
		new WelcomeClass();
	}
}
