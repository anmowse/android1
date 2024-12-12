package vn.edu.stu.myapplication;

import java.io.Serializable;

public class NhanVien implements Serializable {
    private String ma;
    private String ten;
    private int heSoLuong;
    private double luongCoBan;

    public NhanVien(String ma, String ten, int heSoLuong, double luongCoBan) {
        this.ma = ma;
        this.ten = ten;
        this.heSoLuong = heSoLuong;
        this.luongCoBan = luongCoBan;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(int heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    @Override
    public String toString() {
        return ma+ " "+ ten+ " " + heSoLuong+ " "+luongCoBan;
    }
}
