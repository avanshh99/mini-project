/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class view_customer {

    private JTextField meterNumberField;
    private JTable table;

    public view_customer() {
        
        JFrame frame = new JFrame("Customer Details Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
         frame.setSize(600, 400);
        frame.setVisible(true);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        JPanel searchPanel = new JPanel();
        JLabel meterNumberLabel = new JLabel("Enter Meter Number:");
        meterNumberField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String meterNumber = meterNumberField.getText().trim();
                if (!meterNumber.isEmpty()) {
                    displayCustomerDetails(meterNumber);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a meter number.");
                }
            }
        });

        searchPanel.add(meterNumberLabel);
        searchPanel.add(meterNumberField);
        searchPanel.add(searchButton);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    public void show_details(){
         JFrame frame = new JFrame("Customer Details Search");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

         frame.setSize(600, 400);
        frame.setVisible(true);

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);
        
        JPanel searchPanel = new JPanel();
        JLabel meterNumberLabel = new JLabel("Enter Meter Number:");
        meterNumberField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String meterNumber = meterNumberField.getText();
                if (isValidMeterNumber(meterNumber)) {
                    displayCustomerDetails(meterNumber);
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter a meter number.");
                }
            }
            private boolean isValidMeterNumber(String meterNumber) {
        // Check if the meter number is exactly 6 digits long and contains only digits
        return meterNumber.matches("\\d{6}");
    }
        });

        searchPanel.add(meterNumberLabel);
        searchPanel.add(meterNumberField);
        searchPanel.add(searchButton);

        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);

        frame.add(searchPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setSize(600, 400);
        frame.setVisible(true);
        
    }
    
    
    
    
    
    
    
    private void displayCustomerDetails(String meterNumber) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Meter Number");
        model.addColumn("Email");
        model.addColumn("Phone Number");
        model.addColumn("Address");
        model.addColumn("City");
        model.addColumn("Aadhar Number");

        try (Connection con = DBConnection.getConnection();) {
            String sql = "SELECT * FROM new_customers WHERE meter_no = ?";
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setString(1, meterNumber);
                ResultSet resultSet = statement.executeQuery();
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

        table.setModel(model);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new view_customer().show_details();
            }
        });
    }
}
