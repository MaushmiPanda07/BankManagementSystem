//package bank.managementsystem;
//import java.awt.Image;
//import java.awt.event.ActionListener;
//import java.sql.ResultSet;
//import java.awt.*;
//import java.awt.event.*;
//
//import javax.swing.*;
//
//import com.mysql.cj.protocol.Resultset;
//public class Login extends JFrame implements ActionListener{
//	JButton login,signup,clear;
//	JTextField cardTextField;
//	JPasswordField pinTextField;
//	Login(){
//		setTitle("AUTOMATED TELLER MACHINE");
//		setLayout(null);
//		
//		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("bank/managementsystem/icons/logo.jpg"));
//		Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
//		ImageIcon i3 = new ImageIcon(i2);
//		JLabel label=new JLabel(i3);
//		label.setBounds(70, 10,100,100);
//		add(label);
//		JLabel text =new JLabel("Welcome to ATM");
//		text.setFont(new Font("Osword",Font.BOLD,38));
//		text.setBounds(200,40,400,30);
//		add(text);
//		
//		JLabel cardno =new JLabel("Card NO.");
//		cardno.setFont(new Font("Raleway",Font.BOLD,38));
//		cardno.setBounds(120,150,250,40);
//		add(cardno);
//
//        cardTextField = new JTextField();
//		cardTextField.setBounds(300,150,230,30);
//		cardTextField.setFont(new Font("Arial",Font.BOLD,14));
//		add(cardTextField);
//		
//		JLabel pin =new JLabel("PIN");
//		pin.setFont(new Font("Raleway",Font.BOLD,38));
//		pin.setBounds(120,220,250,30);
//		add(pin);
//		
//		
//
//        pinTextField = new JPasswordField();
//		pinTextField.setBounds(300,220,230,30);
//		pinTextField.setFont(new Font("Arial",Font.BOLD,14));
//		add(pinTextField);
//		
//		 login = new JButton("SIGN IN");
//		login.setBounds(300,300,100,30);
//		login.setBackground(Color.BLACK);
//		login.setForeground(Color.WHITE);
//		login.addActionListener(this);
//		add(login);
//		
//		clear = new JButton("CLEAR");
//		clear.setBounds(430,300,100,30);
//		clear.setBackground(Color.BLACK);
//		clear.setForeground(Color.WHITE);
//		clear.addActionListener(this);
//		add(clear);
//		
//	    signup = new JButton("SIGN UP");
//		signup.setBounds(300,350,230,30);
//		signup.setBackground(Color.BLACK);
//		signup.setForeground(Color.WHITE);
//		signup.addActionListener(this);
//		add(signup);
//		
//		getContentPane().setBackground(Color.WHITE);
//		setSize(800,400);
//		setVisible(true);
//		setLocation(350,200);
//	}
//	public void actionPerformed(ActionEvent ae) {
//		if(ae.getSource()==clear) {
//			cardTextField.setText("");
//			
//			pinTextField.setText("");
//		}else if(ae.getSource()==login){
//			Conn conn = new Conn();
//			String cardno = cardTextField.getName();
//			
//			String pin = pinTextField.getText();
//			String query  = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
//           try {
//        	   ResultSet rs = conn.s.executeQuery(query); 
//        	   if(rs.next()) {
//        		   setVisible(false);
//        		   new Transactions(pin ).setVisible(true);
//        	   }else {
//        		   JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
//        	   }
//           }catch (Exception e) {
//        	   System.out.println(e);
//		}
//		
//	}else if(ae.getSource()==signup) {
//		setVisible(false);
//		new SignUpOne().setVisible(true);
//	}
//	}
//	public static void main(String args[]) {
//		new Login();
//	}
//
//}
//
//
//
//
//
//

package bank.managementsystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

    Login() {
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);

        // ATM logo
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("bank/managementsystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        // Welcome text
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osword", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 30);
        add(text);

        // Card Number label and input field
        JLabel cardno = new JLabel("Card NO:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 250, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);

        // PIN label and input field
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);

        // Buttons: Login, Clear, Signup
        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        // Frame properties
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 400);
        setVisible(true);
        setLocation(350, 200);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource() == login) {
            String cardno = cardTextField.getText();
            String pin = pinTextField.getText();

            String query = "SELECT * FROM login WHERE cardno = '" + cardno + "' AND pin = '" + pin + "'";

            try {
                Conn conn = new Conn();
                ResultSet rs = conn.s.executeQuery(query);

                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        } else if (ae.getSource() == signup) {
            setVisible(false);
            new SignUpOne().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}


































