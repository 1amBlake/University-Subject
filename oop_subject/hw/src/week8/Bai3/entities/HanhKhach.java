package week8.Bai3.entities;

public class HanhKhach {
	private String CMND;
	private String TenKH;
	private String GaDen;
	private double GiaTien;

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getTenKH() {
		return TenKH;
	}

	public void setTenKH(String tenKH) {
		if (tenKH == null || tenKH.trim().isEmpty())
			throw new IllegalArgumentException("Tên của hành khách không được rỗng!");
		for (int i = 0; i < tenKH.length(); i++) {
			if (!Character.isLetter(tenKH.charAt(i)) && tenKH.charAt(i) != ' ')
				throw new IllegalArgumentException("Tên của hành khách phải là chữ cái!");
		}
		TenKH = tenKH;
	}

	public String getGaDen() {
		return GaDen;
	}

	public void setGaDen(String gaDen) {
		if (gaDen == null || gaDen.trim().isEmpty())
			throw new IllegalArgumentException("Ga đến không được rỗng!");
		for (int i = 0; i < gaDen.length(); i++) {
			if (!Character.isLetter(gaDen.charAt(i)) && gaDen.charAt(i) != ' ')
				throw new IllegalArgumentException("Ga đến phải là chữ cái!");
		}
		GaDen = gaDen;
	}

	public double getGiaTien() {
		return GiaTien;
	}

	public void setGiaTien(double giaTien) {
		if (giaTien <= 0)
			throw new IllegalArgumentException("Giá tiền vé không được rỗng!");
		GiaTien = giaTien;
	}

	public HanhKhach(String cMND, String tenKH, String gaDen, double giaTien) {
		setCMND(cMND);
		setTenKH(tenKH);
		setGaDen(gaDen);
		setGiaTien(giaTien);
	}

	@Override
	public String toString() {
		String s = String.format("|%15s|%30s|%30s|%10f|", getCMND(), getTenKH(), getGaDen(), getGiaTien());
		return s;
	}
}
