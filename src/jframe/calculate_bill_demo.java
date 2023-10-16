/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jframe;

/**
 *
 * @author Avan
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.ResultSet;


public class calculate_bill_demo extends JFrame implements ActionListener {

    JTextField tfunits;
    JButton next, cancel;
    JLabel lblname, labeladdress;
    Choice meternumber, cmonth;

    calculate_bill_demo() {
        setSize(500, 410);
        setLocation(500, 170);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(254, 48, 0));
        add(p);

        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(100, 10, 400, 25);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(heading);

        JLabel lblmeternumber = new JLabel("Meter Number");
        lblmeternumber.setBounds(100, 80, 100, 20);
        p.add(lblmeternumber);

        meternumber = new Choice();
        meternumber.setBounds(240, 80, 200, 20);
        p.add(meternumber);
        
      
try (Connection con = DBConnection.getConnection();
     java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM new_customers WHERE meter_no = ?")) {
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
        meternumber.add(rs.getString("meter_no"));
    }
} catch (Exception e) {
}
        
                    try {
             Connection con = DBConnection.getConnection();
          java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM new_customers WHERE meter_no = ?");
          pst.setString(1, meternumber.getSelectedItem());
          ResultSet rs = pst.executeQuery();

             
              while(rs.next()) {
                lblname.setText(rs.getString("name"));
                labeladdress.setText(rs.getString("address"));
            }
        } catch (SQLException e) {
        }
       
        meternumber.addItemListener((ItemEvent ie) -> {
            try {
                Connection con = DBConnection.getConnection();
                java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM new_customers WHERE meter_no = ?");
                pst.setString(1, meternumber.getSelectedItem());
                ResultSet rs = pst.executeQuery();
                
                
                if (rs.next()) {
        lblname.setText(rs.getString("name"));
        labeladdress.setText(rs.getString("address"));
    } else {
        // Handle the case when no record is found for the given meter number
        lblname.setText("N/A");
        labeladdress.setText("N/A");
    }
    
    pst.close();
    rs.close();
    con.close();
            } catch (SQLException e) {
            }
        });

        

        JLabel lblmeterno = new JLabel("Name");
        lblmeterno.setBounds(100, 120, 100, 20);
        p.add(lblmeterno);

        lblname = new JLabel("");
        lblname.setBounds(240, 120, 200, 20);
        p.add(lblname);

        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(100, 160, 100, 20);
        p.add(lbladdress);

        labeladdress = new JLabel();
        labeladdress.setBounds(240, 160, 200, 20);
        p.add(labeladdress);

        JLabel lblcity = new JLabel("Units Consumed");
        lblcity.setBounds(100, 200, 100, 20);
        p.add(lblcity);

        tfunits = new JTextField();
        tfunits.setBounds(240, 200, 200, 20);
        p.add(tfunits);

        JLabel lblstate = new JLabel("Month");
        lblstate.setBounds(100, 240, 100, 20);
        p.add(lblstate);

        cmonth = new Choice();
        cmonth.setBounds(240, 240, 200, 20);
        cmonth.add("January");
        cmonth.add("February");
        cmonth.add("March");
        cmonth.add("April");
        cmonth.add("May");
        cmonth.add("June");
        cmonth.add("July");
        cmonth.add("August");
        cmonth.add("September");
        cmonth.add("October");
        cmonth.add("November");
        cmonth.add("December");
        p.add(cmonth);

        next = new JButton("Submit");
        next.setBounds(120, 300, 100, 25);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        p.add(next);

        cancel = new JButton("Cancel");
        cancel.setBounds(250, 300, 100, 25);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        p.add(cancel);

        setLayout(new BorderLayout());

        add(p, "Center");

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == next) {
            String meter = meternumber.getSelectedItem();
            String units = tfunits.getText();
            String month = cmonth.getSelectedItem();

            int totalbill = 0;
            int unit_consumed = Integer.parseInt(units);

            try (Connection con = DBConnection.getConnection();
                 java.sql.PreparedStatement pst = con.prepareStatement("SELECT * FROM tax");
                 ResultSet rs = pst.executeQuery() ){

                while (rs.next()) {
                    totalbill += unit_consumed * Integer.parseInt(rs.getString("cost_per_unit"));
                    totalbill += Integer.parseInt(rs.getString("meter_rent"));
                    totalbill += Integer.parseInt(rs.getString("service_charge"));
                    totalbill += Integer.parseInt(rs.getString("service_tax"));
                    totalbill += Integer.parseInt(rs.getString("fixed_tax"));
                }

                try (java.sql.PreparedStatement insertStatement = con.prepareStatement("INSERT INTO bill (meter_no, month, units, totalbill) VALUES (?, ?, ?, ?)")) {
                    insertStatement.setString(1, meter);
                    insertStatement.setString(2, month);
                    insertStatement.setString(3, units);
                    insertStatement.setInt(4, totalbill);
                    int rowsAffected = insertStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully");
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to update customer bill");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new calculate_bill_demo();
    }
}
