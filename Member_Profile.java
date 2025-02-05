import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class MemberProfile extends JPanel {
    MemberProfile(String username) {  
        setBounds(0, 0, 950, 730);
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel lblName = new JLabel("Profile: " + username);
        lblName.setFont(new Font("Courier New", Font.BOLD, 18));
        lblName.setBounds(50, 20, 400, 25);
        add(lblName);

        JTextArea txtDetails = new JTextArea();
        txtDetails.setEditable(false);
        txtDetails.setFont(new Font("Courier New", Font.BOLD, 16));
        txtDetails.setBackground(Color.PINK);
        txtDetails.setLineWrap(true);
        txtDetails.setWrapStyleWord(true);

        JScrollPane scrollDetails = new JScrollPane(txtDetails);
        scrollDetails.setBounds(50, 60, 850, 600);
        scrollDetails.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(scrollDetails);

        // Load profile data
        loadProfileData(username, txtDetails);
    }

    private void loadProfileData(String username, JTextArea txtDetails) {
        String filePath = "D:\\LibraryManageementSystem\\Members_with_credentials.txt";
        boolean userFound = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 15 && parts[13].trim().equals(username)) { 
                    txtDetails.setText(
                        "Full Name      : " + parts[0].trim() + " " + parts[1].trim() + "\n" +
                        "Contact        : " + parts[2].trim() + "\n" +
                        "Email          : " + parts[3].trim() + "\n" +
                        "Institution    : " + parts[6].trim() + "\n" +
                        "University     : " + parts[7].trim() + "\n" +
                        "Address        : " + parts[8].trim() + "\n" +
                        "Father's Name  : " + parts[9].trim() + "\n" +
                        "Mother's Name  : " + parts[10].trim() + "\n" +
                        "Membership     : " + parts[11].trim() + "\n" +
                        "Fees           : " + parts[12].trim() + " Taka"
                    );
                    userFound = true;
                    break;
                }
            }

            if (!userFound) {
                txtDetails.setText("No profile data found for user: " + username);
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading profile: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
