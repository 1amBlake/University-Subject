package week2;

import java.util.Scanner;

class CD {
    private int maCD;
    private String tuaCD;
    private String caSi;
    private int soBaiHat;
    private double giaThanh;

    public CD() {
        this.maCD = 0;
        this.tuaCD = "";
        this.caSi = "";
        this.soBaiHat = 0;
        this.giaThanh = 0;
    }

    public CD(int maCD, String tuaCD, String caSi, int soBaiHat, double giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSi = caSi;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    public int getMaCD() { return maCD; }
    public void setMaCD(int maCD) { this.maCD = maCD; }

    public String getTuaCD() { return tuaCD; }
    public void setTuaCD(String tuaCD) { this.tuaCD = tuaCD; }

    public String getCaSi() { return caSi; }
    public void setCaSi(String caSi) { this.caSi = caSi; }

    public int getSoBaiHat() { return soBaiHat; }
    public void setSoBaiHat(int soBaiHat) { this.soBaiHat = soBaiHat; }

    public double getGiaThanh() { return giaThanh; }
    public void setGiaThanh(double giaThanh) { this.giaThanh = giaThanh; }

    @Override
    public String toString() {
        return maCD + " - " + tuaCD + " - " + caSi + " - " + soBaiHat + " bài - " + giaThanh + " VND";
    }
}

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng CD tối đa: ");
        int n = sc.nextInt();
        sc.nextLine();

        CD[] danhSach = new CD[n];
        int soLuong = 0;
        int luaChon;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Thêm CD");
            System.out.println("2. Xuất danh sách");
            System.out.println("3. Tính tổng giá thành");
            System.out.println("4. Sắp xếp giảm dần theo giá");
            System.out.println("5. Sắp xếp tăng dần theo tựa CD");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1:
                    if (soLuong >= n) {
                        System.out.println("Danh sách đã đầy!");
                        break;
                    }
                    System.out.print("Mã CD: ");
                    int ma = sc.nextInt();
                    sc.nextLine();

                    boolean trung = false;
                    for (int i = 0; i < soLuong; i++) {
                        if (danhSach[i].getMaCD() == ma) {
                            trung = true;
                            break;
                        }
                    }
                    if (trung) {
                        System.out.println("Mã CD bị trùng!");
                        break;
                    }

                    System.out.print("Tựa CD: ");
                    String tua = sc.nextLine();

                    System.out.print("Ca sĩ: ");
                    String caSi = sc.nextLine();

                    System.out.print("Số bài hát: ");
                    int soBH = sc.nextInt();

                    System.out.print("Giá thành: ");
                    double gia = sc.nextDouble();
                    sc.nextLine();

                    danhSach[soLuong++] = new CD(ma, tua, caSi, soBH, gia);
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.println("\nDanh sách CD:");
                    for (int i = 0; i < soLuong; i++) {
                        System.out.println(danhSach[i]);
                    }
                    break;

                case 3:
                    double tong = 0;
                    for (int i = 0; i < soLuong; i++) {
                        tong += danhSach[i].getGiaThanh();
                    }
                    System.out.println("Tổng giá thành: " + tong);
                    break;

                case 4:
                    for (int i = 0; i < soLuong - 1; i++) {
                        for (int j = 0; j < soLuong - i - 1; j++) {
                            if (danhSach[j].getGiaThanh() < danhSach[j + 1].getGiaThanh()) {
                                CD temp = danhSach[j];
                                danhSach[j] = danhSach[j + 1];
                                danhSach[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp giảm dần theo giá.");
                    break;

                case 5:
                    for (int i = 0; i < soLuong - 1; i++) {
                        for (int j = 0; j < soLuong - i - 1; j++) {
                            if (danhSach[j].getTuaCD().compareToIgnoreCase(danhSach[j + 1].getTuaCD()) > 0) {
                                CD temp = danhSach[j];
                                danhSach[j] = danhSach[j + 1];
                                danhSach[j + 1] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp tăng dần theo tựa CD.");
                    break;
            }
        } while (luaChon != 0);

        sc.close();
    }
}
