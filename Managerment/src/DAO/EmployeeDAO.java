/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quoc Dat
 */
public class EmployeeDAO {

    public int insertEmployee(Employee nh) {
        int kq = 0;

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = new MyConnection().getConnect();

            ps = cn.prepareStatement("INSERT INTO NhanVien (MaNV, HoTen, MatKhau, GioiTinh, VaiTro, MaPM) VALUES (?, ?, ?, ?, ?, ?)");

            ps.setString(1, nh.getMaNV());
            ps.setString(2, nh.getHoTen());
            ps.setString(3, nh.getMatKhau());
            ps.setInt(4, nh.getGioiTinh());
            ps.setInt(5, nh.getVaiTro());
            ps.setString(6, nh.getMaPM());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return kq;
    }

    public int updateEmployee(Employee nh) {
        int kq = 0;

        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = new MyConnection().getConnect();

            ps = cn.prepareStatement("UPDATE NhanVien SET HoTen=?, MatKhau=?, GioiTinh=?, VaiTro=?, MaPM=? WHERE MaNV=?");

            ps.setString(6, nh.getMaNV());
            ps.setString(1, nh.getHoTen());
            ps.setString(2, nh.getMatKhau());
            ps.setInt(3, nh.getGioiTinh());
            ps.setInt(4, nh.getVaiTro());
            ps.setString(5, nh.getMaPM());
            kq = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return kq;
    }

    public int deleteEmployee(String MaNV) {
        int kq = 0;
        //1. kết nối
        Connection cn = new MyConnection().getConnect();
        if (cn == null) {
            return -1; // ket noi k thanh cong
        }
        try {
            PreparedStatement ps = cn.prepareStatement("delete from NhanVien where MaNV=?");
            ps.setString(1, MaNV);
            kq = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kq;
    }

    public void showDetail(JTable tbl) {
        String[] header = {"Mã NV", "Họ tên", "Mật khẩu",
            "Giới tính", "Vai trò", "Mã phòng máy"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = "select * from NhanVien";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                if (rs.getInt(4) == 1) {
                    row.add("Nam");
                } else {
                    row.add("Nữ");
                }

                if (rs.getInt(5) == 1) {
                    row.add("Quản lý");
                } else {
                    row.add("Nhân Viên");
                }

                row.add(rs.getString(6));

                model.addRow(row);
            }
            tbl.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchDetail(JTable tbl, String search) {
        String[] header = {"Mã NV", "Họ tên", "Mật khẩu",
            "Giới tính", "Vai trò", "Mã phòng máy"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "select * from NhanVien ";
            sql += " where MaNV like '%" + search + "%' ";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                if (rs.getInt(4) == 1) {
                    row.add("Nam");
                } else {
                    row.add("Nữ");
                }
                if (rs.getInt(5) == 1) {
                    row.add("Quan ly");
                } else {
                    row.add("Nhân Viên");
                }
                row.add(rs.getString(6));
                model.addRow(row);
            }
            tbl.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Employee hienthi(JTable tbl, int a) {
        int vaiTro = 0;
        int gender = 0;
        String maNV = String.valueOf(tbl.getValueAt(a, 0));
        String hoTen = String.valueOf(tbl.getValueAt(a, 1));
        String matKhau = String.valueOf(tbl.getValueAt(a, 2));        
        String gioiTinh = String.valueOf(tbl.getValueAt(a, 3));
        String vitri = String.valueOf(tbl.getValueAt(a, 4));
        String maPM = String.valueOf(tbl.getValueAt(a, 5));
        
        if (gioiTinh.equals("Nam")) {
            gender = 1;
        } else {
            gender = 0;
        }
        if (vitri.equals("Nhân Viên")) {
            vaiTro = 0;
        } else {
            vaiTro = 1;
        }
        Employee cd = new Employee(maNV, hoTen, matKhau, gender, vaiTro, maPM);
        return cd;
    }

}
