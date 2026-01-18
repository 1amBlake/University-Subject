package midterm2.entities;

import java.time.LocalDate;

public class HangThucPham {
	private String MaHang;
	private String TenHang;
	private String NhaSanXuat;
	private LocalDate NgayNhapKho;
	private String DonViTinh;
	private double DonGia;

	public String getMaHang() {
		return MaHang;
	}

	public void setMaHang(String maHang) {
		MaHang = maHang;
	}

	public String getTenHang() {
		return TenHang;
	}

	public void setTenHang(String tenHang) {
		TenHang = tenHang;
	}

	public String getNhaSanXuat() {
		return NhaSanXuat;
	}

	public void setNhaSanXuat(String nhaSanXuat) {
		NhaSanXuat = nhaSanXuat;
	}

	public LocalDate getNgayNhapKho() {
		return NgayNhapKho;
	}

	public void setNgayNhapKho(LocalDate ngayNhapKho) {
		LocalDate today = LocalDate.now();
		if (ngayNhapKho.isAfter(today))
			throw new IllegalArgumentException("Ngày nhập kho không hợp lệ!");
		NgayNhapKho = ngayNhapKho;
	}

	public String getDonViTinh() {
		return DonViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		DonViTinh = donViTinh;
	}

	public double getDonGia() {
		return DonGia;
	}

	public void setDonGia(double donGia) {
		if (donGia < 0)
			throw new IllegalArgumentException("Đơn giá không hợp lệ!");
		DonGia = donGia;
	}

	public HangThucPham(String maHang, String tenHang, String nhaSanXuat, LocalDate ngayNhapKho, String donViTinh,
			double donGia) {
		setMaHang(maHang);
		setTenHang(tenHang);
		setNhaSanXuat(nhaSanXuat);
		setNgayNhapKho(ngayNhapKho);
		setDonViTinh(donViTinh);
		setDonGia(donGia);
	}

	@Override
	public String toString() {
		String s = String.format("|%20s|%20s|%20s|%20s|%20s|%10f", getMaHang(), getTenHang(), getNhaSanXuat(),
				getNgayNhapKho(), getDonViTinh(), getDonGia());
		return s;
	}
}