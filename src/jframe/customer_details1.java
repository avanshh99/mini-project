/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 

*/
package jframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Avan
 */
public class customer_details1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Customer Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
         Color backgroundColor = new Color(204,51,0); // RGB values for light blue
         
         
         
           int frameWidth = 900;
        int frameHeight = 700;
        frame.setSize(frameWidth, frameHeight);
        
        // Get the screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Calculate the center of the screen
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        
        // Set the frame location
        frame.setLocation(x, y);
        
        // Make the frame visible
        frame.setVisible(true);
        
         
         
         
        // Set the background color of the content pane
        frame.getContentPane().setBackground(backgroundColor);
        
        JPanel panel = new JPanel();
        JButton viewButton = new JButton("View Customer Details");
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        
        JButton close = new JButton("Close");
        close.setBounds(450,10 , 100, 20);
        close.setFocusable(false);
        
        viewButton.addActionListener((e) -> {
            DefaultTableModel model = fetchDataFromDatabase();
            table.setModel(model);
        });
        
        close.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
       
        panel.add(viewButton);
        frame.add(close);
        
        frame.add(panel, "North");
        frame.add(scrollPane);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
    
    public void show_details(){
         JFrame frame = new JFrame("Customer Details");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        JButton viewButton = new JButton("Click to View Customer Details");
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        
        JButton close = new JButton("Close");
        close.setBounds(450,10 , 100, 20);
        close.setFocusable(false);
  
        viewButton.addActionListener((e) -> {
            DefaultTableModel model = fetchDataFromDatabase();
            table.setModel(model);
        });
        
        
           close.addActionListener((ActionEvent e) -> {
            frame.dispose();
        });
        
        panel.add(viewButton);
        panel.add(close);
        
        frame.add(panel, "North");
        frame.add(scrollPane);
        frame.setSize(600, 400);
        frame.setVisible(true);
    }
    
    public static DefaultTableModel fetchDataFromDatabase() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Meter Number");
        model.addColumn("Email");
        model.addColumn("Phone Number");
        model.addColumn("Address");
        model.addColumn("City");
        model.addColumn("Aadhar Number");
        model.addColumn("Payment status");
        
        
        
        
        try (Connection con = DBConnection.getConnection();) {
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
        }
        
        return model;
    }

    
}
