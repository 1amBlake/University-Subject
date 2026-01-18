package week3.Bai11.entities;

public abstract class Xe {
	protected int MaThue;
	protected double DonGia;

	protected int getMaThue() {
		return MaThue;
	}

	protected void setMaThue(int maThue) {
		MaThue = maThue;
	}

	protected double getDonGia() {
		return DonGia;
	}

	protected void setDonGia(double donGia) {
		DonGia = donGia;
	}

	public Xe(Integer maThue, Double donGia) {
		if (maThue == null || maThue < 0)
			throw new IllegalArgumentException("Mã số thuế bị lỗi!");
		this.MaThue = maThue;
		if (donGia == null || donGia < 0)
			throw new IllegalArgumentException("Đơn giá bị lỗi!");
		this.DonGia = donGia;
	}

	protected abstract double getVATrate();

	protected abstract double getThueTruocBarate();

	protected double ThanhTien() {
		return getDonGia() + (getDonGia() * getVATrate()) + (getDonGia() * getThueTruocBarate());
	}

	@Override
	public String toString() {
		return "Mã thuế: " + getMaThue() + ", Đơn Giá: " + getDonGia() + ", Thành Tiền: " + ThanhTien();
	}
}
