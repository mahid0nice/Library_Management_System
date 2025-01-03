package Library_Management_System;

import javax.swing.*;
import java.awt.*;

class Registration_page extends JFrame {
    public Registration_page() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 900);
        this.setLayout(null);

        ImageIcon i = new ImageIcon("D:\\learning_java\\Library_Management_System\\image.png");
        ImageIcon i2 = new ImageIcon("D:\\learning_java\\Library_Management_System\\DALLE_2025-01-03_18.31.36_-_An_animated-styled_image_of_a_library_interior_with_a_dark_and_moody_atmosphere._The_scene_features_tall_wooden_bookshelves_filled_with_books_a_vinta.jpg");
        this.setIconImage(i.getImage());

        JPanel p = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(i2.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };

        p.setBounds(0, 0, 1000, 900);
        p.setLayout(null);

        JLabel label = new JLabel();
        
        label.setText("Registration page");
        label.setForeground(Color.GREEN);
        label.setFont(new Font(null,Font.BOLD,30));
        

        label.setBounds(350, 100, 300, 50);
        p.add(label);

        this.add(p);
        this.setVisible(true);
    }
}
