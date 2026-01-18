package finals.OnTap1.entities;

public class NhanVienHanhChinh extends NhanVien {
	private double HeSoLuong;

	public double getHeSoLuong() {
		return HeSoLuong;
	}

	public void setHeSoLuong(double heSoLuong) {
		if (heSoLuong < 1.66 || heSoLuong > 8.69)
			throw new IllegalArgumentException("Hệ số lương của nhân viên không hợp lệ!");
		HeSoLuong = heSoLuong;
	}

	public NhanVienHanhChinh() {
		super();
	}

	public NhanVienHanhChinh(String maNV, String hoTen, long soDienThoai, double luongCB, double heSoLuong) {
		super(maNV, hoTen, soDienThoai, luongCB);
		setHeSoLuong(heSoLuong);
	}

	@Override
	public double tinhLuongNV() {
		return getLuongCB() * getHeSoLuong();
	}

	public String toString() {
		String s = String.format("|%s|%10.3f|", super.toString(), getHeSoLuong());
		return s;
	}
}
