package week8.Bai3.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import week8.Bai3.entities.HanhKhach;

public class QuanLyHanhKhach_NhaGa {
	private Queue<HanhKhach> HanhKhachCho;
	private ArrayList<HanhKhach> HanhKhachCoVe;

	public QuanLyHanhKhach_NhaGa() {
		HanhKhachCho = new LinkedList<HanhKhach>();
		HanhKhachCoVe = new ArrayList<HanhKhach>();
	}

	private boolean checkHK_data(String cmnd, String tenHK, String gaDen, double giaTien) {
		if (cmnd == null || cmnd.isEmpty() || tenHK == null || tenHK.isEmpty() || gaDen == null || gaDen.isEmpty()
				|| giaTien <= 0) {
			return false;
		}
		for (int j = 0; j < tenHK.length(); j++) {
			if (!Character.isLetter(tenHK.charAt(j)) && tenHK.charAt(j) != ' ')
				return false;
		}
		for (int k = 0; k < gaDen.length(); k++) {
			if (!Character.isLetter(gaDen.charAt(k)) && gaDen.charAt(k) != ' ')
				return false;
		}
		return true;
	}

	public int themHanhKhac(String cmnd, String tenHK, String gaDen, double giaTien) {
		if (!checkHK_data(cmnd, tenHK, gaDen, giaTien))
			return -1;
		else {
			for (HanhKhach hk : HanhKhachCho) {
				if (cmnd.equalsIgnoreCase(hk.getCMND())) {
					hk.setGaDen(gaDen);
					hk.setGiaTien(giaTien);
					return 2;
				}
			}
			HanhKhachCho.add(new HanhKhach(cmnd, tenHK, gaDen, giaTien));
		}
		return 1;
	}

	public String banVe() {
		if (HanhKhachCho.size() == 0)
			return null;
		HanhKhach temp = HanhKhachCho.poll();
		HanhKhachCoVe.add(temp);
		return temp.toString();
	}

	public Queue<HanhKhach> danhsachHKCho() {
		return new LinkedList<>(HanhKhachCho);
	}

	public ArrayList<HanhKhach> danhsachHKCoVe() {
		return new ArrayList<>(HanhKhachCoVe);
	}

	public HanhKhach xoaHK_DSChoVe(String cmnd) {
		Iterator<HanhKhach> it = HanhKhachCho.iterator();

		while (it.hasNext()) {
			HanhKhach hk = it.next();
			if (cmnd.equalsIgnoreCase(hk.getCMND())) {
				it.remove();
				return hk;
			}
		}
		return null;
	}

	public int slHKChoVe() {
		return HanhKhachCho.size();
	}

	public int slHKCoVe() {
		return HanhKhachCoVe.size();
	}

	public double tongTien() {
		double sum = 0;
		Iterator<HanhKhach> it = HanhKhachCoVe.iterator();

		while (it.hasNext()) {
			HanhKhach hk = it.next();
			sum += hk.getGiaTien();
		}

		return sum;
	}

	public Set<String> getDSGaHKCho() {
		Set<String> dsGa = new TreeSet<String>((g1, g2) -> g1.compareToIgnoreCase(g2));
		for (HanhKhach hk : HanhKhachCho)
			dsGa.add(hk.getGaDen());

		return dsGa;
	}

	public Map<String, Integer> getDSGaSoKhach() {
		Map<String, Integer> map = new TreeMap<String, Integer>();
		for (HanhKhach hk : HanhKhachCho)
			map.put(hk.getGaDen(), map.getOrDefault(hk.getGaDen(), 0) + 1);

		return map;
	}

	// test duyệt
	public Queue<HanhKhach> Test() {
		return HanhKhachCho;
	}

	public ArrayList<HanhKhach> Test2() {
		return HanhKhachCoVe;
	}
}
