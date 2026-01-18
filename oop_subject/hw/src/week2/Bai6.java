package week2;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

class HangThucPham {
    private final String maHang;
    private String tenHang;
    private double donGia;
    private Date ngaySX;
    private Date ngayHH;

    public HangThucPham(String maHang) {
        if (maHang == null || maHang.trim().isEmpty())
            this.maHang = "Unknown";
        else
            this.maHang = maHang;
    }

    public HangThucPham(String maHang, String tenHang, double donGia, Date ngaySX, Date ngayHH) {
        if (maHang == null || maHang.trim().isEmpty())
            this.maHang = "Unknown";
        else
            this.maHang = maHang;

        setTenHang(tenHang);
        setDonGia(donGia);
        setNgaySX(ngaySX);
        setNgayHH(ngayHH);
    }

    public String getMaHang() { return maHang; }
    public String getTenHang() { return tenHang; }
    public double getDonGia() { return donGia; }
    public Date getNgaySX() { return ngaySX; }
    public Date getNgayHH() { return ngayHH; }

    public void setTenHang(String tenHang) {
        if (tenHang == null || tenHang.trim().isEmpty())
            this.tenHang = "No name";
        else
            this.tenHang = tenHang;
    }

    public void setDonGia(double donGia) {
        if (donGia > 0) this.donGia = donGia;
        else this.donGia = 0;
    }

    public void setNgaySX(Date ngaySX) {
        if (ngaySX == null) this.ngaySX = new Date();
        else this.ngaySX = ngaySX;
    }

    public void setNgayHH(Date ngayHH) {
        if (ngayHH == null || (ngaySX != null && ngayHH.before(ngaySX)))
            this.ngayHH = ngaySX;
        else
            this.ngayHH = ngayHH;
    }

    public boolean daHetHan() {
        Date now = new Date();
        return ngayHH.before(now);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return "Mã hàng: " + maHang +
               ", Tên hàng: " + tenHang +
               ", Đơn giá: " + df.format(donGia) +
               ", Ngày SX: " + sdf.format(ngaySX) +
               ", Ngày HH: " + sdf.format(ngayHH) +
               ", Hết hạn: " + (daHetHan() ? "Rồi" : "Chưa");
    }
}

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã hàng: ");
        String ma = sc.nextLine();

        System.out.print("Nhập tên hàng: ");
        String ten = sc.nextLine();

        System.out.print("Nhập đơn giá: ");
        double gia = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
        String nsxStr = sc.nextLine();

        System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
        String nhhStr = sc.nextLine();

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date nsx = sdf.parse(nsxStr);
            Date nhh = sdf.parse(nhhStr);

            HangThucPham hang = new HangThucPham(ma, ten, gia, nsx, nhh);
            System.out.println(hang);
        } catch (Exception e) {
            System.out.println("Lỗi định dạng ngày!");
        }

        sc.close();
    }
}
