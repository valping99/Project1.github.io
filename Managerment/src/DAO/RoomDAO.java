/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Game;
import Model.Room;
import UI.RoomUI;
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
public class RoomDAO {
    public RoomDAO(){
        
    }
    

    public void showDetail(JTable tbl) {
        String header[] = {"Mã phòng máy","Mức phí","Thời lượng (Phút)","Ghi chú","Mã chi nhánh","Mã thể loại"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from PhongMay";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getFloat(2));
                row.add(rs.getInt(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchDetail(JTable tbl, String search) {
        String header[] = {"Mã phòng máy","Mức phí","Thời lượng","Ghi chú","Mã chi nhánh","Mã thể loại"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "select * from PhongMay ";
            sql += " where MaPM like '%" + search + "%' ";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getFloat(2));
                row.add(rs.getInt(3));
                row.add(rs.getString(4));
                row.add(rs.getString(5));
                row.add(rs.getString(6));
                model.addRow(row);
            }
            tbl.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Room hienthi(JTable tbl,int a) {
        String MaPM = String.valueOf(tbl.getValueAt(a, 0));
        float MucPhi = Float.parseFloat(String.valueOf(tbl.getValueAt(a, 1)));
        int ThoiLuong = Integer.parseInt(String.valueOf(tbl.getValueAt(a, 2)));
        String GhiChu = String.valueOf(tbl.getValueAt(a, 3));
        String MaCN = String.valueOf(tbl.getValueAt(a, 4));
        String MaTL = String.valueOf(tbl.getValueAt(a, 5));
        Room cd = new Room(MaPM, MucPhi, ThoiLuong, GhiChu, MaCN, MaTL);
        return cd;
    }

    public void insertItem(Room in) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "insert into PhongMay values(?,?,?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, in.getMaPM());
            stm.setFloat(2, Float.parseFloat(String.valueOf(in.getMucPhi())));
            stm.setInt(3, in.getThoiLuong());
            stm.setString(4, in.getGhiChu());
            stm.setString(5, in.getMaCN());
            stm.setString(6, in.getMaTL());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Room ud) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "update PhongMay set MucPhi=?, ThoiLuong=?, GhiChu=?, MaCN=?, MaTL=? where MaPM=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(6, ud.getMaPM());
            stm.setFloat(1, Float.parseFloat(String.valueOf(ud.getMucPhi())));
            stm.setInt(2, Integer.parseInt(String.valueOf(ud.getThoiLuong())));
            stm.setString(3, ud.getGhiChu());
            stm.setString(4, ud.getMaCN());
            stm.setString(5, ud.getMaTL());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(Room del) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "delete from PhongMay where MaPM=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, del.getMaPM());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertItem(RoomUI cd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
