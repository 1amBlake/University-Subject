package week3.Bai1;
import java.util.*;
public class ChuyenXe {
	protected String Macx, NameTX, SoX;
	protected double DoanhThu;
	Scanner in = new Scanner(System.in);
	
	protected void setMacx (String macx) {
		Macx = macx;
	}
	protected String getMacx() {
		return Macx;
	}
	protected void setNameTX(String nameTX) {
		NameTX = nameTX;
	}
	protected String getNameTX() {
		return NameTX;
	}
	protected void setSoX(String soX) {
		SoX = soX;
	}
	protected String getSoX() {
		return SoX;
	}
	protected void setDoanhThu(double doanhThu) {
		DoanhThu = doanhThu;
	}
	protected double getDoanhThu() {
		return DoanhThu;
	}
	protected ChuyenXe() {
		this.Macx = "";
		this.NameTX = "";
		this.SoX = "";
		this.DoanhThu = 0;
	}
	protected ChuyenXe(String ma, String name, String sx, double dt) {
		this.Macx = ma;
		this.NameTX = name;
		this.SoX = sx;
		this.DoanhThu = dt;
	}
	protected void nhap() {
		System.out.println("Nhập mã số chuyến: ");
		this.Macx = in.nextLine();
		System.out.println("Họ tên tài xế: ");
		this.NameTX = in.nextLine();
		System.out.print("Số xe: ");
		this.SoX = in.nextLine();
		System.out.println("Doanh thu: ");
		this.DoanhThu = in.nextDouble();
	}
	public String toString() {
		return "\nMS chuyến: "+this.Macx+"\nTên tài xế: "+this.NameTX+"\nSố xe: "+this.SoX;
	}
}

class NgoaiThanh extends ChuyenXe{
	private int SoNgay;
	private String NoiDen;
	Scanner in = new Scanner(System.in);
	
	public void setNoiDen(String noiDen) {
		NoiDen = noiDen;
	}
	public String getNoiDen() {
		return NoiDen;
	}
	public void setSoNgay(int soNgay) {
		SoNgay = soNgay;
	}
	public int getSoNgay() {
		return SoNgay;
	}
	public NgoaiThanh() {
		super();
		this.SoNgay = 0;
		this.NoiDen = "";
	}
	public NgoaiThanh(String ma, String name, String sx, double dt, String nd, int sn) {
		super(ma, name, sx, dt);
		this.SoNgay = sn;
		this.NoiDen = nd;
	}
	public void nhap() {
		super.nhap();
		System.out.println("Nơi đến: ");
		this.NoiDen = in.nextLine();
		System.out.println("Số ngày: ");
		this.SoNgay = in.nextInt();
	}
	public String toString() {
		return "Chuyến xe ngoại thành"+super.toString()+"\nNơi đến:"+this.NoiDen+"\nSố ngày"+this.SoNgay+"\nDoanh thu: "+this.DoanhThu;
	}
}

class NoiThanh extends ChuyenXe{
	private double SoKm;
	private String SoTuyen;
	Scanner in = new Scanner(System.in);
	
	public NoiThanh() {
		super();
		this.SoTuyen = "";
		this.SoKm = 0;
	}
	public NoiThanh(String ma, String name, String sx, double dt, String st, double skm) {
		super(ma, name, sx, dt);
		this.SoTuyen = st;
		this.SoKm = skm;
	}
	
	public void setSoKm(double soKm) {
		SoKm = soKm;
	}
	public double getSoKm() {
		return SoKm;
	}
	public void setSoTuyen(String soTuyen) {
		SoTuyen = soTuyen;
	}
	public String getSoTuyen() {
		return SoTuyen;
	}
	
	public void nhap() {
		super.nhap();
		System.out.println("Nhập số tuyến: ");
		this.SoTuyen = in.nextLine();
		System.out.println("Số Km: ");
		this.SoKm = in.nextDouble();
	}
	public String toString() {
		return "Chuyến xe nội thành: "+super.toString()+"\nSố tuyến: "+this.SoTuyen+"\nSố km: "+this.SoKm+"\nDoanh thu: "+this.DoanhThu;
	}
}
