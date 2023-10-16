package jframe;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CustomerDetailsViewer {
    private JTextField meterNumberField;
    private JTable table;

    public CustomerDetailsViewer() {
        JFrame frame = new JFrame("Customer Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Fetch initial data from the database and populate the table
        DefaultTableModel model = fetchDataFromDatabase();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel searchPanel = new JPanel();
        JLabel meterNumberLabel = new JLabel("Enter Meter Number:");
        meterNumberField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(e -> {
            String meterNumber = meterNumberField.getText().trim();
            if (!meterNumber.isEmpty()) {
                filterTableData(meterNumber);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a meter number.");
            }
        });

        searchPanel.add(meterNumberLabel);
        searchPanel.add(meterNumberField);
        searchPanel.add(searchButton);
        
         JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            frame.dispose(); // Close the current frame (CustomerDetailsViewer)
//            new admin_homepage(); // Open the admin page again
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);


        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        // Center the frame on the screen
    
    
    
    
    }

    public void show_details(){
        JFrame frame = new JFrame("Customer Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Fetch initial data from the database and populate the table
        DefaultTableModel model = fetchDataFromDatabase();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel searchPanel = new JPanel();
        JLabel meterNumberLabel = new JLabel("Enter Meter Number:");
        meterNumberField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(e -> {
            String meterNumber = meterNumberField.getText().trim();
            if (!meterNumber.isEmpty()) {
                filterTableData(meterNumber);
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a meter number.");
            }
        });

        searchPanel.add(meterNumberLabel);
        searchPanel.add(meterNumberField);
        searchPanel.add(searchButton);
        
             JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> {
            frame.dispose(); // Close the current frame (CustomerDetailsViewer)
           // Open the admin page again
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(closeButton);

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
    private DefaultTableModel fetchDataFromDatabase() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Meter Number");
        model.addColumn("Email");
        model.addColumn("Phone Number");
        model.addColumn("Address");
        model.addColumn("City");
        model.addColumn("Aadhar Number");

        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM new_customers";
            try (PreparedStatement statement = con.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Object[] row = new Object[8];
                    for (int i = 1; i <= 8; i++) {
                        row[i - 1] = resultSet.getObject(i);
                    }
                    model.addRow(row);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error fetching data from the database.");
        }

        return model;
    }

    private void filterTableData(String meterNumber) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        table.setRowSorter(rowSorter);
        
        // Set the filter based on meter number
        rowSorter.setRowFilter(RowFilter.regexFilter(meterNumber)); // Assuming meter number is at column index 2
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(CustomerDetailsViewer::new);
    }
}
