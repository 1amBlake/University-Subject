package week8.Bai2.entities;

public class PhongMayTinh extends PhongHoc {
	private int SLMayTinh;

	public int getSLMayTinh() {
		return SLMayTinh;
	}

	public void setSLMayTinh(int sLMayTinh) {
		if (sLMayTinh <= 0)
			throw new IllegalArgumentException("Số lượng máy tính phải lớn hơn 0!");
		SLMayTinh = sLMayTinh;
	}

	@Override
	public boolean DatChuan() {
		return (super.DatChuan() && getDienTich() / getSLMayTinh() >= 1.5);
	}

	public PhongMayTinh(String maPhong, String dayNha, double dienTich, int sLBongDen, int sLMayTinh) {
		super(maPhong, dayNha, dienTich, sLBongDen);
		setSLMayTinh(sLMayTinh);
	}

	@Override
	public String toString() {
		String s, checkMT;
		if (DatChuan())
			checkMT = "X";
		else
			checkMT = " ";
		s = String.format("|%30s|%60s|%10s|", "Phòng Máy Tính", super.toString(), checkMT);
		return s;
	}
}
