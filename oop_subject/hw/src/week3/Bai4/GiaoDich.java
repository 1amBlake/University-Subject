package week3.Bai4;

import java.util.*;
import java.time.*;
import java.time.format.*;

public class GiaoDich {
	Scanner sc = new Scanner(System.in);
	protected DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	protected String MaGD;
	protected double DonGia, DienTich;
	protected LocalDate NgayGD;
	
	protected String getMaGD() {
		return MaGD;
	}
	protected void setMaGD(String maGD) {
		MaGD = maGD;
	}
	
	protected LocalDate getNgayGD() {
		return NgayGD;
	}
	protected void setNgayGD(LocalDate ngayGD) {
		NgayGD = ngayGD;
	}
	
	protected double getDonGia() {
		return DonGia;
	}
	protected void setDonGia(double donGia) {
		DonGia = donGia;
	}
	
	protected double getDienTich() {
		return DienTich;
	}
	protected void setDienTich(double dienTich) {
		DienTich = dienTich;
	}
	
	protected GiaoDich() {
		this.MaGD = "n/a";
		this.NgayGD = LocalDate.now();
		this.DonGia = 0;
		this.DienTich = 0;
	}
	protected GiaoDich(String magd, LocalDate ngaygd, double dgia, double dtich) {
		this.MaGD = magd;
		this.NgayGD = ngaygd;
		this.DonGia = dgia;
		this.DienTich = dtich;
	}
	
	public void nhap() {
		System.out.print("Mã giao dịch: ");
		MaGD = sc.nextLine();
		while(true) {
			System.out.print("Ngày giao dịch (dd/mm/yyyy): ");
			String input = sc.nextLine();
			
			try {
				NgayGD = LocalDate.parse(input, format);
				break;
			}catch(DateTimeParseException e) {
				System.out.println("Định dạng hoặc ngày không hợp lệ, vui lòng nhập lại!");
			}
		}
		System.out.print("Đơn giá: ");
		DonGia = sc.nextDouble();
		System.out.print("Diện tích: ");
		DienTich = sc.nextDouble();
	}
	
	public String toString() {
		return "Mã giao dịch: "+MaGD+", Ngày giao dịch: "+NgayGD+", Đơn giá: "+DonGia+", Diện tích: "+DienTich;
	}
}

class GiaoDichDat extends GiaoDich{
	protected String LoaiDat;
	
	protected String getLoaiDat() {
		return LoaiDat;
	}
	protected void setLoaiDat(String loaiDat) {
		LoaiDat = loaiDat;
	}
	
	protected GiaoDichDat() {
		super();
		this.LoaiDat = "n/a";
	}
	protected GiaoDichDat(String mgd, LocalDate ngaygd, double dgia, double dtich, String ldat) {
		super(mgd, ngaygd, dgia, dtich);
		this.LoaiDat = ldat;
	}
	
	public double ThanhTien() {
		if(LoaiDat.equals("A")) return this.DienTich  * this.DonGia;
		return this.DienTich * this.DonGia * 1.5;
	}
	
	
	public void nhap() {
		super.nhap();
		int chonDat;
		do {
			System.out.print("Chọn loại đất: \n1. Loại A\n2. Loại B\n3. Loại C\n=>");
			chonDat = sc.nextInt();
			if (chonDat == 1) LoaiDat = "A";
			else if (chonDat == 2) LoaiDat = "B";
			else if (chonDat == 3) LoaiDat = "C";
			else System.out.println("Loại đất không hợp lệ! Vui lòng nhập lại!");
		}while (chonDat < 1 || chonDat > 3);
	}
	
	public String toString() {
		return "[Giao Dịch Đất] "+super.toString()+", Loại đất: "+LoaiDat+", Thành tiền: "+ThanhTien();
	}
}


class GiaoDichNha extends GiaoDich{
	protected String LoaiNha, DiaChi;
	
	protected String getLoaiNha() {
		return LoaiNha;
	}
	protected void setLoaiNha(String loaiNha) {
		LoaiNha = loaiNha;
	}
	
	protected String getDiaChi(){
		return DiaChi;
	}
	protected void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	
	protected GiaoDichNha() {
		super();
		this.LoaiNha = "n/a";
		this.DiaChi = "n/a";
	}
	
	protected GiaoDichNha(String mgd, LocalDate ngaygd, double dgia, double dtich, String lnha, String dchi) {
		super(mgd, ngaygd, dgia, dtich);
		this.LoaiNha = lnha;
		this.DiaChi = dchi;
	}
	
	public double ThanhTien() {
		if (LoaiNha.equalsIgnoreCase("Cao Cấp")) return this.DienTich * this.DonGia;
		return this.DienTich * this.DonGia * 0.9;
	}
	
	public void nhap() {
		super.nhap();
		int chonNha;
		do {
			System.out.print("Chọn loại nhà: \n1. Cao cấp\n2. Thường\n=>>");
			chonNha = sc.nextInt();
			if(chonNha == 1) LoaiNha = "Cao Cấp";
			else if (chonNha == 2) LoaiNha = "Thường";
			else System.out.println("Loại nhà không hợp lệ. Vui lòng chọn lại!");
		}while (chonNha != 1 && chonNha != 2);
		System.out.print("Địa chỉ: ");
		DiaChi = sc.nextLine();
	}
	
	public String toString() {
		return "[Giao Dịch Đất] "+super.toString()+", Loại nhà: "+LoaiNha+", Địa chỉ: "+DiaChi+", Thành tiền: "+ThanhTien();
	}
}