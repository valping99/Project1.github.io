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
public class Game {
    private String MaTL;
    private String TenTL;
    private String Hinh;
    private String Mota;

    public Game(String MaTL, String TenTL, String Hinh, String Mota) {
        this.MaTL = MaTL;
        this.TenTL = TenTL;
        this.Hinh = Hinh;
        this.Mota = Mota;
    }

    public Game() {
    }

    public String getMaTL() {
        return MaTL;
    }

    public void setMaTL(String MaTL) {
        this.MaTL = MaTL;
    }

    public String getTenTL() {
        return TenTL;
    }

    public void setTenTL(String TenTL) {
        this.TenTL = TenTL;
    }

    public String getHinh() {
        return Hinh;
    }

    public void setHinh(String Hinh) {
        this.Hinh = Hinh;
    }

    public String getMota() {
        return Mota;
    }

    public void setMota(String Mota) {
        this.Mota = Mota;
    }

    
}
