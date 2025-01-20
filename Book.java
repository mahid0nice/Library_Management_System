import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

class Book extends JPanel implements ActionListener {

    private static final String BOOKS_FILE = "Book.txt";

    // GUI components
    private JTextField txtSearch, txtTitle, txtAuthor;
    private JButton btnSearch, btnAdd, btnUpdate;
    private JList<String> lstBooks;
    private DefaultListModel<String> listModel;

    // In-memory list of BookItem objects
    private ArrayList<BookItem> books;

    Book() {
        // Fill the entire gray panel size (assuming largestpanel is 1620x1010)
        setBounds(0, 0, 1620, 1010);
        setLayout(null);

        // Initialize data structures
        books = new ArrayList<>();
        listModel = new DefaultListModel<>();
        loadBooksFromFile();

        // =================== HEADER LABEL ===================
        // Make it span the full width
        JLabel lblHeader = new JLabel("Books Title Management", SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 28));
        lblHeader.setBounds(0, 0, 1620, 50);
        add(lblHeader);

        // =================== SEARCH SECTION ===================
        JLabel lblSearch = new JLabel("Search Title:");
        lblSearch.setFont(new Font("Arial", Font.PLAIN, 18));
        lblSearch.setBounds(50, 70, 120, 30);
        add(lblSearch);

        txtSearch = new JTextField();
        txtSearch.setBounds(180, 70, 300, 30);
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Arial", Font.PLAIN, 16));
        btnSearch.setBounds(490, 70, 100, 30);
        btnSearch.addActionListener(this);
        add(btnSearch);

        // =================== BOOK LIST (JLIST) ===================
        lstBooks = new JList<>(listModel);
        lstBooks.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JScrollPane scrollPane = new JScrollPane(lstBooks);
        // Give it a bigger area so it fills the left portion
        scrollPane.setBounds(50, 120, 540, 700);
        add(scrollPane);

        showAllBooksInList(); // show the initial data

        // =================== ADD/UPDATE SECTION ===================
        JLabel lblTitle = new JLabel("Title:");
        lblTitle.setFont(new Font("Arial", Font.PLAIN, 18));
        lblTitle.setBounds(650, 120, 60, 30);
        add(lblTitle);

        txtTitle = new JTextField();
        txtTitle.setBounds(720, 120, 300, 30);
        add(txtTitle);

        JLabel lblAuthor = new JLabel("Author:");
        lblAuthor.setFont(new Font("Arial", Font.PLAIN, 18));
        lblAuthor.setBounds(650, 170, 70, 30);
        add(lblAuthor);

        txtAuthor = new JTextField();
        txtAuthor.setBounds(720, 170, 300, 30);
        add(txtAuthor);

        btnAdd = new JButton("Add Book");
        btnAdd.setFont(new Font("Arial", Font.PLAIN, 16));
        btnAdd.setBounds(650, 220, 120, 30);
        btnAdd.addActionListener(this);
        add(btnAdd);

        btnUpdate = new JButton("Update");
        btnUpdate.setFont(new Font("Arial", Font.PLAIN, 16));
        btnUpdate.setBounds(780, 220, 120, 30);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
    }

    // --------------------- ACTION LISTENER ---------------------
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnSearch) {
            searchBooks();
        } else if(e.getSource() == btnAdd) {
            addBook();
        } else if(e.getSource() == btnUpdate) {
            updateBook();
        }
    }

    // --------------------- SEARCH FUNCTION ---------------------
    private void searchBooks() {
        String query = txtSearch.getText().trim().toLowerCase();
        if(query.isEmpty()) {
            showAllBooksInList();
            return;
        }
        listModel.clear();
        for(BookItem b : books) {
            if(b.getTitle().toLowerCase().contains(query)) {
                listModel.addElement(b.getTitle() + " by " + b.getAuthor());
            }
        }
    }

    // Show all books in the JList
    private void showAllBooksInList() {
        listModel.clear();
        for(BookItem b : books) {
            listModel.addElement(b.getTitle() + " by " + b.getAuthor());
        }
    }

    // --------------------- ADD BOOK ---------------------
    private void addBook() {
        String title = txtTitle.getText().trim();
        String author = txtAuthor.getText().trim();

        if(title.isEmpty() || author.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter both title and author.");
            return;
        }

        BookItem newBook = new BookItem(title, author);
        books.add(newBook);

        listModel.addElement(title + " by " + author);

        writeBooksToFile();
        txtTitle.setText("");
        txtAuthor.setText("");
    }

    // --------------------- UPDATE BOOK ---------------------
    private void updateBook() {
        int selectedIndex = lstBooks.getSelectedIndex();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, 
                "Please select a book in the list to update.");
            return;
        }

        String newTitle = txtTitle.getText().trim();
        String newAuthor = txtAuthor.getText().trim();

        if(newTitle.isEmpty() || newAuthor.isEmpty()) {
            JOptionPane.showMessageDialog(this, 
                "Please enter both title and author.");
            return;
        }

        BookItem selectedBook = books.get(selectedIndex);
        selectedBook.setTitle(newTitle);
        selectedBook.setAuthor(newAuthor);

        listModel.set(selectedIndex, newTitle + " by " + newAuthor);
        writeBooksToFile();

        txtTitle.setText("");
        txtAuthor.setText("");
    }

    // --------------------- FILE I/O ---------------------
    private void loadBooksFromFile() {
        File file = new File(BOOKS_FILE);
        if(!file.exists()) {
            return; // no file yet
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if(parts.length == 2) {
                    books.add(new BookItem(parts[0], parts[1]));
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
                "Error loading file: " + ex.getMessage());
        }
    }

    private void writeBooksToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(BOOKS_FILE))) {
            for(BookItem b : books) {
                bw.write(b.getTitle() + "|" + b.getAuthor());
                bw.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this,
            "Error writing to file: " + ex.getMessage());
        }
    }

    // --------------------- INNER CLASS BookItem ---------------------
    class BookItem {
        private String title;
        private String author;

        public BookItem(String t, String a) {
            this.title = t;
            this.author = a;
        }
        public String getTitle() { return title; }
        public void setTitle(String t) { this.title = t; }
        public String getAuthor() { return author; }
        public void setAuthor(String a) { this.author = a; }
    }

    // If you need a main for quick tests:
    // public static void main(String[] args) {
    //    JFrame testFrame = new JFrame("Test Book Panel");
    //    testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //    Book bookPanel = new Book();
    //    testFrame.add(bookPanel);
    //    testFrame.setSize(1620, 1010);
    //    testFrame.setLocationRelativeTo(null);
    //    testFrame.setVisible(true);
    // }
}
