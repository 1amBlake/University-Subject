package week3.Bai6;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class HoaDon {

	DateTimeFormatter format = DateTimeFormatter.ofPattern("d/M/yyyy");
	protected String MaHD, TenKH;
	protected LocalDate NgayHD;
	protected int MaPG;
	protected double DonGia;

	protected HoaDon() {
		this.MaHD = "n/a";
		this.TenKH = "n/a";
		this.NgayHD = LocalDate.now();
		this.MaPG = -1;
		this.DonGia = -1;
	}

	protected HoaDon(String maHD, String tenKH, LocalDate ngayHD, int maPG, double dgia) {
		this.MaHD = maHD;
		this.TenKH = tenKH;
		this.NgayHD = ngayHD;
		this.MaPG = maPG;
		this.DonGia = dgia;
	}

	protected DateTimeFormatter getFormat() {
		return format;
	}

	protected void setFormat(DateTimeFormatter format) {
		this.format = format;
	}

	protected String getMaHD() {
		return MaHD;
	}

	protected void setMaHD(String maHD) {
		MaHD = maHD;
	}

	protected String getTenKH() {
		return TenKH;
	}

	protected void setTenHD(String tenKH) {
		TenKH = tenKH;
	}

	protected LocalDate getNgayHD() {
		return NgayHD;
	}

	protected void setNgayHD(LocalDate ngayHD) {
		NgayHD = ngayHD;
	}

	protected int getMaPG() {
		return MaPG;
	}

	protected void setMaPG(int maPG) {
		MaPG = maPG;
	}

	protected double getDonGia() {
		return DonGia;
	}

	protected void setDonGia(double donGia) {
		DonGia = donGia;
	}

	public String toString() {
		return "| " + getMaHD() + " | " + getTenKH() + " | " + getNgayHD() + " | " + getMaPG() + " | " + getDonGia();
	}
}
