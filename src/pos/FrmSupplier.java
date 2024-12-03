/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pos;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author umrmaulana
 */
public class FrmSupplier extends javax.swing.JFrame {
    koneksi k;
    Statement statement;
    ResultSet resultset;
    int pil;

    /**
     * Creates new form FrmSuppliier
     */
    public FrmSupplier() {
        initComponents();
        k = new koneksi();
        tampilIcon();
        tampilTabel();
    }
    private void tampilIcon() {
        btnTambah.setIcon(new ImageIcon("./gambar/Add_16x16.png"));
        btnKoreksi.setIcon(new ImageIcon("./gambar/Edit_16x16.png"));
        btnHapus.setIcon(new ImageIcon("./gambar/Delete_16x16.png"));
        btnSimpan.setIcon(new ImageIcon("./gambar/Save_16x16.png"));
        btnBatal.setIcon(new ImageIcon("./gambar/Cancel_16x16.png"));
        btnKeluar.setIcon(new ImageIcon("./gambar/LogOut_16x16.png"));
    }

    private void tampilTabel() {
        Object header[] = { "Kode", "Nama", "Alamat", "Kota", "Telp.", "HP" };
        DefaultTableModel modelSupplier = new DefaultTableModel(null, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelSupplier.setModel(modelSupplier);
        int baris = tabelSupplier.getRowCount();
        for (int i = 0; i < baris; i++) {
            modelSupplier.removeRow(i);
        }
        String sql = "SELECT * FROM supplier";
        try {
            statement = k.conn.createStatement();
            resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                String kode = resultset.getString(1);
                String nama = resultset.getString(2);
                String alamat = resultset.getString(3);
                String kota = resultset.getString(4);
                String telp = resultset.getString(5);
                String hp = resultset.getString(6);
                String kolom[] = { kode, nama, alamat, kota, telp, hp };
                modelSupplier.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void setTombol(boolean xTambah, boolean xKoreksi, boolean xHapus, boolean xSimpan, boolean xBatal,
            boolean xKeluar) {
        btnTambah.setEnabled(xTambah);
        btnKoreksi.setEnabled(xKoreksi);
        btnHapus.setEnabled(xHapus);
        btnSimpan.setEnabled(xSimpan);
        btnBatal.setEnabled(xBatal);
        btnKeluar.setEnabled(xKeluar);
    }

    private void setEdit(boolean yKode, boolean yNama, boolean yAlamat, boolean yKota,
            boolean yTelp, boolean yHP) {
        mKodeSupplier.setEnabled(yKode);
        mNamaSupplier.setEnabled(yNama);
        mAlamatSupplier.setEnabled(yAlamat);
        mKotaSupplier.setEnabled(yKota);
        mTelpSupplier.setEnabled(yTelp);
        mHPSupplier.setEnabled(yHP);
    }

    private void bersih() {
        mKodeSupplier.setText(null);
        mNamaSupplier.setText(null);
        mAlamatSupplier.setText(null);
        mKotaSupplier.setText(null);
        mTelpSupplier.setText(null);
        mHPSupplier.setText(null);
    }

    private void simpanData() {
        String sql_insert = "insert into supplier values ('" + mKodeSupplier.getText() + "','" + mNamaSupplier.getText()
                + "','" + mAlamatSupplier.getText() + "','" + mKotaSupplier.getText()
                + "','" + mTelpSupplier.getText() + "','" + mHPSupplier.getText() + "')";
        try {
            statement.executeUpdate(sql_insert);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void koreksiData() {
        String sql_edit = "update supplier set namasupplier='" + mNamaSupplier.getText() + "', alamatsupplier='"
                + mAlamatSupplier.getText() + "',kotasupplier='" + mKotaSupplier.getText() + "', telpsupplier='"
                + mTelpSupplier.getText() + "',hpsupplier='" + mHPSupplier.getText() +
                "' where kodesupplier='" + mKodeSupplier.getText() + "'";
        try {
            statement.executeUpdate(sql_edit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void hapusData() {
        String sql_delete = "delete from supplier where kodesupplier='" + mKodeSupplier.getText() + "'";
        try {
            statement.executeUpdate(sql_delete);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
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
        jLabel1 = new javax.swing.JLabel();
        mKodeSupplier = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mNamaSupplier = new javax.swing.JTextField();
        mAlamatSupplier = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mKotaSupplier = new javax.swing.JTextField();
        mTelpSupplier = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mHPSupplier = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelSupplier = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnKoreksi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: Form Supplier :.");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Kode Supplier");

        mKodeSupplier.setEnabled(false);
        mKodeSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeSupplierActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Supplier");

        mNamaSupplier.setEnabled(false);
        mNamaSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaSupplierActionPerformed(evt);
            }
        });

        mAlamatSupplier.setEnabled(false);
        mAlamatSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAlamatSupplierActionPerformed(evt);
            }
        });

        jLabel3.setText("Alamat Supplier");

        jLabel4.setText("Kota Supplier");

        mKotaSupplier.setEnabled(false);
        mKotaSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKotaSupplierActionPerformed(evt);
            }
        });

        mTelpSupplier.setEnabled(false);
        mTelpSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTelpSupplierActionPerformed(evt);
            }
        });

        jLabel5.setText("Telp. Supplier");

        mHPSupplier.setEnabled(false);
        mHPSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHPSupplierActionPerformed(evt);
            }
        });

        jLabel6.setText("HP Supplier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mAlamatSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mKotaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mHPSupplier, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mTelpSupplier, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(126, 126, 126))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mAlamatSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mKotaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mTelpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mHPSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Alamat", "Kota", "Telp.", "HP"
            }
        ));
        tabelSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelSupplier);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnTambah.setText("Tambah");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKoreksi.setText("Koreksi");
        btnKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoreksiActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setEnabled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKoreksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKeluar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnKoreksi)
                    .addComponent(btnHapus)
                    .addComponent(btnSimpan)
                    .addComponent(btnBatal)
                    .addComponent(btnKeluar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mKodeSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeSupplierActionPerformed
        // TODO add your handling code here:
        if (mKodeSupplier.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Supplier masih kosong...",
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
            mKodeSupplier.requestFocus();
        } else {
            // Button Tambah
            if (pil == 1) {
                String sql_select = "select * from supplier where kodesupplier='" + mKodeSupplier.getText() + "'";
                try {
                    statement = k.conn.createStatement();
                    resultset = statement.executeQuery(sql_select);
                    int baris = 0;
                    while (resultset.next()) {
                        baris = resultset.getRow();
                    }
                    if (baris == 0) {
                        setEdit(false, true, true, true, true, true);
                        btnSimpan.setEnabled(true);
                        mNamaSupplier.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier sudah ada...",
                                "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        mKodeSupplier.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Tambah
              // Button Koreksi
            if (pil == 2) {
                String sql_select = "select * from supplier where kodesupplier='" + mKodeSupplier.getText() + "'";
                try {
                    statement = k.conn.createStatement();
                    resultset = statement.executeQuery(sql_select);
                    if (resultset.next()) {
                        mNamaSupplier.setText(resultset.getString(2));
                        mAlamatSupplier.setText(resultset.getString(3));
                        mKotaSupplier.setText(resultset.getString(4));
                        mTelpSupplier.setText(resultset.getString(5));
                        mHPSupplier.setText(resultset.getString(6));
                        setEdit(false, true, true, true, true, true);
                        btnSimpan.setEnabled(true);
                        mNamaSupplier.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier tidak diketemukan...", "Kesalahan",
                                JOptionPane.ERROR_MESSAGE);
                        mKodeSupplier.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Koreksi
              // Button Hapus
            if (pil == 3) {
                String sql_select = "select * from supplier where kodesupplier='" + mKodeSupplier.getText() + "'";
                try {
                    statement = k.conn.createStatement();
                    resultset = statement.executeQuery(sql_select);
                    if (resultset.next()) {
                        mNamaSupplier.setText(resultset.getString(2));
                        mAlamatSupplier.setText(resultset.getString(3));
                        mKotaSupplier.setText(resultset.getString(4));
                        mTelpSupplier.setText(resultset.getString(5));
                        mHPSupplier.setText(resultset.getString(6));
                        setEdit(false, false, false, false, false,
                                false);
                        int opsi = JOptionPane.showConfirmDialog(null,
                                "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data",
                                JOptionPane.YES_NO_OPTION);
                        if (opsi == JOptionPane.YES_OPTION) {
                            hapusData();
                        }
                        tampilTabel();
                        setTombol(true, true, true, false, false,
                                true);
                        setEdit(false, false, false, false, false,
                                false);
                        bersih();
                        pil = 5;
                        btnTambah.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier tidak diketemukan...",
                                "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        mKodeSupplier.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Hapus
        }
    }//GEN-LAST:event_mKodeSupplierActionPerformed

    private void mNamaSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNamaSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNamaSupplierActionPerformed

    private void mAlamatSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAlamatSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mAlamatSupplierActionPerformed

    private void mKotaSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKotaSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mKotaSupplierActionPerformed

    private void mTelpSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTelpSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mTelpSupplierActionPerformed

    private void mHPSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHPSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mHPSupplierActionPerformed

    private void tabelSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelSupplierMouseClicked
        // TODO add your handling code here:
        if (pil == 2 || pil == 3) {
            mKodeSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 0).toString());
            mNamaSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 1).toString());
            mAlamatSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 2).toString());
            mKotaSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 3).toString());
            mTelpSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 4).toString());
            mHPSupplier.setText(tabelSupplier.getValueAt(tabelSupplier.getSelectedRow(), 5).toString());
        }
        if (pil == 2) {
            setEdit(false, true, true, true, true, true);
            btnSimpan.setEnabled(true);
            mNamaSupplier.requestFocus();
        }
        if (pil == 3) {
            mKodeSupplier.setEnabled(false);
            int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?",
                    "Penghapusan Data",
                    JOptionPane.YES_NO_OPTION);
            if (opsi == JOptionPane.YES_OPTION) {
                hapusData();
            }
            tampilTabel();
            setTombol(true, true, true, false, false, true);
            setEdit(false, false, false, false, false, false);
            bersih();
            pil = 5;
            btnTambah.requestFocus();
        }
    }//GEN-LAST:event_tabelSupplierMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeSupplier.requestFocus();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoreksiActionPerformed
        // TODO add your handling code here:
         pil = 2;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeSupplier.requestFocus();
    }//GEN-LAST:event_btnKoreksiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeSupplier.requestFocus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (pil == 1) {
            simpanData();
        } else if (pil == 2) {
            koreksiData();
        }
        tampilTabel();
        pil = 4;
        setTombol(true, true, true, false, false, true);
        setEdit(false, false, false, false, false, false);
        bersih();
        btnTambah.requestFocus();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
       if (pil == 3) {
            btnSimpan.setText("Simpan");
        }
        pil = 5;
        setTombol(true, true, true, false, false, true);
        setEdit(false, false, false, false, false, false);
        bersih();
        btnTambah.requestFocus();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSupplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKoreksi;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mAlamatSupplier;
    private javax.swing.JTextField mHPSupplier;
    private javax.swing.JTextField mKodeSupplier;
    private javax.swing.JTextField mKotaSupplier;
    private javax.swing.JTextField mNamaSupplier;
    private javax.swing.JTextField mTelpSupplier;
    private javax.swing.JTable tabelSupplier;
    // End of variables declaration//GEN-END:variables
}
