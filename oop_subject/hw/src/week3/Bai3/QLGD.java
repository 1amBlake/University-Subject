package week3.Bai3;

import java.util.Scanner;

public class QLGD {

	public static void main(String[] args) {
		ListGD lgd = new ListGD();
		Scanner sc = new Scanner(System.in);
		int x;
		do {
			System.out.println("\n\t\t----------------------------------");
			System.out.println("\t\t|0. Thoát ứng dụng\t\t\t\t |");
			System.out.println("\t\t|1. Thêm giao dịch vàng\t\t\t\t |");
			System.out.println("\t\t|2. Thêm giao dịch tiền tệ\t\t\t |");
			System.out.println("\t\t|3. Hiển thị danh sách giao dịch\t\t |");
			System.out.println("\t\t|4. Xem tổng số lượng của các giao dịch\t\t |");
			System.out.println("\t\t|5. Xem trung bình của các giao dịch tiền tệ\t\t |");
			System.out.println("\t\t|6. Hiển thị danh sách giao dịch có đơn giá > 1 ngan |");
			System.out.println("\t\t--------------------------------------");
			x = sc.nextInt();
			switch(x) {
			case 1:
				lgd.ThemGD(1);
				break;
			case 2:
				lgd.ThemGD(2);
				break;
			case 3: 
				lgd.HienThiDS();
				break;
			case 4:	
				lgd.TongSL();
				break;
			case 5: 
				lgd.TrungBinhGDTT();
				break;
			case 6:
				lgd.GiaoDich1Ty();
			}
		}while(x!=0);
		System.out.println("");
		sc.close();
	}

}
