package bank.managementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transactions extends JFrame implements ActionListener {
	JButton deposit,withdrawl,fastcash, ministatement,pinchange,balanceenquiry,exit;
	String pin;
	 Transactions(String pin){
		 this.pin=pin;
		 setLayout(null);
		 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/managementsystem/icons/atm.jpg"));
		 Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	        ImageIcon i3 = new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(0,0,900,900);
	        add(image);
	        
	        JLabel text = new JLabel("Please Select Your Transaction");
	        text.setBounds(200,300,700,35);
	        text.setForeground(Color.WHITE);
	        text.setFont(new Font("System",Font.BOLD,16));
	        image.add(text);
	        
	        deposit = new JButton("Deposit");
	        deposit.setBounds(170,415,150,30);
	        deposit.addActionListener(this);
	        image.add(deposit);
	        
	        withdrawl = new JButton("Cash Withdrawl");
	        withdrawl.setBounds(355,415,150,30);
	        withdrawl.addActionListener(this);
	        image.add(withdrawl);
	        
	        fastcash = new JButton("Fast Cash");
	        fastcash.setBounds(170,450,150,30);
	        fastcash.addActionListener(this);
	        image.add(fastcash);
	        
	        ministatement = new JButton("Ministatement");
	        ministatement.setBounds(355,450,150,30);
	        ministatement.addActionListener(this);
	        image.add(ministatement);
	        
	        pinchange = new JButton("Pin Change ");
	        pinchange.setBounds(170,485,150,30);
	        pinchange.addActionListener(this);
	        image.add(pinchange);

	        balanceenquiry = new JButton("Balance Enquiry ");
	        balanceenquiry.setBounds(355,485,150,30); // Corrected position to avoid overlap
	        balanceenquiry.addActionListener(this);
	        image.add(balanceenquiry);

	        
	        exit = new JButton("EXIT");
	        exit.setBounds(335, 520, 150, 30); // Adjusted Y-coordinate to avoid overlap
	        exit.addActionListener(this);
	        image.add(exit); // Properly added to the image label

	        
		    setSize(960,900);
	        setLocation(300,0);
	        setUndecorated(true);
	        setVisible(true);
		 
	 }
	 
	 public void actionPerformed(ActionEvent ae){
		 if(ae.getSource()==exit){ 
			System.exit(0); 
		 }
		 else if (ae.getSource() == deposit) {
	            setVisible(false);
	            new Deposit(pin).setVisible(true);  // Show Deposit screen
	        }else if(ae.getSource()==withdrawl){
	        	setVisible(false);
	        	new Withdrawl(pin).setVisible(true);
	        	
	        }else if(ae.getSource()==fastcash) {
	        	setVisible(false);
	        	new FastCash(pin).setVisible(true);
	        }else if(ae.getSource()==pinchange){
	        	setVisible(false);
	        	new Pin(pin).setVisible(true);
	        	
	        }else if(ae.getSource()==balanceenquiry ){
	        setVisible(false);
	        new BalanceEnquiry(pin).setVisible(true);
	        }else if(ae.getSource()==ministatement) {
	        	
	        	new MiniStatement(pin).setVisible(true);
	        }
	 }
	public static void main(String[] args){
		new Transactions(" ");
	}
}
