package midterm2.executes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import midterm2.entities.HangThucPham;
import midterm2.services.QuanLyHangThucPham;

public class TestingMT2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuanLyHangThucPham ql = new QuanLyHangThucPham();
		int choice;

		do {
			System.out.println("1. Thêm một hàng thực phẩm");
			System.out.println("2. Trích ra danh sách hàng thực phẩm có số ngày lưu kho trên 30");
			System.out.println("3. Tìm danh sách hàng hóa");
			System.out.println("4. Xóa danh sách các hàng theo tên");
			System.out.print("Vui lòng chọn tính năng (Nhập 0 để thoát): ");
			choice = sc.nextInt();

			if (choice < 0)
				System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!");
			else {
				switch (choice) {
				case 1:
					System.out.println("\n-----------Tính năng thêm hàng thực phẩm-----------\n");
					sc.nextLine();
					System.out.print("Nhập Mã hàng thực phẩm: ");
					String maHang = sc.nextLine();

					System.out.print("Nhập Tên hàng thực phẩm: ");
					String tenHang = sc.nextLine();

					System.out.print("Nhập Nhà sản xuất: ");
					String nhaSX = sc.nextLine();

					LocalDate ngayNhapKho = null;
					while (true) {
						try {
							System.out.print("Nhập Ngày nhập kho (dd/MM/yyyy): ");
							String date = sc.nextLine();
							DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
							ngayNhapKho = LocalDate.parse(date, fmt);

							if (ngayNhapKho.isAfter(LocalDate.now()))
								System.out.println("Ngày nhập kho không hợp lệ! Hãy nhập lại!");
							else
								break;
						} catch (Exception e) {
							System.out.println("Sai định dạng ngày! Hãy nhập lại");
						}
					}

					System.out.print("Nhập Đơn vị tính: ");
					String donVi = sc.nextLine();

					double giaTien;
					do {
						System.out.print("Nhập Giá tiền: ");
						giaTien = sc.nextDouble();

						if (giaTien < 0)
							System.out.println("Giá tiền không hợp lệ! Vui lòng nhập lại");
					} while (giaTien < 0);
					sc.nextLine();
					HangThucPham hang = new HangThucPham(maHang, tenHang, nhaSX, ngayNhapKho, donVi, giaTien);
					int check = ql.themHang(hang);
					if (check == 1) {
						System.out.println("Thêm thành công!");
						HangThucPham[] hang3 = ql.duyetDSHTP();
						for (HangThucPham kq : hang3)
							if (kq != null)
								System.out.println(kq);
					} else
						System.out.println("Không thêm được!\n");
					System.out.println();
					break;

				case 2:
					System.out.println("\n-----------Tính năng tìm hàng thực phẩm lưu kho trên 30 ngày-----------\n");
					HangThucPham[] kq = ql.TrichDanhSachHangThucPham();

					if (kq == null)
						System.out.println("Danh sách hàng thực phẩm rỗng!");

					else if (kq.length == 0)
						System.out.println("Không có hàng phẩm được lưu kho trên 30 ngày!");

					else {
						for (HangThucPham h : kq) {
							System.out.println(h);
						}
					}
					System.out.println();
					break;

				case 3:
					sc.nextLine();
					System.out.println("\n-----------Tính năng tìm hàng thực phẩm theo tên-----------\n");
					System.out.print("Nhập tên hàng thực phẩm muốn kiếm: ");
					String name = sc.nextLine();

					HangThucPham[] hang1 = ql.timHTPTheoTen(name);
					if (hang1 == null)
						System.out.println("Danh sách hàng thực phẩm rỗng!");
					else if (hang1.length == 0)
						System.out.println("Không có hàng thực phẩm theo tên \"" + name + "\'");
					else {
						for (HangThucPham kq2 : hang1)
							System.out.println(kq2);
					}
					System.out.println();
					break;

				case 4:
					sc.nextLine();
					System.out.println("\n-----------Tính năng xóa hàng thực phẩm theo tên-----------\n");
					System.out.print("Nhập tên hàng thực phẩm muốn xóa (có thể xóa hàng loạt): ");
					String del_name = sc.nextLine();

					int kq4 = ql.xoaHTPTheoTen(del_name);
					if (kq4 == -1)
						System.out.println("Danh sách hàng thực phẩm rỗng!");

					else if (kq4 == 0)
						System.out.println("Không có hàng thục phẩm theo tên!");

					else {
						System.out.println("Xoá thành công " + kq4 + " hàng thực phẩm" + "\n Danh sách hiện tại: ");
						HangThucPham[] hang4 = ql.duyetDSHTP();
						if (hang4.length == 0)
							System.out.println("Danh sách hàng thực phẩm rỗng!");
						else {
							for (HangThucPham out : hang4) {
								if (out != null)
									System.out.println(out);
							}
						}
					}
					break;
				}
			}
		} while (choice != 0);

		sc.close();
	}
}
