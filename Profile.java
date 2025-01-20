//package Library_Management_System;
import javax.swing.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class ProfilePanel extends JPanel {
    public ProfilePanel() {
        this.setBounds(0, 0, 1620, 1010);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);

        ImageIcon image_of_admin = new ImageIcon("D:\\learning_java\\Library_Management_System\\profile.jpg");
        JLabel picture = new JLabel();
        picture.setIcon(image_of_admin);
        picture.setBounds(50,50,300,300);

        JLabel admin_name = new JLabel();
        admin_name.setText("Name :");
        admin_name.setFont(new Font("Courier New",Font.BOLD,18));
        admin_name.setBounds(50,400,100,25);
        
        JTextArea admin_info = new JTextArea();
        admin_info.setEditable(false);
        admin_info.setFont(new Font("Courier New",Font.BOLD,18));
        admin_info.setBackground(Color.pink);
        
        
        JScrollPane scrollPane_1 = new JScrollPane(admin_info);
        scrollPane_1.setBounds(400, 400, 300, 25);
        scrollPane_1.setBorder(BorderFactory.createLineBorder(Color.BLACK));



        JLabel email = new JLabel();
        email.setText("Email :");
        email.setFont(new Font("Courier New",Font.BOLD,18));
        email.setBounds(50,450,100,25);
        
        JTextArea admin_email = new JTextArea();
        admin_email.setEditable(false);
        admin_email.setFont(new Font("Courier New",Font.BOLD,18));
        admin_email.setBackground(Color.pink);
        
        
        JScrollPane scrollpane_2 = new JScrollPane(admin_email);
        scrollpane_2.setBounds(400, 450, 400, 25);
        scrollpane_2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        


        JLabel address = new JLabel();
        address.setText("Address :");
        address.setFont(new Font("Courier New",Font.BOLD,18));
        address.setBounds(50,500,100,25);
        
        JTextArea admin_address = new JTextArea();
        admin_address.setEditable(false);
        admin_address.setFont(new Font("Courier New",Font.BOLD,18));
        admin_address.setBackground(Color.pink);
         
        JScrollPane scrollpane_3= new JScrollPane(admin_address);
        scrollpane_3.setBounds(400, 500, 300, 25);
        scrollpane_3.setBorder(BorderFactory.createLineBorder(Color.BLACK));


        JLabel number = new JLabel();
        number.setText("Phone Number :");
        number.setFont(new Font("Courier New",Font.BOLD,18));
        number.setBounds(50,550,200,25);
        
        JTextArea admin_number = new JTextArea();
        admin_number.setEditable(false);
        admin_number.setFont(new Font("Courier New",Font.BOLD,18));
        admin_number.setBackground(Color.pink);
        
        
        JScrollPane scrollpane_4= new JScrollPane(admin_number);
        scrollpane_4.setBounds(400, 550, 300, 25);
        scrollpane_4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        

        try (BufferedReader read = new BufferedReader(new FileReader("D:\\learning_java\\java_learning\\admin.txt"))){
            String line;
            while ((line = read.readLine())!= null){

                // Assuming the profile photo path is also stored in the file
                String photoPath = line.split(",")[4];
                if (!photoPath.isEmpty()) {
                    image_of_admin = new ImageIcon(photoPath);
                    picture.setIcon(image_of_admin);
                }
                String name = line.split(",")[0];
                String Gmail = line.split(",")[1];
                String Address = line.split(",")[2];
                String contact = line.split(",")[3];
                admin_info.append(name);
                admin_email.append(Gmail);
                admin_number.append(contact);
                admin_address.append(Address);
            }
        } catch (IOException e){
            JOptionPane.showMessageDialog(this, "An error occuring!!!"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                 
        }
                
        this.setBackground(new Color(155, 137, 204));
        this.add(picture);
        this.add(admin_name);
        this.add(email);
        this.add(number);
        this.add(address);

        this.add(scrollPane_1);
        this.add(scrollpane_2);
        this.add(scrollpane_3);
        this.add(scrollpane_4);
    }
}


