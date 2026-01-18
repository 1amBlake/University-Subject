package test;
import java.util.*;

class Vehicle {
    private String veOwner;
    private String veType;
    private int veCap;
    private double vePrice;

    public Vehicle() {
        this.veOwner = "N/A";
        this.veType = "N/A";
        this.veCap = -1;
        this.vePrice = -1;
    }

    public void setVO(String name) { this.veOwner = name; }
    public void setVT(String car) { this.veType = car; }
    public void setVC(int capacity) { this.veCap = capacity; }
    public void setVP(double price) { this.vePrice = price; }

    public String getVO(){ return this.veOwner; }
    public String getVT() { return this.veType; }
    public int getVC() { return this.veCap; }
    public double getVP() { return this.vePrice; }

    public double veTaxes() {
        if (veCap < 100) return vePrice * 0.01;
        else if (veCap <= 200) return vePrice * 0.03;
        else return vePrice * 0.05;
    }

    public void input(Scanner sc) {
        System.out.print("Vui long nhap chu so huu: "); 
        veOwner = sc.nextLine();
        System.out.print("Vui long nhap loai xe: "); 
        veType = sc.nextLine();

        do {
            System.out.print("Vui long nhap dung tich xe: "); 
            veCap = sc.nextInt();
            System.out.print("Vui long nhap tri gia cua xe: "); 
            vePrice = sc.nextDouble();
            if (vePrice < 1000000 || veCap < 50) {
                System.out.println("Da xay ra loi! Vui long nhap lai.");
            }
        } while (vePrice < 1000000 || veCap < 50);
        sc.nextLine(); // loại bỏ newline
    }

    public String toString() {
        if (vePrice < 0 || veCap < 0) 
            return "Khong ton tai du lieu";
        return String.format("%-30s%-20s%10d%15.2f%15.2f",
            veOwner, veType, veCap, vePrice, veTaxes());
    }
}

public class Tester {
    static void inputData(Vehicle xe, Scanner sc) {
        xe.input(sc);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Vehicle xe1 = new Vehicle();
        Vehicle xe2 = new Vehicle();
        Vehicle xe3 = new Vehicle();

        inputData(xe1, sc);
        inputData(xe2, sc);
        inputData(xe3, sc);

        System.out.printf("%-30s%-20s%-10s%-15s%-15s\n", 
            "Tên Chủ Xe", "Loại Xe", "Dung Tích", "Trị Giá", "Thuế Phải Nộp");
        System.out.println(xe1);
        System.out.println(xe2);
        System.out.println(xe3);

        sc.close();
    }
}