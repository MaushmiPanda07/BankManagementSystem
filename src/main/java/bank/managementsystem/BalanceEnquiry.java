package bank.managementsystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener  {
	JButton back;
	String pin;
	BalanceEnquiry(String pin ){
		this.pin=pin;
		setLayout(null);
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/managementsystem/icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l4 = new JLabel(i3);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        Conn c= new Conn();
        int balance = 0;
		 try {
			 ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
			
			
	            while (rs.next()) {
	                if (rs.getString("type").equals("Deposit")) {
	                    balance += Integer.parseInt(rs.getString("amount"));
	                } else {
	                    balance -= Integer.parseInt(rs.getString("amount"));
	                }
               }
           }catch(Exception e) {
        	   System.out.println(e);
           }
		 JLabel text = new JLabel("Your Current Account Balance is Rs  " + balance);
		 text.setForeground(Color.WHITE);
		 text.setBounds(170,300,400,30);
		 image.add(text);
			 
        
		setSize(960,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }
	
	public static void main(String[] args) {
		new BalanceEnquiry("");
		
	}

}
