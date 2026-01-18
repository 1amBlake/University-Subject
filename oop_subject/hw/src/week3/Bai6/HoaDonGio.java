package week3.Bai6;

import java.time.LocalDate;

public class HoaDonGio extends HoaDon {
	protected int GioThue;
	protected double ThanhTien;

	protected HoaDonGio() {
		super();
		this.GioThue = -1;
	}

	protected HoaDonGio(String maHD, String tenKH, LocalDate ngayHD, int maPG, double dgia, int gThue) {
		super(maHD, tenKH, ngayHD, maPG, dgia);
		this.GioThue = gThue;
	}

	protected int getGioThue() {
		return GioThue;
	}

	protected void setGioThue(int gioThue) {
		GioThue = gioThue;
	}

	protected double getThanhTien() {
		return ThanhTien;
	}

	public void ThanhTien() {
		this.ThanhTien = getThanhTien() * getGioThue();
	}

	@Override
	public String toString() {
		return "[Hóa Đơn Giờ]" + super.toString() + " | " + getGioThue() + " | " + getThanhTien() + " | ";
	}
}
