/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Quoc Dat
 */
public class Room {
    private String MaPM;
    private float MucPhi;
    private int ThoiLuong;
    private String GhiChu;
    private String MaCN;
    private String MaTL;

    public Room() {
    }

    public Room(String MaPM, float MucPhi, int ThoiLuong, String GhiChu, String MaCN, String MaTL) {
        this.MaPM = MaPM;
        this.MucPhi = MucPhi;
        this.ThoiLuong = ThoiLuong;
        this.GhiChu = GhiChu;
        this.MaCN = MaCN;
        this.MaTL = MaTL;
    }

    public String getMaPM() {
        return MaPM;
    }

    public void setMaPM(String MaPM) {
        this.MaPM = MaPM;
    }

    public float getMucPhi() {
        return MucPhi;
    }

    public void setMucPhi(float MucPhi) {
        this.MucPhi = MucPhi;
    }

    public int getThoiLuong() {
        return ThoiLuong;
    }

    public void setThoiLuong(int ThoiLuong) {
        this.ThoiLuong = ThoiLuong;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String MaCN) {
        this.MaCN = MaCN;
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

}
