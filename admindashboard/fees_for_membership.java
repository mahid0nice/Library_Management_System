package admindashboard;
import javax.swing.*;
import java.awt.*;
import java.io.*;

 class ChangeFeesDialog {

    private String filePath; // Path to the fees text file

    // Constructor to initialize the file path
    public ChangeFeesDialog(String filePath) {
        this.filePath = filePath;
    }

    // Method to display the fee editing dialog
    public void showDialog() {
        // Read the current fees from the file
        String[] fees = readFeesFromFile(filePath);

        if (fees == null) {
            JOptionPane.showMessageDialog(null, "Error reading fees from file.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create input fields for weekly, monthly, and yearly fees
        JTextField weeklyField = new JTextField(fees[0]);
        JTextField monthlyField = new JTextField(fees[1]);
        JTextField yearlyField = new JTextField(fees[2]);

        // Create a panel to hold the input fields
        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Weekly Fee:"));
        panel.add(weeklyField);
        panel.add(new JLabel("Monthly Fee:"));
        panel.add(monthlyField);
        panel.add(new JLabel("Yearly Fee:"));
        panel.add(yearlyField);

        // Show the dialog
        int result = JOptionPane.showConfirmDialog(
                null,
                panel,
                "Change Membership Fees",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        // If the user clicks OK, update the fees in the file
        if (result == JOptionPane.OK_OPTION) {
            String newWeeklyFee = weeklyField.getText().trim();
            String newMonthlyFee = monthlyField.getText().trim();
            String newYearlyFee = yearlyField.getText().trim();

            // Validate the input
            if (newWeeklyFee.isEmpty() || newMonthlyFee.isEmpty() || newYearlyFee.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All fields must be filled.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Write the updated fees to the file
            boolean success = writeFeesToFile(filePath, newWeeklyFee, newMonthlyFee, newYearlyFee);

            if (success) {
                JOptionPane.showMessageDialog(null, "Fees updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error updating fees.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    // Method to read fees from the file
    private String[] readFeesFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] fees = new String[3];
            String line;
            int index = 0;

            while ((line = reader.readLine()) != null && index < 3) {
                String[] parts = line.split(":");
                if (parts.length == 2) {
                    fees[index++] = parts[1].trim();
                }
            }

            return fees;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Method to write fees to the file
    private boolean writeFeesToFile(String filePath, String weeklyFee, String monthlyFee, String yearlyFee) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Weekly:" + weeklyFee);
            writer.newLine();
            writer.write("Monthly:" + monthlyFee);
            writer.newLine();
            writer.write("Yearly:" + yearlyFee);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Path to the fees text file
        String filePath = "D:\\learning_java\\Library_Management_System\\fees.txt";

        // Create an instance of ChangeFeesDialog
        ChangeFeesDialog dialog = new ChangeFeesDialog(filePath);

        // Show the fee editing dialog
        dialog.showDialog();
    }
}