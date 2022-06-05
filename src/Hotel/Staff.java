/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hotel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dell
 */
public class Staff extends javax.swing.JFrame {
DefaultTableModel tblModel;

    /**
     * Creates new form LoginStaff
     */
    public Staff() {
        initComponents();
        loadData();
        loaddata();
        this.id.setVisible(false);
        this.name.setVisible(false);
        this.phone.setVisible(false);
        this.positon.setVisible(false);
    }
Connection con = null;
    ResultSet rs = null,rs1;
    Statement st = null,st1;
    PreparedStatement pst;
    private void clear(){
        room.setText("");
        type.setText("");
        view.setText("");
        bed.setText("");
        price.setText("");
    }
     private void search(){
         String room1 = room.getText();
    try {                          
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
        String sql ="select * from room where RoomNumber = "+room1;
        PreparedStatement pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        tblModel.setRowCount(0);
        while(rs.next()){
            String [] row = new String[]{
                 rs.getString("RoomNumber"), rs.getString("RoomType"),rs.getString("View"),rs.getString("Bed"),rs.getString("Price"),rs.getString("Status")
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
        }
    private void loaddata(){
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
        String sql ="SELECT * FROM `room`";
        PreparedStatement pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        tblModel.setRowCount(0);
        while(rs.next()){
            String [] row = new String[]{
                rs.getString("RoomNumber"), rs.getString("RoomType"),rs.getString("View"),rs.getString("Bed"),rs.getString("Price"),rs.getString("Status")
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
     private void loadData(){
        try{
            tblModel = new DefaultTableModel();
            tblModel.setColumnIdentifiers(new String[]{"Room Number","Room Type","View","Bed","Price","Status"});
            jTable1.setModel(tblModel);
        }catch(Exception e){
            JOptionPane.showConfirmDialog(this, e);
        }
    }
      private void loaddata1(){
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
        String sql ="SELECT * FROM `staff`";
        PreparedStatement pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        tblModel.setRowCount(0);
        while(rs.next()){
            String [] row = new String[]{
                rs.getString("ID"), rs.getString("Name"),rs.getString("dof"),rs.getString("Phone"),rs.getString("ID card"),rs.getString("Address"),rs.getString("Position")
            };
            tblModel.addRow(row);
        }
        tblModel.fireTableDataChanged();
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
      private void addroom(){
         try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
            String sql = "insert into room values(?,?,?,?,?,?)";
            pst = con.prepareStatement(sql);
            pst.setString(1, room.getText());
            pst.setString(2, type.getText());
            pst.setString(3, view.getText());
            pst.setString(4, bed.getText());
            pst.setString(5, price.getText());
            pst.setString(6,"Not booked");
            int row = pst.executeUpdate();
         }catch(Exception e){
             e.printStackTrace();
         }
     }
      private void delete(){
    try {
        String sql = "delete from room where RoomNumber = ?"; 
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_manager","root","123");
        PreparedStatement statement = con.prepareCall(sql);
        statement.setInt(1, Integer.valueOf(room.getText()));
        statement.execute();
    } catch (SQLException ex) {
        Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
    }
         
     }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        roomnumber = new javax.swing.JLabel();
        roomtype = new javax.swing.JLabel();
        views = new javax.swing.JLabel();
        bed1 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        price1 = new javax.swing.JLabel();
        room = new javax.swing.JTextField();
        type = new javax.swing.JTextField();
        view = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        bed = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        add1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        positon = new javax.swing.JLabel();
        delete1 = new javax.swing.JButton();
        search1 = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(978, 648));
        setPreferredSize(new java.awt.Dimension(978, 648));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 51, 51));

        jLabel8.setFont(new java.awt.Font("Adobe Arabic", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_user_shield_70px.png"))); // NOI18N
        jLabel8.setText("Staff");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/close.png"))); // NOI18N
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(389, 389, 389)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 429, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 80));

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_food_70px.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Logout_70px_1.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(185, 185, 185)
                .addComponent(jLabel7)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 100, 530));

        roomnumber.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomnumber.setText("Room Number\n");
        getContentPane().add(roomnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        roomtype.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        roomtype.setText("Room Type");
        getContentPane().add(roomtype, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        views.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        views.setText("View");
        getContentPane().add(views, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        bed1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bed1.setText("Bed");
        getContentPane().add(bed1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, 160, -1));

        price1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        price1.setText("Price");
        getContentPane().add(price1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, -1, -1));

        room.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(room, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 160, -1));

        type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(type, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 150, 160, -1));

        view.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(view, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 160, -1));

        jTextField5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 190, 160, -1));

        bed.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(bed, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 230, 160, -1));

        jButton2.setBackground(new java.awt.Color(0, 153, 153));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_back_40px.png"))); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 160, 50));

        add1.setBackground(new java.awt.Color(0, 153, 153));
        add1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        add1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_room_40px.png"))); // NOI18N
        add1.setText("Add Room\n");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });
        getContentPane().add(add1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 170, -1));

        jButton4.setBackground(new java.awt.Color(0, 153, 153));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_search_40px.png"))); // NOI18N
        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 170, -1));

        jButton5.setBackground(new java.awt.Color(0, 153, 153));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Delete_40px.png"))); // NOI18N
        jButton5.setText("Delete");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 160, 50));

        id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        id.setText("ID");
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, -1, -1));

        name.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        name.setText("Name");
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

        phone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        phone.setText("Phone");
        getContentPane().add(phone, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, -1, -1));

        positon.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        positon.setText("Positon");
        getContentPane().add(positon, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, -1, -1));

        delete1.setBackground(new java.awt.Color(0, 153, 153));
        delete1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        delete1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_Delete_40px.png"))); // NOI18N
        delete1.setText("Delete");
        delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete1ActionPerformed(evt);
            }
        });
        getContentPane().add(delete1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 160, 50));

        search1.setBackground(new java.awt.Color(0, 153, 153));
        search1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        search1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_search_40px.png"))); // NOI18N
        search1.setText("Search");
        search1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search1ActionPerformed(evt);
            }
        });
        getContentPane().add(search1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 180, 170, -1));

        update.setBackground(new java.awt.Color(0, 153, 153));
        update.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/icons8_update_40px_1.png"))); // NOI18N
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 880, 310));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 880, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel14MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        new OrderFood().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        loadData();
        loaddata();
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        addroom();
        loadData();
        loaddata();
        clear();
        JOptionPane.showConfirmDialog(null, "Add success room");
    }//GEN-LAST:event_add1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(room.getText().isEmpty()){
            JOptionPane.showConfirmDialog(rootPane, "Please input Room");
        }else
        search();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        delete();
        clear();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_delete1ActionPerformed

    private void search1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if(jTable1.getSelectedRow() >= 0){
            price.setText(jTable1.getValueAt(jTable1.getSelectedRow(),4)+ "");
            room.setText(jTable1.getValueAt(jTable1.getSelectedRow(),0)+ "");
            type.setText(jTable1.getValueAt(jTable1.getSelectedRow(),1)+ "");
            view.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 2)+ "");
            bed.setText(jTable1.getValueAt(jTable1.getSelectedRow(), 3)+ "");
        }
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Staff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Staff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add1;
    private javax.swing.JTextField bed;
    private javax.swing.JLabel bed1;
    private javax.swing.JButton delete1;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel positon;
    private javax.swing.JTextField price;
    private javax.swing.JLabel price1;
    private javax.swing.JTextField room;
    private javax.swing.JLabel roomnumber;
    private javax.swing.JLabel roomtype;
    private javax.swing.JButton search1;
    private javax.swing.JTextField type;
    private javax.swing.JButton update;
    private javax.swing.JTextField view;
    private javax.swing.JLabel views;
    // End of variables declaration//GEN-END:variables
}
