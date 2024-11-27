package bank.managementsystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class MiniStatement extends JFrame implements ActionListener{
	MiniStatement(String pin){
		setTitle("Mini Statement");
		setLayout(null);
		
		JLabel mini = new JLabel();
		mini.setBounds(20,140,400,200);
		add(mini);
		
		JLabel bank = new JLabel("Indian Bank");
		bank.setBounds(150,20,100,20);
		add(bank);
		
		JLabel card = new JLabel();
		card.setBounds(20,80,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		
		try {
			Conn c1 = new Conn();
			
			 ResultSet rs = c1.s.executeQuery("SELECT * FROM login where pin = '"+pin+"'");
			while(rs.next()) {
				card.setText("Card Number:" + rs.getString("cardno").substring(0,4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
			
			}
			
		}catch(Exception e) {
			System.out.println(e);
		}
		try {
			Conn c1 = new Conn();
			int bal = 0;
			 ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '"+pin+"'");
			 while(rs.next()) {
					mini.setText(mini.getText() + "<html>" +  rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>"  );
					if (rs.getString("type").equals("Deposit")) {
	                    bal+= Integer.parseInt(rs.getString("amount"));
	                } else {
	                    bal -= Integer.parseInt(rs.getString("amount"));
                }
	
				}
			 balance.setText("Your total Balance is Rs " + bal);
		}catch(Exception e) {
			System.out.println(e);
		}
		
		//mini.setBounds(20,140,400,200);
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
		
	}
	public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
	public static void main(String[] args){
		new MiniStatement("").setVisible(true);
		
	}

}




























