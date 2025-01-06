package Library_Management_System;
import java.awt.Color;

import java.awt.event.*;
import javax.swing.*;
class newpage extends JFrame implements ActionListener {
    newpage(){
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,700);
        this.setLayout(null);

        ImageIcon i = new ImageIcon("D:\\learning_java\\Library_Management_System\\image.png");
        this.setIconImage(i.getImage());

        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        p.setBounds(0,0,500,700);
        p.setLayout(null);

        JLabel l1 = new JLabel();
        l1.setText("First Name : ");
        l1.setForeground(Color.BLACK);
        l1.setBounds(20,60,100,15);
        JTextField t1= new JTextField();
        t1.setBounds(200,60,230,20);

        JLabel l2 = new JLabel();
        l2.setText("Last Name :");
        l2.setForeground(Color.BLACK);
        l2.setBounds(20,90,100,15);
        JTextField t2= new JTextField();
        t2.setBounds(200,90,230,20);

        JLabel l3 = new JLabel();
        l3.setText("Contact Number :");
        l3.setForeground(Color.BLACK);
        l3.setBounds(20,120,100,15);
        JTextField t3= new JTextField();
        t3.setBounds(200,120,230,20);

        JLabel l4 = new JLabel();
        l4.setText("Gmail :");
        l4.setForeground(Color.BLACK);
        l4.setBounds(20,150,100,15);
        JTextField t4= new JTextField();
        t4.setBounds(200,150,230,20);

        JLabel l5 = new JLabel();
        l5.setText("       Day                     Month                 Year");
        l5.setForeground(Color.BLUE);
        l5.setBounds(200, 190, 230, 15);

        JLabel l6 = new JLabel();
        l6.setText("Date of Birth: ");
        l6.setForeground(Color.BLACK);
        l6.setBounds(20, 210, 100, 15);

        JComboBox<Integer> dayComboBox = new JComboBox<>();
        for (int k = 1; k <= 31; k++) {
            dayComboBox.addItem(k);
        }
        dayComboBox.setBounds(200, 210, 60, 20);
        JComboBox<String> monthComboBox = new JComboBox<>(new String[]{
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        });
        
        monthComboBox.setBounds(270, 210, 100, 20);
        
        JComboBox<Integer> yearComboBox = new JComboBox<>();
        for (int j = 1990; j <= 2020; j++) {
            yearComboBox.addItem(j);
        }
        yearComboBox.setBounds(380, 210, 80, 20);

        JLabel l7 = new JLabel();
        l7.setText("Blood Group :");
        l7.setForeground(Color.BLACK);
        l7.setBounds(20, 240, 100, 15);
        JComboBox<String> Bloodgroup = new JComboBox<>(new String[]{
            "A+","A-","B+","B-","AB+","AB-","O+","O-"
        });
        Bloodgroup.setBounds(200, 240, 60, 20);

        JLabel l8 = new JLabel();
        l8.setText("Student OF : ");
        l8.setForeground(Color.black);
        l8.setBounds(20,270,100,15);
        JComboBox<String> Institute = new JComboBox<>(new String[]{
            "University","College","High School"
        });
        Institute.setBounds(200, 270, 200, 20);
        
        JLabel l9 = new JLabel();
        l9.setText("Permanent address :");
        l9.setForeground(Color.BLACK);
        l9.setBounds(20,300,200,15);
        JTextField t5= new JTextField();
        t5.setBounds(200,300,230,20);

        JLabel l10 = new JLabel();
        l10.setText("Home Address : ");
        l10.setForeground(Color.black);
        l10.setBounds(20,330,200,15);
        JTextField t6= new JTextField();
        t6.setBounds(200,330,230,20);

        JLabel l11= new JLabel();
        l11.setText("Fathers Name : ");
        l11.setForeground(Color.black);
        l11.setBounds(20,360,200,15);
        JTextField t7= new JTextField();
        t7.setBounds(200,360,230,20);

        JLabel l12 = new JLabel();
        l12.setText("Mothers Name : ");
        l12.setForeground(Color.black);
        l12.setBounds(20,390,200,15);
        JTextField t8= new JTextField();
        t8.setBounds(200,390,230,20);

        JLabel l13 = new JLabel();
        l13.setText("Membership :");
        l13.setForeground(Color.black);
        l13.setBounds(20,420,230,20);
        JComboBox<String> membership = new JComboBox<>(new String[]{
            "Weekly","Monthly","Yearly"
        });
        membership.setBounds(200, 420, 150, 20);
        
        JLabel l14 = new JLabel();
        l14.setText("Fees :");
        l14.setForeground(Color.black);
        l14.setBounds(20,450,230,20);

        JCheckBox termsCheckBox = new JCheckBox("I accept the Terms and Conditions");
        termsCheckBox.setBackground(Color.lightGray);
        termsCheckBox.setBounds(60, 480, 300, 20);

        JButton b1 = new JButton("Confirm Registration");
        b1.setBounds(40,530,200,25);
        
        JButton b2 = new JButton("Cancel");
        b2.setBounds(260,530,100,25);

        JPanel p2 = new JPanel();
        p2.setBounds(500,0,500,700);

        ImageIcon i1= new ImageIcon("D:\\learning_java\\Library_Management_System\\lib(1).jpg");
        JLabel r= new JLabel();
        r.setBounds(500,0,500,700);
        r.setIcon(i1);
        
        p.add(l1);
        p.add(l2);
        p.add(l3);
        p.add(l4);
        p.add(l5);
        p.add(l6);
        p.add(l7);
        p.add(l8);
        p.add(l9);
        p.add(l10);
        p.add(l11);
        p.add(l12);
        p.add(l13);
        p.add(l14);

        p.add(t1);
        p.add(t2);
        p.add(t3);
        p.add(t4);
        p.add(t5);
        p.add(t6);
        p.add(t7);
        p.add(t8);
        p.add(termsCheckBox);

        p.add(b1);
        p.add(b2);
        
        p2.add(r);
        
        p.add(dayComboBox);
        p.add(monthComboBox);
        p.add(yearComboBox);
        p.add(Bloodgroup);
        p.add(Institute);
        p.add(membership);
       
        this.add(p);
        this.add(p2);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Define the action to be performed here
    }
}

