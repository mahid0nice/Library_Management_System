package Library_Management_System;

import javax.swing.*;
import java.awt.*;

class Registration_page extends JFrame {
    public Registration_page() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 900);
        this.setTitle("Registration Form");

        ImageIcon icon = new ImageIcon("D:/learning_java/Library_Management_System/image.png");
        this.setIconImage(icon.getImage());

        JPanel main = new JPanel(new GridLayout(1, 2, 50, 50));

        JPanel main1 = new JPanel(new GridLayout(7, 2, 10, 10));
        main1.setBorder(BorderFactory.createTitledBorder("General Information"));
        main1.setBackground(Color.LIGHT_GRAY);

        main1.add(new JLabel("STUDENT OF:"));
        main1.add(new JComboBox<>(new String[]{"High School", "Undergraduate", "Postgraduate", "PhD"}));

        main1.add(new JLabel("First Name:"));
        main1.add(new JTextField(15));

        main1.add(new JLabel("Last Name:"));
        main1.add(new JTextField(15));

        main1.add(new JLabel("Institute Name:"));
        main1.add(new JTextField(15));

        main1.add(new JLabel("Select Date of Birth:"));

        JPanel dobPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JComboBox<Integer> dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        JComboBox<String> monthComboBox = new JComboBox<>(new String[]{
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        });
        JComboBox<Integer> yearComboBox = new JComboBox<>();
        for (int i = 1990; i <= 2020; i++) {
            yearComboBox.addItem(i);
        }
        dobPanel.add(dayComboBox);
        dobPanel.add(monthComboBox);
        dobPanel.add(yearComboBox);

        main1.add(dobPanel);

        JPanel main2 = new JPanel(new GridLayout(7, 2, 10, 10));
        main2.setBorder(BorderFactory.createTitledBorder("Contact Details"));
        main2.setBackground(Color.YELLOW);

        main2.add(new JLabel("Permanent Address:"));
        main2.add(new JTextField(15));

        main2.add(new JLabel("Home Address:"));
        main2.add(new JTextField(15));

        main2.add(new JLabel("City:"));
        main2.add(new JTextField(15));

        main2.add(new JLabel("Postal Code:"));
        main2.add(new JTextField(15));

        main2.add(new JLabel("Country:"));
        main2.add(new JComboBox<>(new String[]{"USA", "UK", "Germany", "India"}));

        main2.add(new JLabel("Phone Number:"));
        main2.add(new JTextField(15));

        main2.add(new JLabel("Email:"));
        main2.add(new JTextField(15));

        JPanel bottom = new JPanel(new FlowLayout());
        JCheckBox termsCheckBox = new JCheckBox("I accept the Terms and Conditions");
        JButton registerButton = new JButton("Register Badge");
        bottom.add(termsCheckBox);
        bottom.add(registerButton);

        main.add(main1);
        main.add(main2);

        this.setLayout(new BorderLayout());
        this.add(main, BorderLayout.CENTER);
        this.add(bottom, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}


/* 
        ImageIcon backgroundIcon = new ImageIcon("D:\\learning_java\\Library_Management_System\\library.jpg");
        
        
        JPanel bp = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        bp.setLayout(null); // Allow absolute positioning
        bp.setBounds(0, 0, 1000, 900);

        // Add the background panel to the frame
        this.add(bp);*/

