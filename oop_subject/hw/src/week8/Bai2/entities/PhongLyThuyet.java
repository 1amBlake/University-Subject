package week8.Bai2.entities;

public class PhongLyThuyet extends PhongHoc {
	private int MayChieu;

	public int getMayChieu() {
		return MayChieu;
	}

	public void setMayChieu(int mayChieu) {
		if (mayChieu < 0 || mayChieu > 1) // 1 = yes
			throw new IllegalArgumentException("Lựa chọn máy chiếu không hợp lệ!");
		MayChieu = mayChieu;
	}

	@Override
	public boolean DatChuan() {
		return (super.DatChuan() && getMayChieu() == 1);
	}

	public PhongLyThuyet(String maPhong, String dayNha, double dienTich, int sLBongDen, int mayChieu) {
		super(maPhong, dayNha, dienTich, sLBongDen);
		setMayChieu(mayChieu);
	}

	@Override
	public String toString() {
		String s, checkMC;
		if (DatChuan())
			checkMC = "X";
		else
			checkMC = " ";
		s = String.format("|%30s|%60s|%10s|", "Phòng Lý Thuyết", super.toString(), checkMC);
		return s;
	}
}
