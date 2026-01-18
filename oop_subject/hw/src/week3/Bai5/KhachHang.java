package week3.Bai5;
import java.util.Scanner;
public class KhachHang {
	protected int MaKH, SoLuong;
	protected double DonGia, ThanhTien;
	protected String NgayHD, HoTenKH;
	Scanner sc = new Scanner(System.in);
	
	protected KhachHang() {
		this.MaKH = 0;
		this.DonGia = 0;
		this.NgayHD = "";
		this.HoTenKH = "";
		this.SoLuong = 0;
	}
	protected KhachHang(int ma, double dgia, String ngay, String hoten, int sl, double ttien) {
		this.MaKH = ma;
		this.DonGia = dgia;
		this.NgayHD = ngay;
		this.HoTenKH = hoten;
		this.SoLuong = sl;
		this.ThanhTien = ttien;
	}
	
	protected int getMaKH() {
		return MaKH;
	}
	protected void setMaKH(int maKH) {
		MaKH = maKH;
	}
	protected String getHoTenKH() {
		return HoTenKH;
	}
	protected void setHoTenKH(String hoTenKH) {
		HoTenKH = hoTenKH;
	}
	protected int getSoLuong() {
		return SoLuong;
	}
	protected void setSoLuong(int sl) {
		SoLuong = sl;
	}
	protected double getThanhTien() {
		return ThanhTien;
	}
	protected void setThanhTien(double ttien) {
		ThanhTien = ttien;
	}
	
	protected void nhap() {
		System.out.println("Nhập mã khách hàng: ");
		MaKH = sc.nextInt();
		System.out.println("Họ và tên khách hàng: ");
		HoTenKH = sc.nextLine();
		sc.nextLine();
		System.out.println("Ngày lập hóa đơn: ");
		NgayHD = sc.nextLine();
		System.out.println("Số lượng (KW): ");
		SoLuong = sc.nextInt();
		System.out.println("Đơn giá: ");
		DonGia = sc.nextDouble();
	}
	
	public String toString() {
		return "[Mã KH: "+MaKH+", Họ tên KH: "+HoTenKH+", Ngày HĐ: "+NgayHD+", Đơn giá: "+DonGia+", Số lượng: "+SoLuong;
	}
}

class KhachHangNuocNgoai extends KhachHang{
	private String QuocTich;
	
	public KhachHangNuocNgoai() {
		super();
		this.QuocTich = "";
	}
	
	public KhachHangNuocNgoai(int ma, double dgia, String ngay, String hoten, int sl, double ttien, String qt) {
		super(ma, dgia, ngay, hoten, sl, ttien);
		this.QuocTich = qt;
	}
	
	public String getQuocTich() {
		return QuocTich;
	}
	public void setQuocTich(String qt) {
		QuocTich = qt;
	}
	
	public void nhap() {
		super.nhap();
		System.out.println("Quốc tịch: ");
		QuocTich = sc.next();
	}
	
	public double TTien() {
		return this.ThanhTien = this.SoLuong * this.DonGia;
	}
	
	public String toString() {
		return "Khách hàng nước ngoài: "+super.toString()+", Quốc tịch: "+QuocTich+", Thành tiền: "+ThanhTien;
	}
}

class KhachHangViet extends KhachHang{
	private int LoaiKH, DinhMuc;
	
	public KhachHangViet() {
		super();
		this.LoaiKH = 0;
		this.DinhMuc = 0;
	}
	
	public KhachHangViet(int ma, double dgia, String ngay, String hoten, int sl, double ttien, int loai, int dm) {
		super(ma, dgia, ngay, hoten, sl, ttien);
		this.LoaiKH = loai;
		this.DinhMuc = dm;
	}
	
	public int getLoaiKH() {
		return LoaiKH;
	}
	public void setLoaiKH(int loaiKH) {
		LoaiKH = loaiKH;
	}
	public int getDinhMuc() {
		return DinhMuc;
	}
	public void setDinhMuc(int dinhMuc) {
		DinhMuc = dinhMuc;
	}
	
	public void nhap() {
		super.nhap();
		System.out.println("Loại khách hàng (1 = Sinh Hoạt, 2 = Kinh Doanh, 3 = Sản xuất)");
		LoaiKH = sc.nextInt();
		System.out.println("Định mức: ");
		DinhMuc = sc.nextInt();
	}
	
	public double TTien() {
		if (SoLuong <= DinhMuc) return this.ThanhTien = this.DonGia*this.SoLuong;
		else return this.ThanhTien = this.DinhMuc*this.DonGia+(this.SoLuong-this.DinhMuc)*this.DonGia*2.5;
	}
	
	public String toString() {
		String temp;
		if(LoaiKH == 1) temp = "Sinh Hoạt";
		else if(LoaiKH == 2) temp = "Kinh Doanh";
		else temp = "Sản Xuất";
		return "Khách hàng Việt: "+super.toString()+", Loại KH: "+temp+", Định mức: "+DinhMuc+", Thành tiền: "+ThanhTien;
	}
}