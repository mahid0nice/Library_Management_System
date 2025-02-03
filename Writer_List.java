//package Library_Management_System; 

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class WriterListPanel extends JPanel {
    private JTextField searchField;
    private JTextArea resultArea;
    private ArrayList<String> writerNames;

    public WriterListPanel(String filePath) {
        setLayout(new BorderLayout());
        setBackground(new Color(192, 162, 219));

       
        writerNames = new ArrayList<>();
        loadWritersFromFile(filePath);

        
        JPanel searchPanel = new JPanel();
        searchPanel.setBackground(new Color(66, 155, 245));
        searchPanel.setLayout(new FlowLayout());

        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        
        searchPanel.add(new JLabel("Search Writer: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        
        resultArea = new JTextArea();
        resultArea.setEditable(false);
        resultArea.setFont(new Font("Courier New", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(resultArea);

        
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        
        searchButton.addActionListener(e -> searchWriter());
        searchField.addActionListener(e -> searchWriter());
    }

    private void loadWritersFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                writerNames.add(line.trim());
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading writer names.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchWriter() {
        String query = searchField.getText().trim().toLowerCase();
        resultArea.setText("");

        for (String writer : writerNames) {
            if (writer.toLowerCase().contains(query)) {
                resultArea.append(writer + "\n");
            }
        }
    }
}