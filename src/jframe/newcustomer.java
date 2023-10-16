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
public class newcustomer extends javax.swing.JFrame {

    /**
     * Creates new form newcustomer
     */
    public newcustomer() {
        initComponents();
    }

     public void insertSignupDetail(){
       String name = txt_name.getText();
       String email = txt_email.getText();
        String city = txt_city.getText();
        String aadhar_no = txt_aadhar.getText();
         String address = txt_address.getText();
          String phone = txt_phone.getText();
          
        String meter_no = Utils.calculateCRC32(aadhar_no);
        
    
       try{
           Connection con = DBConnection.getConnection();
           String sql = "INSERT INTO new_customers(name,email,phone_no,address,city,aadhar_no,meter_no) VALUES(?, ?, ?,?,?,?,? ) ";


            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, city);
            pst.setString(4, phone);
            pst.setString(5, address);
            pst.setString(6, aadhar_no);
            pst.setString(7, meter_no);
            int updatedRowCount = pst.executeUpdate();
            

          if(updatedRowCount > 0){
              JOptionPane.showMessageDialog(this, "Account added Successfully and meter no is '"+meter_no+"'");
              admin_homepage b = new admin_homepage();
              b.setVisible(true);
          }else {
         JOptionPane.showMessageDialog(this, "Data Insertion failure");
          }
       }catch(HeadlessException | SQLException e){
            e.printStackTrace();
    JOptionPane.showMessageDialog(this, "Data Insertion failure");
       }
   }
    
     public boolean validateSignup(){
     String name = txt_name.getText();
       String email = txt_email.getText();
        String city = txt_city.getText();
        String aadhar_no = txt_aadhar.getText();
         String address = txt_address.getText();
          String phone = txt_phone.getText();
       
         if (name.equals("") || email.equals("") || aadhar_no.equals("") || phone.equals("") || city.equals("") || address.equals("")) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
        return false;
    }
       
       
       if(email.matches("^[_A-Za-z0-9-]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$\";")){
           JOptionPane.showMessageDialog(this, "Enter valid email id");
           return false;
            }
       
       if(phone.equals("^[2-9]\\\\d{9}$")){
           JOptionPane.showMessageDialog(this, "Enter valid phone no");
           return false;
            }
       
       
     
     if(aadhar_no.length() != 12)
{
           JOptionPane.showMessageDialog(this, "Enter the valid aadhar no");
           return false;
            }
     return true;
     
     
     }







    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_aadhar = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_email = new javax.swing.JTextField();
        txt_phone = new javax.swing.JTextField();
        txt_city = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_address = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 153, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Aadhar Number       :");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 130, 40));

        jLabel2.setFont(new java.awt.Font("Montserrat", 0, 18)); // NOI18N
        jLabel2.setText("NEW CUSTOMER");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 210, 40));

        jLabel3.setText("CUSTOMER NAME :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 130, 40));

        jLabel4.setText("Email                      :");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 130, 40));

        jLabel5.setText("Phone                     :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 130, 40));

        jLabel6.setText("Address                   :");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 130, 40));

        jLabel7.setText("City                          :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, 130, 40));

        txt_aadhar.setBackground(new java.awt.Color(255, 0, 0));
        txt_aadhar.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_aadhar.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_aadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 220, 30));

        txt_name.setBackground(new java.awt.Color(255, 0, 0));
        txt_name.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 220, 30));

        txt_email.setBackground(new java.awt.Color(255, 0, 0));
        txt_email.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 220, 30));

        txt_phone.setBackground(new java.awt.Color(255, 0, 0));
        txt_phone.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_phone.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, 220, 30));

        txt_city.setBackground(new java.awt.Color(255, 0, 0));
        txt_city.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_city.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txt_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 220, 30));

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 460, -1, -1));

        jButton2.setText("CANCEL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, -1, -1));

        jScrollPane1.setBackground(new java.awt.Color(255, 51, 0));

        txt_address.setBackground(new java.awt.Color(255, 51, 0));
        txt_address.setColumns(20);
        txt_address.setFont(new java.awt.Font("Montserrat", 0, 14)); // NOI18N
        txt_address.setRows(5);
        jScrollPane1.setViewportView(txt_address);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 220, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 550));

        setSize(new java.awt.Dimension(585, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your System.exit(0);handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                if(validateSignup()== true ){       
        insertSignupDetail();}
//                this.dispose();
             
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(newcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newcustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new newcustomer().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txt_aadhar;
    private javax.swing.JTextArea txt_address;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_phone;
    // End of variables declaration//GEN-END:variables
}
