package week3.Bai4;

import java.util.*;

public class CTQL_GiaoDich {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GiaoDichList gdl = new GiaoDichList();
		int menuPointer;
		
		do {
			System.out.println("\n Chương trình QLGD");
			System.out.println("|1. Thêm giao dịch");
			System.out.println("|2. Xuất giao dịch");
			System.out.println("|3. Tính tổng số lượng giao dịch");
			System.out.println("|4. Tính trung bình thành tiền của giao dịch đất");
			System.out.println("|5. Xuất giao dịch theo thời gian yêu cầu");
			System.out.println("|0. Thoát");
			menuPointer = sc.nextInt();
			
			System.out.println("==>>");
			
			if(menuPointer >= 0 && menuPointer <= 5) {
				switch(menuPointer) {
				case 1:
					gdl.inputDSGD();
					break;
				case 2:
					gdl.outputDSGD();
					break;
				case 3:
					gdl.SoLuongGiaoDich();
					break;
				case 4:
					gdl.averageThanhTien();
					break;
				case 5:
					gdl.outputGDrequest();
					break;
				}
			}
			else {
				System.out.println("Đã xảy ra lỗi, hãy chọn lại!");
			}
		}while (menuPointer != 0);
		System.out.println("");
		sc.close();
	}

}
