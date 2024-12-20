package bank.managementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Withdrawl extends JFrame implements ActionListener {
	JTextField amount;
	JButton withdraw,back;
	String pin;
	Withdrawl( String pin){
		this.pin=pin;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/managementsystem/icons/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		 ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(0,0,900,900);
	        add(image);
	        
	        JLabel text = new JLabel("ENTER AMOUNT YOU WANT TO WITHDRAW");
	        text.setForeground(Color.WHITE);
	        text.setFont(new Font("System",Font.BOLD,16));
	        text.setBounds(170,300,400,20);
	        image.add(text);
	        
	        amount =  new JTextField();
	        amount.setFont(new Font("Raleway", Font.BOLD, 25));
	        amount.setBounds(170,350,320,20);
	        image.add(amount);
	        
	        withdraw = new JButton("Withdraw");
	        withdraw.setBounds(355, 485, 150, 30);
	        withdraw.addActionListener(this); 
	        image.add(withdraw);
	        
	        back = new JButton("Back");
	        back.setBounds(355,520,150,30);
	        back.addActionListener(this);
	        image.add(back);
		
		setSize(960,900);
        setUndecorated(true);
        setLocation(300,0);
        setVisible(true);
	}
	
	 public void actionPerformed(ActionEvent ae){
		 if (ae.getSource() ==  withdraw ) {
	            String number = amount.getText();
	            Date date = new Date();
			 
			 if(number.equals("")) {
				 JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
			 }else {
				 try {
				 Conn conn = new Conn();
				 String query = "insert into bank values(' "+pin+"','"+date+"',' Withdrawl ','"+number+"')";
				 conn.s.executeUpdate(query);
				 JOptionPane.showMessageDialog(null, "Rs. "+number+"  Withdrawl Successfully");
				 setVisible(false);
				 new Transactions(pin).setVisible(true);
			 }catch(Exception e) {
				 System.out.println(e);
			 }
			 }
			 
		 }else if(ae.getSource()==back){
			 setVisible(false);
			new Transactions(pin).setVisible(true); 
		 }
	 }
	 public static void main(String[] args){
	        new Withdrawl(" ");
	    }

}

