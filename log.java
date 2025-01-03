package Library_Management_System;

import javax.swing.*;
import java.awt.*;

public class log extends JFrame{
    public log(){
        

        ImageIcon i= new ImageIcon("D:\\learning_java\\Library_Management_System\\image.png");
        ImageIcon i1 = new ImageIcon("D:\\learning_java\\Library_Management_System\\lib(1).jpg");
        
        JLabel l = new JLabel();
        l.setIcon(i1);
        l.setBounds(0, 0,500,700);
        JPanel p = new JPanel();
        p.setBounds(500,0,500,700);
        p.setBackground(Color.LIGHT_GRAY);

        JLabel textLabel = new JLabel("Welcome to our Library");
        textLabel.setBounds(50, 100, 400, 30);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        p.setLayout(null);
        p.add(textLabel);
        
        JLabel username=new JLabel("Username :");
        username.setFont(new Font(null,Font.BOLD,15));
        username.setBounds(50, 300, 200, 30);

        JTextField usernamefield = new JTextField();
        usernamefield.setBounds(150, 300, 200, 30);
        usernamefield.setFont(new Font(null,Font.BOLD,13));

        p.add(username);
        p.add(usernamefield);

        JLabel password=new JLabel("Password :");
        password.setFont(new Font(null,Font.BOLD,15));
        password.setBounds(50, 350, 200, 30);

        JPasswordField password1= new JPasswordField();
        password1.setBounds(150, 350, 200, 30);
        password1.setFont(new Font(null,Font.BOLD,13));
        p.add(password);
        p.add(password1);

        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,700);
        this.setLayout(null);
        this.setIconImage(i.getImage());

        Button b = new Button();
        b.setLabel("Login");
        b.setBounds(200, 400, 100, 30);
        b.addActionListener(e -> {
            String u1 = usernamefield.getText();
            String p1 = new String(password1.getPassword());
            
            System.out.println("Username: " + u1);
            System.out.println("Password: " + p1);
            
        });
        p.add(b);
        this.add(p);
        this.add(l);
         
        this.setVisible(true);
    }    
}
