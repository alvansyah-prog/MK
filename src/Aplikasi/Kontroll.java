/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aplikasi;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author acer
 */
public class Kontroll implements Interface{
    private Koneksi conn = new Koneksi();
    private Statement smt;
    private ResultSet rs;
    private String sql;
    private String salah;
//    private ArrayList<Tanpung> cek = new ArrayList<Tanpung>();
    
    @Override
    public int simpan(Pengguna p) {
        int jumlah = 0;
        sql = "insert into pengguna values ('"+p.getUser()+"','"+p.getPassword()+"','"+p.getNama_Perusahaan()+"')";
        jumlah=conn.dml(sql);
        return jumlah;
    }

    @Override
    public int login(Pengguna p) {
        int jumlah = 0;
        try {
            String sql = "Select * from Pengguna";
            smt = conn.getConn().createStatement();
            rs = smt.executeQuery(sql);
            Tanpung t =new Tanpung();
            while (rs.next()) {
//                t.setUser(rs.getString(1));
//                t.setPassword(rs.getString(2));
//                cek.add(t);
                if(p.getUser().equals(rs.getString(1))) {
                    if (p.getPassword().equals(rs.getString(2))) {
                        jumlah = 1;
                    } else {
                    }
                }else{
                    
                }
            }
//            for (int i = 0; i <cek.size() ; i++) {
//                if(user.equals(cek.get(i).getUser())) {
//                    if (pass.equals(cek.get(i).getPassword())) {
//                        jumlah = 1;
//                    } else if(i+1>=cek.size()){
////                        jumlah = 2;
//                    }
//                }
//            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Pesan Erorr", 1);
        }
        return jumlah;
    }

    
}
