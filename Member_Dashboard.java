import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MemberDashboard extends JFrame implements ActionListener {

    private JPanel largestpanel;
    private JButton profileButton, bookHistoryButton, logOutButton;
    private String username; 

    MemberDashboard(String username) {
        this.username = username;

        setTitle("Member Dashboard");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        JPanel topPanel = new JPanel();
        topPanel.setBounds(0, 0, 1200, 70);
        topPanel.setBackground(new Color(192, 162, 219));
        topPanel.setLayout(null);

        ImageIcon logoIcon = new ImageIcon("D:\\LibraryManageementSystem\\Membership_logo.png");
        JLabel logo = new JLabel();
        logo.setBounds(0, 0, 70, 70);
        logo.setIcon(logoIcon);
        topPanel.add(logo);

        JLabel libraryName = new JLabel("The Realm Of Reads (Member)");
        libraryName.setFont(new Font("Courier New", Font.BOLD, 20));
        libraryName.setBounds(80, 0, 500, 70);
        topPanel.add(libraryName);

        add(topPanel);

     
        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 70, 250, 730);
        leftPanel.setBackground(new Color(66, 155, 245));
        leftPanel.setLayout(null);

        profileButton = new JButton("My Profile");
        profileButton.setBounds(10, 40, 230, 40);
        profileButton.setBackground(new Color(66, 200, 245));
        profileButton.addActionListener(this);
        leftPanel.add(profileButton);

        bookHistoryButton = new JButton("Book History");
        bookHistoryButton.setBounds(10, 100, 230, 40);
        bookHistoryButton.setBackground(new Color(66, 200, 245));
        bookHistoryButton.addActionListener(this);
        leftPanel.add(bookHistoryButton);

        logOutButton = new JButton("Log Out");
        logOutButton.setBounds(10, 160, 230, 40);
        logOutButton.setBackground(new Color(66, 200, 245));
        logOutButton.addActionListener(this);
        leftPanel.add(logOutButton);

        add(leftPanel);

        
        largestpanel = new JPanel();
        largestpanel.setBounds(250, 70, 950, 730);
        largestpanel.setBackground(Color.LIGHT_GRAY);
        largestpanel.setLayout(null);
        add(largestpanel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileButton) {
            largestpanel.removeAll();
            largestpanel.add(new MemberProfile(username));  
            largestpanel.revalidate();
            largestpanel.repaint();
        }
        if (e.getSource() == bookHistoryButton) {
            largestpanel.removeAll();
            largestpanel.add(new BookHistory(username)); 
            largestpanel.revalidate();
            largestpanel.repaint();
        }
        if (e.getSource() == logOutButton) {
            new Member_Login().setVisible(true);
            dispose();
        }
    }

    public static void main(String[] args) {
        new MemberDashboard("test_user"); 
    }
}
