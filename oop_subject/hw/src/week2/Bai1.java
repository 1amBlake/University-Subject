package week2;
import java.util.*;

class HinhChuNhat{
	private double cDai;
	private double cRong;
	boolean checkValid = true;
	
	public double getcDai() {
		return cDai;
	}
	public double getcRong() {
		return cRong;
	}
	public void setcDai(double cDai) {
		this.cDai = cDai;
		if (cDai <= 0) checkValid = false;
	}
	public void setcRong(double cRong) {
		this.cRong = cRong;
		if (cRong <= 0) checkValid = false;
	}
	
	public double calChuVi() {
		if (checkValid == false) {
			System.out.println("Error: Khong the tinh chu vi!");
			return -1;
		}
		else return (cDai + cRong) * 2;
	}
	public double calDienTich() {
		if (checkValid == false) {
			System.out.println("Error: Khong the tinh dien tich!");
			return -1;
		}
		else return cDai * cRong;
	}
	public String toString() {
		if (checkValid == false) return "Chieu dai hoac chieu rong khong hop le\nKhong the tinh chu vi\nKhong the tinh dien tich";
		else return "Chieu dai: "+cDai+"\nChieu rong: "+cRong+"\nChu vi: "+calChuVi()+"\nDien tich: "+calDienTich();
	}
}

public class Bai1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HinhChuNhat hcn = new HinhChuNhat();
		System.out.print("Vui long nhap chieu dai: ");
		double cd = sc.nextDouble();
		System.out.print("Vui long nhap chieu rong: ");
		double cr = sc.nextDouble();
		hcn.setcDai(cd);
		hcn.setcRong(cr);
		System.out.println("Thong tin hinh chu nhat: "+hcn.toString());
		sc.close();
	}

}
