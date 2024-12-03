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
public class FrmKonsumen extends javax.swing.JFrame {
    koneksi k;
    Statement statement;
    ResultSet resultset;
    int pil;

    /**
     * Creates new form FrmKonsumen
     */
    public FrmKonsumen() {
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
        DefaultTableModel modelKonsumen = new DefaultTableModel(null, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelKonsumen.setModel(modelKonsumen);
        int baris = tabelKonsumen.getRowCount();
        for (int i = 0; i < baris; i++) {
            modelKonsumen.removeRow(i);
        }
        String sql = "SELECT * FROM konsumen";
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
                modelKonsumen.addRow(kolom);
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
        mKodeKonsumen.setEnabled(yKode);
        mNamaKonsumen.setEnabled(yNama);
        mAlamatKonsumen.setEnabled(yAlamat);
        mKotaKonsumen.setEnabled(yKota);
        mTelpKonsumen.setEnabled(yTelp);
        mHPKonsumen.setEnabled(yHP);
    }

    private void bersih() {
        mKodeKonsumen.setText(null);
        mNamaKonsumen.setText(null);
        mAlamatKonsumen.setText(null);
        mKotaKonsumen.setText(null);
        mTelpKonsumen.setText(null);
        mHPKonsumen.setText(null);
    }

    private void simpanData() {
        String sql_insert = "insert into konsumen values ('" + mKodeKonsumen.getText() + "','" + mNamaKonsumen.getText()
                + "','" + mAlamatKonsumen.getText() + "','" + mKotaKonsumen.getText()
                + "','" + mTelpKonsumen.getText() + "','" + mHPKonsumen.getText() + "')";
        try {
            statement.executeUpdate(sql_insert);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void koreksiData() {
        String sql_edit = "update konsumen set namakonsumen='" + mNamaKonsumen.getText() + "', alamatkonsumen='"
                + mAlamatKonsumen.getText() + "',kotakonsumen='" + mKotaKonsumen.getText() + "', telpkonsumen='"
                + mTelpKonsumen.getText() + "',hpkonsumen='" + mHPKonsumen.getText() +
                "' where kodekonsumen='" + mKodeKonsumen.getText() + "'";
        try {
            statement.executeUpdate(sql_edit);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void hapusData() {
        String sql_delete = "delete from konsumen where kodekonsumen='" + mKodeKonsumen.getText() + "'";
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mKodeKonsumen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        mNamaKonsumen = new javax.swing.JTextField();
        mAlamatKonsumen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mKotaKonsumen = new javax.swing.JTextField();
        mTelpKonsumen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mHPKonsumen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKonsumen = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnKoreksi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: Form Konsumen :.");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Kode");

        mKodeKonsumen.setEnabled(false);
        mKodeKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeKonsumenActionPerformed(evt);
            }
        });

        jLabel2.setText("Nama");

        mNamaKonsumen.setEnabled(false);
        mNamaKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaKonsumenActionPerformed(evt);
            }
        });

        mAlamatKonsumen.setEnabled(false);
        mAlamatKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mAlamatKonsumenActionPerformed(evt);
            }
        });

        jLabel3.setText("Alamat");

        jLabel4.setText("Kota");

        mKotaKonsumen.setEnabled(false);
        mKotaKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKotaKonsumenActionPerformed(evt);
            }
        });

        mTelpKonsumen.setEnabled(false);
        mTelpKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTelpKonsumenActionPerformed(evt);
            }
        });

        jLabel5.setText("Telp.");

        mHPKonsumen.setEnabled(false);
        mHPKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHPKonsumenActionPerformed(evt);
            }
        });

        jLabel6.setText("HP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mAlamatKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mKotaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mHPKonsumen))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(mTelpKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(mKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mAlamatKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mKotaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(mTelpKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(mHPKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tabelKonsumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Alamat", "Kota", "Telp.", "HP"
            }
        ));
        tabelKonsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKonsumenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKonsumen);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
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
                        .addGap(6, 6, 6)
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
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelKonsumenMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tabelKonsumenMouseClicked
        // TODO add your handling code here:
        if (pil == 2 || pil == 3) {
            mKodeKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(), 0).toString());
            mNamaKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(), 1).toString());
            mAlamatKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(), 2).toString());
            mKotaKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(), 3).toString());
            mTelpKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(), 4).toString());
            mHPKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(), 5).toString());
        }
        if (pil == 2) {
            setEdit(false, true, true, true, true, true);
            btnSimpan.setEnabled(true);
            mNamaKonsumen.requestFocus();
        }
        if (pil == 3) {
            mKodeKonsumen.setEnabled(false);
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
    }// GEN-LAST:event_tabelKonsumenMouseClicked

    private void mKodeKonsumenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mKodeKonsumenActionPerformed
        // TODO add your handling code here:
        if (mKodeKonsumen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Konsumen masih kosong...",
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
            mKodeKonsumen.requestFocus();
        } else {
            // Button Tambah
            if (pil == 1) {
                String sql_select = "select * from konsumen where kodekonsumen='" + mKodeKonsumen.getText() + "'";
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
                        mNamaKonsumen.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Konsumen sudah ada...",
                                "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        mKodeKonsumen.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Tambah
              // Button Koreksi
            if (pil == 2) {
                String sql_select = "select * from konsumen where kodekonsumen='" + mKodeKonsumen.getText() + "'";
                try {
                    statement = k.conn.createStatement();
                    resultset = statement.executeQuery(sql_select);
                    if (resultset.next()) {
                        mNamaKonsumen.setText(resultset.getString(2));
                        mAlamatKonsumen.setText(resultset.getString(3));
                        mKotaKonsumen.setText(resultset.getString(4));
                        mTelpKonsumen.setText(resultset.getString(5));
                        mHPKonsumen.setText(resultset.getString(6));
                        setEdit(false, true, true, true, true, true);
                        btnSimpan.setEnabled(true);
                        mNamaKonsumen.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Konsumen tidak diketemukan...", "Kesalahan",
                                JOptionPane.ERROR_MESSAGE);
                        mKodeKonsumen.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Koreksi
              // Button Hapus
            if (pil == 3) {
                String sql_select = "select * from konsumen where kodekonsumen='" + mKodeKonsumen.getText() + "'";
                try {
                    statement = k.conn.createStatement();
                    resultset = statement.executeQuery(sql_select);
                    if (resultset.next()) {
                        mNamaKonsumen.setText(resultset.getString(2));
                        mAlamatKonsumen.setText(resultset.getString(3));
                        mKotaKonsumen.setText(resultset.getString(4));
                        mTelpKonsumen.setText(resultset.getString(5));
                        mHPKonsumen.setText(resultset.getString(6));
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
                        JOptionPane.showMessageDialog(null, "Kode Konsumen tidak diketemukan...",
                                "Kesalahan", JOptionPane.ERROR_MESSAGE);
                        mKodeKonsumen.requestFocus();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null,
                            e.getMessage());
                }
            } // Akhir Button Hapus
        }
    }// GEN-LAST:event_mKodeKonsumenActionPerformed

    private void mNamaKonsumenActionPerformed(java.awt.event.ActionEvent evt) {
        // GEN-FIRST:event_mNamaKonsumenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mNamaKonsumenActionPerformed

    private void mAlamatKonsumenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mAlamatKonsumenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mAlamatKonsumenActionPerformed

    private void mKotaKonsumenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mKotaKonsumenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mKotaKonsumenActionPerformed

    private void mTelpKonsumenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mTelpKonsumenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mTelpKonsumenActionPerformed

    private void mHPKonsumenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_mHPKonsumenActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_mHPKonsumenActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeKonsumen.requestFocus();
    }// GEN-LAST:event_btnTambahActionPerformed

    private void btnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnKoreksiActionPerformed
        // TODO add your handling code here:
        pil = 2;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeKonsumen.requestFocus();
    }// GEN-LAST:event_btnKoreksiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false, false, false, false, true, false);
        setEdit(true, false, false, false, false, false);
        mKodeKonsumen.requestFocus();
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {// GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }// GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmKonsumen().setVisible(true);
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
    private javax.swing.JTextField mAlamatKonsumen;
    private javax.swing.JTextField mHPKonsumen;
    private javax.swing.JTextField mKodeKonsumen;
    private javax.swing.JTextField mKotaKonsumen;
    private javax.swing.JTextField mNamaKonsumen;
    private javax.swing.JTextField mTelpKonsumen;
    private javax.swing.JTable tabelKonsumen;
    // End of variables declaration//GEN-END:variables
}
