/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quoc Dat
 */
public class CustomerDAO {
    public void showDetail(JTable tbl) {
        String header[] = {"Mã người chơi","Mật khẩu","Mã phòng máy","Số tiền nạp"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from NguoiChoi";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getFloat(4));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchDetail(JTable tbl, String search) {
        String header[] = {"Mã người chơi","Mật khẩu","Mã phòng máy","Số tiền nạp"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "select * from NguoiChoi ";
            sql += " where MaNC like '%" + search + "%' ";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getFloat(4));
                model.addRow(row);
            }
            tbl.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer hienthi(JTable tbl,int a) {
        String MaNC = String.valueOf(tbl.getValueAt(a, 0));
        String MatKhau = String.valueOf(tbl.getValueAt(a, 1));
        String MaPM = String.valueOf(tbl.getValueAt(a, 2));
        float TienNap = Float.parseFloat(String.valueOf(tbl.getValueAt(a, 3)));
        Customer nc = new Customer(MaNC, MatKhau, MaPM, TienNap);
        return nc;
    }

    public void insertItem(Customer in) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "insert into NguoiChoi values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, in.getMaNC());
            stm.setString(2, in.getMatKhau());
            stm.setString(3, in.getMaPM());
            stm.setFloat(4, Float.parseFloat(String.valueOf(in.getTienNap())));
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addMoreMoney(Customer add) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "update NguoiChoi set TienNap=TienNap + ? where MaNC=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(2, add.getMaNC());
            stm.setFloat(1, Float.parseFloat(String.valueOf(add.getTienNap())));
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Customer ud) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "update NguoiChoi set MatKhau=?, MaPM=?, TienNap=? where MaNC=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(4, ud.getMaNC());
            stm.setString(1, ud.getMatKhau());
            stm.setString(2, ud.getMaPM());
            stm.setFloat(3, Float.parseFloat(String.valueOf(ud.getTienNap())));
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(Customer del) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "delete from NguoiChoi where MaNC=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, del.getMaNC());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}
