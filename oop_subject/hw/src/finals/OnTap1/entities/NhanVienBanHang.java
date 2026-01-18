package finals.OnTap1.entities;

public class NhanVienBanHang extends NhanVien { // toString 55
	private double DoanhSoBanHang;

	public double getDoanhSoBanHang() {
		return DoanhSoBanHang;
	}

	public void setDoanhSoBanHang(double doanhSoBanHang) {
		if (doanhSoBanHang <= 0)
			throw new IllegalArgumentException("Doanh số bán hàng phải dương!");
		DoanhSoBanHang = doanhSoBanHang;
	}

	public NhanVienBanHang() {
		super();
	}

	public NhanVienBanHang(String maNV, String hoTen, long soDienThoai, double luongCB, double doanhSoBanHang) {
		super(maNV, hoTen, soDienThoai, luongCB);
		setDoanhSoBanHang(doanhSoBanHang);
	}

	@Override
	public double tinhLuongNV() {
		if (getDoanhSoBanHang() > 20)
			return getLuongCB() + (0.03 * getDoanhSoBanHang());
		return getLuongCB();
	}

	@Override
	public String toString() {
		String s = String.format("|%s|%10.2f|", super.toString(), getDoanhSoBanHang());
		return s;
	}
}
