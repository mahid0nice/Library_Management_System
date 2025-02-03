import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.table.DefaultTableModel;

class StockCheckPanel extends JPanel {
    private JTextField searchField;
    private JButton searchButton;
    private JTable bookTable;
    private DefaultTableModel tableModel;

    public StockCheckPanel() {
        setLayout(new BorderLayout());

        
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout());
        
        searchField = new JTextField(20);
        searchButton = new JButton("Search");

        searchPanel.add(new JLabel("Search Book: "));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        
        add(searchPanel, BorderLayout.NORTH);

        
        String[] columns = {"Book Name", "Quantity"};
        tableModel = new DefaultTableModel(columns, 0);
        bookTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(bookTable);
        add(scrollPane, BorderLayout.CENTER);

        
        loadBooks();

        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBook();
            }
        });
    }

    
    private void loadBooks() {
        String filePath = "C:\\All\\Code\\Library_Management_System\\stockcheck.txt"; 
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(","); 
                if (bookData.length == 2) {
                    String bookName = bookData[0].trim();
                    String quantity = bookData[1].trim();
                    tableModel.addRow(new Object[]{bookName, quantity});
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading the file", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    private void searchBook() {
        String searchQuery = searchField.getText().trim().toLowerCase();
        boolean found = false;
        
        
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String bookName = tableModel.getValueAt(i, 0).toString().toLowerCase();
            if (bookName.contains(searchQuery)) {
                
                bookTable.setRowSelectionInterval(i, i);
                found = true;
                break;
            }
        }

        if (!found) {
            JOptionPane.showMessageDialog(this, "Book not found!", "Search Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}