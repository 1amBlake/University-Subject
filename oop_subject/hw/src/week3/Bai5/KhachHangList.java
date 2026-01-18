package week3.Bai5;

public class KhachHangList {
	private KhachHang kh[] = new KhachHang[100];
	private int CountKH, sum1 = 0, sum2 = 0, dem = 0, sumtien = 0;
	
	public KhachHangList() {
		CountKH = 0;
		for (int i = 0; i < 100; i++) kh[i] = new KhachHang();
	}
	
	public void ThemKH(int temp) {
		if(CountKH > 100) System.out.println("Bộ nhớ đầy! Không thể thêm!");
		else {
			if(temp == 1) {
				kh[CountKH] = new KhachHangViet();
				KhachHangViet khv = new KhachHangViet();
				khv.nhap();
				khv.ThanhTien = khv.TTien();
				kh[CountKH] = khv;
				sum1 += khv.SoLuong;
			}
			else {
				kh[CountKH] = new KhachHangNuocNgoai();
				KhachHangNuocNgoai khnn = new KhachHangNuocNgoai();
				khnn.nhap();
				khnn.ThanhTien = khnn.TTien();
				kh[CountKH] = khnn;
				sum2 += khnn.SoLuong;
				sumtien += khnn.SoLuong;
				dem++;
			}
			CountKH++;
		}
	}
	
	public void HienThiKH() {
		for (int i = 0; i < CountKH; i++) {
			System.out.println("\nSố TT: "+(i+1));
			System.out.println(kh[i].toString());
		}
	}
	
	public void TongSL() {
		System.out.println(":::=>> Tổng số lượng (KW) điện của KH Việt Nam: "+sum1);
		System.out.println(":::=>> Tổng số lượng (KW) điện của KH Nước Ngoài: "+sum2);
	}
	
	public void TrungBinh() {
		System.out.println("|-->> Trung Bình Thành Tiền Của KH Nước Ngoài: "+(sumtien/dem));
	}
}
