package week8.Bai2.services;

import java.util.ArrayList;

import week8.Bai2.entities.PhongHoc;
import week8.Bai2.entities.PhongLyThuyet;
import week8.Bai2.entities.PhongMayTinh;
import week8.Bai2.entities.PhongThiNghiem;

public class QuanLyPhongHoc {
	private ArrayList<PhongHoc> dsPH;

	public QuanLyPhongHoc() {
		dsPH = new ArrayList<>();
	}

	private boolean checkTrungMa(String maPhong) {
		for (PhongHoc checkDS : dsPH) {
			if (checkDS.getMaPhong().equalsIgnoreCase(maPhong))
				return true;
		}
		return false;
	}

	public int themPH(int loaiPhong, String maPhong, String dayNha, double dienTich, int soBongDen, int checkMayChieu,
			int soMayTinh, String chuyenNganh, int sucChua, int checkBonRua) {
		int check = dsPH.size();
		if (checkTrungMa(maPhong))
			return 0;

		if (dayNha.length() != 1 || !Character.isLetter(dayNha.charAt(0)))
			return -1;

		if (dienTich <= 0 || soBongDen <= 0)
			return -2;

		if (loaiPhong == 1) {
			if (checkMayChieu < 0 || checkMayChieu > 1)
				return -3;
			else
				dsPH.add(new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, checkMayChieu));
		} else if (loaiPhong == 2) {
			if (soMayTinh <= 0)
				return -2;
			else
				dsPH.add(new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh));
		} else {
			if (checkBonRua < 0 || checkBonRua > 1)
				return -3;
			if (sucChua <= 0)
				return -2;
			dsPH.add(new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, checkBonRua));
		}

		if (check < dsPH.size()) {
			for (PhongHoc out : dsPH)
				System.out.println(out);
		}
		return 1;
	}

	public PhongHoc timPHTheoMa(String maPhong) {
		if (maPhong == null || maPhong.isEmpty())
			return null;

		for (PhongHoc check : dsPH) {
			if (maPhong.equalsIgnoreCase(check.getMaPhong())) {
				return check;
			}
		}
		return null;
	}

	public ArrayList<PhongHoc> inDanhSachPhong() {
		return new ArrayList<>(dsPH);
	}

	public ArrayList<PhongHoc> sapxepDSTheoDayNha() {
		for (int i = 0; i < dsPH.size() - 1; i++) {
			for (int j = i + 1; j < dsPH.size(); j++) {
				String s1 = dsPH.get(i).getDayNha();
				String s2 = dsPH.get(j).getDayNha();

				if (s1.compareToIgnoreCase(s2) > 0) {
					PhongHoc temp = dsPH.get(i);
					dsPH.set(i, dsPH.get(j));
					dsPH.set(j, temp);
				}
			}
		}
		return dsPH;
	}
	/*
	 * public ArrayList<PhongHoc> sapxepDSTheoDayNha() { dsPH.sort((a, b) ->
	 * a.getDayNha().compareToIgnoreCase(b.getDayNha())); return dsPH; }
	 */

	public ArrayList<PhongHoc> sapxepDSTheoDienTichGD() {
		dsPH.sort((a, b) -> Double.compare(b.getDienTich(), a.getDienTich()));
		return dsPH;
	}

	public ArrayList<PhongHoc> sapxepDSTheoSLBongDen() {
		dsPH.sort((a, b) -> Integer.compare(a.getSLBongDen(), b.getSLBongDen()));
		return dsPH;
	}

	public boolean updateSLMayTinh(String MaPhong, int new_slMT) {
		if (dsPH.isEmpty())
			return false;
		for (PhongHoc ph : dsPH) {
			if (MaPhong.equalsIgnoreCase(ph.getMaPhong())) {
				if (ph instanceof PhongMayTinh) {
					((PhongMayTinh) ph).setSLMayTinh(new_slMT);
					return true;
				} else
					return false;
			}
		}
		return false;
	}

	public int xoaPhongHoc(String MaPhong) {
		if (dsPH.size() == 0)
			return -1;
		for (int i = 0; i < dsPH.size(); i++) {
			if (MaPhong.equalsIgnoreCase(dsPH.get(i).getMaPhong())) {
				dsPH.remove(i);
				return 1;
			}
		}
		return 0;
	}

	public int tongSoPhongHoc() {
		return dsPH.size();
	}

	public ArrayList<PhongHoc> phongCoSLMayTren60() {
		ArrayList<PhongHoc> new_ds = new ArrayList<>();

		for (PhongHoc PH : dsPH) {
			if (PH instanceof PhongMayTinh) {
				if (((PhongMayTinh) PH).getSLMayTinh() >= 60)
					new_ds.add(PH);
			}
		}
		if (new_ds.size() > 0)
			return new ArrayList<>(new_ds);
		else
			return new_ds;
	}
}
