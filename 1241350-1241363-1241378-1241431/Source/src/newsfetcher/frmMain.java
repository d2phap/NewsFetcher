/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

/*import com.sun.xml.internal.fastinfoset.stax.factory.StAXInputFactory;
 import com.sun.xml.internal.stream.XMLInputFactoryImpl;*/
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Duong Dieu Phap
 */
public class frmMain extends javax.swing.JFrame {

    /*
     * Variable
     */
    public List<Website> listWebsite;
    public List<Category> listCategory;
    public List<Content> listContent;
    private int MAX_NUM_OF_CONTENT = 0;
    private int ROW_PER_PAGE = 20;
    private int PAGE_NUM = 1;
    private int COUNT_ARTICLE = 0;
    private int TOTAL_PAGES = 0;
    private JPanel panThumb;

    /**
     * Creates new form frmMain
     */
    public frmMain() {
        initComponents();
        LoadDanhSachTrang();
        btnPrev.setEnabled(false);
    }
    DataProvider dp = null;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblThongTinPhanMem = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbTrangWeb = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        cmbChuyenMuc = new javax.swing.JComboBox();
        btnThemTrangWeb = new javax.swing.JButton();
        btnXoaTrangWeb = new javax.swing.JButton();
        btnChinhSuaTrang = new javax.swing.JButton();
        btnXemTinTuc = new javax.swing.JButton();
        btnLayTin = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        panBaiViet = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        panImageLayout = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtContent = new javax.swing.JTextArea();
        lblDate = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        jlbTrang = new javax.swing.JLabel();
        btnXoaBaiViet = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbContent = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("News Fetcher");
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(239, 239, 239));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("News Fetcher");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Phần mềm lấy tin tức tự động");

        lblThongTinPhanMem.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        lblThongTinPhanMem.setText("Thông tin");
        lblThongTinPhanMem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblThongTinPhanMemMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblThongTinPhanMemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblThongTinPhanMemMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 420, Short.MAX_VALUE)
                        .addComponent(lblThongTinPhanMem)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblThongTinPhanMem))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(220, 220, 220));
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jLabel3.setText("Trang web:");

        cmbTrangWeb.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int idx  = cmbTrangWeb.getSelectedIndex();
                LoadChuyenMuc(idx);
            }
        });

        jLabel4.setText("Chuyên mục:");

        btnThemTrangWeb.setText("Thêm trang mới");
        btnThemTrangWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemTrangWebActionPerformed(evt);
            }
        });

        btnXoaTrangWeb.setText("Xoá trang web");
        btnXoaTrangWeb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangWebActionPerformed(evt);
            }
        });

        btnChinhSuaTrang.setText("Chỉnh sửa trang");
        btnChinhSuaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaTrangActionPerformed(evt);
            }
        });

        btnXemTinTuc.setText("Xem tin tức");
        btnXemTinTuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemTinTucActionPerformed(evt);
            }
        });

        btnLayTin.setText("Lấy tin tức");
        btnLayTin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLayTinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(10, 10, 10)
                        .addComponent(cmbChuyenMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(cmbTrangWeb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnXemTinTuc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLayTin)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(btnThemTrangWeb)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnChinhSuaTrang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoaTrangWeb)
                        .addGap(15, 15, 15))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbTrangWeb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaTrangWeb)
                    .addComponent(btnChinhSuaTrang)
                    .addComponent(btnThemTrangWeb))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbChuyenMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXemTinTuc)
                    .addComponent(btnLayTin))
                .addGap(15, 15, 15))
        );

        jPanel4.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        panBaiViet.setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 153, 204));
        lblTitle.setText("##");
        lblTitle.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblTitle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblTitleMouseClicked(evt);
            }
        });

        panImageLayout.setMaximumSize(new java.awt.Dimension(100, 100));
        panImageLayout.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout panImageLayoutLayout = new javax.swing.GroupLayout(panImageLayout);
        panImageLayout.setLayout(panImageLayoutLayout);
        panImageLayoutLayout.setHorizontalGroup(
            panImageLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panImageLayoutLayout.setVerticalGroup(
            panImageLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        txtContent.setEditable(false);
        txtContent.setColumns(20);
        txtContent.setRows(5);
        txtContent.setLineWrap(true);
        txtContent.setWrapStyleWord(true);
        txtContent.setAutoscrolls(false);
        jScrollPane1.setViewportView(txtContent);

        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText("##");
        lblDate.setToolTipText("");

        javax.swing.GroupLayout panBaiVietLayout = new javax.swing.GroupLayout(panBaiViet);
        panBaiViet.setLayout(panBaiVietLayout);
        panBaiVietLayout.setHorizontalGroup(
            panBaiVietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBaiVietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBaiVietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panBaiVietLayout.createSequentialGroup()
                        .addComponent(panImageLayout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1))
                    .addGroup(panBaiVietLayout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDate, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panBaiVietLayout.setVerticalGroup(
            panBaiVietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panBaiVietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panBaiVietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitle)
                    .addComponent(lblDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panBaiVietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panImageLayout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panBaiVietLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.add(panBaiViet, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btnPrev.setText("Trang trước");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnNext.setText("Trang sau");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });

        jlbTrang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrang.setText("1/~");

        btnXoaBaiViet.setText("Xoá bài viết");
        btnXoaBaiViet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaBaiVietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNext)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
                .addComponent(btnXoaBaiViet)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(btnNext)
                    .addComponent(jlbTrang)
                    .addComponent(btnXoaBaiViet))
                .addContainerGap())
        );

        jPanel3.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N

        jtbContent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtbContent.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jtbContent);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel4, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     * Event Method
     */
    private void btnChinhSuaTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaTrangActionPerformed
        // TODO add your handling code here:
        int idx = cmbTrangWeb.getSelectedIndex();
        int webID = listWebsite.get(idx)._id;
        frmWebsite f = new frmWebsite(webID);
        f.setVisible(true);

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                LoadDanhSachTrang();
            }
        });


    }//GEN-LAST:event_btnChinhSuaTrangActionPerformed

    private void lblThongTinPhanMemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinPhanMemMouseClicked
        // TODO add your handling code here:
        
        JOptionPane.showMessageDialog(new JFrame(),
                "Thông tin nhóm thực hiện:\n\n"
                + "Nguyễn Ngọc Khánh - 1241350\n"
                + "Bùi Bá Lộc - 1241363\n"
                + "Dương Diệu Pháp - 1241378\n"
                + "Nguyễn Quốc Tuấn - 1241431");
        
        
        
    }//GEN-LAST:event_lblThongTinPhanMemMouseClicked

    private void lblThongTinPhanMemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinPhanMemMouseEntered
        // TODO add your handling code here:
        lblThongTinPhanMem.setText("Thông tin <");
        lblThongTinPhanMem.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblThongTinPhanMemMouseEntered

    private void lblThongTinPhanMemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblThongTinPhanMemMouseExited
        // TODO add your handling code here:
        lblThongTinPhanMem.setText("Thông tin");
    }//GEN-LAST:event_lblThongTinPhanMemMouseExited

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //dp = new DataProvider("./app.config");

        File dir = new File(".\\xml");

        if (!dir.exists()) {
            dir.mkdir();
        }
        
        DataProvider dp = new DataProvider(".//config.xml");
        if(!dp.isConnected())
        {
            JOptionPane.showMessageDialog(this, 
                    "Không thể kết nối tới CSDL, xin vui lòng kiểm tra tập tin cấu hình config.xml");
            
        }
        
        ListSelectionModel ls = jtbContent.getSelectionModel();
        ls.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                jtbContentSelectionChange(e);
            }
        });
        

    }//GEN-LAST:event_formWindowOpened

    /**
     * Sự kiện chọn item trên table
     *
     * @param e
     */
    private void jtbContentSelectionChange(ListSelectionEvent e) {
        try {
            if (jtbContent.getSelectedRow() != -1) {
                int selectedId = jtbContent.getSelectedRow();
                int categoryId = Integer.parseInt(jtbContent.getValueAt(selectedId, 0).toString());
                LoadContentDetail(selectedId);
            }
        } catch (Exception ex) {
            //JOptionPane.showMessageDialog(null, ex.toString());
            ex.printStackTrace();
        }
    }

    private void btnXemTinTucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemTinTucActionPerformed
        PAGE_NUM = 1;
        LoadDanhSachBaiViet();
    }//GEN-LAST:event_btnXemTinTucActionPerformed

    private void btnThemTrangWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemTrangWebActionPerformed
        // TODO add your handling code here:
        JFileChooser c = new JFileChooser(".\\xml");
        c.setFileFilter(new FileNameExtensionFilter("XML Files (*.xml)", "xml"));

        if (c.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            int websiteID = ReadWriteXML.ReadXML(c.getSelectedFile());
            frmWebsite f = new frmWebsite(websiteID);
            f.setVisible(true);

            LoadDanhSachTrang();
        }
    }//GEN-LAST:event_btnThemTrangWebActionPerformed

    private void btnXoaTrangWebActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTrangWebActionPerformed

        try {

            if (JOptionPane.showConfirmDialog(this, "Xác nhận xoá trang web này?", "Xác nhận",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                int idx = cmbTrangWeb.getSelectedIndex();
                int webID = listWebsite.get(idx)._id;

                Website.deleteWebsite(webID);
                LoadDanhSachTrang();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnXoaTrangWebActionPerformed

    private void btnLayTinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLayTinActionPerformed

        try {

            Website web = listWebsite.get(cmbTrangWeb.getSelectedIndex());
            Category cat = listCategory.get(cmbChuyenMuc.getSelectedIndex());


            frmLayTin f = new frmLayTin(web, cat);
            f.setVisible(true);


        } catch (Exception ex) {
            Logger.getLogger(frmMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLayTinActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        btnNext.setEnabled(true);
        if (PAGE_NUM <= 1) {
            btnPrev.setEnabled(false);
            return;
        } else {
            PAGE_NUM--;
            LoadDanhSachBaiViet();
        }

        System.out.println(PAGE_NUM);

    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        // TODO add your handling code here:
        btnPrev.setEnabled(true);

        if (PAGE_NUM >= TOTAL_PAGES) {
            btnNext.setEnabled(false);
            return;
        } else {
            PAGE_NUM++;
            LoadDanhSachBaiViet();
        }
        System.out.println(PAGE_NUM);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnXoaBaiVietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaBaiVietActionPerformed
        XoaBaiViet();
    }//GEN-LAST:event_btnXoaBaiVietActionPerformed

    private void lblTitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblTitleMouseClicked
        // TODO add your handling code here:
        OpenLink();
    }//GEN-LAST:event_lblTitleMouseClicked

    /**
     * Main method
     */
    private void LoadDanhSachTrang() {
        try {
            cmbTrangWeb.removeAllItems();
            listWebsite = Website.getListWebsite();

            for (int i = 0; i < listWebsite.size(); i++) {
                cmbTrangWeb.addItem(listWebsite.get(i)._name);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Load danh sách chuyên mục
     *
     * @param idx
     */
    private void LoadChuyenMuc(int idx) {
        try {
            cmbChuyenMuc.removeAllItems();
            listCategory = listWebsite.get(idx)._categories;

            for (int i = 0; i < listCategory.size(); i++) {
                cmbChuyenMuc.addItem(listCategory.get(i)._name);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void LoadDanhSachBaiViet() {
        try {
            int idx = cmbChuyenMuc.getSelectedIndex();
            int id = listCategory.get(idx)._id;

            COUNT_ARTICLE = Content.getCountOfContentByCategoryId(id);
            TOTAL_PAGES = (int) Math.ceil(COUNT_ARTICLE * 1.0 / ROW_PER_PAGE);

            jlbTrang.setText(PAGE_NUM + "/" + TOTAL_PAGES);

            listContent = Content.getListContent(id, PAGE_NUM);

            String tableCol[] = {"STT", "Bài viết"};
            DefaultTableModel defaultTable = new DefaultTableModel(tableCol, 0) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
            };

            for (int i = 0; i < listContent.size(); i++) {
                Vector item;
                item = new Vector();
                Content con = new Content();
                con = listContent.get(i);

                item.add(((PAGE_NUM - 1) * ROW_PER_PAGE) + i + 1);
                item.add(con._title);

                defaultTable.addRow(item);
            }

            jtbContent.setModel(defaultTable);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void LoadContentDetail(int selectedId) {
        try {
            Content con = listContent.get(selectedId);

            lblTitle.setText(con._title);
            lblDate.setText(con._date);
            txtContent.setText(con._description);

            BufferedImage image = null;
            URL url = new URL(con._image);
            image = ImageIO.read(url);
            
            panThumb = new ImagePanel(image);
            panThumb.paintComponents(image.getGraphics());
            panThumb.setBounds(new Rectangle(0, 0, 100, 100));
            
            panImageLayout.add(panThumb);
            panThumb.repaint();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void XoaBaiViet() {
        try {
            int idx = jtbContent.getSelectedRow();
            int contentID = listContent.get(idx)._id;

            Content.deleteContent(contentID);
            LoadDanhSachBaiViet();
            LoadContentDetail(0);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void OpenLink() {
        try {
            int idx = jtbContent.getSelectedRow();
            String link = listContent.get(idx)._link;

            Desktop.getDesktop().browse(new URI(link));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

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
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmMain().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChinhSuaTrang;
    private javax.swing.JButton btnLayTin;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnThemTrangWeb;
    private javax.swing.JButton btnXemTinTuc;
    private javax.swing.JButton btnXoaBaiViet;
    private javax.swing.JButton btnXoaTrangWeb;
    private javax.swing.JComboBox cmbChuyenMuc;
    private javax.swing.JComboBox cmbTrangWeb;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jlbTrang;
    private javax.swing.JTable jtbContent;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblThongTinPhanMem;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panBaiViet;
    private javax.swing.JPanel panImageLayout;
    private javax.swing.JTextArea txtContent;
    // End of variables declaration//GEN-END:variables
}