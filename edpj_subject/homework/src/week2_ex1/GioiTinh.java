package week2_ex1;

public enum GioiTinh {
	NAM("Nam"), NU("Nữ");

	private String hienThi;

	GioiTinh(String hienThi) {
		this.hienThi = hienThi;
	}

	public String getHienString() {
		return hienThi;
	}
}
