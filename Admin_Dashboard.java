//package Library_Management_System;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class dashboard extends JFrame implements ActionListener {
    JButton profileButton;
    JPanel largestpanel;
    public dashboard(){
        
        this.setSize(1920,1080);
        this.setLayout(null);
        
        JPanel upperpanel = new JPanel();
        upperpanel.setBounds(0, 0, 1920,70 );
        upperpanel.setBackground(Color.BLUE);
        
        JPanel leftpanel = new JPanel();
        leftpanel.setBounds(0, 70, 300, 1080);
        leftpanel.setBackground(Color.GRAY);

        profileButton = new JButton();
        profileButton.setText("My Profile");
        profileButton.setPreferredSize(new java.awt.Dimension(200, 40));
        profileButton.setBounds(10,80,300,40);
        profileButton.setBackground(Color.lightGray);
        profileButton.addActionListener(this);

        JButton stock_books = new JButton();
        stock_books.setText("Stock Check");
        stock_books.setPreferredSize(new java.awt.Dimension(200, 40));
        stock_books.setBounds(10,160,300,40);
        stock_books.setBackground(Color.lightGray);

        JButton number_of_members = new JButton();
        number_of_members.setText("Member list");
        number_of_members.setPreferredSize(new java.awt.Dimension(200, 40));
        number_of_members.setBounds(10,240,300,40);
        number_of_members.setBackground(Color.lightGray);
        
        JButton add_member = new JButton();
        add_member.setText("Add Member");
        add_member.setPreferredSize(new java.awt.Dimension(200, 40));
        add_member.setBounds(10,320,300,40);
        add_member.setBackground(Color.lightGray);

        JButton add_librarian = new JButton();
        add_librarian.setText("Add Librarian");
        add_librarian.setPreferredSize(new java.awt.Dimension(200, 40));
        add_librarian.setBounds(10,400,300,40);
        add_librarian.setBackground(Color.lightGray);

        JButton fees_for_member = new JButton();
        fees_for_member.setText("Fees For Member");
        fees_for_member.setPreferredSize(new java.awt.Dimension(200, 40));
        fees_for_member.setBounds(10,480,300,40);
        fees_for_member.setBackground(Color.lightGray);

        JButton rules_regulation = new JButton();
        rules_regulation.setText("Rules And Regulation");
        rules_regulation.setPreferredSize(new java.awt.Dimension(200, 40));
        rules_regulation.setBounds(10,560,300,40);
        rules_regulation.setBackground(Color.lightGray); 
        
        JButton name_of_writer = new JButton();
        name_of_writer.setText("Writer List");
        name_of_writer.setPreferredSize(new java.awt.Dimension(200, 40));
        name_of_writer.setBounds(10,640,300,40);
        name_of_writer.setBackground(Color.lightGray);

        JButton books_title = new JButton();
        books_title.setText("Books Title");
        books_title.setPreferredSize(new java.awt.Dimension(200, 40));
        books_title.setBounds(10,720,300,40);
        books_title.setBackground(Color.lightGray);
         
        JButton rent_book = new JButton();
        rent_book.setText("Borrow book list");
        rent_book.setPreferredSize(new java.awt.Dimension(200, 40));
        rent_book.setBounds(10,800,300,40);
        rent_book.setBackground(Color.lightGray);
        
        JButton Sold_Book = new JButton();
        Sold_Book.setText("Sold Book");
        Sold_Book.setPreferredSize(new java.awt.Dimension(200, 40));
        Sold_Book.setBounds(10,800,300,40);
        Sold_Book.setBackground(Color.lightGray);

        JButton edit_profile = new JButton();
        edit_profile.setText("Edit Profile");
        edit_profile.setPreferredSize(new java.awt.Dimension(200, 40));
        edit_profile.setBounds(10,880,300,40);
        edit_profile.setBackground(Color.lightGray);
        
        JButton log_out = new JButton();
        log_out.setText("Log Out");
        log_out.setPreferredSize(new java.awt.Dimension(200, 40));
        log_out.setBounds(10,960,300,40);
        log_out.setBackground(Color.lightGray);

        largestpanel = new JPanel();
        largestpanel.setBounds(300,70,1620,1010);
        largestpanel.setBackground(Color.WHITE);
        largestpanel.setLayout(null);
        

        leftpanel.add(profileButton);
        leftpanel.add(stock_books);
        leftpanel.add(add_member);
        leftpanel.add(number_of_members);
        leftpanel.add(add_librarian);
        leftpanel.add(fees_for_member);
        leftpanel.add(rules_regulation);
        leftpanel.add(name_of_writer);
        leftpanel.add(books_title);
        leftpanel.add(rent_book);
        leftpanel.add(Sold_Book);
        leftpanel.add(edit_profile);
        leftpanel.add(log_out);
             

        this.add(upperpanel);
        this.add(leftpanel);
        this.add(largestpanel);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == profileButton){
            largestpanel.removeAll();
            largestpanel.add(new ProfilePanel());
            largestpanel.revalidate();
            largestpanel.repaint();


        }
    
    }


public static void main(String[] args){
        new dashboard();
    }

}
