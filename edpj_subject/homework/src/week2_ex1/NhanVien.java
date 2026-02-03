package week2_ex1;

import java.util.Objects;

public class NhanVien {
	private String maNV;
	private String hoNV;
	private String tenNV;
	private int tuoiNV;
	private GioiTinh gioiTinhNV;
	private double luongNV;

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public int getTuoiNV() {
		return tuoiNV;
	}

	public void setTuoiNV(int tuoiNV) {
		this.tuoiNV = tuoiNV;
	}

	public GioiTinh getGioiTinhNV() {
		return gioiTinhNV;
	}

	public void setGioiTinhNV(GioiTinh gioiTinhNV) {
		this.gioiTinhNV = gioiTinhNV;
	}

	public double getLuongNV() {
		return luongNV;
	}

	public void setLuongNV(double luongNV) {
		this.luongNV = luongNV;
	}

	/*
	 * @Override public int hashCode() { return Objects.hash(gioiTinhNV, hoNV, maNV,
	 * tenNV, tuoiNV); }
	 * 
	 * @Override public boolean equals(Object obj) { if (this == obj) return true;
	 * if (obj == null) return false; if (getClass() != obj.getClass()) return
	 * false; NhanVien other = (NhanVien) obj; return gioiTinhNV == other.gioiTinhNV
	 * && Objects.equals(hoNV, other.hoNV) && Objects.equals(maNV, other.maNV) &&
	 * Objects.equals(tenNV, other.tenNV) && tuoiNV == other.tuoiNV; }
	 */
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(maNV, other.maNV);
	}

	public NhanVien(String maNV, String hoNV, String tenNV, int tuoiNV, GioiTinh gioiTinhNV, double luongNV) {
		super();
		setMaNV(maNV);
		setHoNV(hoNV);
		setTenNV(tenNV);
		setTuoiNV(tuoiNV);
		setGioiTinhNV(gioiTinhNV);
		setLuongNV(luongNV);
	}

	public NhanVien(String maNV) {
		this.maNV = maNV;
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", tuoiNV=" + tuoiNV + ", gioiTinhNV="
				+ gioiTinhNV + ", luongNV=" + luongNV + "]";
	}

}
