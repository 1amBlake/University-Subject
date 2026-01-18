package week3.Bai8.entities;

public abstract class HangHoa {
	protected final String MaH;
	protected String TenH;
	protected int SLTon;
	protected double DonGia;

	protected String getMaH() {
		return MaH;
	}

	protected String getTenH() {
		return TenH;
	}

	protected void setTenH(String tenH) {
		if (tenH == null || tenH.trim().equals(""))
			throw new IllegalArgumentException("Tên hàng không thể để trống!");
		this.TenH = tenH;
	}

	protected int getSLTon() {
		return SLTon;
	}

	protected void setSLTon(int slTon) {
		if (slTon < 0)
			throw new IllegalArgumentException("Số lượng tồn không được âm!");
		this.SLTon = slTon;
	}

	protected double getDonGia() {
		return DonGia;
	}

	protected void setDonGia(double donGia) {
		if (donGia <= 0)
			throw new IllegalArgumentException("Đơn giá phải lớn hơn 0!");
		this.DonGia = donGia;
	}

	public HangHoa(String maH, String tenH, int slTon, double donGia) {
		if (maH == null || maH.trim().equals(" "))
			throw new IllegalArgumentException("Mã hàng không thể trống");
		this.MaH = maH;
		setTenH(tenH);
		setSLTon(slTon);
		setDonGia(donGia);
	}

	public String toString() {
		return "Mã hàng hóa: " + getMaH() + ", Tên hàng hóa: " + getTenH() + ", Số lượng tồn kho: " + getSLTon()
				+ ", Đơn giá: " + getDonGia();
	}
}