 package Library_Management_System;
import javax.swing.*;
public class button extends JFrame {
    button(){
        JButton b= new JButton();
        
       b.setText("Login");
        b.addActionListener(e -> {
            // Code to handle login action
            //System.out.println("Login button clicked");
        });
        add(b);
        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }
    
}
