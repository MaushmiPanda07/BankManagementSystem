      
package bank.managementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SignUpTwo extends JFrame implements ActionListener {

    JTextField pan, adhar;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, occuptiona, education, income;
    String formno;
    
    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("New Account Application Form - Page 2");

       
        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);

        
        JLabel religionLabel = new JLabel("Religion:");
        religionLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        religionLabel.setBounds(100, 140, 200, 30);
        add(religionLabel);

        String valReligion[] = { "Hindu", "Muslim", "Sikh", "Christian", "Other" };
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        
        JLabel categoryLabel = new JLabel("Category:");
        categoryLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        categoryLabel.setBounds(100, 190, 200, 30);
        add(categoryLabel);

        String valCategory[] = { "General", "OBC", "SC", "ST", "Other" };
        category = new JComboBox(valCategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        
        JLabel incomeLabel = new JLabel("Income:");
        incomeLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        incomeLabel.setBounds(100, 240, 200, 30);
        add(incomeLabel);

        String incomeCategory[] = { "Null", "< 1,50,000", "< 2,50,000", "< 5,00,000", "Up to 10,00,000" };
        income = new JComboBox(incomeCategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        
        JLabel educationLabel = new JLabel("Educational Qualification:");
        educationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        educationLabel.setBounds(100, 290, 400, 30);
        add(educationLabel);

        String educationalValues[] = { "Non-Graduation", "Graduate", "Post-Graduation", "Doctorate", "Other" };
        education = new JComboBox(educationalValues);
        education.setBounds(300, 330, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

       
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        occupationLabel.setBounds(100, 390, 200, 30);
        add(occupationLabel);

        String occupationValues[] = { "Salaried", "Self-Employed", "Business", "Student", "Retired", "Other" };
        occuptiona = new JComboBox(occupationValues);
        occuptiona.setBounds(300, 390, 400, 30);
        occuptiona.setBackground(Color.WHITE);
        add(occuptiona);

        
        JLabel panLabel = new JLabel("PAN Number:");
        panLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        panLabel.setBounds(100, 440, 200, 30);
        add(panLabel);

        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        
        JLabel adharLabel = new JLabel("Aadhaar Number:");
        adharLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        adharLabel.setBounds(100, 490, 200, 30);
        add(adharLabel);

        adhar = new JTextField();
        adhar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);

        
        JLabel seniorLabel = new JLabel("Senior Citizen:");
        seniorLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorLabel.setBounds(100, 540, 200, 30);
        add(seniorLabel);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorGroup = new ButtonGroup();
        seniorGroup.add(syes);
        seniorGroup.add(sno);

       
        JLabel existingLabel = new JLabel("Existing Account:");
        existingLabel.setFont(new Font("Raleway", Font.BOLD, 20));
        existingLabel.setBounds(100, 590, 200, 30);
        add(existingLabel);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup existingGroup = new ButtonGroup();
        existingGroup.add(eyes);
        existingGroup.add(eno);

        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        
        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent ae) {
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occuptiona.getSelectedItem();
        String span = pan.getText();
        String sadhar = adhar.getText();
        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        try {
            Conn c = new Conn();
            String query = "INSERT INTO signuptwoo VALUES('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + sadhar + "','" + seniorCitizen + "','" + existingAccount + "')";
            c.s.executeUpdate(query); 
           setVisible(false);
        } catch(Exception e) {
       	System.out.println(e);	
        }
    }
        public static void main(String[] args) {
          new SignUpTwo("");
      }
 }





















