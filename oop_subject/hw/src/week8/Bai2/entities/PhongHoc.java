package week8.Bai2.entities;

public abstract class PhongHoc {
	protected String MaPhong;
	protected String DayNha;
	protected double DienTich;
	protected int SLBongDen;

	public String getMaPhong() {
		return MaPhong;
	}

	public void setMaPhong(String maPhong) {
		MaPhong = maPhong;
	}

	public String getDayNha() {
		return DayNha;
	}

	public void setDayNha(String dayNha) {
		DayNha = dayNha;
	}

	public double getDienTich() {
		return DienTich;
	}

	public void setDienTich(double dienTich) {
		if (dienTich <= 0)
			throw new IllegalArgumentException("Diện tích phòng học phải lớn hơn 0!");
		DienTich = dienTich;
	}

	public int getSLBongDen() {
		return SLBongDen;
	}

	public void setSLBongDen(int sLBongDen) {
		if (sLBongDen <= 0)
			throw new IllegalArgumentException("Số lượng bóng đèn trong phòng học phải lớn hơn 0!");
		SLBongDen = sLBongDen;
	}

	public boolean DatChuan() {
		return (getDienTich() / getSLBongDen() >= 10);
	}

	public PhongHoc(String maPhong, String dayNha, double dienTich, int sLBongDen) {
		setMaPhong(maPhong);
		setDayNha(dayNha);
		setDienTich(dienTich);
		setSLBongDen(sLBongDen);
	}

	@Override
	public String toString() {
		String s = String.format("%20s|%20s|%10.2f|%10d", getMaPhong(), getDayNha(), getDienTich(), getSLBongDen());
		return s;
	}
}
