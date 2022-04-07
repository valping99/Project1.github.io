/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quoc Dat
 */
public class StatisticsDAO {

    public void showTheLoai(JTable tbl) {
        String header[] = {"Tên thể loại", "Tổng số người chơi", "Tổng doanh thu (VNĐ)"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "{ call sp_ThongKeTheLoai()}";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getInt(2));
                row.add(rs.getInt(3));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showNhanVien(JTable tbl, String MaPM) {
        String header[] = {"Mã nhân viên", "Họ tên", "Giới tính", "Vai trò"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "{ call sp_NhanVien (?)}";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, MaPM);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                if (rs.getInt(3) == 1) {
                    row.add("Nam");
                } else {
                    row.add("Nữ");
                }
                if (rs.getInt(4) == 1) {
                    row.add("Quản lý");
                } else {
                    row.add("Nhân Viên");
                }
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showNguoiChoi(JTable tbl, String MaPM) {
        String header[] = {"Mã người chơi", "Mật khẩu", "Số tiền nạp (VNĐ)", "Thời gian còn lại (Phút)"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "{ call sp_ThongKeNguoiChoi (?)}";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, MaPM);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getInt(3));
                if (rs.getString(5)=="PM001"  ) {
                    row.add(rs.getInt(4)*60/12000);
                } else if(rs.getString(5)=="PM002" ){
                    row.add(rs.getInt(4)*60/8000);
                } else{                    
                    row.add(rs.getInt(4)*60/24000);
                }
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void ShowChiNhanh(JTable tbl) {
        String header[] = {"Chi nhánh", "Tổng số phòng máy", "Tổng doanh thu (VNĐ)", "Tổng quản lý và nhân viên"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "{ call sp_ThongKeChiNhanh()}";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getInt(2));
                row.add(rs.getInt(3));
                row.add(rs.getInt(4));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showPhongMay(JTable tbl) {
        String header[] = {"Mã phòng máy", "Tổng số người chơi", "Tổng doanh Thu (VNĐ)", "Tiền nạp cao nhất (VNĐ)", "Tiền nạp thấp nhất (VNĐ)", "Chi nhánh","Loại phòng máy"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "{ call sp_ThongKePhongMay ()}";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getInt(2));
                row.add(rs.getInt(3));
                row.add(rs.getInt(4));
                row.add(rs.getInt(5));
                row.add(rs.getString(6));
                row.add(rs.getString(7));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addComboBoxNhanVien(JComboBox cbo) {
        cbo.removeAllItems();
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "select MaPM from PhongMay";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbo.addItem(rs.getString(1));
            }
            cbo.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void addComboNguoiChoi(JComboBox cbo) {
        cbo.removeAllItems();
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "select MaPM from PhongMay";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                cbo.addItem(rs.getString(1));
            }
            cbo.setSelectedIndex(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    


}
