import javax.swing.*;
import java.awt.*;
import java.io.*;

class BookHistory extends JPanel {
    BookHistory(String username) { 
        setLayout(null);
        setBounds(0, 0, 950, 730);
        setBackground(Color.WHITE);

        JLabel lbl = new JLabel("Book History for " + username);
        lbl.setFont(new Font("Arial", Font.BOLD, 20));
        lbl.setBounds(20, 20, 400, 30);
        add(lbl);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBounds(20, 70, 900, 600);
        add(scrollPane);

        loadBookHistory(username, textArea);
    }

    private void loadBookHistory(String username, JTextArea textArea) {
        String historyFile = "D:\\LibraryManageementSystem\\borrowed.txt";
        try (BufferedReader br = new BufferedReader(new FileReader(historyFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 4 && parts[1].trim().equals(username)) {  
                    textArea.append("Book: " + parts[0] + " | Borrowed: " + parts[2] + " | Return: " + parts[3] + "\n");
                }
            }
        } catch (IOException e) {
            textArea.append("Error reading history file: " + e.getMessage() + "\n");
        }
    }
}

