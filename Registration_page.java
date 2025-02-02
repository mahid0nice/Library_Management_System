//package Library_Management_System;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;



class aNewPage extends JFrame implements ActionListener {
   
    JTextField firstname_f, lastname_f, contactnumber_f, email_f,permanentaddress_f,homeaddress_f, fathersname_f, mothersname_f, fees_f,Voter_id;
    JComboBox<Integer> dayComboBox, yearComboBox;
    JComboBox<String> monthComboBox, bloodGroupComboBox, instituteComboBox, membershipComboBox;
    JCheckBox termsCheckBox;
    JButton confirmButton, cancelButton;

    aNewPage() {
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\learning_java\\Library_Management_System\\image.png");
        ImageIcon i1 = new ImageIcon("D:\\learning_java\\Library_Management_System\\lib(1).jpg");

        this.setIconImage(icon.getImage());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBounds(0, 0, 500,700 );
        leftPanel.setLayout(null);

        JLabel firstName = new JLabel("First Name:");
        firstName.setBounds(20, 60, 100, 15);
        firstname_f = new JTextField();
        firstname_f.setBounds(200, 60, 230, 20);

        JLabel X1 = new JLabel("*");
        X1.setBounds(440,60,10,10);

        JLabel lastName = new JLabel("Last Name:");
        lastName.setBounds(20, 90, 100, 15);
        lastname_f = new JTextField();
        lastname_f.setBounds(200, 90, 230, 20);

        JLabel X2 = new JLabel("*");
        X2.setBounds(440,90,10,10);

        JLabel contactNumber = new JLabel("Contact Number:");
        contactNumber.setBounds(20, 120, 100, 15);
        contactnumber_f = new JTextField();
        contactnumber_f.setBounds(200, 120, 230, 20);

        JLabel X3 = new JLabel("*");
        X3.setBounds(440,120,10,10);

        JLabel email = new JLabel("Email:");
        email.setBounds(20, 150, 100, 15);
        email_f = new JTextField();
        email_f.setBounds(200, 150, 230, 20);

        JLabel X4 = new JLabel("*");
        X4.setBounds(440,150,10,10);

        JLabel voterpin = new JLabel("Voter ID:");
        voterpin.setBounds(20,180,100,15);
        Voter_id = new JTextField();
        Voter_id.setBounds(200,180,230,20);

        JLabel X5 = new JLabel("*");
        X5.setBounds(440,180,10,10);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(20, 210, 100, 15);

        dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        dayComboBox.setBounds(200, 210, 60, 20);

        monthComboBox = new JComboBox<>(new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        });
        monthComboBox.setBounds(270, 210, 100, 20);

        yearComboBox = new JComboBox<>();
        for (int i = 1990; i <= 2020; i++) {
            yearComboBox.addItem(i);
        }
        yearComboBox.setBounds(380, 210, 80, 20);

        JLabel bloodGroup = new JLabel("Blood Group:");
        bloodGroup.setBounds(20, 240, 100, 15);
        bloodGroupComboBox = new JComboBox<>(new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        bloodGroupComboBox.setBounds(200, 240, 100, 20);

        JLabel institute = new JLabel("Student Of:");
        institute.setBounds(20, 270, 100, 15);
        instituteComboBox = new JComboBox<>(new String[]{"University", "College", "High School"});
        instituteComboBox.setBounds(200, 270, 200, 20);

        JLabel permanentAddress = new JLabel("Permanent Address:");
        permanentAddress.setBounds(20, 300, 150, 15);
        permanentaddress_f = new JTextField();
        permanentaddress_f.setBounds(200, 300, 230, 20);

        JLabel X6 = new JLabel("*");
        X6.setBounds(440,300,10,10);

        JLabel homeAddress = new JLabel("Home Address:");
        homeAddress.setBounds(20, 330, 150, 15);
       homeaddress_f = new JTextField();
       homeaddress_f.setBounds(200, 330, 230, 20);

        JLabel fathersName = new JLabel("Father's Name:");
        fathersName.setBounds(20, 360, 150, 15);
        fathersname_f = new JTextField();
        fathersname_f.setBounds(200, 360, 230, 20);

        JLabel mothersName = new JLabel("Mother's Name:");
        mothersName.setBounds(20, 390, 150, 15);
        mothersname_f = new JTextField();
        mothersname_f.setBounds(200, 390, 230, 20);

        JLabel membership = new JLabel("Membership:");
        membership.setBounds(20, 420, 150, 15);
        membershipComboBox = new JComboBox<>(new String[]{"Weekly", "Monthly", "Yearly"});
        membershipComboBox.setBounds(200, 420, 150, 20);

        membershipComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFeesBasedOnMembership();
            }
        });

        JLabel fees = new JLabel("Fees:");
        fees.setBounds(20, 450, 150, 15);
        fees_f = new JTextField();
        fees_f.setBounds(200, 450, 230, 20);

        termsCheckBox = new JCheckBox("I accept the Terms and Conditions");
        termsCheckBox.setBounds(60, 480, 300, 20);

        
        confirmButton = new JButton("Confirm Registration");
        confirmButton.setBounds(40, 530, 200, 25);
        confirmButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(260, 530, 100, 25);
        cancelButton.addActionListener(this);

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(500, 0, 500, 700);

        JLabel pic = new JLabel();
        pic.setIcon(i1);
        pic.setBounds(500, 0, 500, 700);
        

        
        leftPanel.add(firstName);
        leftPanel.add(firstname_f);
        leftPanel.add(X1);

        leftPanel.add(lastName);
        leftPanel.add(lastname_f);
        leftPanel.add(X2);

        leftPanel.add(contactNumber);
        leftPanel.add(contactnumber_f);
        leftPanel.add(X3);

        leftPanel.add(email);
        leftPanel.add(email_f);
        leftPanel.add(X4);

        leftPanel.add(voterpin);
        leftPanel.add(Voter_id);
        leftPanel.add(X5);

        leftPanel.add(dob);

        leftPanel.add(dayComboBox);
        leftPanel.add(monthComboBox);
        leftPanel.add(yearComboBox);

        leftPanel.add(bloodGroup);
        leftPanel.add(bloodGroupComboBox);

        leftPanel.add(institute);
        leftPanel.add(instituteComboBox);

        leftPanel.add(permanentAddress);
        leftPanel.add(permanentaddress_f);
        leftPanel.add(X6);

        leftPanel.add(homeAddress);
        leftPanel.add(homeaddress_f);

        leftPanel.add(fathersName);
        leftPanel.add(fathersname_f);

        leftPanel.add(mothersName);
        leftPanel.add(mothersname_f);

        leftPanel.add(membership);
        leftPanel.add(membershipComboBox);

        leftPanel.add(fees);
        leftPanel.add(fees_f);

        leftPanel.add(termsCheckBox);

        leftPanel.add(confirmButton);

        leftPanel.add(cancelButton);

        rightPanel.add(pic);

        this.add(leftPanel);
        this.add(rightPanel);
        this.setTitle("Registration Page");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }
    private void updateFeesBasedOnMembership() {
        String selectedMembership = (String) membershipComboBox.getSelectedItem();
        if (selectedMembership != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader("D:\\learning_java\\Library_Management_System\\fees.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts[0].trim().equalsIgnoreCase(selectedMembership)) {
                        fees_f.setText(parts[1].trim());
                        break;
                    }
                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error reading fees: " + ex.getMessage());
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            if (termsCheckBox.isSelected() && !firstname_f.getText().isEmpty() && !lastname_f.getText().isEmpty() && !contactnumber_f.getText().isEmpty() && !email_f.getText().isEmpty() && !permanentaddress_f.getText().isEmpty() && !Voter_id.getText().isEmpty()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\learning_java\\Library_Management_System\\Members_information.txt", true))) {
                    
                    writer.write(
                        firstname_f.getText() + "," +lastname_f.getText()+ "," +contactnumber_f.getText() + "," +email_f.getText() + "," +dayComboBox.getSelectedItem() + "/" +
                        monthComboBox.getSelectedItem() + "/" +yearComboBox.getSelectedItem() + "," +bloodGroupComboBox.getSelectedItem() + "," +instituteComboBox.getSelectedItem() + "," +
                        permanentaddress_f.getText() + "," +homeaddress_f.getText() + "," +fathersname_f.getText() + "," +mothersname_f.getText() + "," +membershipComboBox.getSelectedItem() + "," +fees_f.getText());
                    writer.newLine();
                    JOptionPane.showMessageDialog(this, "Registration Successful!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please accept the terms and conditions and fill in all the required fields.");
            }
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }

    public static void main(String[] args){
        new aNewPage();
    }
}