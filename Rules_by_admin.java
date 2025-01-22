
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class Rules_by_admin extends JPanel implements ActionListener {
    private JTextArea rule;
    private JButton save, edit;

    Rules_by_admin() {
        this.setBounds(0, 0, 1620, 980); 
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(new BorderLayout());

        rule = new JTextArea();
        rule.setEditable(false);

        JScrollPane sp = new JScrollPane(rule);
        sp.setBounds(0, 0, 1620, 810); 
        this.add(sp, BorderLayout.CENTER);

        rules_and_regulation_call();

        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); 
        buttonPanel.setPreferredSize(new Dimension(1620, 120)); 

        save = new JButton("Save");
        save.setBounds(750, 10, 90, 20); 
        save.setEnabled(false);

        edit = new JButton("Edit");
        edit.setBounds(860, 10, 90, 20); 
        buttonPanel.add(save);
        buttonPanel.add(edit);

        this.add(buttonPanel, BorderLayout.SOUTH);

        save.addActionListener(this);
        edit.addActionListener(this);
    }

    private void rules_and_regulation_call() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Library_Management_System/new_rules.txt"))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            rule.setText(content.toString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error loading rules: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saverules() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Library_Management_System/new_rules.txt"))) {
            writer.write(rule.getText());
            JOptionPane.showMessageDialog(this, "Rules saved successfully.", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == edit) {
            rule.setEditable(true);
            save.setEnabled(true);
            edit.setEnabled(false);
        } else if (e.getSource() == save) {
            saverules();
            rule.setEditable(false);
            save.setEnabled(false);
            edit.setEnabled(true);
        }
    }

        
}
