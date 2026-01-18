package week3.Bai5;

import java.util.*;

public class KhachHang_CTQuanLy {

	public static void main(String[] args) {
		KhachHangList lkh = new KhachHangList();
		Scanner sc = new Scanner(System.in);
		int x;
		
		do {
			System.out.println("\n\t\t------------------------------------");
			System.out.println("\t\t|0. Thoát ứng dụng\t\t   |");
			System.out.println("\t\t|1. Thêm khách hàng Việt\t   |");
			System.out.println("\t\t|2. Thêm khách hàng nước ngoài\t   |");
			System.out.println("\t\t|3. Hiển thị danh sách khách hàng  |");
			System.out.println("\t\t|4. Xem tổng (KW) của các KH\t   |");
			System.out.println("\t\t|5. Xem TB thành tiền của KH NN\t   |");
			System.out.println("\t\t------------------------------------");
			x = sc.nextInt();
			System.out.println("=======>>");
			switch(x) {
				case 1:
					lkh.ThemKH(x);
					break;
				case 2:
					lkh.ThemKH(x);
					break;
				case 3:
					lkh.HienThiKH();
					break;
				case 4:
					lkh.TongSL();
					break;
				case 5:
					lkh.TrungBinh();
					break;
			}
		}while(x != 0);
		System.out.println("");
		sc.close();
	}

}
