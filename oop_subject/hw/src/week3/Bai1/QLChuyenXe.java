package week3.Bai1;
import java.util.*;
public class QLChuyenXe {
	public static void main(String[] args) {
		int x;
		Scanner sc = new Scanner(System.in);
		
		ListChuyenXe dscx = new ListChuyenXe();
		do {
			System.out.println("\n\t-----------------------------------");
			System.out.println("\t0. Thoát");
			System.out.println("\t1. Thêm chuyến xe nội thành");
			System.out.println("\t2. Thêm chuyến xe ngoại thành");
			System.out.println("\t3. Hiển thị danh mục chuyến xe");
			System.out.println("\n\t-----------------------------------");
			x = sc.nextInt();
			System.out.println("------>>");
			
			switch(x) {
				case 1:
					dscx.listcx(1);
					break;
				case 2:
					dscx.listcx(2);
					break;
				case 3:
					dscx.listcx(3);
					break;
			}
		}while(x!=0);
		System.out.println("");
		sc.close();
	}
}
