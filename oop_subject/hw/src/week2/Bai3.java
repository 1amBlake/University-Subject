package week2;
import java.util.*;

class Vehicle{
	//fields
	private String veOwner;
	private String veType;
	private int veCap;
	private double vePrice;

	//cons
	public Vehicle() {
		this.veOwner = "N/A";
		this.veType = "N/A";
		this.veCap = -1;
		this.vePrice = -1;
	}
	
	//get-set
	public void setVO(String name) {
		this.veOwner = name;
	}
	public void setVT(String car) {
		this.veType = car;
	}
	public void setVC(int capacity) {
		this.veCap = capacity;
	}
	public void setVP(double price) {
		this.vePrice = price;
	}
	
	public String getVO(){
		return this.veOwner;
	}
	public String getVT() {
		return this.veType;
	}
	public int getVC() {
		return this.veCap;
	}
	public double getVP() {
		return this.vePrice;
	}
	
	//methods
		//cal taxes
	public double veTaxes() {
		if (getVC() < 100) return getVP() * 0.01;
		else if(getVC() >= 100 && getVC() <= 200) return getVP() * 0.03;
		else return getVP() * 0.05;
	}
	
	public void input(Scanner sc) {
		System.out.print("Vui long nhap chu so huu: "); setVO(sc.nextLine());
		System.out.print("Vui long nhap loai xe: "); setVT(sc.nextLine());
		while (getVP() < 1000000 || getVC() < 50) {
			System.out.print("Vui long nhap dung tich xe: "); setVC(sc.nextInt());
			System.out.print("Vui long nhap tri gia cua xe: "); setVP(sc.nextDouble());
			if(getVP() < 1000000 || getVC() < 50) System.out.println("Da xay ra loi! Vui long nhap lai");
		}
		sc.nextLine();
	}
	
		//output
	public String toString() {
		if(getVC() == -1) return "Khong ton tai du lieu";
		return String.format("%-30s%-20s%-20d%-20.2f%-20.2f", getVO(), getVT(), getVC(), getVP(), veTaxes());
	}
}
public class Bai3 {
	static void inputData(Vehicle xe, Scanner sc) {
		xe.input(sc);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//objs
		Vehicle xe1 = new Vehicle();
		Vehicle xe2 = new Vehicle();
		Vehicle xe3 = new Vehicle();
		
		//input objs
		inputData(xe1, sc);
		inputData(xe2, sc);
		inputData(xe3, sc);
		
		//output
		System.out.printf("%-30s%-20s%-20s%-20s%-20s\n=====================================================================================================\n", "Tên Chủ Xe", "Loại Xe", "Dung Tích", "Trị Giá", "Thuế Phải Nộp");
		System.out.println(xe1.toString()+"\n"+xe2.toString()+"\n"+xe3.toString());
		sc.close();
	}

}
