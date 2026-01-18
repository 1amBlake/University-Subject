package week3.Bai2;

import java.util.*;

public class CTQL_Sach {
	public static void main(String[] args) {
		ListSach dss = new ListSach();
		Scanner sc = new Scanner(System.in);
		int x;
		
		do {
			System.out.println("\nProgram: Quản Lý Sách");
			System.out.println("----------------------------------------------");
			System.out.println("|0. Exit                                     |");
			System.out.println("|1. Nhập loại sách                           |");
			System.out.println("|2. Xuất loại sách                           |");
			System.out.println("|3. Tổng thành tiền cho từng loại sách       |");
			System.out.println("|4. Trung bình đơn giá của các sách tham khảo|");
			System.out.println("|5. Xuất các loại sách tham khảo theo NBX    |");
			System.out.println("----------------------------------------------");
			x = sc.nextInt();
			
			System.out.println("==>>");
			if(x >= 0 && x <= 5) {
				switch(x) {
				case 1:
					int chonSach;
					do {
						System.out.println("Chọn loại sách để nhập: 1. Sách Giáo Khoa 2. Sách Tham Khảo");
						chonSach = sc.nextInt();
						if (chonSach < 1 || chonSach > 2)
							System.out.println("Lỗi! Vui lòng chọn lại");
					}while(chonSach < 1 || chonSach > 2);
					dss.addSach(chonSach);
					break;
				case 2:
					dss.exportSach();
					break;
				case 3:
					dss.tongThanhTien();
					break;
				case 4:
					dss.trungBinhDonGiaSTK();
					break;
				case 5:
					dss.xuatSGKtheoNXB();
					break;
				}
			}
			else System.out.println("Lỗi! Hãy chọn lại");
		}while(x != 0);
		System.out.println("");
		sc.close();
	}
}
