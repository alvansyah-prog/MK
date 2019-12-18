/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author acer
 */
public class Koneksi {
    private String url = "jdbc:sqlserver://127.0.0.1;database=Manajemen_Keuangan;user=sa;password=123";
    private Connection conn;

    public Connection getConn() throws Exception {
        conn = DriverManager.getConnection(url);
        return conn;
    }
     public int dml(String query){
        int jumlah = 0;
        try {
            conn = DriverManager.getConnection(url);
            java.sql.Statement save = conn.createStatement();
            jumlah = save.executeUpdate(query);
            conn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "pesan", 0);
        }
        return jumlah;
    }
     public void reset(JTable nTable){
         while (nTable.getRowCount()>0) {             
             DefaultTableModel table = (DefaultTableModel) nTable.getModel();
             table.removeRow(0);
         }
     }
}
