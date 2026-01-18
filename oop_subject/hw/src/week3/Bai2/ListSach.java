package week3.Bai2;

import java.util.*;

public class ListSach {
	private Sach sach[] = new Sach[1000];
	private int countSLSach, slSTK = 0;
	private double sumSGK = 0, sumSTK = 0, sumDGSTK = 0;
	Scanner sc = new Scanner(System.in);
	
	public ListSach() {
		countSLSach = 0;
		for (int i = 0; i < 1000; i++)
			sach[i] = new Sach();
	}
	
	public void addSach(int chonSach) {
		if (countSLSach > 1000)
			System.out.println("Bộ nhớ đã đầy, không thể thêm mới!");
		else {
			if(chonSach == 1) {
				sach[countSLSach] = new SachGiaoKhoa();
				SachGiaoKhoa sgk = new SachGiaoKhoa();
				sgk.nhap();
				sgk.ThanhTien = sgk.ThanhTien();
				sach[countSLSach] = sgk;
				sumSGK += sgk.ThanhTien;
			}
			else if(chonSach == 2) {
				sach[countSLSach] = new SachThamKhao();
				SachThamKhao stk = new SachThamKhao();
				stk.nhap();
				stk.ThanhTien = stk.ThanhTien();
				sach[countSLSach] =  stk;
				sumSTK += stk.ThanhTien;
				sumDGSTK += stk.DonGia;
				slSTK++;
			}
			countSLSach++;
		}
	}
	
	public void exportSach() {
		int checkSGK = 0, checkSTK = 0;
		
		System.out.println("Sách Giáo Khoa: ");
		for(int i = 0; i < countSLSach; i++) {
			if(sach[i] instanceof SachGiaoKhoa) {
				SachGiaoKhoa sgk = (SachGiaoKhoa) sach[i];
				System.out.println(sgk.toString());
				checkSGK = 1;
			}
		}
		if (checkSGK == 0) System.out.println("Không có dữ liệu!");
		
		System.out.println("\nSách Tham Khảo: ");
		for (int i = 0; i < countSLSach; i++) {
			if (sach[i] instanceof SachThamKhao) {
				SachThamKhao stk = (SachThamKhao) sach[i];
				System.out.println(stk.toString());
				checkSTK = 1;
			}
		}
		if (checkSTK == 0) System.out.println("Không có dữ liệu!");
	}
	
	public void tongThanhTien() {
		System.out.println("Tổng thành tiền cho từng loại sách là: ");
		System.out.println("==>>SGK: "+sumSGK+"\n==>>STK: "+sumSTK);
	}
	
	public void trungBinhDonGiaSTK() {
		System.out.println("Trung bình đơn giá của sách tham khảo là: "+(sumDGSTK / slSTK));
	}
	
	public void xuatSGKtheoNXB() {
		int check = 0;
		
		System.out.println("Nhập tên Nhà Xuất Bản: ");
		String nameNXB = sc.nextLine();
		
		System.out.println("Danh sách Sách Giáo Khoa chung NXB là: ");
		for (int i = 0; i < countSLSach; i++) {
			if (sach[i] instanceof SachGiaoKhoa) {
				SachGiaoKhoa sgk2 = (SachGiaoKhoa) sach[i];
				if (nameNXB.equalsIgnoreCase(sgk2.NXB)) {
					System.out.println(sgk2.toString());
					check = 1;
				}
			}
		}
		if (check == 0) System.out.println("Không tồn tại!");
	}
}
