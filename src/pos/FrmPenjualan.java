/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author umrmaulana
 */
public class FrmPenjualan extends javax.swing.JFrame {
    koneksi k;
    Statement statement;
    ResultSet resultSet;
    int tot, byr, kmbli;
    String tanggal;


    /**
     * Creates new form FrmPenjualann
     */
    public FrmPenjualan() {
        initComponents();
        k = new koneksi();
        tampilIcon();
        tampilTabel();
        bacaKonsumen();
        bacaBarang();
    }
    
    private void tampilIcon() {
        BtnBaru.setIcon(new ImageIcon("./gambar/New_16x16.png"));
        BtnSimpan.setIcon(new ImageIcon("./gambar/Save_16x16.png"));
        BtnBatal.setIcon(new ImageIcon("./gambar/Cancel_16x16.png"));
        BtnKeluar.setIcon(new ImageIcon("./gambar/LogOut_16x16.png"));
        BtnTambah.setIcon(new ImageIcon("./gambar/Add_16x16.png"));
        BtnHapus.setIcon(new ImageIcon("./gambar/Delete_16x16.png"));
    }

    private void tampilTabel() {
        Object header[] = { "Kd Barang", "Nama Barang", "Harga Barang", "Jml Jual", "Sub Total Jual" };
        DefaultTableModel modelBarang = new DefaultTableModel(null,
                header) {
            @Override
            // Membuat jTable read only
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabelBarang.setModel(modelBarang);
    }

    private void bersih() {
        mKodeJual.setText(null);
        cKodeKonsumen.setSelectedIndex(0);
        mNamaKonsumen.setText(null);
        cKodeBarang.setSelectedIndex(0);
        mNamaBarang.setText(null);
        mHargaBarang.setText(null);
        mJmlJual.setText(null);
        mSubTotalBarang.setText(null);
        mTotal.setText(null);
        mBayar.setText(null);
        mKembali.setText(null);
        sTglJual.setValue(new Date());
    }

    private void setTombol(boolean xBaru, boolean xSimpan, boolean xBatal,
            boolean xKeluar, boolean xTambah, boolean xHapus) {
        BtnBaru.setEnabled(xBaru);
        BtnSimpan.setEnabled(xSimpan);
        BtnBatal.setEnabled(xBatal);
        BtnKeluar.setEnabled(xKeluar);
        BtnTambah.setEnabled(xTambah);
        BtnHapus.setEnabled(xHapus);
    }

    private void setEdit(boolean yKodeJual, boolean yTglJual, boolean yKodeKonsumen,
            boolean yNamaKonsumen, boolean yKodeBarang, boolean yNamaBarang,
            boolean yHargaBarang, boolean yJmlJual, boolean ySubTotalBarang,
            boolean yTotal, boolean yBayar, boolean yKembali) {
        mKodeJual.setEnabled(yKodeJual);
        sTglJual.setEnabled(yTglJual);
        cKodeKonsumen.setEnabled(yKodeKonsumen);
        mNamaKonsumen.setEnabled(yNamaKonsumen);
        cKodeBarang.setEnabled(yKodeBarang);
        mNamaBarang.setEnabled(yNamaBarang);
        mHargaBarang.setEnabled(yHargaBarang);
        mJmlJual.setEnabled(yJmlJual);
        mSubTotalBarang.setEnabled(ySubTotalBarang);
        mTotal.setEnabled(yTotal);
        mBayar.setEnabled(yBayar);
        mKembali.setEnabled(yKembali);
    }

    private void bacaKonsumen() {
        String sql_select = "select * from konsumen";
        try {
            statement = k.conn.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // Mendukung navigasi bidirectional
                    ResultSet.CONCUR_READ_ONLY
            );
            resultSet = statement.executeQuery(sql_select);
            resultSet.beforeFirst();
            while (resultSet.next()) {
                cKodeKonsumen.addItem(resultSet.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void bacaBarang() {
        String sql_select = "select * from barang";
        try {
            statement = k.conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, // Mendukung navigasi bidirectional
                        ResultSet.CONCUR_READ_ONLY);
            resultSet = statement.executeQuery(sql_select);
            resultSet.beforeFirst();
            while (resultSet.next()) {
                cKodeBarang.addItem(resultSet.getString(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    private void jmlTotal() {
        DefaultTableModel modelBarang = (DefaultTableModel) tabelBarang.getModel();
        int brs = modelBarang.getRowCount();
        int subTot = 0;
        for (int i = 0; i < brs; i++) {
            int dataJumlah = Integer.parseInt(modelBarang.getValueAt(i, 4).toString());
            subTot += dataJumlah;
        }
        mTotal.setText(String.valueOf(subTot));
    }

    private void bersihTabel() {
        DefaultTableModel modelBarang = (DefaultTableModel) tabelBarang.getModel();
        int brs = modelBarang.getRowCount();
        if (brs > 0) {
            for (int i = brs - 1; i >= 0; i--) {
                modelBarang.removeRow(i);
                jmlTotal();
            }
        }
    }

    private void format_tanggal() {
        String DATE_FORMAT = "yyyy-MM-dd HH:mm";
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
        Calendar c1 = Calendar.getInstance();
        int year = c1.get(Calendar.YEAR);
        int month = c1.get(Calendar.MONTH) + 1;
        int day = c1.get(Calendar.DAY_OF_MONTH);
        int hour = c1.get(Calendar.HOUR_OF_DAY);
        int minute = c1.get(Calendar.MINUTE);
        tanggal = Integer.toString(year) + "-" + Integer.toString(month) + "-" + Integer.toString(day) + ":"
                + Integer.toString(hour) + ":" + Integer.toString(minute);
    }

    public void uangRp() {
        String tampung_harga = mHargaBarang.getText();
        try {
            double harga = Double.parseDouble(mHargaBarang.getText());
            DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols dfs = new DecimalFormatSymbols();
            dfs.setCurrencySymbol("");
            dfs.setMonetaryDecimalSeparator(',');
            dfs.setGroupingSeparator('.');
            df.setDecimalFormatSymbols(dfs);
            String hsl = "Rp." + df.format(harga);
            mHargaBarang.setText(hsl);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Pengisian harga tidak boleh kosong");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        mKodeJual = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mNamaKonsumen = new javax.swing.JTextField();
        cKodeKonsumen = new javax.swing.JComboBox<>();
        sTglJual = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cKodeBarang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        mNamaBarang = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        mHargaBarang = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        mJmlJual = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        mSubTotalBarang = new javax.swing.JTextField();
        BtnTambah = new javax.swing.JButton();
        BtnHapus = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        BtnBaru = new javax.swing.JButton();
        BtnSimpan = new javax.swing.JButton();
        BtnBatal = new javax.swing.JButton();
        BtnKeluar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        mTotal = new javax.swing.JTextField();
        mBayar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        mKembali = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(".: Form Penjualan :.");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Kode Jual");

        mKodeJual.setEnabled(false);
        mKodeJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeJualActionPerformed(evt);
            }
        });

        jLabel2.setText("Tanggal Jual");

        jLabel3.setText("Kode Konsumen");

        jLabel4.setText("Nama Konsumen");

        mNamaKonsumen.setEnabled(false);
        mNamaKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaKonsumenActionPerformed(evt);
            }
        });

        cKodeKonsumen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        cKodeKonsumen.setEnabled(false);
        cKodeKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cKodeKonsumenActionPerformed(evt);
            }
        });

        sTglJual.setModel(new javax.swing.SpinnerDateModel());
        sTglJual.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKodeJual, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sTglJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(mKodeJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sTglJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Kode Barang");

        cKodeBarang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        cKodeBarang.setEnabled(false);
        cKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cKodeBarangActionPerformed(evt);
            }
        });

        jLabel6.setText("Nama Barang");

        mNamaBarang.setEnabled(false);
        mNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaBarangActionPerformed(evt);
            }
        });

        jLabel7.setText("Harga Barang");

        mHargaBarang.setEnabled(false);
        mHargaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mHargaBarangActionPerformed(evt);
            }
        });

        jLabel8.setText("Jml Jual");

        mJmlJual.setEnabled(false);
        mJmlJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mJmlJualActionPerformed(evt);
            }
        });

        jLabel9.setText("Sub Total");

        mSubTotalBarang.setEnabled(false);
        mSubTotalBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSubTotalBarangActionPerformed(evt);
            }
        });

        BtnTambah.setText("Tambah");
        BtnTambah.setEnabled(false);
        BtnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnTambahActionPerformed(evt);
            }
        });

        BtnHapus.setText("Hapus");
        BtnHapus.setEnabled(false);
        BtnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cKodeBarang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mNamaBarang)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(mHargaBarang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mJmlJual, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mSubTotalBarang)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnHapus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mJmlJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mSubTotalBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnTambah)
                    .addComponent(BtnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kd Barang", "Nama Barang", "Harga Barang", "Jml Jual", "Sub Total Jual"
            }
        ));
        jScrollPane1.setViewportView(tabelBarang);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnBaru.setText("Transaksi Baru");
        BtnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBaruActionPerformed(evt);
            }
        });

        BtnSimpan.setText("Simpan");
        BtnSimpan.setEnabled(false);
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        BtnBatal.setText("Batal");
        BtnBatal.setEnabled(false);
        BtnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBatalActionPerformed(evt);
            }
        });

        BtnKeluar.setText("Keluar");
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });

        jLabel10.setText("Total");

        mTotal.setEnabled(false);
        mTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mTotalActionPerformed(evt);
            }
        });

        mBayar.setEnabled(false);
        mBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mBayarActionPerformed(evt);
            }
        });

        jLabel11.setText("Bayar");

        jLabel12.setText("Kembali");

        mKembali.setEnabled(false);
        mKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKembaliActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(BtnBaru)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnSimpan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnKeluar)
                        .addGap(124, 124, 124)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mKembali, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                            .addComponent(mTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(mBayar))
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnBaru)
                    .addComponent(BtnSimpan)
                    .addComponent(BtnBatal)
                    .addComponent(BtnKeluar)
                    .addComponent(jLabel10)
                    .addComponent(mTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(mBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(mKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mKodeJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeJualActionPerformed
        // TODO add your handling code here:
        if (mKodeJual.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Kode Penjualan masih kosong...", "Kesalahan",
                    JOptionPane.ERROR_MESSAGE);
            mKodeJual.requestFocus();
        } else {
            String sql_select = "select * from penjualan where kodepenjualan='" + mKodeJual.getText() + "'";
            try {
                statement = k.conn.createStatement();
                resultSet = statement.executeQuery(sql_select);
                int baris = 0;
                while (resultSet.next()) {
                    baris = resultSet.getRow();
                }
                if (baris == 0) {
                    setEdit(false, true, true, false, false, false,
                            false, false, false, false, false, false);
                    sTglJual.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Kode Penjualan sudah ada...", "Kesalahan",
                            JOptionPane.ERROR_MESSAGE);
                    mKodeJual.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_mKodeJualActionPerformed

    private void mNamaKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNamaKonsumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNamaKonsumenActionPerformed

    private void cKodeKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cKodeKonsumenActionPerformed
        // TODO add your handling code here:
        if (cKodeKonsumen.getSelectedItem() == "-- Pilih --") {
            mNamaKonsumen.setText(null);
            cKodeKonsumen.setSelectedIndex(0);
            cKodeBarang.setEnabled(false);
            cKodeKonsumen.requestFocus();
        } else {
            String sql_select = "select * from konsumen where kodekonsumen='" + cKodeKonsumen.getSelectedItem() + "'";
            try {
                statement = k.conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, // Mendukung navigasi bidirectional
                        ResultSet.CONCUR_READ_ONLY);
                resultSet = statement.executeQuery(sql_select);
                resultSet.beforeFirst();
                while (resultSet.next()) {
                    mNamaKonsumen.setText(resultSet.getString(2));
                }
                cKodeBarang.setEnabled(true);
                BtnHapus.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_cKodeKonsumenActionPerformed

    private void cKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cKodeBarangActionPerformed
        // TODO add your handling code here:
        if (cKodeBarang.getSelectedItem() == "-- Pilih --") {
            mNamaBarang.setText(null);
            mHargaBarang.setText(null);
            mJmlJual.setText(null);
            mSubTotalBarang.setText(null);
            mJmlJual.setEnabled(false);
        } else {
            String sql_select = "select * from barang where kodebarang='" + cKodeBarang.getSelectedItem() + "'";
            try {
                // Membuat Statement dengan tipe ResultSet yang mendukung scroll
                statement = k.conn.createStatement(
                        ResultSet.TYPE_SCROLL_INSENSITIVE, // Mendukung navigasi bidirectional
                        ResultSet.CONCUR_READ_ONLY // Hanya baca
                );
                resultSet = statement.executeQuery(sql_select);

                if (resultSet.next()) { // Menggunakan next() untuk pindah ke data pertama
                    mNamaBarang.setText(resultSet.getString(2));
                    mHargaBarang.setText(resultSet.getString(4));
                }
                mJmlJual.setEnabled(true);
                mJmlJual.requestFocus();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_cKodeBarangActionPerformed

    private void mNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNamaBarangActionPerformed

    private void mHargaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mHargaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mHargaBarangActionPerformed

    private void mJmlJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mJmlJualActionPerformed
        // TODO add your handling code here:
        int harga = Integer.parseInt(mHargaBarang.getText());
        int jml = Integer.parseInt(mJmlJual.getText());
        int sub = harga * jml;
        mSubTotalBarang.setText(String.valueOf(sub));
        BtnTambah.setEnabled(true);
        BtnTambah.requestFocus();
    }//GEN-LAST:event_mJmlJualActionPerformed

    private void mSubTotalBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSubTotalBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mSubTotalBarangActionPerformed

    private void BtnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTambahActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelBarang = (DefaultTableModel) tabelBarang.getModel();
        String[] data = new String[5];
        data[0] = cKodeBarang.getSelectedItem().toString();
        data[1] = mNamaBarang.getText();
        data[2] = mHargaBarang.getText();
        data[3] = mJmlJual.getText();
        data[4] = mSubTotalBarang.getText();
        modelBarang.addRow(data);
        cKodeBarang.setSelectedIndex(0);
        mNamaBarang.setText(null);
        mHargaBarang.setText(null);
        mJmlJual.setText(null);
        mSubTotalBarang.setText(null);
        jmlTotal();
        mBayar.setEnabled(true);
        BtnTambah.setEnabled(false);
    }//GEN-LAST:event_BtnTambahActionPerformed

    private void BtnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnHapusActionPerformed
        // TODO add your handling code here:
        try {
            DefaultTableModel tableModel = (DefaultTableModel) tabelBarang.getModel();
            int x = tabelBarang.getSelectedRow();
            tableModel.removeRow(x);
            jmlTotal();
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Tabel Belum Dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_BtnHapusActionPerformed

    private void BtnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBaruActionPerformed
        // TODO add your handling code here:
        setTombol(false, false, true, false, false, false);
        setEdit(true, false, false, false, false, false, false, false,
                false, false, false, false);
        mKodeJual.requestFocus();
    }//GEN-LAST:event_BtnBaruActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        format_tanggal();
        String sql_insert = "insert into penjualan values('" + mKodeJual.getText() + "','" +
                cKodeKonsumen.getSelectedItem() + "','" + tanggal + "')";
        try {
            statement.executeUpdate(sql_insert);
            DefaultTableModel modelBarang = (DefaultTableModel) tabelBarang.getModel();
            int brs = modelBarang.getRowCount();
            for (int i = 0; i < brs; i++) {
                String xkd = (String) tabelBarang.getValueAt(i, 0);
                // int xhrg=(Integer)tabelBarang.getValueAt(i,2);
                // int xjml=(Integer)tabelBarang.getValueAt(i,3);
                int xhrg = Integer.parseInt(tabelBarang.getValueAt(i, 2).toString());
                int xjml = Integer.parseInt(tabelBarang.getValueAt(i, 3).toString());
                String zsql = "insert into dpenjualan values('" + mKodeJual.getText() +
                        "','" + xkd + "'," + xhrg + "," + xjml + ")";
                statement.executeUpdate(zsql);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        // Simpan ke detail penjualan
        setTombol(true, false, false, true, false, false);
        setEdit(false, false, false, false, false, false, false, false,
                false, false, false, false);
        bersihTabel();
        bersih();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBatalActionPerformed
        // TODO add your handling code here:
        setTombol(true, false, false, true, false, false);
        setEdit(false, false, false, false, false, false, false, false,
                false, false, false, false);
        bersihTabel();
        bersih();
    }//GEN-LAST:event_BtnBatalActionPerformed

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void mTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mTotalActionPerformed

    private void mBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mBayarActionPerformed
        // TODO add your handling code here:
        tot = Integer.parseInt(mTotal.getText());
        byr = Integer.parseInt(mBayar.getText());
        kmbli = byr - tot;
        mKembali.setText(String.valueOf(kmbli));
        BtnSimpan.setEnabled(true);
    }//GEN-LAST:event_mBayarActionPerformed

    private void mKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mKembaliActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPenjualan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnBaru;
    private javax.swing.JButton BtnBatal;
    private javax.swing.JButton BtnHapus;
    private javax.swing.JButton BtnKeluar;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnTambah;
    private javax.swing.JComboBox<String> cKodeBarang;
    private javax.swing.JComboBox<String> cKodeKonsumen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mBayar;
    private javax.swing.JTextField mHargaBarang;
    private javax.swing.JTextField mJmlJual;
    private javax.swing.JTextField mKembali;
    private javax.swing.JTextField mKodeJual;
    private javax.swing.JTextField mNamaBarang;
    private javax.swing.JTextField mNamaKonsumen;
    private javax.swing.JTextField mSubTotalBarang;
    private javax.swing.JTextField mTotal;
    private javax.swing.JSpinner sTglJual;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
