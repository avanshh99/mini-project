/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Avan
 */
public class generate_bill extends javax.swing.JFrame {

    /**
     * Creates new form newcustomer
     */
    public generate_bill() {
        initComponents();
    }

//     public void insertSignupDetails(){
//       String name = txt_name.getText();
//       String email = txt_email.getText();
//        String city = txt_city.getText();
//        String aadhar_no = txt_aadhar.getText();
//         String address = txt_address.getText();
//          String phone = txt_phone.getText();
//          
//        String meter_no = Utils.calculateCRC32(aadhar_no);
//        
//    
//       try{
//           Connection con = DBConnection.getConnection();
//            String sql = "INSERT INTO new_customers(name,meter_no,email,phone_no,address,city,aadhar,meter_no) VALUES(?, ?, ?,?,?,?,? ) ";
//
//            java.sql.PreparedStatement pst = con.prepareStatement(sql);
//            pst.setString(1, name);
//            pst.setString(2, email);
//            pst.setString(3, city);
//            pst.setString(4, phone);
//            pst.setString(5, address);
//            pst.setString(6, aadhar_no);
//            pst.setString(7, meter_no);
//            int updatedRowCount = pst.executeUpdate();
//            
//
//          if(updatedRowCount > 0){
//              JOptionPane.showMessageDialog(this, "Account added Successfully and meter no is '"+meter_no+"'");
//              
//          }else {
//         JOptionPane.showMessageDialog(this, "Data Insertion failure");
//          }
//       }catch(HeadlessException | SQLException e){
//       }
//   }
//    
//     public boolean validateSignup(){
//     String name = txt_name.getText();
//       String email = txt_email.getText();
//        String city = txt_city.getText();
//        String aadhar_no = txt_aadhar.getText();
//         String address = txt_address.getText();
//          String phone = txt_phone.getText();
//       
//         if (name.equals("") || email.equals("") || aadhar_no.equals("") || phone.equals("") || city.equals("") || address.equals("")) {
//        JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
//        return false;
//    }
//       
//       
//       if(email.equals("")){
//           JOptionPane.showMessageDialog(this, "Enter valid email id");
//           return false;
//            }
//       
//       if(phone.equals("")){
//           JOptionPane.showMessageDialog(this, "Enter valid phone no");
//           return false;
//            }
//       
//       
//     
//     if(aadhar_no.equals("")){
//           JOptionPane.showMessageDialog(this, "Enter the valid aadhar no");
//           return false;
//            }
//     return true;
//     
//     
//     }
//






    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_phone = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_phone1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_phone2 = new javax.swing.JTextField();
        txt_phone3 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        txt_email1 = new javax.swing.JTextField();
        meterno = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel2.setText("GENERATE BILL");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 180, 40));

        jLabel3.setText("Meter no  :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 130, 40));

        jLabel4.setText("Units consumed :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 130, 40));

        jLabel5.setText("Cost per unit");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 130, 40));

        jLabel6.setText("Final Amt :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 130, 40));

        jLabel7.setText("Month :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 130, 40));

        txt_phone.setBackground(new java.awt.Color(255, 0, 0));
        txt_phone.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_phone.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 220, 30));

        jButton1.setText("Generate");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 500, 90, 30));

        jLabel8.setText("Note    :");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 440, 60, 40));

        jLabel9.setText("BY Default the Bill is generated for 30 days only");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 270, 40));

        txt_phone1.setBackground(new java.awt.Color(255, 0, 0));
        txt_phone1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_phone1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_phone1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 220, 30));

        jLabel10.setText("Tax :");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 40));

        txt_phone2.setBackground(new java.awt.Color(255, 0, 0));
        txt_phone2.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_phone2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_phone2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 220, 30));

        txt_phone3.setBackground(new java.awt.Color(255, 0, 0));
        txt_phone3.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_phone3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_phone3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 220, 30));

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 80, 30));

        txt_email1.setBackground(new java.awt.Color(255, 0, 0));
        txt_email1.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_email1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 220, 30));

        meterno.setBackground(new java.awt.Color(255, 153, 0));
        meterno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        meterno.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                meternoComponentAdded(evt);
            }
        });
        jPanel2.add(meterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 220, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 550));

        setSize(new java.awt.Dimension(585, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your System.exit(0);handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void meternoComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_meternoComponentAdded
       
    }//GEN-LAST:event_meternoComponentAdded

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(generate_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generate_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generate_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generate_bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new generate_bill().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> meterno;
    private javax.swing.JTextField txt_email1;
    private javax.swing.JTextField txt_phone;
    private javax.swing.JTextField txt_phone1;
    private javax.swing.JTextField txt_phone2;
    private javax.swing.JTextField txt_phone3;
    // End of variables declaration//GEN-END:variables
}
