//package Library_Management_System;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


class dashboard extends JFrame implements ActionListener {
    JButton profileButton, Book, log_out , rules_regulation , add_librarian , add_member , rent_book ;
    JPanel largestpanel;
    ImageIcon icon,loogo,dashboard;

    public dashboard()
    {
        icon= new ImageIcon("D:\\LibraryManageementSystem\\image.png");
        loogo= new ImageIcon("D:\\LibraryManageementSystem\\logo1(1).jpg"); 
        this.setSize(1920,1080);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        JPanel upperpanel = new JPanel();
        upperpanel.setBounds(0, 0, 1920,70 );
        upperpanel.setBackground(new Color(192, 162, 219));
        upperpanel.setLayout(null);

        JLabel logo = new JLabel();
        logo.setBounds(0,0,100,70);
        logo.setIcon(loogo);

        JLabel Library_Name = new JLabel("The Realm Of Reads");
        Library_Name.setFont(new Font("Courier New", Font.BOLD, 20));
        Library_Name.setHorizontalAlignment(JLabel.RIGHT);
        Library_Name.setBounds(110, 0, 250, 70);
        
        JPanel leftpanel = new JPanel();
        leftpanel.setBounds(0, 70, 300, 1080);
        leftpanel.setBackground(new Color(66,155,245));
        
        profileButton = new JButton();
        profileButton.setText("My Profile");
        profileButton.setPreferredSize(new java.awt.Dimension(200, 40));
        profileButton.setBounds(10,80,300,40);
        profileButton.setBackground(new Color(66, 200, 245));
        profileButton.addActionListener(this);

        JButton stock_books = new JButton();
        stock_books.setText("Stock Check");
        stock_books.setPreferredSize(new java.awt.Dimension(200, 40));
        stock_books.setBounds(10,160,300,40);
        stock_books.setBackground(new Color(66, 200, 245));

        JButton number_of_members = new JButton();
        number_of_members.setText("Member list");
        number_of_members.setPreferredSize(new java.awt.Dimension(200, 40));
        number_of_members.setBounds(10,240,300,40);
        number_of_members.setBackground(new Color(66, 200, 245));
        
        add_member = new JButton();
        add_member.setText("Add Member");
        add_member.setPreferredSize(new java.awt.Dimension(200, 40));
        add_member.setBounds(10,320,300,40);
        add_member.setBackground(new Color(66, 200, 245));
		add_member.addActionListener(this);

        add_librarian = new JButton();
        add_librarian.setText("Add Librarian");
        add_librarian.setPreferredSize(new java.awt.Dimension(200, 40));
        add_librarian.setBounds(10,400,300,40);
        add_librarian.setBackground(new Color(66, 200, 245));
		add_librarian.addActionListener(this);

        JButton fees_for_member = new JButton();
        fees_for_member.setText("Fees For Member");
        fees_for_member.setPreferredSize(new java.awt.Dimension(200, 40));
        fees_for_member.setBounds(10,480,300,40);
        fees_for_member.setBackground(new Color(66, 200, 245));

        rules_regulation = new JButton();
        rules_regulation.setText("Rules And Regulation");
        rules_regulation.setPreferredSize(new java.awt.Dimension(200, 40));
        rules_regulation.setBounds(10,560,300,40);
        rules_regulation.setBackground(new Color(66, 200, 245)); 
		rules_regulation.addActionListener(this);
        
        

        Book= new JButton();
        Book.setText("Books Information");
        Book.setPreferredSize(new java.awt.Dimension(200, 40));
        Book.setBounds(10,720,300,40);
        Book.setBackground(new Color(66, 200, 245));
        Book.addActionListener(this);
         
        rent_book = new JButton();
        rent_book.setText("Borrow book list");
        rent_book.setPreferredSize(new java.awt.Dimension(200, 40));
        rent_book.setBounds(10,800,300,40);
        rent_book.setBackground(new Color(66, 200, 245));
        rent_book.addActionListener(this);
		
		
        JButton Sold_Book = new JButton();
        Sold_Book.setText("Sold Book");
        Sold_Book.setPreferredSize(new java.awt.Dimension(200, 40));
        Sold_Book.setBounds(10,800,300,40);
        Sold_Book.setBackground(new Color(66, 200, 245));

        JButton edit_profile = new JButton();
        edit_profile.setText("Edit Profile");
        edit_profile.setPreferredSize(new java.awt.Dimension(200, 40));
        edit_profile.setBounds(10,880,300,40);
        edit_profile.setBackground(new Color(66, 200, 245));
        
        log_out = new JButton();
        log_out.setText("Log Out");
        log_out.setPreferredSize(new java.awt.Dimension(200, 40));
        log_out.setBounds(10,960,300,40);
        log_out.setBackground(new Color(66, 200, 245));
        log_out.addActionListener(this);

        dashboard = new ImageIcon("D:\\LibraryManageementSystem\\dashboard(1).jpg");
        
        largestpanel = new JPanel();
        largestpanel.setBounds(300,20,1300,800);
        largestpanel.setBackground(Color.LIGHT_GRAY);
        largestpanel.setLayout(null);

        JLabel first_label= new JLabel();
        first_label.setIcon(dashboard);
        first_label.setBounds(0,0,1620,1010);

    
      
        leftpanel.add(profileButton);
        leftpanel.add(stock_books);
        leftpanel.add(add_member);
        leftpanel.add(number_of_members);
        leftpanel.add(add_librarian);
        leftpanel.add(fees_for_member);
        leftpanel.add(rules_regulation);
        leftpanel.add(Book);
        leftpanel.add(rent_book);
        leftpanel.add(Sold_Book);
        leftpanel.add(edit_profile);
        leftpanel.add(log_out);
        this.add(leftpanel);
    

        upperpanel.add(logo);
        upperpanel.add(Library_Name);
        this.add(upperpanel);


        largestpanel.add(first_label);
        this.add(largestpanel);


        this.setTitle("Admin Dashboard");
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
        if(e.getSource() == Book)
        {
            largestpanel.removeAll();
            Book bookPanel = new Book();
            largestpanel.add(bookPanel);
            largestpanel.revalidate();
            largestpanel.repaint();

        }
		
		if(e.getSource() == rules_regulation)
		{
            largestpanel.removeAll();
            largestpanel.add(new Rules_regulation());
            largestpanel.revalidate();
            largestpanel.repaint();
        }

        if (e.getSource() == log_out) {
        largestpanel.removeAll();               
        LogOut logoutPanel = new LogOut();

        logoutPanel.setBounds(0, 0, largestpanel.getWidth(), largestpanel.getHeight());
        largestpanel.add(logoutPanel);

        largestpanel.revalidate();
        largestpanel.repaint();
		}
		if(e.getSource() == add_librarian)
		{
            largestpanel.removeAll();
            largestpanel.add(new Librarian());
            largestpanel.revalidate();
            largestpanel.repaint();
        }
		
		if(e.getSource() == rent_book )
		{
            largestpanel.removeAll();
            largestpanel.add(new BorrowBook());
            largestpanel.revalidate();
            largestpanel.repaint();
        }
		
		if (e.getSource()== add_member)
		{
            new NewPage();
        }
    }
    
    public static void main(String[] args) {
        new dashboard();
    }
}
