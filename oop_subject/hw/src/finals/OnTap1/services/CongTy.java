package finals.OnTap1.services;

import java.util.ArrayList;

import finals.OnTap1.entities.NhanVien;
import finals.OnTap1.entities.NhanVienBanHang;
import finals.OnTap1.entities.NhanVienHanhChinh;

public class CongTy {
	private ArrayList<NhanVien> cty;

	public CongTy() {
		cty = new ArrayList<>();
	}

	private boolean checkTrungMaNV(String MNV) {
		for (NhanVien check : cty) {
			if (MNV.equalsIgnoreCase(check.getMaNV()))
				return true;
		}
		return false;
	}

	private boolean checkTenHopLe(String HTNV) {
		for (int i = 0; i < HTNV.length(); i++) {
			char c = HTNV.charAt(i);
			if (!Character.isLetter(c) && c != ' ')
				return false;
		}
		return true;
	}

	public boolean themNhanVien(int loaiNV, String MaNV, String HoTen, long SDT, double LuongCB, double DoanhSo,
			double HeSo) {
		if (checkTrungMaNV(MaNV))
			return false;
		if (!checkTenHopLe(HoTen))
			return false;
		if ((SDT < 100000000L || SDT > 9999999999L) || LuongCB <= 0)
			return false;

		if (loaiNV == 1) {
			if (DoanhSo <= 0)
				return false;
			else
				cty.add(new NhanVienBanHang(MaNV, HoTen, SDT, LuongCB, DoanhSo));
		} else {
			if (HeSo < 1.66 || HeSo > 8.69)
				return false;
			else
				cty.add(new NhanVienHanhChinh(MaNV, HoTen, SDT, LuongCB, HeSo));
		}
		return true;
	}

	public ArrayList<NhanVien> inDanhSach() {
		return new ArrayList<>(cty);
	}

	public double tinhTrungBinhLuong() {
		int slNVBH = 0;
		double tienLuongTB = 0;
		for (int i = 0; i < cty.size(); i++) {
			if (cty.get(i) instanceof NhanVienBanHang) {
				tienLuongTB += cty.get(i).tinhLuongNV();
				slNVBH++;
			}
		}
		if (slNVBH <= 0)
			return 0;
		tienLuongTB /= slNVBH;
		return tienLuongTB;
	}

	public boolean xoaNhanVien(String MaNV) {
		for (int i = 0; i < cty.size(); i++) {
			if (MaNV.equalsIgnoreCase(cty.get(i).getMaNV())) {
				cty.remove(i);
				return true;
			}
		}
		return false;
	}
}
