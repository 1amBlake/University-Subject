package week2;

import java.util.Scanner;

class SinhVien2 {
    private int maSV;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;


    public SinhVien2() {
        this.maSV = 0;
        this.hoTen = "";
        this.diaChi = "";
        this.soDienThoai = "";
    }


    public SinhVien2(int maSV, String hoTen, String diaChi, String soDienThoai) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }


    public int getMaSV() { return maSV; }
    public void setMaSV(int maSV) { this.maSV = maSV; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getSoDienThoai() { return soDienThoai; }
    public void setSoDienThoai(String soDienThoai) { this.soDienThoai = soDienThoai; }


    @Override
    public String toString() {
        return maSV + " - " + hoTen + " - " + diaChi + " - " + soDienThoai;
    }
}

public class Bai7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int n = sc.nextInt();
        sc.nextLine();

        SinhVien2[] danhSach = new SinhVien2[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1));

            System.out.print("Mã sinh viên: ");
            int ma = sc.nextInt();
            sc.nextLine();

            System.out.print("Họ tên: ");
            String ten = sc.nextLine();

            System.out.print("Địa chỉ: ");
            String diaChi = sc.nextLine();

            System.out.print("Số điện thoại (7 chữ số): ");
            String sdt = sc.nextLine();

            danhSach[i] = new SinhVien2(ma, ten, diaChi, sdt);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (danhSach[j].getMaSV() > danhSach[j + 1].getMaSV()) {
                    SinhVien2 temp = danhSach[j];
                    danhSach[j] = danhSach[j + 1];
                    danhSach[j + 1] = temp;
                }
            }
        }

        System.out.println("\nDanh sách sinh viên sau khi sắp xếp:");
        for (SinhVien2 sv : danhSach) {
            System.out.println(sv);
        }

        sc.close();
    }
}
