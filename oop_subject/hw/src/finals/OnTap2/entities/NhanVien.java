package finals.OnTap2.entities;

public abstract class NhanVien {
	protected String MaNV;
	protected String HoTen;
	protected long SDT;
	protected double LuongCB;

	public abstract double tinhLuongNhanVien();

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
			if (!Character.isLetter(hoTen.charAt(i)) && hoTen.charAt(i) != ' ')
				throw new IllegalArgumentException("Ho ten nhan vien khong hop le!");
		}
		HoTen = hoTen;
	}

	public long getSDT() {
		return SDT;
	}

	public void setSDT(long sDT) {
		if (sDT <= 0)
			throw new IllegalArgumentException("SDT khong hop le!");
		SDT = sDT;
	}

	public double getLuongCB() {
		return LuongCB;
	}

	public void setLuongCB(double luongCB) {
		if (luongCB <= 0)
			throw new IllegalArgumentException("Luong can ban khong hop le!");
		LuongCB = luongCB;
	}

	public NhanVien(String maNV, String hoTen, long sDT, double luongCB) {
		setHoTen(hoTen);
		setLuongCB(luongCB);
		setMaNV(maNV);
		setSDT(sDT);
	}

	@Override
	public String toString() {
		String s = String.format("|%10s|%30s|%11d|%10.2f", getMaNV(), getHoTen(), getSDT(), getLuongCB());
		return s;
	}
}
