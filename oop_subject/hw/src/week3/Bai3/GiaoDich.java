package week3.Bai3;
import java.util.*;
public class GiaoDich {
	protected int MaGD, SoLuong;
	protected String NgayGD;
	protected double DonGia, ThanhTien;
	Scanner sc = new Scanner(System.in);
	
	protected GiaoDich() {
		this.MaGD = 0;
		this.NgayGD = "";
		this.DonGia = 0;
		this.SoLuong = 0;
		this.ThanhTien = 0;
	}
	protected GiaoDich(int ma, int sl, String ngay, double dgia, double ttien) {
		this.MaGD = ma;
		this.NgayGD = ngay;
		this.DonGia = dgia;
		this.SoLuong = sl;
		this.ThanhTien = ttien;
	}
	
	protected int getMaGD() {
		return MaGD;
	}
	protected void setMaGD(int maGD) {
		MaGD = maGD;
	}
	protected int getSoLuong() {
		return SoLuong;
	}
	protected void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	protected String getNgayGD() {
		return NgayGD;
	}
	protected void setNgayGD(String ngayGD) {
		NgayGD = ngayGD;
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
	
	protected void nhap() {
		System.out.println("Mã giao dịch: ");
		MaGD = sc.nextInt();
		System.out.println("Ngày giao dịch: ");
		NgayGD = sc.next();
		System.out.println("Đơn giá: ");
		DonGia = sc.nextDouble();
		System.out.println("Số lượng: ");
		SoLuong = sc.nextInt();
	}
	
	public String toString() {
		return "Mã giao dịch: "+MaGD+", Số lượng: "+SoLuong+", Ngày gia dịch: "+NgayGD+", Đơn giá: "+DonGia;
	}
}

class GiaoDichVang extends GiaoDich{
	private String LoaiVang;
	
	public GiaoDichVang() {
		super();
		this.LoaiVang = "";
	}
	public GiaoDichVang(int ma, int sl, String ngay, double dgia, double ttien, String lvang) {
		super(ma, sl, ngay, dgia, ttien);
		this.LoaiVang = lvang;
	}
	
	public String getLoaiVang() {
		return LoaiVang;
	}
	public void setLoaiVang(String loaiVang) {
		LoaiVang = loaiVang;
	}
	
	public void nhap() {
		super.nhap();
		System.out.println("Loại vàng: ");
		LoaiVang = sc.next();
	}
	
	public double TTien() {
		return this.ThanhTien = this.DonGia * this.SoLuong;
	}
	
	public String toString() {
		return "Giao dịch vàng: "+super.toString()+", Loại vàng: "+LoaiVang+", Thành tiền: "+ThanhTien;
	}
}

class GiaoDichTienTe extends GiaoDich{
	private double TiGia;
	private int LoaiTienTe;
	
	public GiaoDichTienTe() {
		super();
		this.TiGia = 0;
		this.LoaiTienTe = 0;
	}
	public GiaoDichTienTe(int ma, int sl, String ngay, double dgia, double ttien, double tgia, int loai) {
		super(ma, sl, ngay, dgia, ttien);
		this.TiGia = tgia;
		this.LoaiTienTe = loai;
	}
	
	public double getTiGia() {
		return TiGia;
	}
	public void setTiGia(double tiGia) {
		TiGia = tiGia;
	}
	public int getLoaiTienTe() {
		return LoaiTienTe;
	}
	public void setLoaiTienTe(int loaiTienTe) {
		LoaiTienTe = loaiTienTe;
	}
	
	public void nhap() {
		super.nhap();
		System.out.println("Tỉ giá: ");
		TiGia = sc.nextDouble();
		System.out.println("Loại tiền tệ: ");
		LoaiTienTe = sc.nextInt();
	}
	public double TTien(){
		if (LoaiTienTe == 1) 
			return this.ThanhTien = this.DonGia * this.SoLuong;
		else
			return this.ThanhTien = this.DonGia * this.SoLuong * this.TiGia;
	}
	
	public String toString() {
		String temp;
		if(LoaiTienTe == 1) temp = "VND";
		else if (LoaiTienTe == 2) temp = "USD";
		else temp = "EURO";
		return "Giao dịch tiền tệ: "+super.toString()+", Tỉ giá: "+TiGia+", Loại tiền tệ"+temp+", Thành tiền: "+ThanhTien;
	}
}