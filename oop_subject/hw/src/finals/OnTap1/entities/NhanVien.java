package finals.OnTap1.entities;

public abstract class NhanVien {
	protected String MaNV;
	protected String HoTen;
	protected long SoDienThoai;
	protected double LuongCB;

	public abstract double tinhLuongNV();

	public String getMaNV() {
		return MaNV;
	}

	public void setMaNV(String maNV) {
		MaNV = maNV;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		for (int i = 0; i < hoTen.length(); i++) {
			if (!Character.isLetter(hoTen.charAt(i)))
				throw new IllegalArgumentException("Họ Tên phải là chữ cái!");
		}
		HoTen = hoTen;
	}

	public long getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(long soDienThoai) {
		if (soDienThoai < 100000000L || soDienThoai > 9999999999L)
			throw new IllegalArgumentException("Số điện thoại nhập vào không hợp lệ!");
		SoDienThoai = soDienThoai;
	}

	public double getLuongCB() {
		return LuongCB;
	}

	public void setLuongCB(double luongCB) {
		if (luongCB <= 0)
			throw new IllegalArgumentException("Lương cơ bản phải là số dương!");
		LuongCB = luongCB;
	}

	public NhanVien() {
		setMaNV("n/a");
		setHoTen("n/a");
		setSoDienThoai(1);
		setLuongCB(1);
	}

	public NhanVien(String maNV, String hoTen, long soDienThoai, double luongCB) {
		setMaNV(maNV);
		setHoTen(hoTen);
		setSoDienThoai(soDienThoai);
		setLuongCB(luongCB);
	}

	@Override
	public String toString() {
		String s = String.format("%20s|%30s|%20d|%20.2f", getMaNV(), getHoTen(), getSoDienThoai(), getLuongCB());
		return s;
	}
}
