import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Cricket_stats_1 extends javax.swing.JFrame {

   
    public Cricket_stats_1() {
        initComponents();
        //connecting java with mysql database
        Connect();
        table_update();
    }
    
    Connection con;
    PreparedStatement pst;
    
    public void Connect(){
        try {
            
        Class.forName("com.mysql.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/ipl","root","");
        System.out.println("Connect");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cricket_stats_1.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Cricket_stats_1.class.getName()).log(Level.SEVERE, null, ex);
        }                
    }
    
    //method for instantly reflecting the changes made to the table
        private void table_update(){
        try {
            int CC;
            pst=con.prepareStatement("SELECT * FROM ipl_stats");
            ResultSet Rs=pst.executeQuery();
            ResultSetMetaData RSMD=Rs.getMetaData();
            CC=RSMD.getColumnCount();
            DefaultTableModel DFT=(DefaultTableModel) ipl_table.getModel();
            DFT.setRowCount(0);
            
                    while(Rs.next()){
                    Vector v=new Vector();
                    
                    for(int i=1;i<=CC;i++){
                        v.add(Rs.getString("ID"));
                        v.add(Rs.getString("Name"));
                        v.add(Rs.getString("Team"));
                        v.add(Rs.getString("Runs"));
                        v.add(Rs.getString("Strike_Rate"));
                        v.add(Rs.getString("Average"));
                        v.add(Rs.getString("Highest_Score"));   
                    }
                    
                    DFT.addRow(v);
            }
         
        } catch (SQLException ex) {
            Logger.getLogger(Cricket_stats_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ipl_table = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        insert_but = new javax.swing.JButton();
        update_but = new javax.swing.JButton();
        delete_but = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name_tf = new javax.swing.JTextField();
        team_tf = new javax.swing.JTextField();
        runs_tf = new javax.swing.JTextField();
        strikerate_tf = new javax.swing.JTextField();
        avg = new javax.swing.JLabel();
        hs = new javax.swing.JLabel();
        average_tf = new javax.swing.JTextField();
        highestscore_tf = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("IPL Players (Batsman only) Statistics Management System");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ipl_table.setBackground(new java.awt.Color(204, 204, 255));
        ipl_table.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        ipl_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Team", "Runs", "Strike Rate", "Average", "Highest Score"
            }
        ));
        ipl_table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        ipl_table.setGridColor(new java.awt.Color(0, 0, 0));
        ipl_table.setShowGrid(true);
        ipl_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ipl_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ipl_table);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        insert_but.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        insert_but.setText("INSERT");
        insert_but.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        insert_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_butActionPerformed(evt);
            }
        });

        update_but.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        update_but.setText("UPDATE");
        update_but.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 2, true));
        update_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_butActionPerformed(evt);
            }
        });

        delete_but.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        delete_but.setText("DELETE");
        delete_but.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 0), 2, true));
        delete_but.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_butActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Name");

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel3.setText("Team");

        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setText("Runs");

        jLabel5.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel5.setText("Strike Rate");

        name_tf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 51), 2, true));
        name_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                name_tfActionPerformed(evt);
            }
        });

        team_tf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 0), 2, true));
        team_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                team_tfActionPerformed(evt);
            }
        });

        runs_tf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 0), 2, true));
        runs_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runs_tfActionPerformed(evt);
            }
        });

        strikerate_tf.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 51, 0), 2, true));
        strikerate_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strikerate_tfActionPerformed(evt);
            }
        });

        avg.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        avg.setText("Avearage");

        hs.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        hs.setText("Highest Score");

        average_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

        highestscore_tf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));
        highestscore_tf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                highestscore_tfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(avg)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(hs)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(team_tf, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                            .addComponent(name_tf)
                            .addComponent(runs_tf)
                            .addComponent(strikerate_tf)
                            .addComponent(average_tf))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(insert_but, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(delete_but, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(update_but, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)))))
                    .addComponent(highestscore_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(215, 215, 215))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(name_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(team_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(insert_but, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(runs_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(strikerate_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(update_but, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(average_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(avg))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(highestscore_tf, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hs))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(delete_but, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void name_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_name_tfActionPerformed

    }//GEN-LAST:event_name_tfActionPerformed

    
    //action to be performed on clicking the insert button
    private void insert_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_butActionPerformed
        try {
            String name,team,runs,strikerate,average,highestscore;
            name=name_tf.getText();
            team=team_tf.getText();
            runs=runs_tf.getText();
            strikerate=strikerate_tf.getText();
            average=average_tf.getText();
            highestscore=highestscore_tf.getText();
            pst=con.prepareStatement("insert into ipl_stats(Name,Team,Runs,Strike_Rate,Average,Highest_Score) values(?,?,?,?,?,?)");
            
            pst.setString(1,name);
            pst.setString(2,team);
            pst.setString(3,runs);
           pst.setString(4,strikerate);
            pst.setString(5,average);
           pst.setString(6,highestscore);
            
            pst.executeUpdate();
           
            JOptionPane.showMessageDialog(this,"record saved");
            table_update();
            name_tf.setText("");
            team_tf.setText("");
            runs_tf.setText("");
            strikerate_tf.setText("");
            average_tf.setText("");
            highestscore_tf.setText("");
            name_tf.requestFocus();
        
        } catch (SQLException ex) {
            Logger.getLogger(Cricket_stats_1.class.getName()).log(Level.SEVERE, null, ex);
        }
                    
    }//GEN-LAST:event_insert_butActionPerformed

    //getting the data from the table into equivalent textfields
    private void ipl_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ipl_tableMouseClicked
        DefaultTableModel model=(DefaultTableModel) ipl_table.getModel();
        int select=ipl_table.getSelectedRow();
        name_tf.setText(model.getValueAt(select,1).toString());
        team_tf.setText(model.getValueAt(select,2).toString());
        runs_tf.setText(model.getValueAt(select,3).toString());
        strikerate_tf.setText(model.getValueAt(select,4).toString());
        average_tf.setText(model.getValueAt(select,5).toString());
        highestscore_tf.setText(model.getValueAt(select,6).toString());
    }//GEN-LAST:event_ipl_tableMouseClicked

    
    //action to be performed after clivking update button
    private void update_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_butActionPerformed
      
        try {
            
        DefaultTableModel model=(DefaultTableModel) ipl_table.getModel();
        int select=ipl_table.getSelectedRow();
        
        int id=Integer.parseInt(model.getValueAt(select, 0).toString());
            
            String name,team,runs,strikerate,average,highestscore;
            name=name_tf.getText();
            team=team_tf.getText();
            runs=runs_tf.getText(); 
            strikerate=strikerate_tf.getText();
            average=average_tf.getText();
            highestscore=highestscore_tf.getText();
            
            pst=con.prepareStatement("update ipl_stats set Name=?,Team=?,Runs=?,Strike_Rate=?,Average=?,Highest_Score=? where ID=?");
            
            pst.setString(1,name);
            pst.setString(2,team);
            pst.setString(3,runs);
            pst.setString(4,strikerate);
            pst.setString(5,average);
            pst.setString(6, highestscore);
            pst.setInt(7, id);
            
            pst.executeUpdate();
           
            JOptionPane.showMessageDialog(this,"record updated");
            table_update();
            name_tf.setText("");
            team_tf.setText("");
            runs_tf.setText("");
            strikerate_tf.setText("");
            average_tf.setText("");
            highestscore_tf.setText("");
            name_tf.requestFocus();

        } catch (SQLException ex) {
            Logger.getLogger(Cricket_stats_1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_update_butActionPerformed

    private void delete_butActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_butActionPerformed
         try {
            
        DefaultTableModel model=(DefaultTableModel) ipl_table.getModel();
        int select=ipl_table.getSelectedRow();
        
        int id=Integer.parseInt(model.getValueAt(select, 0).toString());
            
            pst=con.prepareStatement("delete from ipl_stats where id=?");
            
            pst.setInt(1,id);
            
            pst.executeUpdate();
           
            JOptionPane.showMessageDialog(this,"record deleted");
            table_update();
            name_tf.setText("");
            team_tf.setText("");
            runs_tf.setText("");
            strikerate_tf.setText("");
            average_tf.setText("");
            highestscore_tf.setText("");
            name_tf.requestFocus();   
        } catch (SQLException ex) {
            Logger.getLogger(Cricket_stats_1.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }//GEN-LAST:event_delete_butActionPerformed

    private void team_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_team_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_team_tfActionPerformed

    private void strikerate_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strikerate_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_strikerate_tfActionPerformed

    private void runs_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runs_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_runs_tfActionPerformed

    private void highestscore_tfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_highestscore_tfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_highestscore_tfActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cricket_stats_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField average_tf;
    private javax.swing.JLabel avg;
    private javax.swing.JButton delete_but;
    private javax.swing.JTextField highestscore_tf;
    private javax.swing.JLabel hs;
    private javax.swing.JButton insert_but;
    private javax.swing.JTable ipl_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name_tf;
    private javax.swing.JTextField runs_tf;
    private javax.swing.JTextField strikerate_tf;
    private javax.swing.JTextField team_tf;
    private javax.swing.JButton update_but;
    // End of variables declaration//GEN-END:variables
}
