import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

class SoldBookListPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public SoldBookListPanel() {
        setLayout(new BorderLayout());

        
        String[] columns = {"Serial No.", "Book Name", "Writer Name", "Sell Date", "Price"};
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        
        loadSoldBooks();
    }

    private void loadSoldBooks() {
        String filePath = "C:\\All\\Code\\Library_Management_System\\soldbooklist.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int serialNumber = 1; 
            while ((line = reader.readLine()) != null) {
                String[] bookData = line.split(",");
                if (bookData.length == 4) {
                    String bookName = bookData[0].trim();
                    String writerName = bookData[1].trim();
                    String sellDate = bookData[2].trim();
                    String price = bookData[3].trim();
                    tableModel.addRow(new Object[]{serialNumber, bookName, writerName, sellDate, price});
                    serialNumber++;
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error reading sold book list!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}