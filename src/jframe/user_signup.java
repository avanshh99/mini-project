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
public class user_signup extends javax.swing.JFrame {

    /**
     * Creates new form uers_login
     */
    public user_signup() {
        initComponents();
    }

     public void insertSignupDetails(){
       String name = txt_username.getText();
       String pwd = txt_pwd.getText();
       String email = txt_email.getText();
        String contact = txt_contact.getText();
        String aadhar = txt_aadhar.getText();
        String meterno = Utils.calculateCRC32(aadhar);
    
       try{
           Connection con = DBConnection.getConnection();
            String sql = "INSERT INTO customers(name,password,email,contact,aadhar,meterno) VALUES(?, ?, ?,?,?,? ) ";
//      String sql = "INSERT INTO new_customers(name,email,phone_no,address,city,aadhar_no,meter_no) VALUES(?, ?, ?,?,?,?,? ) ";


            java.sql.PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, name);
            pst.setString(2, pwd);
            pst.setString(3, email);
            pst.setString(4, contact);
            pst.setString(5, aadhar);
            pst.setString(6, meterno);
            int updatedRowCount = pst.executeUpdate();
            

          if(updatedRowCount > 0){
              JOptionPane.showMessageDialog(this, "Account created Successfully and meter no is '"+meterno+"'");
              
          }else {
         JOptionPane.showMessageDialog(this, "Data Insertion failure");
          }
       }catch(HeadlessException | SQLException e){
       }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_pwd = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_contact = new javax.swing.JTextField();
        jlabel222 = new javax.swing.JLabel();
        jlabel223 = new javax.swing.JLabel();
        txt_aadhar = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(153, 0, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\Avan\\OneDrive\\Desktop\\mysql\\tower_sunset2.jpg")); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, -330, 780, 890));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 560));

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Constantia", 1, 24)); // NOI18N
        jLabel1.setText("WELCOME  CUSTOMER");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 290, 30));

        jLabel2.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel2.setText("Name :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 80, 30));

        txt_username.setBackground(new java.awt.Color(255, 204, 153));
        txt_username.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        txt_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 200, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Account_50px.png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 50, 50));

        jLabel5.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel5.setText("Password :");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 170, 30));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secure_50px.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 50, 50));

        jLabel7.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jLabel7.setText("Email :");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, 150, -1));

        txt_email.setBackground(new java.awt.Color(255, 204, 153));
        txt_email.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        jPanel2.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 200, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Secured_Letter_50px.png"))); // NOI18N
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 40));

        jLabel9.setFont(new java.awt.Font("RomanS_IV25", 0, 14)); // NOI18N
        jLabel9.setText("(Kindly Enter your Details)");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 230, 20));

        txt_pwd.setBackground(new java.awt.Color(255, 204, 153));
        jPanel2.add(txt_pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 200, 30));

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 100, 40));

        jButton2.setBackground(new java.awt.Color(204, 51, 0));
        jButton2.setFont(new java.awt.Font("Montserrat", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Create");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 100, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\Avan\\OneDrive\\Desktop\\mysql\\icons8-biometric-passport-50.png")); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 50, 40));

        txt_contact.setBackground(new java.awt.Color(255, 204, 153));
        txt_contact.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        txt_contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_contactActionPerformed(evt);
            }
        });
        jPanel2.add(txt_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 200, 30));

        jlabel222.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jlabel222.setText("Contact:");
        jPanel2.add(jlabel222, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 150, -1));

        jlabel223.setFont(new java.awt.Font("Book Antiqua", 1, 18)); // NOI18N
        jlabel223.setText("Aadhar no:");
        jPanel2.add(jlabel223, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 150, -1));

        txt_aadhar.setBackground(new java.awt.Color(255, 204, 153));
        txt_aadhar.setFont(new java.awt.Font("Constantia", 0, 17)); // NOI18N
        txt_aadhar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_aadharActionPerformed(evt);
            }
        });
        jPanel2.add(txt_aadhar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 200, 30));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Google_Mobile_50px.png"))); // NOI18N
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 50, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 370, 560));

        setSize(new java.awt.Dimension(1008, 565));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public boolean validateSignup(){
         String name = txt_username.getText();
       String pwd = txt_pwd.getText();
       String email = txt_email.getText();
         String phone = txt_contact.getText();
           String aadhar = txt_aadhar.getText();
          
       if(name.equals("")){
           JOptionPane.showMessageDialog(this, "please enter the username");
           return false;
       }
       
        if(pwd.equals("") ){
           JOptionPane.showMessageDialog(this, "please enter the password");
           return false;
       }  
       
     
           if(email.equals("")){
           JOptionPane.showMessageDialog(this, "Enter your valid no");
           return false;
       }
            if(phone.equals("")){
           JOptionPane.showMessageDialog(this, "Enter your phone no");
           return false;
            }
            
            if(aadhar.equals("")){
           JOptionPane.showMessageDialog(this, "Enter the valid aadhar no");
           return false;
            }
        
       return true;  
   }
    
    
    
    
    
    
    
    
    
    
    
    
    private void txt_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_usernameActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       Connection con = DBConnection.getConnection(); // Handle the exception properly (log it or show an error message)
user_login d = new user_login();
d.setVisible(true);
this.setVisible(false); 
           
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  if(validateSignup()== true ){       
        insertSignupDetails();}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txt_contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_contactActionPerformed

    private void txt_aadharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_aadharActionPerformed
         
    }//GEN-LAST:event_txt_aadharActionPerformed

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
            java.util.logging.Logger.getLogger(user_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new user_signup().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel jlabel222;
    private javax.swing.JLabel jlabel223;
    private javax.swing.JTextField txt_aadhar;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_email;
    private javax.swing.JPasswordField txt_pwd;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
