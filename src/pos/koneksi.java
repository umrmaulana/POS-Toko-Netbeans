/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author umrmaulana
 */
public class koneksi {

    Connection conn;
    String url = "jdbc:mysql://localhost:3306/pos_toko";
    String user = "root";
    String password = "";

    public koneksi() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                System.out.println("Koneksi ke database berhasil!");
            } else {
                System.out.println("Gagal koneksi ke database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        koneksi k = new koneksi();
    }
}
