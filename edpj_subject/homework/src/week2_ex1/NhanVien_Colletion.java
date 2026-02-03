package week2_ex1;

import java.util.ArrayList;

public class NhanVien_Colletion {
	private ArrayList<NhanVien> dsNV;

	public NhanVien_Colletion() {
		dsNV = new ArrayList<NhanVien>();
	}

	// them nv moi
	public boolean addNV(NhanVien nv) {
		if (dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}

	// xoa 1 nhan vien
	public boolean deleteNV(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if (dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}

	public NhanVien findNV(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if (dsNV.contains(nv))
			return dsNV.get(dsNV.indexOf(nv));
		return null;
	}

	public ArrayList<NhanVien> getDSNV() {
		return dsNV;
	}

	public void setDSNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}

	public NhanVien getElement(int index) {
		if (index < 0 || index >= dsNV.size())
			return null;
		return dsNV.get(index);
	}

	public int getSize() {
		return dsNV.size();
	}
}
