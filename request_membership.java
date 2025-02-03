
import javax.swing.*;
import java.awt.*;
import java.io.*;

 class request_membership extends JPanel {
    public request_membership() {
        this.setBounds(0, 0, 1620, 1010);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);

        JLabel picture = new JLabel();
        picture.setBounds(50, 50, 300, 300);
        this.add(picture);

        JLabel adminNameLabel = new JLabel("Name:");
        adminNameLabel.setFont(new Font("Courier New", Font.BOLD, 18));
        adminNameLabel.setBounds(50, 400, 100, 25);
        this.add(adminNameLabel);

        JTextArea adminInfo = new JTextArea();
        adminInfo.setEditable(false);
        adminInfo.setFont(new Font("Courier New", Font.BOLD, 18));
        adminInfo.setBackground(Color.PINK);
        adminInfo.setBounds(150, 400, 400, 25);
        this.add(adminInfo);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Courier New", Font.BOLD, 18));
        emailLabel.setBounds(50, 450, 100, 25);
        this.add(emailLabel);

        JTextArea adminEmail = new JTextArea();
        adminEmail.setEditable(false);
        adminEmail.setFont(new Font("Courier New", Font.BOLD, 18));
        adminEmail.setBackground(Color.PINK);
        adminEmail.setBounds(150, 450, 400, 25);
        this.add(adminEmail);

        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setFont(new Font("Courier New", Font.BOLD, 18));
        addressLabel.setBounds(50, 500, 100, 25);
        this.add(addressLabel);

        JTextArea adminAddress = new JTextArea();
        adminAddress.setEditable(false);
        adminAddress.setFont(new Font("Courier New", Font.BOLD, 18));
        adminAddress.setBackground(Color.PINK);
        adminAddress.setBounds(150, 500, 400, 25);
        this.add(adminAddress);

        JLabel phoneLabel = new JLabel("Phone:");
        phoneLabel.setFont(new Font("Courier New", Font.BOLD, 18));
        phoneLabel.setBounds(50, 550, 100, 25);
        this.add(phoneLabel);

        JTextArea adminPhone = new JTextArea();
        adminPhone.setEditable(false);
        adminPhone.setFont(new Font("Courier New", Font.BOLD, 18));
        adminPhone.setBackground(Color.PINK);
        adminPhone.setBounds(150, 550, 400, 25);
        this.add(adminPhone);

        try (BufferedReader reader = new BufferedReader(new FileReader("D:\\learning_java\\java_learning\\admin.txt"))) {
            String line = reader.readLine();
            if (line != null) {
                String[] details = line.split(",");
                if (details.length == 5) {
                    String photoPath = details[0];
                    String name = details[1];
                    String email = details[2];
                    String address = details[3];
                    String phone = details[4];

                    adminInfo.setText(name);
                    adminEmail.setText(email);
                    adminAddress.setText(address);
                    adminPhone.setText(phone);

                    ImageIcon image = new ImageIcon(photoPath);
                    Image scaledImage = image.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    picture.setIcon(new ImageIcon(scaledImage));
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid data format in profile file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading profile data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
