package midterm2.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import midterm2.entities.HangThucPham;

public class QuanLyHangThucPham {
	private HangThucPham[] DSHTP;
	private int count;

	// default constructor
	public QuanLyHangThucPham() {
		DSHTP = new HangThucPham[10];
		count = 0;
	}

	// copy cons
	public QuanLyHangThucPham(QuanLyHangThucPham dsHTP) {
		if (dsHTP.count <= 0) {
			DSHTP = new HangThucPham[10];
			count = 0;
		} else {
			DSHTP = new HangThucPham[dsHTP.DSHTP.length];
			for (int i = 0; i < dsHTP.count; i++) {
				DSHTP[i] = dsHTP.DSHTP[i];
			}
			count = dsHTP.count;
		}
	}

	// ktra trung ma
	private boolean checkTrungMa(String ma) {
		for (int i = 0; i < count; i++) {
			if (DSHTP[i].getMaHang().equalsIgnoreCase(ma)) {
				return true;
			}
		}
		return false;
	}

	private void tangKichThuoc() {
		int kichThuocMoi = (int) (DSHTP.length * 1.75);
		if (kichThuocMoi == DSHTP.length)
			kichThuocMoi++;
		HangThucPham[] temp = new HangThucPham[kichThuocMoi];

		for (int i = 0; i < count; i++)
			temp[i] = DSHTP[i];
		DSHTP = temp;
	}

	public int themHang(HangThucPham hang) {
		if (checkTrungMa(hang.getMaHang()))
			return -1;

		if (count == DSHTP.length)
			tangKichThuoc();

		DSHTP[count++] = hang;
		return 1;
	}

	private boolean checkLuuKhoTren30ngay(HangThucPham hang) {
		LocalDate today = LocalDate.now();
		long soNgay = ChronoUnit.DAYS.between(hang.getNgayNhapKho(), today);
		if (soNgay >= 30)
			return true;
		return false;
	}

	public HangThucPham[] TrichDanhSachHangThucPham() {
		if (count <= 0)
			return null;

		HangThucPham[] temp = new HangThucPham[count];
		int dem = 0;
		for (int i = 0; i < count; i++) {
			if (checkLuuKhoTren30ngay(DSHTP[i]))
				temp[dem++] = DSHTP[i];
		}

		if (dem == 0)
			return new HangThucPham[0];

		HangThucPham[] kq = new HangThucPham[dem];
		for (int i = 0; i < dem; i++)
			kq[i] = temp[i];

		return kq;
	}

	public HangThucPham[] timHTPTheoTen(String name) {
		if (count <= 0)
			return null;

		HangThucPham[] temp = new HangThucPham[count];
		int dem = 0;
		for (int i = 0; i < count; i++) {
			if ((DSHTP[i].getTenHang().toLowerCase()).contains(name.toLowerCase()))
				temp[dem++] = DSHTP[i];
		}

		if (dem == 0)
			return new HangThucPham[0];

		HangThucPham[] kq = new HangThucPham[dem];
		for (int i = 0; i < dem; i++)
			kq[i] = temp[i];

		return kq;
	}

	public HangThucPham[] duyetDSHTP() {
		if (count <= 0)
			return new HangThucPham[0];
		return DSHTP;
	}

	/*
	 * public int xoaHTPTheoTen (String name) { int del_count = 0; if (count <= 0)
	 * return -1;
	 * 
	 * HangThucPham[] temp = new HangThucPham[DSHTP.length - 1]; int temp_count =
	 * count; for (int i = 0; i < temp_count; i++) {
	 * if(!(DSHTP[i].getTenHang().toLowerCase().contains(name.toLowerCase()))) {
	 * temp[del_count++] = DSHTP[i]; count--; } }
	 * 
	 * if (del_count == 0) return 0;
	 * 
	 * else if (del_count > 0) { DSHTP = new HangThucPham[count]; for (int i = 0; i
	 * < count; i++) DSHTP[i] = temp[i]; } return del_count; }
	 */
	public int xoaHTPTheoTen(String name) {
		if (count <= 0)
			return -1;

		int del_count = 0;
		HangThucPham[] temp = new HangThucPham[DSHTP.length];
		int newCount = 0;

		for (int i = 0; i < count; i++) {
			if (DSHTP[i].getTenHang().toLowerCase().contains(name.toLowerCase())) {
				del_count++;
			} else {
				temp[newCount++] = DSHTP[i];
			}
		}

		if (del_count == 0)
			return 0;

		DSHTP = new HangThucPham[temp.length];
		for (int i = 0; i < newCount; i++) {
			DSHTP[i] = temp[i];
		}

		count = newCount;
		return del_count;
	}
}
