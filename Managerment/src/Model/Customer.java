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
public class Customer {
    private String MaNC;
    private String MatKhau;
    private String MaPM;
    private float TienNap;

    public Customer() {
    }
 
    public Customer(String MaNC, String MatKhau, String MaPM, float TienNap) {
        this.MaNC = MaNC;
        this.MatKhau = MatKhau;
        this.MaPM = MaPM;
        this.TienNap = TienNap;
    }

    public String getMaNC() {
        return MaNC;
    }

    public void setMaNC(String MaNC) {
        this.MaNC = MaNC;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getMaPM() {
        return MaPM;
    }

    public void setMaPM(String MaPM) {
        this.MaPM = MaPM;
    }

    public float getTienNap() {
        return TienNap;
    }

    public void setTienNap(float TienNap) {
        this.TienNap = TienNap;
    }
 
}
