/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.io.File;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duong Dieu Phap
 */
public class frmWebsite extends javax.swing.JDialog {
    public int ID;
    public boolean isInsert = true;
    /**
     * Creates new form frmWebsite
     */
    public frmWebsite() {
        initComponents();
    }
    
    public frmWebsite(File file) {
        initComponents();
        
        this.setTitle(file.getAbsolutePath());
        this.setSize(900, 600);
        
        String kq = "";

        try {
            ID = ReadWriteXML.ReadXML(file);
            LoadData();
            DisableButton();
        } catch (Exception ex) {
            
        }
    }
    
    public frmWebsite(int ID) {
        initComponents();
        
        this.ID = ID;
        LoadData();
        DisableButton();
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
        jPanel3 = new javax.swing.JPanel();
        jlbWebsite = new javax.swing.JLabel();
        jtxtWebsite = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtxtURL = new javax.swing.JTextField();
        jtxtXPathID = new javax.swing.JTextField();
        jtxtXPathTitle = new javax.swing.JTextField();
        jtxtXPathImage = new javax.swing.JTextField();
        jtxtXPathDate = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtxtXPathDescription = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtXPathNextPage = new javax.swing.JTextField();
        jbtnDelete = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnInsert = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jtxtXPathLink = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jtxtXPathName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtxtXPathURL = new javax.swing.JTextField();
        jbtnReset = new javax.swing.JButton();
        jtxtXPathNextPage1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtxtXPathLayout = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCategory = new javax.swing.JTable();
        jbtnHuy = new javax.swing.JButton();
        jbtnLuu = new javax.swing.JButton();
        jbtnXuatXML = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(740, 600));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)), "Website Information"));

        jlbWebsite.setText("Website: ");

        jLabel1.setText("URL: ");

        jLabel2.setText("Category Editor");

        jLabel3.setText("ID: ");

        jLabel4.setText("Title: ");

        jLabel5.setText("Image: ");

        jtxtXPathID.setEnabled(false);

        jLabel6.setText("Date: ");

        jLabel7.setText("Description: ");

        jLabel8.setText("Next page: ");

        jbtnDelete.setText("Xóa");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jbtnUpdate.setText("Cập nhật");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnInsert.setText("Thêm");
        jbtnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnInsertActionPerformed(evt);
            }
        });

        jLabel9.setText("Link: ");

        jLabel10.setText("Name: ");

        jLabel11.setText("URL: ");

        jbtnReset.setText("Nhập lại");
        jbtnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnResetActionPerformed(evt);
            }
        });

        jLabel12.setText("XPath Next Page:");

        jLabel13.setText("XPath Layout: ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbWebsite)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtXPathID, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtXPathName, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtXPathURL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jtxtXPathLayout, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtXPathTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtxtXPathLink, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtxtXPathImage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxtXPathDate, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jtxtXPathDescription)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtXPathNextPage, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jtxtXPathNextPage1, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnInsert)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnUpdate)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnDelete)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnReset)
                .addGap(10, 10, 10))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlbWebsite)
                            .addComponent(jtxtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jtxtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtxtXPathID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jtxtXPathImage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(jtxtXPathName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jtxtXPathURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jtxtXPathDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtXPathDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(jtxtXPathLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jtxtXPathNextPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtxtXPathNextPage1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jtxtXPathLink, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtxtXPathTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnDelete)
                    .addComponent(jbtnUpdate)
                    .addComponent(jbtnInsert)
                    .addComponent(jbtnReset))
                .addContainerGap())
        );

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        jtbCategory.setModel(new javax.swing.table.DefaultTableModel(
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
        jtbCategory.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jtbCategory.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jtbCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCategory);

        jbtnHuy.setText("Đóng");
        jbtnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnHuyActionPerformed(evt);
            }
        });

        jbtnLuu.setText("Lưu");
        jbtnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLuuActionPerformed(evt);
            }
        });

        jbtnXuatXML.setText("Xuất XML");
        jbtnXuatXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnXuatXMLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnXuatXML)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnLuu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnHuy))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE)
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnHuy)
                    .addComponent(jbtnLuu)
                    .addComponent(jbtnXuatXML))
                .addGap(20, 20, 20))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jPanel2.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtbCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbCategoryMouseClicked
        // TODO add your handling code here:
        try {
            int selectedId = jtbCategory.getSelectedRow();
            int categoryId = Integer.parseInt(jtbCategory.getValueAt(selectedId, 0).toString()); 
            LoadCategoryDetail(selectedId);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }//GEN-LAST:event_jtbCategoryMouseClicked

    private void jbtnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnResetActionPerformed
        // TODO add your handling code here:
        ResetTextBox();
    }//GEN-LAST:event_jbtnResetActionPerformed

    private void jbtnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnInsertActionPerformed
        // TODO add your handling code here:
        insertCategory();
    }//GEN-LAST:event_jbtnInsertActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        // TODO add your handling code here:
        updateCategory();
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        // TODO add your handling code here:
        deleteCategory();
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnHuyActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnHuyActionPerformed

    private void jbtnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLuuActionPerformed
        // TODO add your handling code here:
        updateWebsite();
        this.dispose();
    }//GEN-LAST:event_jbtnLuuActionPerformed

    private void jbtnXuatXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnXuatXMLActionPerformed
        // TODO add your handling code here:
        
        JFileChooser c = new JFileChooser(".\\xml");
        c.setFileFilter(new FileNameExtensionFilter("XML Files (*.xml)", "xml"));
        
        if(c.showOpenDialog(this) == JFileChooser.APPROVE_OPTION)
        {
            File file = c.getSelectedFile();
            ReadWriteXML.WriteXML(ID, file.getAbsolutePath());
        }
        
    }//GEN-LAST:event_jbtnXuatXMLActionPerformed

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
            java.util.logging.Logger.getLogger(frmWebsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmWebsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmWebsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmWebsite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmWebsite().setVisible(true);
            }
        });
        
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnHuy;
    private javax.swing.JButton jbtnInsert;
    private javax.swing.JButton jbtnLuu;
    private javax.swing.JButton jbtnReset;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JButton jbtnXuatXML;
    private javax.swing.JLabel jlbWebsite;
    private javax.swing.JTable jtbCategory;
    private javax.swing.JTextField jtxtURL;
    private javax.swing.JTextField jtxtWebsite;
    private javax.swing.JTextField jtxtXPathDate;
    private javax.swing.JTextField jtxtXPathDescription;
    private javax.swing.JTextField jtxtXPathID;
    private javax.swing.JTextField jtxtXPathImage;
    private javax.swing.JTextField jtxtXPathLayout;
    private javax.swing.JTextField jtxtXPathLink;
    private javax.swing.JTextField jtxtXPathName;
    private javax.swing.JTextField jtxtXPathNextPage;
    private javax.swing.JTextField jtxtXPathNextPage1;
    private javax.swing.JTextField jtxtXPathTitle;
    private javax.swing.JTextField jtxtXPathURL;
    // End of variables declaration//GEN-END:variables

    private void setTitle(File absoluteFile) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void LoadData() {
        try {
            Website web = Website.getWebsite(ID);
            
            jtxtWebsite.setText(web._name);
            jtxtURL.setText(web._url);

            List<Category> categoryList = web._categories;
            
            String tableCol[] = {"ID", "Website ID", "Name", "Url", "XPath Layout", "Link", "Title", "Image", "Date", "Description", "Next Page", "XPath NextPage"};
            DefaultTableModel defaultTable = new DefaultTableModel(tableCol, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };
        
            for (int i = 0; i < categoryList.size(); i++) {
                Vector item;
                item = new Vector();
                Category cate = new Category();
                cate = categoryList.get(i);
                
                item.add(cate._id);
                item.add(cate._websiteID);
                item.add(cate._name);
                item.add(cate._url);
                item.add(cate._xpathLayout);
                item.add(cate._link);
                item.add(cate._title);
                item.add(cate._image);
                item.add(cate._date);
                item.add(cate._description);
                item.add(cate._nextpage);
                item.add(cate._xpathNextPage);
                
                defaultTable.addRow(item);
            }
            
            jtbCategory.setModel(defaultTable);
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void LoadCategoryDetail(int rowId) {
        try {
            jtxtXPathID.setText(jtbCategory.getValueAt(rowId, 0).toString());
            jtxtXPathName.setText(jtbCategory.getValueAt(rowId, 2).toString());
            jtxtXPathURL.setText(jtbCategory.getValueAt(rowId, 3).toString());
            jtxtXPathLink.setText(jtbCategory.getValueAt(rowId, 5).toString());
            jtxtXPathTitle.setText(jtbCategory.getValueAt(rowId, 6).toString());
            jtxtXPathImage.setText(jtbCategory.getValueAt(rowId, 7).toString());
            jtxtXPathDate.setText(jtbCategory.getValueAt(rowId, 8).toString());
            jtxtXPathDescription.setText(jtbCategory.getValueAt(rowId, 9).toString());
            jtxtXPathNextPage.setText(jtbCategory.getValueAt(rowId, 10).toString());
            
            jtxtXPathLayout.setText(jtbCategory.getValueAt(rowId, 4).toString());
            jtxtXPathNextPage1.setText(jtbCategory.getValueAt(rowId, 11).toString());
            
            isInsert = false;
            DisableButton();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
                
    }
    
    public void ResetTextBox() {
        jtxtXPathID.setText("");
        jtxtXPathName.setText("");
        jtxtXPathURL.setText("");
        jtxtXPathLink.setText("");
        jtxtXPathTitle.setText("");
        jtxtXPathImage.setText("");
        jtxtXPathDate.setText("");
        jtxtXPathDescription.setText("");
        jtxtXPathNextPage.setText("");
        
        jtxtXPathLayout.setText("");
        jtxtXPathNextPage1.setText("");
        
        isInsert = true;
        DisableButton();
    }
    
    public void DisableButton() {
        if (isInsert == true) {
            jbtnInsert.setEnabled(true);
            jbtnDelete.setEnabled(false);
            jbtnUpdate.setEnabled(false);
        } else {
            jbtnInsert.setEnabled(false);
            jbtnDelete.setEnabled(true);
            jbtnUpdate.setEnabled(true);
        }
    }
    
    public void insertCategory () {
        try {
            Category cate = new Category();
            cate._websiteID = this.ID;
            cate._name = jtxtXPathName.getText();
            cate._url = jtxtXPathURL.getText();
            cate._link = jtxtXPathLink.getText();
            cate._title = jtxtXPathTitle.getText();
            cate._image = jtxtXPathImage.getText();
            cate._date = jtxtXPathDate.getText();
            cate._description = jtxtXPathDescription.getText();
            cate._nextpage = jtxtXPathNextPage.getText();
            
            cate._xpathLayout = jtxtXPathLayout.getText();
            cate._xpathNextPage = jtxtXPathNextPage1.getText();
            
            Category.insertCategory(cate);
            LoadData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateCategory() {
        try {
            Category cate = new Category();
            cate._id = Integer.parseInt(jtxtXPathID.getText());
            cate._websiteID = this.ID;
            cate._name = jtxtXPathName.getText();
            cate._url = jtxtXPathURL.getText();
            cate._link = jtxtXPathLink.getText();
            cate._title = jtxtXPathTitle.getText();
            cate._image = jtxtXPathImage.getText();
            cate._date = jtxtXPathDate.getText();
            cate._description = jtxtXPathDescription.getText();
            cate._nextpage = jtxtXPathNextPage.getText();
            
            cate._xpathLayout = jtxtXPathLayout.getText();
            cate._xpathNextPage = jtxtXPathNextPage1.getText();
            
            Category.updateCategory(cate);
            LoadData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteCategory() {
        try {
            int categoryID = Integer.parseInt(jtxtXPathID.getText());
            Category.deleteCategory(categoryID);
            LoadData();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void updateWebsite() {
        try {
            Website web = new Website();
            web._id = this.ID;
            web._name = jtxtWebsite.getText();
            web._url = jtxtURL.getText();
            if (Website.updateWebsite(web)) {
                JOptionPane.showMessageDialog(null, "Cập nhật thành công");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
