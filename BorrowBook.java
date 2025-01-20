import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

class BorrowBook extends JPanel implements ActionListener {

    private static final String BORROWED_FILE = "borrowed.txt";

    private JTextField txtBookTitle, txtBorrower, txtDateBorrowed, txtExpectedReturn;
    private JButton btnAdd;
    private JList<String> lstBorrowed;
    private DefaultListModel<String> listModel;
	
    private ArrayList<BorrowRecord> borrowedRecords;

    BorrowBook() {
        
        setBounds(0, 0, 1620, 1010);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        borrowedRecords = new ArrayList<>();
        listModel = new DefaultListModel<>();

        loadBorrowedFromFile();

        JLabel lblHeader = new JLabel("Borrowed Books", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 28));
  
        lblHeader.setBounds(0, 0, 1620, 50);
        add(lblHeader);

     
        lstBorrowed = new JList<>(listModel);
        lstBorrowed.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        refreshList(); 

        JScrollPane scrollPane = new JScrollPane(lstBorrowed);

        scrollPane.setBounds(50, 70, 800, 500);
        add(scrollPane);

      
        JLabel lblBookTitle = new JLabel("Book Title:");
        lblBookTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        lblBookTitle.setBounds(900, 70, 120, 30);
        add(lblBookTitle);

        txtBookTitle = new JTextField();
        txtBookTitle.setBounds(1020, 70, 300, 30);
        add(txtBookTitle);

        JLabel lblBorrower = new JLabel("Borrower:");
        lblBorrower.setFont(new Font("Arial", Font.PLAIN, 18));
        lblBorrower.setBounds(900, 120, 120, 30);
        add(lblBorrower);

        txtBorrower = new JTextField();
        txtBorrower.setBounds(1020, 120, 300, 30);
        add(txtBorrower);

        JLabel lblDateBorrowed = new JLabel("Date Borrowed (dd/mm/yyyy):");
        lblDateBorrowed.setFont(new Font("Arial", Font.PLAIN, 18));
        lblDateBorrowed.setBounds(900, 170, 300, 30);
        add(lblDateBorrowed);

        txtDateBorrowed = new JTextField();
        txtDateBorrowed.setBounds(1200, 170, 120, 30);
        add(txtDateBorrowed);

        JLabel lblExpectedReturn = new JLabel("Return Date (dd/mm/yyyy):");
        lblExpectedReturn.setFont(new Font("Arial", Font.PLAIN, 18));
        lblExpectedReturn.setBounds(900, 220, 300, 30);
        add(lblExpectedReturn);

        txtExpectedReturn = new JTextField();
        txtExpectedReturn.setBounds(1200, 220, 120, 30);
        add(txtExpectedReturn);

        btnAdd = new JButton("Add Record");
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 16));
        btnAdd.setBounds(1020, 280, 140, 30);
        btnAdd.addActionListener(this);
        add(btnAdd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addBorrowRecord();
        }
    }

    private void addBorrowRecord() {
        String bookTitle       = txtBookTitle.getText().trim();
        String borrower        = txtBorrower.getText().trim();
        String dateBorrowedStr = txtDateBorrowed.getText().trim();
        String expectedReturnStr = txtExpectedReturn.getText().trim();

        if (bookTitle.isEmpty() || borrower.isEmpty()
            || dateBorrowedStr.isEmpty() || expectedReturnStr.isEmpty()) 
        {
            JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        
        int[] borrowedDate;
        try {
            borrowedDate = parseDate(dateBorrowedStr);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Invalid borrowed date: " + ex.getMessage());
            return;
        }

  
        int[] returnDate;
        try {
            returnDate = parseDate(expectedReturnStr);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                "Invalid return date: " + ex.getMessage());
            return;
        }

      
        int borrowedTotal = totalDaysSince2024(borrowedDate[0], borrowedDate[1], borrowedDate[2]);
        int returnTotal   = totalDaysSince2024(returnDate[0], returnDate[1], returnDate[2]);
        int diff = returnTotal - borrowedTotal;
        if (diff != 7) {
            JOptionPane.showMessageDialog(this, 
                "Return date must be exactly 7 days after borrowed date.");
            return;
        }

        
        BorrowRecord newRecord = new BorrowRecord(
            bookTitle, borrower, dateBorrowedStr, expectedReturnStr
        );
        borrowedRecords.add(newRecord);
        refreshList();
        writeBorrowedToFile();

       
        txtBookTitle.setText("");
        txtBorrower.setText("");
        txtDateBorrowed.setText("");
        txtExpectedReturn.setText("");
    }

    private void refreshList() {
        listModel.clear();
        for (BorrowRecord rec : borrowedRecords) {
            String displayLine = String.format(
                "Title: %s | Borrower: %s | Borrowed: %s | Return: %s",
                rec.getBookTitle(), rec.getBorrower(),
                rec.getDateBorrowed(), rec.getExpectedReturn()
            );
            listModel.addElement(displayLine);
        }
    }



    private int[] parseDate(String dateStr) throws Exception {
        String[] parts = dateStr.split("/");
        if (parts.length != 3) {
            throw new Exception("Date format should be dd/mm/yyyy");
        }

        int day   = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year  = Integer.parseInt(parts[2]);

        if (year < 2024 || year > 2025) {
            throw new Exception("Year must be 2024 or 2025");
        }
        if (month < 1 || month > 12) {
            throw new Exception("Month must be 1..12");
        }
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int maxDay = daysInMonth[month - 1];
        if (day < 1 || day > maxDay) {
            throw new Exception("Invalid day for month " + month + ": " + day);
        }
        return new int[]{day, month, year};
    }

    private int totalDaysSince2024(int day, int month, int year) {
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        int dayOfYear = 0;
        for (int m=1; m<month; m++) {
            dayOfYear += daysInMonth[m-1];
        }
        dayOfYear += day;

        if (year == 2025) {
            dayOfYear += 365;
        }
        return dayOfYear;
    }

    
    private void loadBorrowedFromFile() {
        File file = new File(BORROWED_FILE);
        if (!file.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 4) {
                    BorrowRecord r = new BorrowRecord(parts[0], parts[1], parts[2], parts[3]);
                    borrowedRecords.add(r);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error reading file: " + ex.getMessage());
        }
    }

    private void writeBorrowedToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BORROWED_FILE))) {
            for (BorrowRecord rec : borrowedRecords) {
                bw.write(rec.getBookTitle() + "|" +
                         rec.getBorrower() + "|" +
                         rec.getDateBorrowed() + "|" +
                         rec.getExpectedReturn());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error writing file: " + ex.getMessage());
        }
    }

   

    class BorrowRecord {
        private String bookTitle;
        private String borrower;
        private String dateBorrowed;
        private String expectedReturn;

        public BorrowRecord(String bookTitle, String borrower,
                            String dateBorrowed, String expectedReturn) {
            this.bookTitle = bookTitle;
            this.borrower = borrower;
            this.dateBorrowed = dateBorrowed;
            this.expectedReturn = expectedReturn;
        }
        public String getBookTitle()      { return bookTitle; }
        public String getBorrower()       { return borrower; }
        public String getDateBorrowed()   { return dateBorrowed; }
        public String getExpectedReturn() { return expectedReturn; }
    }

   
}
