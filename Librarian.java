import java.awt.Color;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;

class Librarian extends JFrame implements ActionListener {

    JTextField firstname_f, lastname_f, contactnumber_f, email_f, permanentaddress_f, homeaddress_f, fathersname_f, mothersname_f;
    JComboBox<Integer> dayComboBox, yearComboBox;
    JComboBox<String> monthComboBox, bloodGroupComboBox;
    JButton confirmButton, cancelButton;

    Librarian() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLayout(null);

        ImageIcon icon = new ImageIcon("D:\\LibraryManageementSystem\\image.png");
        ImageIcon i1 = new ImageIcon("D:\\LibraryManageementSystem\\librarian.jpg");

        this.setIconImage(icon.getImage());

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.LIGHT_GRAY);
        leftPanel.setBounds(0, 0, 500, 700);
        leftPanel.setLayout(null);

        JLabel firstName = new JLabel("First Name:");
        firstName.setBounds(20, 60, 100, 15);
        firstname_f = new JTextField();
        firstname_f.setBounds(200, 60, 230, 20);

        JLabel lastName = new JLabel("Last Name:");
        lastName.setBounds(20, 90, 100, 15);
        lastname_f = new JTextField();
        lastname_f.setBounds(200, 90, 230, 20);

        JLabel contactNumber = new JLabel("Contact Number:");
        contactNumber.setBounds(20, 120, 100, 15);
        contactnumber_f = new JTextField();
        contactnumber_f.setBounds(200, 120, 230, 20);

        JLabel email = new JLabel("Email:");
        email.setBounds(20, 150, 100, 15);
        email_f = new JTextField();
        email_f.setBounds(200, 150, 230, 20);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(20, 210, 100, 15);

        dayComboBox = new JComboBox<>();
        for (int i = 1; i <= 31; i++) {
            dayComboBox.addItem(i);
        }
        dayComboBox.setBounds(200, 210, 60, 20);

        monthComboBox = new JComboBox<>(new String[]{
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
        });
        monthComboBox.setBounds(270, 210, 100, 20);

        yearComboBox = new JComboBox<>();
        for (int i = 1990; i <= 2020; i++) {
            yearComboBox.addItem(i);
        }
        yearComboBox.setBounds(380, 210, 80, 20);

        JLabel bloodGroup = new JLabel("Blood Group:");
        bloodGroup.setBounds(20, 240, 100, 15);
        bloodGroupComboBox = new JComboBox<>(new String[]{"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"});
        bloodGroupComboBox.setBounds(200, 240, 100, 20);

        JLabel universityLabel = new JLabel("University: American International University-Bangladesh");
        universityLabel.setBounds(20, 270, 400, 15);

        JLabel permanentAddress = new JLabel("Permanent Address:");
        permanentAddress.setBounds(20, 300, 150, 15);
        permanentaddress_f = new JTextField();
        permanentaddress_f.setBounds(200, 300, 230, 20);

        JLabel homeAddress = new JLabel("Home Address:");
        homeAddress.setBounds(20, 330, 150, 15);
        homeaddress_f = new JTextField();
        homeaddress_f.setBounds(200, 330, 230, 20);

        JLabel fathersName = new JLabel("Father's Name:");
        fathersName.setBounds(20, 360, 150, 15);
        fathersname_f = new JTextField();
        fathersname_f.setBounds(200, 360, 230, 20);

        JLabel mothersName = new JLabel("Mother's Name:");
        mothersName.setBounds(20, 390, 150, 15);
        mothersname_f = new JTextField();
        mothersname_f.setBounds(200, 390, 230, 20);

        confirmButton = new JButton("Confirm Registration");
        confirmButton.setBounds(40, 530, 200, 25);
        confirmButton.addActionListener(this);

        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(260, 530, 100, 25);
        cancelButton.addActionListener(this);

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(500, 0, 500, 700);

        JLabel pic = new JLabel();
        pic.setIcon(i1);
        pic.setBounds(500, 0, 500, 700);

        leftPanel.add(firstName);
        leftPanel.add(firstname_f);

        leftPanel.add(lastName);
        leftPanel.add(lastname_f);

        leftPanel.add(contactNumber);
        leftPanel.add(contactnumber_f);

        leftPanel.add(email);
        leftPanel.add(email_f);

        leftPanel.add(dob);

        leftPanel.add(dayComboBox);
        leftPanel.add(monthComboBox);
        leftPanel.add(yearComboBox);

        leftPanel.add(bloodGroup);
        leftPanel.add(bloodGroupComboBox);

        leftPanel.add(universityLabel);

        leftPanel.add(permanentAddress);
        leftPanel.add(permanentaddress_f);

        leftPanel.add(homeAddress);
        leftPanel.add(homeaddress_f);

        leftPanel.add(fathersName);
        leftPanel.add(fathersname_f);

        leftPanel.add(mothersName);
        leftPanel.add(mothersname_f);

        leftPanel.add(confirmButton);

        leftPanel.add(cancelButton);

        rightPanel.add(pic);

        this.add(leftPanel);
        this.add(rightPanel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == confirmButton) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\LibraryManageementSystem\\librarian_info.txt", true))) {

                writer.write(
                    firstname_f.getText() + "," + lastname_f.getText() + "," + contactnumber_f.getText() + "," + email_f.getText() + "," + dayComboBox.getSelectedItem() + "/" +
                    monthComboBox.getSelectedItem() + "/" + yearComboBox.getSelectedItem() + "," + bloodGroupComboBox.getSelectedItem() + "," +
                    permanentaddress_f.getText() + "," + homeaddress_f.getText() + "," + fathersname_f.getText() + "," + mothersname_f.getText());
                writer.newLine();
                JOptionPane.showMessageDialog(this, "Registration Successful!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error saving data: " + ex.getMessage());
            }
        } else if (e.getSource() == cancelButton) {
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Librarian();
    }
}