import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

 class alogin extends JFrame {
    public alogin() {
        ImageIcon i = new ImageIcon("D:\\learning_java\\Library_Management_System\\image.png");
        ImageIcon i1 = new ImageIcon("D:\\learning_java\\Library_Management_System\\lib(1).jpg");

        JLabel l = new JLabel();
        l.setIcon(i1);
        l.setBounds(0, 0, 500, 700);
        JPanel p = new JPanel();
        p.setBounds(500, 0, 500, 700);
        p.setBackground(Color.LIGHT_GRAY);

        JLabel textLabel = new JLabel("Welcome to our Library");
        textLabel.setBounds(50, 100, 400, 30);
        textLabel.setFont(new Font("Arial", Font.BOLD, 30));
        p.setLayout(null);
        p.add(textLabel);

        JLabel username = new JLabel("Username :");
        username.setFont(new Font(null, Font.BOLD, 15));
        username.setBounds(50, 300, 200, 30);

        JTextField usernamefield = new JTextField();
        usernamefield.setBounds(150, 300, 200, 30);
        usernamefield.setFont(new Font(null, Font.BOLD, 13));

        JComboBox<String> login = new JComboBox<>(new String[]{
            "Admin", "Librarian"
        });
        login.setBounds(350, 300, 100, 30);

        p.add(login);
        p.add(username);
        p.add(usernamefield);

        JLabel password = new JLabel("Password :");
        password.setFont(new Font(null, Font.BOLD, 15));
        password.setBounds(50, 350, 200, 30);

        JPasswordField password1 = new JPasswordField();
        password1.setBounds(150, 350, 200, 30);
        password1.setFont(new Font(null, Font.BOLD, 13));
        p.add(password);
        p.add(password1);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        this.setLayout(null);
        this.setIconImage(i.getImage());

        JButton b = new JButton("Login");
        b.setBounds(200, 400, 100, 30);

        p.add(b);
        this.add(p);
        this.add(l);

        this.setVisible(true);

        addEnterKeyNavigation(usernamefield, password1);
        addEnterKeyNavigation(password1, b);

        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String select_role = (String) login.getSelectedItem();
                String user_name = usernamefield.getText();
                String password = new String(password1.getPassword());

                if ("Admin".equals(select_role)) {
                    if (validateCredentials(user_name, password)) {
                        JOptionPane.showMessageDialog(p, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        new Admin_dashboard().setVisible(true);
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(p, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else if("Librarian".equals(select_role)) {
                    if (validateCredentials(user_name, password)) {
                        JOptionPane.showMessageDialog(p, "Login Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        new Librarian_dashboard().setVisible(true);
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(p, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    
                }
            }
        });
    }

    private void addEnterKeyNavigation(JComponent currentComponent, JComponent nextComponent) {
        currentComponent.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "moveFocus");
        currentComponent.getActionMap().put("moveFocus", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextComponent.requestFocus(); 
            }
        });
    }

    private boolean validateCredentials(String username, String password) {
        String admin_login = "D:\\learning_java\\Library_Management_System\\Admin_Login_info.txt";
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(admin_login))) {
            String line;
            while ((line = bufferedreader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String U_name = parts[0].trim();
                    String P_password = parts[1].trim();
                    if (username.equals(U_name) && password.equals(P_password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error reading credentials file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    public static void main(String[] args) {
        new alogin();
    }
}
