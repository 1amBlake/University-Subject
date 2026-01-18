package week3.Bai2;

import java.util.*;
import java.time.*;
import java.time.format.*;

public class Sach {
	protected String MaSach,NXB;
	protected long SoLuong;
	protected double  DonGia, ThanhTien;
	protected LocalDate NgayNhap;
	protected DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	Scanner sc = new Scanner(System.in);
	
	protected String getMaSach() {
		return MaSach;
	}
	protected void setMaSach(String maSach) {
		MaSach = maSach;
	}
	
	protected LocalDate getNgayNhap() {
		return NgayNhap;
	}
	
	protected String getNXB() {
		return NXB;
	}
	protected void setNBX(String nhaXB) {
		NXB = nhaXB;
	}
	
	protected double getDonGia() {
		return DonGia;
	}
	protected void setDonGia(double donGia) {
		DonGia = donGia;
	}
	
	protected double getThanhTien() {
		return ThanhTien;
	}
	protected void setThanhTien(double thanhTien) {
		ThanhTien = thanhTien;
	}
	
	protected long getSoLuong() {
		return SoLuong;
	}
	protected void setSoLuong(long soLuong) {
		SoLuong = soLuong;
	}
	
	protected Sach() {
		MaSach = "";
		NgayNhap = LocalDate.now();
		NXB = "";
		DonGia = 0;
		ThanhTien = 0;
		SoLuong = 0;
	}
	
	protected Sach(String msach, String nxb, double dgia, double ttien, long sluong) {
		this.MaSach = msach;
		this.NgayNhap = LocalDate.now();
		this.NXB = nxb;
		this.DonGia = dgia;
		this.ThanhTien = ttien;
		this.SoLuong = sluong;
	}
	
	public void nhap() {
		System.out.println("Nhập mã sách: ");
		MaSach = sc.nextLine();
		System.out.println("Nhập đơn giá: ");
		DonGia = sc.nextDouble();
		System.out.println("Nhập số lượng: ");
		SoLuong = sc.nextLong();
		sc.nextLine();
		System.out.println("Nhập Nhà xuất bản: ");
		NXB = sc.nextLine();
	}
	
	public String toString() {
		return "Mã sách: "+MaSach+", Ngày nhập: "+NgayNhap.format(format)+", Đơn giá: "+DonGia+", Số lượng: "+SoLuong;
	}
}

class SachGiaoKhoa extends Sach{
	protected int TinhTrang;
	
	protected int getTinhTrang() {
		return TinhTrang;
	}
	protected void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	
	public SachGiaoKhoa() {
		super();
		this.TinhTrang = 0;
	}
	
	public SachGiaoKhoa(String ms, String nxb, double dgia, double ttien, long sluong, int ttrang) {
		super(ms, nxb, dgia, ttien, sluong);
		this.TinhTrang = ttrang;
	}
	
	public void nhap() {
		super.nhap();
		
		do {
			System.out.println("Tình trạng sách: 1. Sách mới 2. Sách cũ");
			TinhTrang = sc.nextInt();
			if (TinhTrang < 1 || TinhTrang > 2) System.out.println("Tình trạng nhập vào không hợp lệ! Vui lòng nhập lại!");
		}while(TinhTrang < 1 || TinhTrang > 2);
		
	}
	
	public double ThanhTien() {
		if (TinhTrang == 1) return this.ThanhTien = this.SoLuong * this.DonGia;
		else return this.ThanhTien = this.SoLuong * this.DonGia * 0.5;
	}
	
	
	public String toString() {
		String temp;
		if(TinhTrang == 1) temp = "Sách Mới";
		else temp = "Sách Cũ";
		return "SGK: "+super.toString()+", Tình Trạng: "+temp+", Thành tiền: "+ThanhTien;
	}
}

class SachThamKhao extends Sach{
	protected double Tax;
	
	protected double getTax() {
		return Tax;
	}
	protected void setTax(double tax) {
		Tax = tax;
	}
	
	public SachThamKhao() {
		super();
		this.Tax = 0;
	}
	
	public SachThamKhao(String ms, String nxb, double dgia, double ttien, long sluong, double tax) {
		super(ms, nxb, dgia, ttien, sluong);
		this.Tax = tax;
	}
	
	public double ThanhTien() {
		return this.ThanhTien = this.SoLuong * this.DonGia + this.Tax;
	}
	
	public void nhap() {
		super.nhap();
	}
	
	public String toString() {
		return "STK: "+super.toString()+", Thành tiền: "+ThanhTien;
	}
}