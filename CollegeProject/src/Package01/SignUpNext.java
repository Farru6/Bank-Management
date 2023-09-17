package Package01;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SignUpNext extends JFrame implements ActionListener
{
	private JLabel citizenship, religion, category, occupation, pan, aadhar, seniorc, accountType;
	private JTextField panText, aadharText;
	private JComboBox<String>jreligion; 
	private JComboBox<String>jcategory; 
	private JComboBox<String>joccupation;
	private JRadioButton indian, nri, ayes, ano, sav, cur;
	JButton back, next;
	Font font=new Font("Raleway", Font.BOLD, 13);
	String accountNo, name;
	
	public SignUpNext(String accountNo, String name)
	{
		this.accountNo=accountNo;
		this.name=name;
		
		setTitle("SignUp Page 2 of 2");
		setSize(900,730);
		setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon bgImage=new ImageIcon("Images/pagebg.jpg");
		Image img= bgImage.getImage();
		Image tempImg= img.getScaledInstance(900, 730, Image.SCALE_SMOOTH);
		bgImage= new ImageIcon(tempImg);
		JLabel bglabel=new JLabel("", bgImage, JLabel.CENTER);
		bglabel.setBounds(0, 0, 900, 730);
		add(bglabel);
		
		JPanel panel=new JPanel();
		panel.setLayout(null);
		panel.setBounds(25, 10, 840, 660);
		panel.setBackground(new Color(0, 0, 0, 150));
		bglabel.add(panel);
		
		citizenship=new JLabel("Citizenship");
		citizenship.setBounds(35, 65, 200, 30);
		citizenship.setFont(font);
		citizenship.setForeground(Color.WHITE);
		panel.add(citizenship);
		
		indian=new JRadioButton("Indian");
		indian.setBounds(400, 65, 100, 30);
		panel.add(indian);
		
		nri=new JRadioButton("NRI");
		nri.setBounds(600, 65, 100, 30);
		panel.add(nri);
		
		ButtonGroup groupciti=new ButtonGroup();
		groupciti.add(indian);
		groupciti.add(nri);
		
		religion=new JLabel("Religion");
		religion.setBounds(35, 115, 200, 30);
		religion.setFont(font);
		religion.setForeground(Color.WHITE);
		panel.add(religion);
		
		String list[]= {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
		jreligion=new JComboBox<>(list);
		jreligion.setBounds(400, 115, 300, 30);
		jreligion.setBackground(Color.WHITE);
		panel.add(jreligion);

		
		category=new JLabel("Category");
		category.setBounds(35, 165, 200, 30);
		category.setFont(font);
		category.setForeground(Color.WHITE);
		panel.add(category);
		
		String catlist[]= {"General", "OBC", "SC", "ST", "Other"};
		jcategory=new JComboBox<>(catlist);
		jcategory.setBounds(400, 165, 300, 30);
		jcategory.setBackground(Color.WHITE);
		panel.add(jcategory);
		
		occupation=new JLabel("Occupation");
		occupation.setBounds(35, 215, 200, 30);
		occupation.setFont(font);
		occupation.setForeground(Color.WHITE);
		panel.add(occupation);
		
		String occlist[]= {"Employed", "Unemployed", "Salaried", "Student", "Businessman", "Other"};
		joccupation=new JComboBox<>(occlist);
		joccupation.setBounds(400, 215, 300, 30);
		joccupation.setBackground(Color.WHITE);
		panel.add(joccupation);
		
		seniorc=new JLabel("Senior Citizen?");
		seniorc.setBounds(35, 265, 200, 30);
		seniorc.setFont(font);
		seniorc.setForeground(Color.WHITE);
		panel.add(seniorc);
		
		ayes=new JRadioButton("Yes");
		ayes.setBounds(400, 265, 100, 30);
		panel.add(ayes);
		
		ano=new JRadioButton("No");
		ano.setBounds(600, 265, 100, 30);
		panel.add(ano);
		
		ButtonGroup groupacc=new ButtonGroup();
		groupacc.add(ayes);
		groupacc.add(ano);
		
		accountType=new JLabel("Account Type");
		accountType.setBounds(35, 315, 200, 30);
		accountType.setFont(font);
		accountType.setForeground(Color.WHITE);
		panel.add(accountType);
		
		sav=new JRadioButton("Saving");
		sav.setBounds(400, 315, 100, 30);
		panel.add(sav);
		
		cur=new JRadioButton("Current");
		cur.setBounds(600, 315, 100, 30);
		panel.add(cur);
		
		ButtonGroup grouptype=new ButtonGroup();
		grouptype.add(sav);
		grouptype.add(cur);
		
		pan=new JLabel("Pan Number");
		pan.setBounds(35, 365, 200, 30);
		pan.setFont(font);
		pan.setForeground(Color.WHITE);
		panel.add(pan);
		
		panText=new JTextField(30);
		panText.setBounds(400, 365, 300, 30);
		panText.setFont(font);
		panText.setForeground(Color.BLACK);
		panel.add(panText);
		
		aadhar=new JLabel("Aadhar Number");
		aadhar.setBounds(35, 415, 200, 30);
		aadhar.setFont(font);
		aadhar.setForeground(Color.WHITE);
		panel.add(aadhar);
		
		aadharText=new JTextField(30);
		aadharText.setBounds(400, 415, 300, 30);
		aadharText.setFont(font);
		aadharText.setForeground(Color.BLACK);
		panel.add(aadharText);
		
		next=new JButton("Next");
		next.setBounds(600, 465, 100, 40);
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.addActionListener(this);
		panel.add(next);

		setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==next) 
		{
		    String citizenship=null;
		    if(indian.isSelected()) {
			citizenship="Indian";
		    }else if(nri.isSelected()){
			citizenship="NRI";
		    }
		    String religion=""+ jreligion.getSelectedItem();
		    String category=""+ jcategory.getSelectedItem();
		    String occupation=""+ joccupation.getSelectedItem();
		    String seniorc=null;
		    if(ayes.isSelected())
		    {
		    	seniorc="Yes";
	    	}else if(ano.isSelected())
	    	{
		    	seniorc="No";
		    }
		    String accountType=null;
		    if(sav.isSelected())
	    	{
	    		accountType="Saving";
	    	}else if(cur.isSelected())
	    	{
	    		accountType="Current";
	    	}
	    	String pan=panText.getText();
	    	String aadhar=aadharText.getText();
		
	    try {
	    	if(pan.equals("")) {
	    		JOptionPane.showMessageDialog(null, "PAN Number is required.");return;
	    	}else if(aadhar.equals("")) {
	    		JOptionPane.showMessageDialog(null, "Aadhar Number is required.");return;
	    	}else if(!indian.isSelected() && !nri.isSelected()) {
	    		JOptionPane.showMessageDialog(null, "Please select Citizenship.");return;
	    	}else if(!ayes.isSelected() && !ano.isSelected()) {
	    		JOptionPane.showMessageDialog(null, "Please select Senior Citizen.");return;
	    	}else if(!sav.isSelected() && !cur.isSelected()) {
	    		JOptionPane.showMessageDialog(null, "Please select Account Type.");return;
	    	}
	    	else {
	    		ConnectionClass c=new ConnectionClass();
	    		String Q="insert into signupnext values('"+accountNo+"', '"+name+"', '"+citizenship+"', '"+religion+"', '"+category+"', '"+occupation+"', '"+seniorc+"', '"+accountType+"', '"+pan+"', '"+aadhar+"')";
	    		c.statement.executeUpdate(Q);}
	    }catch(Exception e1) {
	    	System.out.println(e1);
	    }
	    setVisible(false);
	    new SignUpEnd(accountNo, name);}
	}
}
