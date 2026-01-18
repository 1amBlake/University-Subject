package week8.Bai2.entities;

public class PhongThiNghiem extends PhongHoc {
	private String ChuyenNganh;
	private int SucChua;
	private int BonRua;

	public String getChuyenNganh() {
		return ChuyenNganh;
	}

	public void setChuyenNganh(String chuyenNganh) {
		if (chuyenNganh.length() == 0)
			this.ChuyenNganh = "n/a";
		else
			this.ChuyenNganh = chuyenNganh;
	}

	public int getSucChua() {
		return SucChua;
	}

	public void setSucChua(int sucChua) {
		if (sucChua <= 0)
			throw new IllegalArgumentException("Sức chứa không được bé hơn 0!");
		SucChua = sucChua;
	}

	public int getBonRua() {
		return BonRua;
	}

	public void setBonRua(int bonChua) {
		if (bonChua < 0 || bonChua > 1)
			throw new IllegalArgumentException("Lựa chọn bồn rửa không hợp lệ!");
		BonRua = bonChua;
	}

	public PhongThiNghiem(String maPhong, String dayNha, double dienTich, int sLBongDen, String chuyenNganh,
			int sucChua, int bonRua) {
		super(maPhong, dayNha, dienTich, sLBongDen);
		setChuyenNganh(chuyenNganh);
		setSucChua(sucChua);
		setBonRua(bonRua);
	}

	@Override
	public boolean DatChuan() {
		return super.DatChuan() && getBonRua() == 1;
	}

	@Override
	public String toString() {
		String s, checkBR;
		if (DatChuan())
			checkBR = "X";
		else
			checkBR = " ";
		s = String.format("|%30s|%60s|%10s|", "Phòng Thí Nghiệm", super.toString(), checkBR);
		return s;
	}
}
