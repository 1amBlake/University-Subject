package week3.Bai4;

import java.util.*;
import java.time.*;
import java.time.format.*;

public class GiaoDichList {
	Scanner sc = new Scanner(System.in);
	DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/yyyy");
	private GiaoDich gd[] = new GiaoDich[100];
	private int countSLGD, slgdDat = 0, slgdNha = 0;
	private double sumTienDat;
	public GiaoDichList() {
		countSLGD = 0;
		for (int i = 0; i < 100; i++) {
			gd[i] = new GiaoDich();
		}
	}
	
	public void inputDSGD() {
		if (countSLGD > 100) {
			System.out.println("Bộ nhớ đã đầy!");
		}
		else {
			int LoaiHinhGD;
			do {
				System.out.print("Nhập loại hình muốn giao dịch: 1. Giao dịch đất 2. Giao dịch nhà\n=>>");
				LoaiHinhGD = sc.nextInt();
				if(LoaiHinhGD != 1 && LoaiHinhGD != 2) System.out.println("Đã xảy ra lỗi! Vui lòng chọn lại!");	
			}while(LoaiHinhGD != 1 && LoaiHinhGD != 2);
			
			if(LoaiHinhGD == 1) {
				gd[countSLGD] = new GiaoDichDat();
				GiaoDichDat gdDat = new GiaoDichDat();
				gdDat.nhap();
				sumTienDat += gdDat.ThanhTien();
				gd[countSLGD] = gdDat;
				slgdDat++;
				countSLGD++;
			}
			else {
				gd[countSLGD] = new GiaoDichNha();
				GiaoDichNha gdNha = new GiaoDichNha();
				gdNha.nhap();
				gdNha.ThanhTien();
				gd[countSLGD] = gdNha;
				slgdNha++;
				countSLGD++;
			}
		}
		
	}
	
	public void outputDSGD() {
		int LoaiHinhGD;
		do {
			System.out.print("Nhập loại hình giao dịch muốn xuất: 1. Giao dịch đất 2. Giao dịch nhà 3. Tất cả\n=>>");
			LoaiHinhGD = sc.nextInt();
			if(LoaiHinhGD < 1 || LoaiHinhGD > 3 ) System.out.println("Đã xảy ra lỗi! Vui lòng chọn lại!");	
		}while(LoaiHinhGD < 1 || LoaiHinhGD > 3);
		
		if(LoaiHinhGD == 1) {
			int checkDat = 0;
			System.out.println("[Danh sách giao dịch đất]");
			for (int i = 0; i < countSLGD; i++) {
				if(gd[i] instanceof GiaoDichDat) {
					System.out.println(gd[i].toString());
					checkDat = 1;
				}
			}
			if(checkDat == 0) System.out.println("Không có dữ liệu!");
		}
		else if (LoaiHinhGD == 2) {
			int checkNha = 0;
			System.out.println("[Danh sách giao dịch nhà]");
			for (int i = 0; i < countSLGD; i++) {
				if(gd[i] instanceof GiaoDichNha) {
					System.out.println(gd[i].toString());
					checkNha = 1;
				}
			}
			if(checkNha == 0) System.out.println("Không có dữ liệu!");
		}
		else {
			int checkDat = 0, checkNha = 0;
			System.out.println("[Danh sách giao dịch đất]");
			for(int i = 0; i < countSLGD; i++) {
				if(gd[i] instanceof GiaoDichDat) {
					System.out.println(gd[i].toString());
					checkDat = 1;
				}
			}
			if(checkDat == 0) System.out.println("Không có dữ liệu!");
			
			System.out.println("[Danh sách giao dịch nhà]");
			for (int i = 0; i < countSLGD; i++) {
				if(gd[i] instanceof GiaoDichNha) {
					System.out.println(gd[i].toString());
					checkNha = 1;
				}
			}
			if(checkNha == 0) System.out.println("Không có dữ liệu!");
		}
	}
	
	public void SoLuongGiaoDich() {
		System.out.println("Số lượng giao dịch đất: "+slgdDat);
		System.out.println("Số lượng giao dịch nhà: "+slgdNha);
	}
	
	public void averageThanhTien() {
		System.out.println("Trung bình thành tiền giao dịch đất: "+(sumTienDat/(double)slgdDat));
	}
	
	public void outputGDrequest() {
		YearMonth dateFind;
		int checkData = 0;
		
		while(true) {
			System.out.print("Nhập thời gian muốn tìm giao dịch (mm/yyyy): ");
			String inputTime = sc.nextLine();
			
			try {
				dateFind = YearMonth.parse(inputTime, format);
				break;
			}catch(DateTimeParseException e) {
				System.out.println("Định dạng hoặc ngày không hợp lệ, vui lòng nhập lại!");
			}
		}
		
		System.out.println("Giao dịch vào "+dateFind);
		for(int i = 0; i < countSLGD; i++) {
			LocalDate ngayGD = gd[i].getNgayGD();
			YearMonth NgayGD = YearMonth.from(ngayGD);
			
			if(NgayGD.equals(dateFind)) {
				System.out.println(gd[i].toString());
				checkData = 1;
			}
		}
		if(checkData == 0) System.out.println("Không có dữ liệu");
	}
}
