/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Game;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Quoc Dat
 */
public class GameDAO {

    public GameDAO() {

    }

    public void showDetail(JTable tbl) {
        String header[] = {"Mã thể loại", "Tên thể loại",
            "Hình", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            Statement st = con.createStatement();
            String sql = " select * from TheLoai";
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                model.addRow(row);
            }
            tbl.setModel(model);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchDetail(JTable tbl, String search) {
        String header[] = {"Mã thể loại", "Tên thể loại",
            "Hình", "Mô tả"};
        DefaultTableModel model = new DefaultTableModel(header, 0);
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "select * from TheLoai ";
            sql += " where TenTL like '%" + search + "%' ";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Vector row = new Vector();
                row.add(rs.getString(1));
                row.add(rs.getString(2));
                row.add(rs.getString(3));
                row.add(rs.getString(4));
                model.addRow(row);
            }
            tbl.setModel(model);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Game hienthi(JTable tbl, int a) {
        String MaTL = String.valueOf(tbl.getValueAt(a, 0));
        String TenTL = String.valueOf(tbl.getValueAt(a, 1));
        String Hinh = String.valueOf(tbl.getValueAt(a, 2));
        String MoTa = String.valueOf(tbl.getValueAt(a, 3));
        Game cd = new Game(MaTL, TenTL, Hinh, MoTa);
        return cd;
    }

    public void insertItem(Game cd) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "insert into TheLoai values(?,?,?,?)";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cd.getMaTL());
            stm.setString(2, cd.getTenTL());
            stm.setString(3, cd.getHinh());
            stm.setString(4, cd.getMota());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateItem(Game cd) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "update TheLoai set TenTL=?, Hinh=?, MoTa=? where MaTL=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(4, cd.getMaTL());
            stm.setString(1, cd.getTenTL());
            stm.setString(2, cd.getHinh());
            stm.setString(3, cd.getMota());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteItem(Game cd) {
        try {
            Connection con = new MyConnection().getConnect();
            String sql = "delete from TheLoai where MaTL=?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cd.getMaTL());
            stm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String chonAnh(JLabel lbllogo) {
        String fileimage = "";
        BufferedImage img = null;
        JFileChooser filec = new JFileChooser("src\\Images\\");
        int r = filec.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            File fl = filec.getSelectedFile();
            try {
                img = ImageIO.read(fl);
                String qaz = String.valueOf(fl);
                String[] str = qaz.split("\\\\");
                fileimage = str[str.length - 1];
                JOptionPane.showMessageDialog(null, fileimage);
                ImageIO.write(img, "png", new File("src\\icon\\" + str[str.length - 1]));
                Image dmg = img.getScaledInstance(lbllogo.getWidth(), lbllogo.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon icon = new ImageIcon(dmg);
                lbllogo.setIcon(icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileimage;
    }


}
