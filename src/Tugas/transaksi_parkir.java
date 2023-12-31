package Tugas;


import com.placeholder.PlaceHolder;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
public class transaksi_parkir extends javax.swing.JFrame {

    int byr, tbyr, kembali;
    String Number="";
    
    public void selectData() throws SQLException{
        //Untuk Menampilkan ke Dalam Tabel
    String kolom[] = {"No Kendaraan", "Jenis Kendaraan", "Lama Parkir", "Total Bayar", "Bayar", "Kembalian"};
    DefaultTableModel dtm = new DefaultTableModel(null, kolom);
    String SQL = "SELECT * FROM parkir";
    ResultSet rs = Koneksi.executeQuery(SQL);
    try {
        while(rs.next()){
        String Noken = rs.getString(1);//untuk kolom 1
        String Jenis ="";
        if ("Motor".equals(rs.getString(2))){// kolom 2
            Jenis = "Motor";
        }else {
            Jenis = "Mobil";
        }
        String Lama = rs.getString(3);// kolom 3
        String Harga = rs.getString(4);// kolom 4
        String Bayar = rs.getString(5);// kolom 5
        String Kembalian = rs.getString(6);// kolom 6
        String Data[] = {Noken, Jenis, Lama, Harga, Bayar, Kembalian}; //arraylist
        dtm.addRow(Data);
        }
    }catch (SQLException ex){
        Logger.getLogger(transaksi_parkir.class.getName()).log(Level.SEVERE, null, ex);
    }
    //source tabel
    tabeldata.setModel(dtm);
    JTableHeader header = tabeldata.getTableHeader();
    header.setFont(new Font("Tekton Pro", Font.BOLD, 18));
}
    //Variable
    private String kode, type;
    private long harga;
    private Timer waktu;
    int a, b, c;
    public transaksi_parkir() {
        initComponents();
        try {
            selectData();
        } catch (SQLException ex) {
            Logger.getLogger(transaksi_parkir.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Untuk Menjalankan Progress dan Menghasilkan Hasil
        ActionListener listenerProgress = new ActionListener(){
            public void actionPerformed (ActionEvent e){
                progres.setValue(progres.getValue()+1);
                if (progres.getValue()==progres.getMaximum()){
                    progres.setValue(0);
                    waktu.stop();
                    //Aritmatika Penjumlahan
                    a = Integer.parseInt(pilih.getText());
                    b = Integer.parseInt(lama.getText());
                    c = a * b;
                    //Untuk Menampilkan Hasil Perkalian
                    total.setText("" +c);
                }
            }
        };
        //Untuk Berapa Lama Waktu Berjalan Progress
        waktu = new Timer(25, listenerProgress);
    }
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        group = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        noken = new javax.swing.JTextField();
        lama = new javax.swing.JTextField();
        total = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabeldata = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        progres = new javax.swing.JProgressBar();
        pilih = new javax.swing.JTextField();
        pilihan = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        kembalian = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setBackground(new java.awt.Color(255, 16, 16));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(153, 0, 0));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("No Kendaraan");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 110, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Total  Bayar");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Lama Parkir");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Harga Parkir");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 110, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText(":");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 290, 30, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText(":");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 30, 30));

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText(":");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 30, 30));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText(":");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 30, 30));

        noken.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(noken, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 340, 30));

        lama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(lama, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 250, 180, 30));

        total.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 290, 340, 30));

        tabeldata.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "No Kendaraan ", "Jenis Kendaraan", "Lama Parkir", "Total Bayar", "Bayar", "Kembalian"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabeldata);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 870, 250));

        jButton1.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jButton1.setText("Proses");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 250, 110, 30));

        jButton2.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 110, -1));

        jButton3.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jButton3.setText("Save");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 110, -1));

        jButton4.setFont(new java.awt.Font("Tekton Pro", 1, 24)); // NOI18N
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 360, 110, -1));
        jPanel1.add(progres, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 870, 20));

        pilih.setEditable(false);
        pilih.setBackground(new java.awt.Color(255, 255, 255));
        pilih.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihActionPerformed(evt);
            }
        });
        jPanel1.add(pilih, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 340, 30));

        pilihan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pilihan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Motor", "Mobil" }));
        pilihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihanActionPerformed(evt);
            }
        });
        jPanel1.add(pilihan, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 340, 30));

        jPanel3.setBackground(new java.awt.Color(255, 51, 0));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        jPanel3.setPreferredSize(new java.awt.Dimension(690, 99));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tekton Pro", 1, 48)); // NOI18N
        jLabel10.setText("Transaksi Parkir");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tekton Pro", 1, 48)); // NOI18N
        jLabel11.setText("Rumah Sakit Jeti ");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 120));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Jenis Kendaraan");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 30));

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText(":");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 30, 30));

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setText("Jam");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 30, 30));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText(":");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, 30, 30));

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Bayar");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 110, 30));

        bayar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bayarMouseClicked(evt);
            }
        });
        bayar.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                bayarInputMethodTextChanged(evt);
            }
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jPanel1.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 330, 220, 30));

        jLabel16.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel16.setText(":");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 30, 30));

        kembalian.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jPanel1.add(kembalian, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 370, 340, 30));

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setText("Kembalian");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 110, 30));

        jButton5.setFont(new java.awt.Font("Tekton Pro", 1, 18)); // NOI18N
        jButton5.setText("Hitung");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 330, 110, 30));

        getContentPane().add(jPanel1);

        setSize(new java.awt.Dimension(966, 729));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Untuk Menyimpan Dalam Tabel
    if ("".equals(noken.getText()) || "".equals(lama.getText()) || "".equals(total.getText()) ||
            "".equals(bayar.getText()) || "".equals(kembalian.getText())) {
        JOptionPane.showMessageDialog(this, "Harap Isi Dengan Benar", "Error", JOptionPane.WARNING_MESSAGE);
    } else {
        String Jenis = (String) pilihan.getSelectedItem();
        String SQL = "INSERT INTO parkir (NoKendaraan, JenisKendaraan, LamaParkir, TotalBayar, Bayar, Kembalian)"
                     + " VALUES('" + noken.getText() + "','" + Jenis + "',"
                     + "'" + lama.getText() + "','" + total.getText() + "','" + bayar.getText() + "','" + kembalian.getText() + "')";
        try {
            int status = Koneksi.execute(SQL);
            if (status == 1) {
                JOptionPane.showMessageDialog(this, "Data Berhasil Di Tambahkan", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                selectData();
            } else {
                JOptionPane.showMessageDialog(this, "Data Gagal Di Tambahkan", "Gagal", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(transaksi_parkir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void pilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihActionPerformed
      
    }//GEN-LAST:event_pilihActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //untuk Menjalankan Progres Bar
        waktu.start(); 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       //Untuk Menghapus Yang Ada di Tabel
            int baris = tabeldata.getSelectedRow();
            if (baris != -1){
                String NoKendaraan = tabeldata.getValueAt(baris, 0).toString();
                String SQL = "DELETE FROM parkir WHERE NoKendaraan = '"+NoKendaraan+"'";
                try {
                    int status = Koneksi.execute(SQL);
                    if (status== 1){
                        JOptionPane.showMessageDialog(this, "Data Berhasil Di Hapus", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        JOptionPane.showMessageDialog(this, "Data Gagal Di Hapus", "Gagal", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(transaksi_parkir.class.getName()).log(Level.SEVERE, null, ex);
                }
            }try {
               selectData(); 
        } catch (SQLException ex) {
            Logger.getLogger(transaksi_parkir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // untuk Menghapus yang ada di Display
        noken.setText("");
        pilih.setText("");
        lama.setText("");
        total.setText("");
        bayar.setText("");
        kembalian.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void pilihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihanActionPerformed
        //Menampilkan If Else Pemilihan Jenis Kendaraan
        kode = (String) pilihan.getSelectedItem();
        if (kode == "Motor"){
            harga = 3000;
        }else{
            harga = 5000;
        }pilih.setText(String.valueOf(harga));
    }//GEN-LAST:event_pilihanActionPerformed

    private void bayarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bayarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarMouseClicked

    private void bayarInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_bayarInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarInputMethodTextChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        tbyr  = Integer.parseInt(total.getText());
        byr = Integer.parseInt(bayar.getText());
        if (byr < tbyr){
            javax.swing.JOptionPane.showMessageDialog(null, "Maaf Uang Anda Kurang!");
            byr=0;
            Number="";
            bayar.setText("");
        }
        else{
            kembali = byr - tbyr;
            Number = Integer.toString(kembali);
            kembalian.setText(Number);
            Number ="";
        }
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(transaksi_parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(transaksi_parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(transaksi_parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(transaksi_parkir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new transaksi_parkir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.ButtonGroup group;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTextField kembalian;
    private javax.swing.JTextField lama;
    private javax.swing.JTextField noken;
    private javax.swing.JTextField pilih;
    private javax.swing.JComboBox<String> pilihan;
    private javax.swing.JProgressBar progres;
    private javax.swing.JTable tabeldata;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
