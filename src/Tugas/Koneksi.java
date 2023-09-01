package Tugas;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Personal
 */
public class Koneksi {
     public static Connection setKoneksi() throws SQLException{
         //Untuk Menyambungkan Database
       String konString = "Jdbc:mysql://localhost:3306/jv_tparkir";
       Connection koneksi = null;
           try {
               Class.forName("com.mysql.jdbc.Driver");
               koneksi = (Connection)DriverManager.getConnection(konString, "root", "");
               System.out.println("Koneksi Berhasil");
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Koneksi Gagal");
           }catch (SQLException ex) {
               Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
               System.out.println("Koneksi Gagal");
       }
       return koneksi;
   }
   
   public static int execute(String SQL) throws SQLException {
       int status = 0;
       Connection Koneksi = setKoneksi();
       try {
           Statement st = Koneksi.createStatement();
           status = st.executeUpdate(SQL);
       } catch (SQLException ex) {
           Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
       }
       return status;
   }
   
   public static ResultSet executeQuery(String SQL) throws SQLException {
       ResultSet rs = null;
       Connection koneksi = setKoneksi();
       try {
           Statement st = koneksi.createStatement();
           rs = st.executeQuery(SQL);
       } catch (SQLException ex) {
           Logger.getLogger(Koneksi.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       return rs;
       
   }  
}
