//package Library_Management_System;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BarChartExample extends JFrame {
    private JTextField textField;
    private JButton updateButton;
    private JPanel chartPanel;
    private DefaultCategoryDataset dataset;

    public BarChartExample() {
        // Set up the frame
        setTitle("Bar Chart Example");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Text field for user input
        textField = new JTextField("Enter data (e.g., Jan:5,Feb:3,Mar:8)", 30);
        updateButton = new JButton("Update Chart");

        JPanel inputPanel = new JPanel();
        inputPanel.add(textField);
        inputPanel.add(updateButton);
        add(inputPanel, BorderLayout.NORTH);

        // Chart panel
        chartPanel = new JPanel(new BorderLayout());
        add(chartPanel, BorderLayout.CENTER);

        // Initialize dataset and chart
        dataset = new DefaultCategoryDataset();
        JFreeChart chart = ChartFactory.createBarChart(
                "Requests by Date", // Chart title
                "Month",            // X-axis label
                "Number of Requests", // Y-axis label
                dataset
        );
        ChartPanel panel = new ChartPanel(chart);
        chartPanel.add(panel);

        // Add button action listener
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateChart();
            }
        });
    }

    private void updateChart() {
        // Clear the dataset
        dataset.clear();

        // Parse input data
        String input = textField.getText();
        String[] entries = input.split(",");
        for (String entry : entries) {
            String[] parts = entry.split(":");
            if (parts.length == 2) {
                String category = parts[0].trim();
                try {
                    int value = Integer.parseInt(parts[1].trim());
                    dataset.addValue(value, "Requests", category);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Invalid input format. Use Month:Value.");
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BarChartExample example = new BarChartExample();
            example.setVisible(true);
        });
    }
}

