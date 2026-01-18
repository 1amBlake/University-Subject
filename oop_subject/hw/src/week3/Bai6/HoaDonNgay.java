package week3.Bai6;

import java.time.LocalDate;

public class HoaDonNgay extends HoaDon {
	protected int SNgayThue;
	protected double ThanhTien;

	protected HoaDonNgay() {
		super();
		this.SNgayThue = -1;
	}

	protected HoaDonNgay(String maHD, String tenKH, LocalDate ngayHD, int maPG, double dgia, int snThue) {
		super(maHD, tenKH, ngayHD, maPG, dgia);
		this.SNgayThue = snThue;
	}

	protected int getSNgayThue() {
		return SNgayThue;
	}

	protected void setSNgayThue(int sNgayThue) {
		SNgayThue = sNgayThue;
	}

	protected double getThanhTien() {
		return ThanhTien;
	}

	public void ThanhTien() {
		int day = getSNgayThue();
		if (day <= 7)
			this.ThanhTien = day * getDonGia();
		else
			this.ThanhTien = (7 * getDonGia()) + (((day - 7) * getDonGia()) - ((day - 7) * getDonGia() * 0.02));
	}

	@Override
	public String toString() {
		return "[Hóa Đơn Ngày]" + super.toString() + " | " + getSNgayThue() + " | " + getThanhTien();
	}
}
