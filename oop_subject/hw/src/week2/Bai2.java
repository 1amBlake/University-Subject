package week2;
import java.util.*;

class SinhVien{
	//fields
	private int MaSV;
	private String hoTen;
	private double scoreLT, scoreTH;
	
	//constructor
	public SinhVien(){
		this.MaSV = 0;
		this.hoTen = "";
		this.scoreLT = 0;
		this.scoreTH = 0;
	}
	public SinhVien(int mSV, String htSV, double sLT, double sTH) {
		this.MaSV = mSV;
		this.hoTen = htSV;
		this.scoreLT = sLT;
		this.scoreTH = sTH;
	}
	
	//set
	public void setMSV(int MSV) {
		this.MaSV = MSV;
	}
	public void setHT(String HT) {
		this.hoTen = HT;
	}
	public void setDLT(double LT) {
		this.scoreLT = LT;
	}
	public void setDTH(double TH) {
		this.scoreTH = TH;
	}
	
	//get
	public int getMSV() {
		return this.MaSV;
	}
	public String getHT() {
		return this.hoTen;
	}
	public double getDLT() {
		return this.scoreLT;
	}
	public double getDTH() {
		return this.scoreTH;
	}
	
	//methods
		//calculate average scores method
	public double calDTB() {
		if (getDLT() < 0 || getDTH() < 0) return -1;
		return (getDLT() + getDTH()) / 2;
	}
		//output method
	public String toString() {
		if (calDTB() == -1) return "Diem nhap vao khong hop le!\n";
		return String.format("%-30s%10d%5.2f%5.2f%5.2f\n", getHT(), getMSV(), getDLT(), getDTH(), calDTB());
	}
}


public class Bai2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//object
		SinhVien sv1 = new SinhVien(1, "Doan Minh Huy", 8.7, 9.9);
		SinhVien sv2 = new SinhVien(2, "Nguyen Van A", 2.4, 5.8);
		SinhVien sv3 = new SinhVien();
		
		//gan value sv3
		System.out.print ("Ten SV: "); sv3.setHT(sc.nextLine());
		System.out.print ("Ma SV: "); sv3.setMSV(sc.nextInt());
		System.out.print("Diem LT: "); sv3.setDLT(sc.nextDouble());
		System.out.print("Diem TH: "); sv3.setDTH(sc.nextDouble());
		
		//output
		System.out.println(sv1.toString());
		System.out.println(sv2.toString());
		System.out.println(sv3.toString());
		
		sc.close();
	}

}
