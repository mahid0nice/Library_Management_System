/*import javax.swing.*;
import java.awt.*;
import java.io.*;

public class UpdateProfileWithPhoto extends JPanel {
    private JTextField adminInfoField;
    private JTextField adminEmailField;
    private JTextField adminAddressField;
    private JTextField adminNumberField;
    private JButton updateButton, uploadPhotoButton;
    private JLabel profilePhotoLabel;
    private String photoPath = "D:\\learning_java\\Library_Management_System\\profile.jpg"; // Default profile photo path

    public UpdateProfileWithPhoto() {
        this.setBounds(0, 0, 800, 600);
        this.setLayout(null);

        profilePhotoLabel = new JLabel();
        profilePhotoLabel.setBounds(50, 20, 150, 150);
        profilePhotoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        loadProfilePhoto(); 
        this.add(profilePhotoLabel);

        uploadPhotoButton = new JButton("Upload Photo");
        uploadPhotoButton.setFont(new Font("Courier New", Font.BOLD, 12));
        uploadPhotoButton.setBounds(50, 180, 150, 30);
        uploadPhotoButton.addActionListener(e -> uploadPhoto());
        this.add(uploadPhotoButton);

        JLabel adminNameLabel = new JLabel("Name:");
        adminNameLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        adminNameLabel.setBounds(250, 50, 100, 30);
        this.add(adminNameLabel);

        adminInfoField = createTextField(350, 50, 300, 30);

        JLabel adminEmailLabel = new JLabel("Email:");
        adminEmailLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        adminEmailLabel.setBounds(250, 100, 100, 30);
        this.add(adminEmailLabel);

        adminEmailField = createTextField(350, 100, 300, 30);

        JLabel adminAddressLabel = new JLabel("Address:");
        adminAddressLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        adminAddressLabel.setBounds(250, 150, 100, 30);
        this.add(adminAddressLabel);

        adminAddressField = createTextField(350, 150, 300, 30);

        JLabel adminNumberLabel = new JLabel("Phone Number:");
        adminNumberLabel.setFont(new Font("Courier New", Font.BOLD, 16));
        adminNumberLabel.setBounds(250, 200, 150, 30);
        this.add(adminNumberLabel);

        adminNumberField = createTextField(350, 200, 300, 30);

        loadProfileData();

        
        updateButton = new JButton("Update Profile");
        updateButton.setFont(new Font("Courier New", Font.BOLD, 16));
        updateButton.setBounds(250, 300, 200, 40);
        updateButton.addActionListener(e -> updateProfile());
        this.add(updateButton);
    }

    private JTextField createTextField(int x, int y, int width, int height) {
        JTextField textField = new JTextField();
        textField.setFont(new Font("Courier New", Font.PLAIN, 16));
        textField.setBounds(x, y, width, height);
        this.add(textField);
        return textField;
    }

    private void loadProfilePhoto() {
        
        ImageIcon image = new ImageIcon(photoPath);
        Image scaledImage = image.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        profilePhotoLabel.setIcon(new ImageIcon(scaledImage));
    }

    private void uploadPhoto() {
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        fileChooser.setDialogTitle("Select Profile Photo");

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            photoPath = selectedFile.getAbsolutePath();
            loadProfilePhoto(); 
        }
    }

    private void loadProfileData() {
        File file = new File("D:\\learning_java\\java_learning\\admin.txt");
        if (!file.exists()) {
            JOptionPane.showMessageDialog(this, "Profile data file not found!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                String[] details = line.split(",");
                if (details.length == 4) {
                    adminInfoField.setText(details[0].trim());
                    adminEmailField.setText(details[1].trim());
                    adminAddressField.setText(details[2].trim());
                    adminNumberField.setText(details[3].trim());
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid data format in profile file.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading profile data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateProfile() {
        File file = new File("D:\\learning_java\\java_learning\\admin.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(adminInfoField.getText().trim() + "," +
                    adminEmailField.getText().trim() + "," +
                    adminAddressField.getText().trim() + "," +
                    adminNumberField.getText().trim());
            JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error updating profile: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Update Profile with Photo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new UpdateProfileWithPhoto());
        frame.setVisible(true);
        
    }
    }
     */

     import javax.swing.*;
     import java.awt.*;
     import java.io.*;
     
     public class UpdateProfileWithPhoto extends JPanel {
         private JTextField adminInfoField;
         private JTextField adminEmailField;
         private JTextField adminAddressField;
         private JTextField adminNumberField;
         private JButton updateButton, uploadPhotoButton;
         private JLabel profilePhotoLabel;
         private String photoPath = "D:\\learning_java\\Library_Management_System\\Admin_Photo_path.txt"; // Default profile photo path
     
         public UpdateProfileWithPhoto() {
             this.setBounds(0, 0, 800, 600);
             this.setLayout(null);
     
             profilePhotoLabel = new JLabel();
             profilePhotoLabel.setBounds(50, 20, 150, 150);
             profilePhotoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
             loadProfilePhoto();
             this.add(profilePhotoLabel);
     
             uploadPhotoButton = new JButton("Upload Photo");
             uploadPhotoButton.setFont(new Font("Courier New", Font.BOLD, 12));
             uploadPhotoButton.setBounds(50, 180, 150, 30);
             uploadPhotoButton.addActionListener(e -> uploadPhoto());
             this.add(uploadPhotoButton);
     
             JLabel adminNameLabel = new JLabel("Name:");
             adminNameLabel.setFont(new Font("Courier New", Font.BOLD, 16));
             adminNameLabel.setBounds(250, 50, 100, 30);
             this.add(adminNameLabel);
     
             adminInfoField = createTextField(450, 50, 300, 30);
     
             JLabel adminEmailLabel = new JLabel("Email:");
             adminEmailLabel.setFont(new Font("Courier New", Font.BOLD, 16));
             adminEmailLabel.setBounds(250, 100, 100, 30);
             this.add(adminEmailLabel);
     
             adminEmailField = createTextField(450, 100, 300, 30);
     
             JLabel adminAddressLabel = new JLabel("Address:");
             adminAddressLabel.setFont(new Font("Courier New", Font.BOLD, 16));
             adminAddressLabel.setBounds(250, 150, 100, 30);
             this.add(adminAddressLabel);
     
             adminAddressField = createTextField(450, 150, 300, 30);
     
             JLabel adminNumberLabel = new JLabel("Phone Number:");
             adminNumberLabel.setFont(new Font("Courier New", Font.BOLD, 16));
             adminNumberLabel.setBounds(250, 200, 150, 30);
             this.add(adminNumberLabel);
     
             adminNumberField = createTextField(450, 200, 300, 30);
     
             loadProfileData();
     
             updateButton = new JButton("Update Profile");
             updateButton.setFont(new Font("Courier New", Font.BOLD, 16));
             updateButton.setBounds(250, 300, 200, 40);
             updateButton.addActionListener(e -> updateProfile());
             this.add(updateButton);
         }
     
         private JTextField createTextField(int x, int y, int width, int height) {
             JTextField textField = new JTextField();
             textField.setFont(new Font("Courier New", Font.PLAIN, 16));
             textField.setBounds(x, y, width, height);
             this.add(textField);
             return textField;
         }
     
         private void loadProfilePhoto() {
             ImageIcon image = new ImageIcon(photoPath);
             Image scaledImage = image.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
             profilePhotoLabel.setIcon(new ImageIcon(scaledImage));
         }
     
         private void uploadPhoto() {
             JFileChooser fileChooser = new JFileChooser();
             fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
             fileChooser.setDialogTitle("Select Profile Photo");
     
             int result = fileChooser.showOpenDialog(this);
             if (result == JFileChooser.APPROVE_OPTION) {
                 File selectedFile = fileChooser.getSelectedFile();
                 photoPath = selectedFile.getAbsolutePath();
                 loadProfilePhoto();
             }
         }
     
         private void loadProfileData() {
             File file = new File("D:\\learning_java\\java_learning\\admin.txt");
             if (!file.exists()) {
                 JOptionPane.showMessageDialog(this, "Profile data file not found!", "Error", JOptionPane.ERROR_MESSAGE);
                 return;
             }
     
             try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                 String line = reader.readLine();
                 if (line != null) {
                     String[] details = line.split(",");
                     if (details.length == 5) {
                         photoPath = details[0].trim();
                         adminInfoField.setText(details[1].trim());
                         adminEmailField.setText(details[2].trim());
                         adminAddressField.setText(details[3].trim());
                         adminNumberField.setText(details[4].trim());
                         loadProfilePhoto();
                     } else {
                         JOptionPane.showMessageDialog(this, "Invalid data format in profile file.", "Error", JOptionPane.ERROR_MESSAGE);
                     }
                 }
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(this, "Error loading profile data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
         }
     
         private void updateProfile() {
             File file = new File("D:\\learning_java\\java_learning\\admin.txt");
             try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                 writer.write(photoPath + "," +
                         adminInfoField.getText().trim() + "," +
                         adminEmailField.getText().trim() + "," +
                         adminAddressField.getText().trim() + "," +
                         adminNumberField.getText().trim());
                 JOptionPane.showMessageDialog(this, "Profile updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
             } catch (IOException e) {
                 JOptionPane.showMessageDialog(this, "Error updating profile: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
             }
         }
     
     }
       



