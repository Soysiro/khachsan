/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author dell
 */
public class CheckOut extends javax.swing.JFrame {

    /**
     * Creates new form CheckOut
     */
    
    public CheckOut() {
        initComponents();
       
    }
    int room2;
    public CheckOut(int roomnumber){
        initComponents();
         room2 = roomnumber;
        room.setText(""+room2);
    }
    private void status(){
        try{
           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
            String Query = "UPDATE `room` SET`Status`=? WHERE RoomNumber = ?";
               PreparedStatement ps =con.prepareStatement(Query);
               ps.setString(1,"Not Booked");
               ps.setString(2,room.getText());
               if(ps.executeUpdate() == 1){
                   JOptionPane.showConfirmDialog(this, " You check Out Success");
               }
               con.close();
        }catch(Exception e){
            
        }
    }
    private void addtodetalils(){
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
            String sql ="insert into checkout values(?,?,?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1,name.getText());
            pst.setString(2,phone.getText());
            pst.setString(3,checkin.getText());
            pst.setString(4,checkout.getText());
            pst.setInt(5,Integer.valueOf(price.getText()));
            pst.setInt(6,Integer.valueOf(numberofdaystay.getText()));
            pst.setInt(7,Integer.valueOf(total.getText()));
            pst.setString(8,email.getText());
            int row = pst.executeUpdate();
            con.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private void deleteroom(){
        String room1 =room.getText();
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
            String sql = "Delete from login where RoomNumber ='"+room1+"'";
            String sql1 = "Delete from checkin where RoomNumber ='"+room1+"'";
            pst = con.prepareStatement(sql);
            pst1 = con.prepareStatement(sql1);
            int row= pst.executeUpdate();
            int del = pst1.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CheckOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Connection con;
    ResultSet rs,rs1;
    PreparedStatement pst,pst1,pst2;
    Statement st;
    private void printfpdf(){
         com.itextpdf.text.Document doc= new com.itextpdf.text.Document();
         try{
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
             String sql = "Select * from checkin";
             st = con.createStatement();
             rs = st.executeQuery(sql);
             
         }catch(Exception e){
             e.printStackTrace();
         }
        try{
             con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
             String sql = "Select * from checkin where RoomNumber = "+room.getText();
             st = con.createStatement();
             rs = st.executeQuery(sql);
             if(rs.next()){
            PdfWriter.getInstance(doc, new FileOutputStream("F:\\Hotel\\CheckOut\\"+room.getText()+".pdf"));
            doc.open();
            Paragraph paragraph1 = new Paragraph("                                                               Hotel Managament\n");
            doc.add(paragraph1);
            Paragraph paragraph2 = new Paragraph("****************************************************************************************************************");
            doc.add(paragraph2);
            Paragraph p3 = new Paragraph("Bill ID:"+rs.getInt(1)+"\n"+"Customer Detalis:\n"+"Name: "+rs.getString(2)+"\n"+"Phone Number: "+rs.getInt(3)+"\n"+"Email: "+rs.getString(6)+"\n");
            doc.add(p3);
            doc.add(paragraph2);
            Paragraph p4 = new Paragraph("Room Detalis:\n"+"Room Number: "+rs.getString(13)+"\n"+"Room Type: "+rs.getString(11)+"\n"+"Bed: "+rs.getString(10)+"\n"+"Price Per Day: "+rs.getInt(14)+"\n");
            doc.add(p4);
            Paragraph p5 = new Paragraph("Thank you for using our service");
            doc.add(paragraph2);
            PdfPTable tbl = new PdfPTable(4);
            PdfPCell c1 = new PdfPCell(new Phrase("Check In Date"));
            tbl.addCell(c1);
            PdfPCell c2 = new PdfPCell(new Phrase("Check Out Date"));
            tbl.addCell(c2);
            PdfPCell c3 = new PdfPCell(new Phrase("Number of stay days"));
            tbl.addCell(c3);
            PdfPCell c4 = new PdfPCell(new Phrase("Price"));
            tbl.addCell(c4);
            tbl.addCell(checkin.getText());
            tbl.addCell(checkout.getText());
            tbl.addCell(numberofdaystay.getText());
            tbl.addCell(price.getText());
           doc.add(tbl);
           doc.add(paragraph2);
           doc.add(p5);
             }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        doc.close();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        room = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        checkin = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        numberofdaystay = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        checkout = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        phone = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1241, 413));
        setMinimumSize(new java.awt.Dimension(1241, 413));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1241, 413));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Adobe Arabic", 1, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Customer Check Out.png"))); // NOI18N
        jLabel1.setText("Customer Check OUT\n");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Room Number");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 75, -1, -1));

        room.setEditable(false);
        room.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        room.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roomActionPerformed(evt);
            }
        });
        getContentPane().add(room, new org.netbeans.lib.awtextra.AbsoluteConstraints(588, 72, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Customer Name");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 239, -1));

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 220, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Price Per Day");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 220, -1));

        price.setEditable(false);
        price.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 220, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Check IN Date");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 239, -1));

        checkin.setEditable(false);
        checkin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(checkin, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 239, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Number of Days stay");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 239, -1));

        numberofdaystay.setEditable(false);
        numberofdaystay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(numberofdaystay, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 239, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Check Out Date");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 240, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Total Amount To Collect From Customer ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, -1, -1));

        checkout.setEditable(false);
        checkout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(checkout, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 240, -1));

        total.setEditable(false);
        total.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 240, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Customer Phone Number");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 130, 240, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Email");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 220, 240, -1));

        phone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 160, 240, -1));

        email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 260, 240, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_search_40px.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 70, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 102, 102));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 255, 255));
        jButton2.setText("Check Out");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 130, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 0, -1, -1));

        jButton11.setBackground(new java.awt.Color(0, 102, 102));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(0, 255, 255));
        jButton11.setText("Print PDF");
        jButton11.setMaximumSize(new java.awt.Dimension(127, 31));
        jButton11.setMinimumSize(new java.awt.Dimension(127, 31));
        jButton11.setPreferredSize(new java.awt.Dimension(127, 31));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 130, 30));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/all pages background.png"))); // NOI18N
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1240, 420));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void roomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roomActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       String room1 =room.getText();
        try{
           con= DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
           String sql = "Select * from checkin where RoomNumber = '"+room1+"'";
           String sql1 = "Select * from room where RoomNumber = '"+room1+"'";
           pst = con.prepareStatement(sql);
           pst2 = con.prepareCall(sql1);
           rs1 = pst2.executeQuery();
           rs = pst.executeQuery();
           
           while(rs.next()){
               name.setText(rs.getString(2));
               phone.setText(rs.getString(3));
               email.setText(rs.getString(6));
               checkin.setText(rs.getString(9));
               
               SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar call = Calendar.getInstance();
        checkout.setText(myformat.format(call.getTime()));
        java.util.Date dateBefore = myformat.parse(rs.getString(9));
        String dateAfterString = myformat.format(call.getTime());
        java.util.Date dateAfter = myformat.parse(rs.getString(10));
        long difference = Math.abs(dateAfter.getTime() - dateBefore.getTime());
        int noOfDayStay = (int) (difference/(1000*60*60*24));
        if(noOfDayStay == 0) noOfDayStay=1;
        numberofdaystay.setText(String.valueOf(noOfDayStay));
        total.setText(rs.getString(17));
           }
           while(rs1.next()){
               price.setText(rs1.getString(5)); 
           }
       }catch(Exception e){
           e.printStackTrace();
       }
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
           status();
           deleteroom();
           addtodetalils();    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        printfpdf();
        JOptionPane.showConfirmDialog(null, "You have successfully printed");
        new ThankYou().setVisible(true);
            
    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckOut().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField checkin;
    private javax.swing.JTextField checkout;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField name;
    private javax.swing.JTextField numberofdaystay;
    private javax.swing.JTextField phone;
    private javax.swing.JTextField price;
    private javax.swing.JTextField room;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
