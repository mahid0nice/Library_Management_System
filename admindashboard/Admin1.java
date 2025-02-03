package admindashboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Admin1 extends JFrame implements ActionListener {
    JButton profileButton, stock_books, number_of_members, Sold_Book_List, add_librarian, fees_for_member,
            rules_regulation, name_of_writer, books_title, rent_book, Sold_Book, request_membership,
            edit_profile, log_out;
    JPanel largestpanel;
    ImageIcon icon, loogo, dashboard;
    private static List<String> membershipRequests = new ArrayList<>(); // Store usernames
    private static DefaultListModel<String> requestListModel = new DefaultListModel<>(); // List model for requests
    private JList<String> requestList;
    private static final String FILE_PATH = "D:\\learning_java\\Library_Management_System\\memberrequest.txt";

    public Admin1() {
        icon = new ImageIcon("D:\\learning_java\\Library_Management_System\\image.png");
        loogo = new ImageIcon("D:\\learning_java\\Library_Management_System\\logo1(1).jpg");
        this.setSize(1920, 1080);
        this.setLayout(null);
        this.setIconImage(icon.getImage());
        initializeUI();
        this.setTitle("Admin Dashboard");
        this.setVisible(true);
    }

    private void initializeUI() {
        JPanel upperpanel = new JPanel();
        upperpanel.setBounds(0, 0, 1920, 70);
        upperpanel.setBackground(new Color(192, 162, 219));
        upperpanel.setLayout(null);

        JLabel logo = new JLabel();
        logo.setBounds(0, 0, 100, 70);
        logo.setIcon(loogo);

        JLabel Library_Name = new JLabel("The Realm Of Reads");
        Library_Name.setFont(new Font("Courier New", Font.BOLD, 20));
        Library_Name.setHorizontalAlignment(JLabel.RIGHT);
        Library_Name.setBounds(110, 0, 250, 70);

        JPanel leftpanel = new JPanel();
        leftpanel.setBounds(0, 70, 300, 1080);
        leftpanel.setBackground(new Color(66, 155, 245));

        profileButton = createButton("My Profile", 10, 80);
        stock_books = createButton("Stock Check", 10, 160);
        number_of_members = createButton("Member list", 10, 240);
        Sold_Book_List = createButton("Sold Book List", 10, 320);
        add_librarian = createButton("Add Librarian", 10, 400);
        fees_for_member = createButton("Fees For Member", 10, 480);
        rules_regulation = createButton("Rules And Regulation", 10, 560);
        name_of_writer = createButton("Writer List", 10, 640);
        books_title = createButton("Books Title", 10, 720);
        rent_book = createButton("Borrow book list", 10, 800);
        Sold_Book = createButton("Sold Book", 10, 880);
        request_membership = createButton("Request of membership", 10, 960);
        edit_profile = createButton("Edit Profile", 10, 1040);
        log_out = createButton("Log Out", 10, 1120);

        dashboard = new ImageIcon("D:\\learning_java\\Library_Management_System\\dashboard(1).jpg");

        largestpanel = new JPanel();
        largestpanel.setBounds(300, 70, 1620, 1010);
        largestpanel.setBackground(Color.LIGHT_GRAY);
        largestpanel.setLayout(new BorderLayout());

        JLabel first_label = new JLabel();
        first_label.setIcon(dashboard);
        first_label.setBounds(0, 0, 1620, 1080);

        leftpanel.add(profileButton);
        leftpanel.add(stock_books);
        leftpanel.add(Sold_Book_List);
        leftpanel.add(number_of_members);
        leftpanel.add(add_librarian);
        leftpanel.add(fees_for_member);
        leftpanel.add(rules_regulation);
        leftpanel.add(name_of_writer);
        leftpanel.add(books_title);
        leftpanel.add(rent_book);
        leftpanel.add(Sold_Book);
        leftpanel.add(request_membership);
        leftpanel.add(edit_profile);
        leftpanel.add(log_out);

        this.add(leftpanel);
        upperpanel.add(logo);
        upperpanel.add(Library_Name);
        this.add(upperpanel);
        largestpanel.add(first_label);
        this.add(largestpanel);
    }

    private JButton createButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 40));
        button.setBounds(x, y, 300, 40);
        button.setBackground(new Color(66, 200, 245));
        button.addActionListener(this);
        return button;
    }

    private void showMembershipRequests() {
        // Read the file and populate the request list
        membershipRequests.clear();
        requestListModel.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 1 || !parts[1].equals("1")) {
                    membershipRequests.add(parts[0]);
                    requestListModel.addElement(parts[0]);
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading file: " + ex.getMessage());
        }

        // Display the requests in a new frame
        JFrame requestFrame = new JFrame("Membership Requests");
        requestFrame.setSize(400, 300);
        requestFrame.setLayout(new BorderLayout());

        requestList = new JList<>(requestListModel);
        JScrollPane scrollPane = new JScrollPane(requestList);
        requestFrame.add(scrollPane, BorderLayout.CENTER);

        JButton approveButton = new JButton("Approve");
        approveButton.addActionListener(e -> approveRequest());
        requestFrame.add(approveButton, BorderLayout.SOUTH);

        requestFrame.setVisible(true);
    }

    private void approveRequest() {
        String selectedRequest = requestList.getSelectedValue();
        if (selectedRequest != null) {
            int response = JOptionPane.showConfirmDialog(
                    this,
                    "Approve membership request for " + selectedRequest + "?",
                    "Approve Request",
                    JOptionPane.YES_NO_OPTION
            );

            if (response == JOptionPane.YES_OPTION) {
                // Update the file to add ",1" beside the username
                updateFile(selectedRequest);

                // Remove the request from the list
                membershipRequests.remove(selectedRequest);
                requestListModel.removeElement(selectedRequest);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a request to approve.");
        }
    }

    private void updateFile(String username) {
        try {
            // Read the file and update the line with the username
            File file = new File(FILE_PATH);
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith(username + ",") || line.equals(username)) {
                    line = username + ",1"; // Add ",1" to indicate approval
                }
                content.append(line).append("\n");
            }
            reader.close();

            // Write the updated content back to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(content.toString());
            writer.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error updating file: " + ex.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == profileButton) {
            largestpanel.removeAll();
            largestpanel.add(new ProfilePanel());
            largestpanel.revalidate();
            largestpanel.repaint();
        }  else if (e.getSource() == rules_regulation) {
            largestpanel.removeAll();
            largestpanel.add(new Rules_by_admin());
            largestpanel.revalidate();
            largestpanel.repaint();
        } else if (e.getSource() == edit_profile) {
            largestpanel.removeAll();
            largestpanel.add(new UpdateProfileWithPhoto());
            largestpanel.revalidate();
            largestpanel.repaint();
        } else if (e.getSource() == log_out) {
            this.dispose();
            new alogin();
        } else if (e.getSource() == request_membership) {
            showMembershipRequests();
        }
    }

    public static void main(String[] args) {
        new Admin1();
    }
}