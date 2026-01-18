package week8.Bai2.executes;

import java.util.ArrayList;
import java.util.Scanner;

import week8.Bai2.entities.PhongHoc;
import week8.Bai2.services.QuanLyPhongHoc;

public class TestingW8P2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuanLyPhongHoc ql = new QuanLyPhongHoc();

		// test nhanh
		/*
		 * QuanLyPhongHoc qlTest = new QuanLyPhongHoc(); qlTest.themPH(2, "MT01", "A",
		 * 120.0, 10, 0, 70, "n/a", -1, 0); // phòng máy 70 máy qlTest.themPH(2, "MT02",
		 * "A", 100.0, 10, 0, 50, "n/a", -1, 0); // phòng máy 50 máy qlTest.themPH(1,
		 * "LT01", "B", 50.0, 6, 1, -1, "n/a", -1, 0); // lý thuyết
		 * 
		 * System.out.println("Total before delete: " + qlTest.tongSoPhongHoc()); //
		 * expect 3 ArrayList<PhongHoc> big = qlTest.phongCoSLMayTren60(); // expect 1
		 * element (MT01) System.out.println("Phong co >60: " + big.size()); int del =
		 * qlTest.xoaPhongHoc("MT02"); // delete MT02
		 * System.out.println("Delete MT02 result: " + del); // expect 1
		 * System.out.println("Total after delete: " + qlTest.tongSoPhongHoc()); //
		 * expect 2
		 */

		int chucNang;
		do {
			System.out.println("\n======Chương Trình Quản Lý Phòng Học======\n");
			System.out.println("1. Thêm một phòng học mới");
			System.out.println("2. Tìm một phòng học theo mã");
			System.out.println("3. In toàn bộ danh sách phòng học");
			System.out.println("4. Sắp xếp danh sách tăng dần theo dãy nhà");
			System.out.println("5. Sắp xếp danh sách giảm dần theo diện tích");
			System.out.println("6. Sắp xếp danh sách tăng dần theo số lượng bóng đèn");
			System.out.println("7. Cập nhật số lượng máy tính cho một phòng máy tính");
			System.out.println("8. Xóa một phòng theo mã phòng");
			System.out.println("9. In ra tổng số phòng học");
			System.out.println("10. In ra danh sách các phòng có tổng số máy tính trên 60");
			System.out.print("\nVui lòng chọn chức năng (Nhập 0 để thoát): ");
			chucNang = sc.nextInt();

			if (chucNang < 0 || chucNang > 11)
				System.out.println("\nLựa chọn (chức năng) không hợp lê! Vui lòng chọn lại!");
			else {
				if (chucNang == 1) {
					sc.nextLine();

					int check;
					int loaiPhong;
					do {
						System.out.println("\n++++Chức Năng Thêm Một Phòng Học Mới++++\n");
						System.out.println("1. Phòng Lý Thuyết");
						System.out.println("2. Phòng Máy Tính");
						System.out.println("3. Phòng Thí Nghiệm");
						System.out.print("\nVui lòng chọn loại phòng muốn thêm (Nhập 0 để quay lại): ");
						loaiPhong = sc.nextInt();

						if (loaiPhong < 0 || loaiPhong > 3)
							System.out.println("\nLoại phòng không hợp lệ! Vui lòng chọn lại!");

						else {
							String loaiPhongString;
							sc.nextLine();

							System.out.print("Nhập Mã phòng: ");
							String maPhong = sc.nextLine();

							System.out.print("Nhập Dãy nhà (A-Z): ");
							String dayNha = sc.nextLine();

							System.out.print("Nhập Diện Tích (>0): ");
							double dienTich = sc.nextDouble();

							System.out.print("Nhập số lượng bóng đèn (>0): ");
							int soBongDen = sc.nextInt();

							int checkMayChieu = 0;
							int soMayTinh = -1;
							String chuyenNganh = "n/a";
							int sucChua = -1;
							int checkBonRua = 0;
							if (loaiPhong == 1) {
								loaiPhongString = "Phòng Lý Thuyết ";
								System.out.print("Có máy chiếu hay không (1 - Có / 0 - Không): ");
								checkMayChieu = sc.nextInt();
							} else if (loaiPhong == 2) {
								loaiPhongString = "Phòng Máy Tính ";
								System.out.print("Nhập Số lượng máy tính (>0): ");
								soMayTinh = sc.nextInt();
							} else {
								sc.nextLine();
								loaiPhongString = "Phòng Thí Nghiệm ";
								System.out.print("Nhập Thông tin chuyên ngành: ");
								chuyenNganh = sc.nextLine();

								System.out.print("Nhập Số lượng sức chứa (>0): ");
								sucChua = sc.nextInt();

								System.out.print("Có bồn rửa hay không (1 - Có / 0 - Không): ");
								checkBonRua = sc.nextInt();
							}

							check = ql.themPH(loaiPhong, maPhong, dayNha, dienTich, soBongDen, checkMayChieu, soMayTinh,
									chuyenNganh, sucChua, checkBonRua);

							/*
							 * check: 1: Thành công 0: Trùng mã/Thất bại -1: Sai định dạng dãy nhà -2: Sai
							 * định dạng hoặc âm (diện tích, số bóng đèn, sức chứa, số máy tính) -3: lựa
							 * chọn cho máy chiếu hoặc bồn rửa không hợp lệ
							 */
							if (check == 1)
								System.out.println("\nThêm thành công " + loaiPhongString);
							else if (check == 0)
								System.out.println("\nThêm thất bại do Trùng mã phòng!");
							else if (check == -1)
								System.out.println(
										"\nThêm thất bại! Dãy nhà phải là một chữ cái duy nhất" + " từ A đến Z");
							else if (check == -2)
								System.out.println("\nThêm thất bai! Diện tích/Bóng đèn/Số máy tính/"
										+ "Sức chứa sai định dạng hoặc đã âm!");
							else if (check == -3)
								System.out.println("\nThêm thất bại! Lựa chọn của Máy chiếu/Bồn rửa "
										+ "chỉ có thể là 1 (có) hoặc 0 (không)!");
						}
					} while (!(loaiPhong >= 0 && loaiPhong <= 3));
				}

				else if (chucNang == 2) { // tim phong hoc theo ma
					sc.nextLine();
					System.out.println("\n++++Chức Năng Tìm Một Phòng Học Theo Mã++++\n");
					System.out.print("Nhập Mã phòng học muốn tìm kiếm: ");
					String maPhong = sc.nextLine();
					PhongHoc check = ql.timPHTheoMa(maPhong);
					if (check == null)
						System.out.println("\nKhông tồn tại phòng học mã " + maPhong);
					else {
						System.out.println("Đã có kết quả: ");
						System.out.println(check);
					}
				}

				else if (chucNang == 3) { // In toàn bộ danh sách phòng học
					System.out.println("\n++++Chức Năng In Danh Sách Phòng Học++++\n");

					ArrayList<PhongHoc> danhSach = ql.inDanhSachPhong();
					if (danhSach.isEmpty())
						System.out.println("Danh sách hiện đang trống!");
					else {
						for (PhongHoc pH : danhSach)
							System.out.println(pH);
					}
				}

				else if (chucNang == 4) { // Sắp xếp danh sách tăng dần theo dãy nhà
					System.out.println("\n++++Chức Năng Sắp Xếp Danh Sách Phòng Học Theo Dãy Nhà Tăng Dần++++\n");

					ArrayList<PhongHoc> danhSach = ql.sapxepDSTheoDayNha();
					if (danhSach.isEmpty())
						System.out.println("Danh sách hiện đang trống!");
					else {
						for (PhongHoc pH : danhSach)
							System.out.println(pH);
					}
				}

				else if (chucNang == 5) {// 5. Sắp xếp danh sách giảm dần theo diện tích
					System.out.println("\n++++Chức Năng Sắp Xếp Danh Sách Phòng Học Theo Diện Tích Giảm Dần++++\n");

					ArrayList<PhongHoc> danhSach = ql.sapxepDSTheoDienTichGD();
					if (danhSach.isEmpty())
						System.out.println("Danh sách hiện đang trống!");
					else {
						for (PhongHoc pH : danhSach)
							System.out.println(pH);
					}
				}

				else if (chucNang == 6) { // 6 Sắp xếp danh sách tăng dần theo số lượng bóng đèn
					System.out.println(
							"\n++++Chức Năng Sắp Xếp Danh Sách Phòng Học Theo Số Lượng Bóng Đèn Tăng Dần++++\n");
					ArrayList<PhongHoc> danhSach = ql.sapxepDSTheoSLBongDen();
					if (danhSach.isEmpty())
						System.out.println("Danh sách hiện đang trống!");
					else {
						for (PhongHoc pH : danhSach)
							System.out.println(pH);
					}
				}

				else if (chucNang == 7) { // 7 Cập nhật số lượng máy tính cho một phòng máy tính
					sc.nextLine();
					System.out.println("\n++++Chức Năng Cập Nhật Số Lượng Máy Tính Cho Phòng Máy Tính++++\n");

					String MaPHMT;
					int slMT;
					System.out.print("Nhập Mã phòng học máy tính muốn cập nhật: ");
					MaPHMT = sc.nextLine();
					System.out.print("Nhập số lượng máy tính muốn cập nhật: ");
					slMT = sc.nextInt();

					boolean checkCN7 = ql.updateSLMayTinh(MaPHMT, slMT);
					if (checkCN7) {
						System.out.println("Cập nhật thành công!\n");
						ArrayList<PhongHoc> danhSach = ql.inDanhSachPhong();
						if (danhSach.isEmpty())
							System.out.println("Danh sách hiện đang trống!");
						else {
							for (PhongHoc pH : danhSach)
								System.out.println(pH);
						}
					} else {
						System.out.println("Cập nhật thất bại! Danh sách rỗng hoặc không có mã phòng máy tính này!\n");
					}
				}

				else if (chucNang == 8) { // 8. Xóa một phòng theo mã phòng
					sc.nextLine();
					System.out.println("\n++++Chức Năng Xóa Phòng Học Theo Mã++++\n");
					/*
					 * check: -1: Danh sach rong 0: Khong ton tai ma phong tuong ung 1: thanh cong
					 */
					String del_MP;
					System.out.print("Nhập Mã phòng muốn xóa: ");
					del_MP = sc.nextLine();

					int checkCN8 = ql.xoaPhongHoc(del_MP);
					if (checkCN8 == -1)
						System.out.println("Danh sách đang rỗng! Không thể xóa\n");
					else if (checkCN8 == 0) {
						System.out.println("Không tìm thấy mã phòng tương ứng!\n");
						ArrayList<PhongHoc> danhSach = ql.inDanhSachPhong();
						for (PhongHoc PH : danhSach)
							System.out.println(PH);
					} else {
						System.out.println("Đã xóa thành công mã phòng " + del_MP);
						System.out.println();
						ArrayList<PhongHoc> danhSach = ql.inDanhSachPhong();
						if (danhSach.isEmpty())
							System.out.println("Danh sách đã rỗng!");
						else {
							for (PhongHoc PH : danhSach)
								System.out.println(PH);
						}
						System.out.println();
					}
				}

				else if (chucNang == 9) { // 9. In ra tổng số phòng học
					System.out.println("\n++++Chức Năng In Tổng Số Phòng Học++++\n");
					System.out.println("Tông số lượng phòng học là: " + ql.tongSoPhongHoc());
					System.out.println();
				}

				else { // In ra danh sách các phòng có tổng số máy tính trên 60
					System.out.println("\n++++Chức Năng In Danh Sách Phòng Máy Tính Có Số Máy Trên 60++++\n");
					ArrayList<PhongHoc> danhSach = ql.phongCoSLMayTren60();

					if (danhSach == null) {
						System.out.println("Không có phòng máy tính nào trên 60 máy tính!\n");
					} else {
						for (PhongHoc out : danhSach)
							System.out.println(out);
					}
				}
			} // cua else lon, chuc nang tiep theo o tren ngoac nay
		} while (chucNang != 0);

		System.out.println("\n______Thoát Chương Trình Thành Công______\n");
		sc.close();
	}
}
