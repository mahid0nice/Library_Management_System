import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

class SoldBookPanel extends JPanel {
    private JTextField bookNameField, writerNameField, dateField, priceField;
    private JButton sellButton;

    public SoldBookPanel() {
        setLayout(new GridBagLayout()); /
        setBackground(new Color(210, 180, 222)); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Book Name:"), gbc);
        gbc.gridx = 1;
        bookNameField = new JTextField(15);
        add(bookNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Writer's Name:"), gbc);
        gbc.gridx = 1;
        writerNameField = new JTextField(15);
        add(writerNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Selling Date (YYYY-MM-DD):"), gbc);
        gbc.gridx = 1;
        dateField = new JTextField(15);
        add(dateField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("Price:"), gbc);
        gbc.gridx = 1;
        priceField = new JTextField(15);
        add(priceField, gbc);

        sellButton = new JButton("Sell Book");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(sellButton, gbc);

        sellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSoldBook();
            }
        });
    }

    private void saveSoldBook() {
        String bookName = bookNameField.getText().trim();
        String writerName = writerNameField.getText().trim();
        String date = dateField.getText().trim();
        String price = priceField.getText().trim();

        if (bookName.isEmpty() || writerName.isEmpty() || date.isEmpty() || price.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String data = bookName + "," + writerName + "," + date + "," + price + "\n";
        String filePath = "C:\\All\\Code\\Library_Management_System\\soldbooklist.txt";
        
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(data);
            JOptionPane.showMessageDialog(this, "Book Sold Successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error saving book details!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        bookNameField.setText("");
        writerNameField.setText("");
        dateField.setText("");
        priceField.setText("");
    }
}
