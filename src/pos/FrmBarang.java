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
public class FrmBarang extends javax.swing.JFrame {
    koneksi k;
    Statement statement;
    ResultSet resultset;
    int pil;

    /**
     * Creates new form FrmBarang
     */
    public FrmBarang() {
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
        Object header[] = { "Kode", "Nama", "Harga Beli", "Harga Jual", "Stok", "Stok Min" };
        DefaultTableModel modelBarang = new DefaultTableModel(null, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelBarang.setModel(modelBarang);
        int baris = tabelBarang.getRowCount();
        for (int i = 0; i < baris; i++) {
            modelBarang.removeRow(i);
        }
        String sql = "SELECT * FROM barang";
        try {
            statement = k.conn.createStatement();
            resultset = statement.executeQuery(sql);
            while (resultset.next()) {
                String kode = resultset.getString(1);
                String nama = resultset.getString(2);
                String harga_beli = resultset.getString(3);
                String harga_jual = resultset.getString(4);
                String stok = resultset.getString(5);
                String stok_min = resultset.getString(6);
                String kolom[] = { kode, nama, harga_beli, harga_jual, stok, stok_min };
                modelBarang.addRow(kolom);
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

    private void setEdit(boolean yKode, boolean yNama, boolean yHargaBeli, boolean yHargaJual,
            boolean yStok, boolean yStokMin) {
        mKodeBarang.setEnabled(yKode);
        mNamaBarang.setEnabled(yNama);
        mHargaBeliBarang.setEnabled(yHargaBeli);
        mHargaJualBarang.setEnabled(yHargaJual);
        mStokBarang.setEnabled(yStok);
        mStokMinBarang.setEnabled(yStokMin);
    }

    private void bersih() {
        mKodeBarang.setText(null);
        mNamaBarang.setText(null);
        mHargaBeliBarang.setText(null);
        mHargaJualBarang.setText(null);
        mStokBarang.setText(null);
        mStokMinBarang.setText(null);
    }

    private void simpanData() {
        String sql_insert = "insert into barang values ('" + mKodeBarang.getText() + "','" + mNamaBarang.getText()
                + "','" + mHargaBeliBarang.getText() + "','" + mHargaJualBarang.getText()
                + "','" + mStokBarang.getText() + "','" + mStokMinBarang.getText() + "')";
        try {
            statement.executeUpdate(sql_insert);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void koreksiData() {
        String sql_edit = "update barang set namabarang='" + mNamaBarang.getText() + "', hargabelibarang='"
                + mHargaBeliBarang.getText() + "',hargajualbarang='" + mHargaJualBarang.getText() + "', stokbarang='"
                + mStokBarang.getText() + "',stokminbarang='" + mStokMinBarang.getText() +
                "' where kodebarang='" + mKodeBarang.getText() + "'";
        try {
            statement.executeUpdate(sql_edit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void hapusData() {
        String sql_delete = "delete from barang where kodebarang='" + mKodeBarang.getText() + "'";
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mKodeBarang = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mNamaBarang = new javax.swing.JTextField();
        mHargaBeliBarang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mHargaJualBarang = new javax.swing.JTextField();
        mStokBarang = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mStokMinBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnKoreksi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: Form Barang :.");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Kode Barang");

        mKodeBarang.setEnabled(false);
        mKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeBarangActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama Barang");

        mNamaBarang.setEnabled(false);
        mNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaBarangActionPerformed(evt);
            }
        });

        mHargaBeliBarang.setEnabled(false);
        mHargaBeliBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHargaBeliBarangActionPerformed(evt);
            }
        });

        jLabel3.setText("Harga Beli Barang");

        jLabel4.setText("Harga Jual Barang");

        mHargaJualBarang.setEnabled(false);
        mHargaJualBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHargaJualBarangActionPerformed(evt);
            }
        });

        mStokBarang.setEnabled(false);
        mStokBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mStokBarangActionPerformed(evt);
            }
        });

        jLabel5.setText("Stok Barang");

        mStokMinBarang.setEnabled(false);
        mStokMinBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mStokMinBarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Stok Min Barang");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mHargaJualBarang, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mHargaBeliBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(mStokMinBarang, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(mStokBarang, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(mNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(302, 302, 302))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mHargaBeliBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mHargaJualBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mStokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mStokMinBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Harga Beli", "Harga Jual", "Stok", "Stok Min"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
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

    private void mKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mKodeBarangActionPerformed
        // TODO add your handling code here:
        if (mKodeBarang.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Barang masih kosong...",
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
            mKodeBarang.requestFocus();
        } else {
            // Button Tambah
            if (pil == 1) {
                String sql_select = "select * from barang where kodebarang='" + mKodeBarang.getText() + "'";
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
                        mNamaBarang.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Barang sudah ada...",
                                "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        mKodeBarang.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Tambah
              // Button Koreksi
            if (pil == 2) {
                String sql_select = "select * from barang where kodebarang='" + mKodeBarang.getText() + "'";
                try {
                    statement = k.conn.createStatement();
                    resultset = statement.executeQuery(sql_select);
                    if (resultset.next()) {
                        mNamaBarang.setText(resultset.getString(2));
                        mHargaBeliBarang.setText(resultset.getString(3));
                        mHargaJualBarang.setText(resultset.getString(4));
                        mStokBarang.setText(resultset.getString(5));
                        mStokMinBarang.setText(resultset.getString(6));
                        setEdit(false, true, true, true, true, true);
                        btnSimpan.setEnabled(true);
                        mNamaBarang.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Barang tidak diketemukan...", "Kesalahan",
                                JOptionPane.ERROR_MESSAGE);
                        mKodeBarang.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Koreksi
              // Button Hapus
            if (pil == 3) {
                String sql_select = "select * from barang where kodebarang='" + mKodeBarang.getText() + "'";
                try {
                    statement = k.conn.createStatement();
                    resultset = statement.executeQuery(sql_select);
                    if (resultset.next()) {
                        mNamaBarang.setText(resultset.getString(2));
                        mHargaBeliBarang.setText(resultset.getString(3));
                        mHargaJualBarang.setText(resultset.getString(4));
                        mStokBarang.setText(resultset.getString(5));
                        mStokMinBarang.setText(resultset.getString(6));
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
                        JOptionPane.showMessageDialog(null, "Kode Barang tidak diketemukan...",
                                "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        mKodeBarang.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Hapus
        }
    }// GEN-LAST:event_mKodeBarangActionPerformed

    private void mNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mNamaBarangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mNamaBarangActionPerformed

    private void mHargaBeliBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mHargaBeliBarangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mHargaBeliBarangActionPerformed

    private void mHargaJualBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mHargaJualBarangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mHargaJualBarangActionPerformed

    private void mStokBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mStokBarangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mStokBarangActionPerformed

    private void mStokMinBarangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mStokMinBarangActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mStokMinBarangActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        if (pil == 2 || pil == 3) {
            mKodeBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 0).toString());
            mNamaBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 1).toString());
            mHargaBeliBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 2).toString());
            mHargaJualBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 3).toString());
            mStokBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 4).toString());
            mStokMinBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(), 5).toString());
        }
        if (pil == 2) {
            setEdit(false, true, true, true, true, true);
            btnSimpan.setEnabled(true);
            mNamaBarang.requestFocus();
        }
        if (pil == 3) {
            mKodeBarang.setEnabled(false);
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
    }// GEN-LAST:event_tabelBarangMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeBarang.requestFocus();
    }// GEN-LAST:event_btnTambahActionPerformed

    private void btnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKoreksiActionPerformed
        // TODO add your handling code here:
        pil = 2;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeBarang.requestFocus();
    }// GEN-LAST:event_btnKoreksiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeBarang.requestFocus();
    }// GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSimpanActionPerformed
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
    }// GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
         if (pil == 3) {
            btnSimpan.setText("Simpan");
        }
        pil = 5;
        setTombol(true, true, true, false, false, true);
        setEdit(false, false, false, false, false, false);
        bersih();
        btnTambah.requestFocus();
    }// GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
         this.dispose();
    }// GEN-LAST:event_btnKeluarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBarang().setVisible(true);
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
    private javax.swing.JTextField mHargaBeliBarang;
    private javax.swing.JTextField mHargaJualBarang;
    private javax.swing.JTextField mKodeBarang;
    private javax.swing.JTextField mNamaBarang;
    private javax.swing.JTextField mStokBarang;
    private javax.swing.JTextField mStokMinBarang;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
