/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;

/**
 *
 * @author Quoc Dat
 */
public class Employee implements Serializable{
    private String MaNV;
    private String HoTen;
    private String MatKhau;
    private int GioiTinh;
    private int VaiTro;
    private String MaPM;

    public Employee() {
    }

    public Employee(String MaNV, String HoTen, String MatKhau, int GioiTinh, int VaiTro, String MaPM) {
        this.MaNV = MaNV;
        this.HoTen = HoTen;
        this.MatKhau = MatKhau;
        this.GioiTinh = GioiTinh;
        this.VaiTro = VaiTro;
        this.MaPM = MaPM;
    }


    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public int getVaiTro() {
        return VaiTro;
    }

    public void setVaiTro(int VaiTro) {
        this.VaiTro = VaiTro;
    }

    public String getMaPM() {
        return MaPM;
    }

    public void setMaPM(String MaPM) {
        this.MaPM = MaPM;
    }
    
}
