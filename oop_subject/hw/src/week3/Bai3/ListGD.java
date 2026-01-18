package week3.Bai3;

public class ListGD {
	GiaoDich gd[] = new GiaoDich[100];
	private int CountGD, sum1 = 0, sum2 = 0, dem = 0, sumtien = 0;
	
	public ListGD() {
		CountGD = 0;
		for (int i = 0; i < 100; i++)
			gd[i] = new GiaoDich();
	}
	
	public void ThemGD(int temp) {
		if (CountGD > 100) System.out.println("Bộ nhớ đã đầy, không thể thêm mới!");
		else {
			if(temp == 1) {
				gd[CountGD] = new GiaoDichVang();
				GiaoDichVang gdv = new GiaoDichVang();
				gdv.nhap();
				gdv.ThanhTien = gdv.TTien();
				gd[CountGD] = gdv;
				sum1 += gdv.SoLuong;
			}
			else {
				gd[CountGD] = new GiaoDichTienTe();
				GiaoDichTienTe gdtt = new GiaoDichTienTe();
				gdtt.nhap();
				gdtt.ThanhTien = gdtt.TTien();
				gd[CountGD] = gdtt;
				sumtien += gdtt.ThanhTien;
				sum2 = gdtt.SoLuong;
				dem++;
			}
			CountGD++;
		}
	}
	
	public void HienThiDS() {
		for(int i = 0; i < CountGD; i++) {
			System.out.println("\n----Số TT: "+(i+1));
			System.out.println(gd[i].toString());
		}
	}
	
	public void TongSL() {
		System.out.println("|-> Tổng số lượng giao dịch của vàng: "+sum1+" <-|");
		System.out.println("|-> Tổng số lượng giao dịch của tiền tệ: "+sum2+" <-|");
	}
	
	public void  TrungBinhGDTT() {
		System.out.println("|-> Trung bình thành tiền giao dịch tiền tệ: "+(sumtien/dem)+" <-|");
	}
	
	public void GiaoDich1Ty() {
		int d = 0;
		for(int i = 0; i < CountGD; i++) {
			if (gd[i].DonGia > 1000) {
				System.out.println(gd[i].toString());
				d++;
			}
		}
		if (d == 0) System.out.println("Không có thông tin!");
	}
}
