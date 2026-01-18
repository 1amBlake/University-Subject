package finals.OnTap1.executes;

import java.util.ArrayList;
import java.util.Scanner;

import finals.OnTap1.entities.NhanVien;
import finals.OnTap1.entities.NhanVienBanHang;
import finals.OnTap1.services.CongTy;

public class TestingOnTap1 {

	public static void main(String[] args) {
		CongTy ct = new CongTy();
		Scanner sc = new Scanner(System.in);

		int chucNang;
		do {
			System.out.println("\n=====Chương Trình Quản Lý Nhân Viên\n");
			System.out.println("1. Thêm nhân viên");
			System.out.println("2. Tình tiền lương trung bình phải trả cho nhân viên bán hàng");
			System.out.println("3. Xóa nhân viên khỏi danh sách theo mã");
			System.out.println("4. In ra toàn bộ danh sách nhân viên bán hàng");
			System.out.print("Vui lòng chọn chức năng (0 để thoát): ");
			chucNang = sc.nextInt();
			sc.nextLine();

			if (chucNang < 0 || chucNang > 4)
				System.out.println("Chức năng được chọn không hợp lệ! Vui lòng chọn lại!\n");
			else {
				switch (chucNang) {
				case 1:
					System.out.println("\n+++++Chức Năng Thêm Nhân Viên+++++\n");
					int loaiNV;
					boolean checkCN1;
					String MaNV = "n/a";
					String HoTen = "n/a";
					long SDT = -1;
					double LuongCB = -1;
					double DoanhSoBH = -1;
					double HeSoLuong = -1;
					do {
						System.out.println("1. Nhân viên bán hàng");
						System.out.println("2. Nhân viên hành chính");
						System.out.print("Vui lòng chọn loại nhân viên: ");
						loaiNV = sc.nextInt();
						sc.nextLine();

						if (loaiNV != 1 && loaiNV != 2)
							System.out.println("Lựa chọn không hợp lê! Vui lòng chọn lại!\n");
						else {
							System.out.print("Nhập Mã nhân viên: ");
							MaNV = sc.nextLine();

							System.out.print("Nhập Họ tên nhân viên: ");
							HoTen = sc.nextLine();

							System.out.print("Nhập Số điện thoại nhân viên: ");
							SDT = sc.nextLong();

							System.out.print("Nhập Lương cơ bản nhân viên: ");
							LuongCB = sc.nextDouble();

							if (loaiNV == 1) {
								System.out.print("Nhập Doanh số của nhân viên: ");
								DoanhSoBH = sc.nextDouble();
							} else {
								System.out.print("Nhập Hệ số lương nhân viên: ");
								HeSoLuong = sc.nextDouble();
							}

							checkCN1 = ct.themNhanVien(loaiNV, MaNV, HoTen, SDT, LuongCB, DoanhSoBH, HeSoLuong);
							if (checkCN1 == false)
								System.out.println(
										"Thêm không thành công do trùng mã hoặc dữ liêu đầu vào không hợp lệ!\n");
							else {
								System.out.println("Thêm thành công! Danh sách: \n");
								String sOut = String.format("|%20s|%30s|%20s|%20s|%10s|", "Mã Nhân Viên", "Họ Tên",
										"Số Điện Thoại", "Lương Cơ Bản", "DT/HS");
								System.out.println(sOut);
								ArrayList<NhanVien> nv = ct.inDanhSach();
								for (NhanVien out : nv)
									System.out.println(out);
							}
						}
					} while (loaiNV < 1 || loaiNV > 2);
					break;

				case 2:
					System.out.println("\n+++++Chức Năng Tính Tiền Lương Trung Bình Của Nhân Viên Bán Hàng+++++\n");
					ArrayList<NhanVien> nv = ct.inDanhSach();
					int sl = 0;
					String sOut = String.format("|%20s|%30s|%20s|%20s|%10s|%10s|", "Mã Nhân Viên", "Họ Tên",
							"Số Điện Thoại", "Lương Cơ Bản", "DT", "Nhận Thực");
					System.out.println(sOut);
					for (NhanVien out : nv) {
						if (out instanceof NhanVienBanHang) {
							String tienLuong = String.format("%10f|", out.tinhLuongNV());
							System.out.println(out.toString() + tienLuong);
							sl++;
						}
					}
					System.out.println("Tổng số lượng nhân viên bán hàng: " + sl);
					System.out.println("Trung bình tiền lương của nhân viên bán hàng: " + ct.tinhTrungBinhLuong());
					break;

				case 3:
					System.out.println("\n+++++Chức Năng Xóa Nhân Viên Theo Mã+++++\n");

					String del_MaNV;
					System.out.print("Nhập Mã nhân viên cần xóa: ");
					del_MaNV = sc.nextLine();
					boolean checkCN3 = ct.xoaNhanVien(del_MaNV);

					if (!checkCN3)
						System.out.println("Không có nhân viên này trong danh sách!\n");
					else {
						System.out.println("Xóa thành công! Danh sách: \n");
						String sOut2 = String.format("|%20s|%30s|%20s|%20s|%10s|", "Mã Nhân Viên", "Họ Tên",
								"Số Điện Thoại", "Lương Cơ Bản", "DT/HS");
						System.out.println(sOut2);
						ArrayList<NhanVien> nv2 = ct.inDanhSach();
						for (NhanVien out : nv2)
							System.out.println(out);
					}
					break;

				case 4:
					System.out.println("\n+++++Chức Năng In Danh Sách Nhân Viên Bán Hàng+++++\n");
					ArrayList<NhanVien> nv3 = ct.inDanhSach();
					String sOut3 = String.format("|%20s|%30s|%20s|%20s|%10s|", "Mã Nhân Viên", "Họ Tên",
							"Số Điện Thoại", "Lương Cơ Bản", "DT");
					System.out.println(sOut3);
					for (NhanVien out : nv3) {
						if (out instanceof NhanVienBanHang) {
							System.out.println(out.toString());
						}
					}
					break;
				}
			}
		} while (chucNang != 0);

		System.out.println("Chương trình đã đóng thành công!");
		sc.close();
	}

}
