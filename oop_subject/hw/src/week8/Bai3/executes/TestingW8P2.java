package week8.Bai3.executes;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

import week8.Bai3.entities.HanhKhach;
import week8.Bai3.services.QuanLyHanhKhach_NhaGa;

public class TestingW8P2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		QuanLyHanhKhach_NhaGa ql = new QuanLyHanhKhach_NhaGa();
		Queue<HanhKhach> dsChoVe;
		ArrayList<HanhKhach> dsCoVe;

		int chucNang;
		do {
			System.out.println("\n======Chương Trình Quản Lý Khách Hàng Nhà Ga======\n");
			System.out.println("1. Thêm một hành khác mới vào hàng đợi");
			System.out.println("2. Bán vé cho hành khách (Chỉ đăng ký trước)");
			System.out.println("3. Hiển thị danh sách khách hàng");
			System.out.println("4. Hủy một khách hàng ra khỏi danh sách (Không mua vé nữa)");
			System.out.println("5. Thống kê tình hình bán vé");
			System.out.println("6. Hiển thị danh sách các ga đang chờ mua vé");
			System.out.println("7. Hiển thị danh sách các ga đang chờ mua vé và số lượng vé tương ứng");
			System.out.print("Vui lòng chọn chức năng (0 để thoát): ");
			chucNang = sc.nextInt();

			if (chucNang < 0 || chucNang > 7)
				System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn lại!\n");
			else {
				switch (chucNang) {
				case 1: // 1. Thêm một hành khác mới vào hàng đợi
					System.out.println("\n++++Chức Năng Thêm Hành Khách++++\n");
					int luaChon = 1;
					do {
						sc.nextLine();
						System.out.print("Nhập CMND của hành khách: ");
						String id_KH = sc.nextLine();
						System.out.print("Nhập Tên của hành khách: ");
						String name_KH = sc.nextLine();
						System.out.print("Nhập Ga đến của hành khách: ");
						String arrival_Station = sc.nextLine();
						System.out.print("Nhập Giá vé của hành khách: ");
						double cost = sc.nextDouble();
						int run_CN1 = ql.themHanhKhac(id_KH, name_KH, arrival_Station, cost);

						/*
						 * 1: thành công 2: cập nhật ga -1: thất bại
						 */

						if (run_CN1 == 1) {
							System.out.println("Hành khách " + name_KH + " đã được thêm thành công\n");
							luaChon = 0;
						} else if (run_CN1 == 2) {
							System.out.println("Hành khách " + name_KH + "đã được cập nhật ga đến thành công\n");
							luaChon = 0;
						} else {
							System.out.println("Thêm hành khách không thành công!\n");
							System.out.print("Bạn có muốn nhập lại? (1 - Có / 0 - Không): ");
							luaChon = sc.nextInt();
						}
					} while (luaChon != 0);
					break;

				case 2: // 2. Ban ve
					sc.nextLine();
					System.out.println("\n++++Chức Năng Bán Vé++++\n");
					String run_CN3 = ql.banVe();
					if (run_CN3 == null)
						System.out.println("Danh sách hành khách hiện đang rỗng!");
					else {
						String s = String.format("|%15s|%30s|%30s|%10s|", "CMND", "Tên Hành Khách", "Ga Đến",
								"Giá Tiền");
						System.out.println("Bán vé cho hành khách thành công!\n" + "Thông tin hành khách: ");
						System.out.println(s);
						System.out.println(run_CN3);
						System.out.println();
					}
					break;

				case 3: // Hiển thị danh sách hành khách
					System.out.println("\n++++Chức Năng Hiển Thị Danh Sách++++\n");
					dsChoVe = ql.danhsachHKCho();
					dsCoVe = ql.danhsachHKCoVe();

					System.out.println("--Danh Sách Hành Khách Đang Chờ Vé--\n");
					String s = String.format("|%15s|%30s|%30s|%10s|", "CMND", "Tên Hành Khách", "Ga Đến", "Giá Tiền");
					System.out.println(s);
					if (dsChoVe.size() == 0) {
						System.out.println("Danh Sách Hành Khách Chờ Vé Hiện Đang Trống");
					} else {
						for (HanhKhach hkChoVe : dsChoVe)
							System.out.println(hkChoVe.toString());
					}
					System.out.println();

					System.out.println("\n--Danh Sách Hành Khách Có Vé--\n");
					System.out.println(s);
					if (dsCoVe.size() == 0)
						System.out.println("Danh Sách Hành Khách Có Vé Hiện Đang Trống\n");
					else {
						for (HanhKhach hkCoVe : dsCoVe)
							System.out.println(hkCoVe.toString());
					}
					System.out.println();
					break;

				case 4: // Hủy 1 hành khách
					System.out.println("\n++++Chức Năng Xóa Hành Khách Khỏi Danh Sách++++\n");
					sc.nextLine();
					System.out.print("Nhập CMND của hành khách: ");
					String cmnd = sc.nextLine();

					HanhKhach run_CN4 = ql.xoaHK_DSChoVe(cmnd);
					if (run_CN4 == null) {
						System.out.println("Không tồn tại hành khách trong danh sách!\n");
					} else {
						System.out.println(
								"Đã xóa thành công hành khách khỏi danh sách!\n " + "Thông tin hành khách đã bị xóa: ");
						s = String.format("|%15s|%30s|%30s|%10s|", "CMND", "Tên Hành Khách", "Ga Đến", "Giá Tiền");
						System.out.println(s);
						System.out.println(run_CN4.toString());
						System.out.println();
					}
					break;

				case 5: // Thông kê tình hình bán vé. Mục thống kê tình hình: cho biết còn bao nhiêu
						// khách hàng
					// chờ nhận vé, bao nhiêu khách hàng đã nhận vé, tổng số tiền đã thu về là bao
					// nhiêu
					System.out.println("\n++++Chức Năng Thống Kê Bán Vé++++\n");
					int slChoVe = ql.slHKChoVe();
					if (slChoVe == 0) {
						System.out.println("Danh sách hành khách chờ vé hiện đang trống!\n");
					} else {
						System.out.println("Số lượng hành khách chờ vé hiện tại: " + slChoVe);
						s = String.format("|%15s|%30s|%30s|%10s|", "CMND", "Tên Hành Khách", "Ga Đến", "Giá Tiền");
						System.out.println(s);
						dsChoVe = ql.danhsachHKCho();
						for (HanhKhach hk : dsChoVe)
							System.out.println(hk.toString());
						System.out.println();
					}

					int slCoVe = ql.slHKCoVe();
					if (slCoVe == 0) {
						System.out.println("Danh sách hành khách có vé hiện đang trống!");
						System.out.println("Tổng số tiền đã thu về: 0\n");
					} else {
						System.out.println("Số lượng hành khách đang có vé hiện tại: " + slCoVe);
						s = String.format("|%15s|%30s|%30s|%10s|", "CMND", "Tên Hành Khách", "Ga Đến", "Giá Tiền");
						System.out.println(s);
						dsCoVe = ql.danhsachHKCoVe();
						for (HanhKhach hk2 : dsCoVe)
							System.out.println(hk2.toString());
						System.out.println("Tổng số tiền đã thu về: " + ql.tongTien() + "\n");
					}
					break;

				case 6: // System.out.println("6. Hiển thị danh sách các ga đang chờ mua vé");
					System.out.println("\n++++Chức Năng Hiển Thị Các Ga Chờ Mua Vé++++\n");
					Set<String> dsGa = ql.getDSGaHKCho();
					for (String ga : dsGa)
						System.out.println(ga);
					break;

				case 7:
					System.out.println("\n++++Chức Năng Hiển Thị Các Ga Chờ Mua Vé Và Số Khách Tương Ứng++++\n");
					Map<String, Integer> map = ql.getDSGaSoKhach();
					for (Entry<String, Integer> entry : map.entrySet())
						System.out.println("Ga: " + entry.getKey() + ", so khach doi ve: " + entry.getValue());
					break;
				}
			}
		} while (chucNang != 0);

		/*
		 * test duyệt Queue<HanhKhach> test = ql.Test(); for (HanhKhach hk : test)
		 * System.out.println(hk); ArrayList<HanhKhach> test2 = ql.Test2(); for
		 * (HanhKhach hk2 : test2) System.out.println(hk2);
		 */

		// ==== TEST CASE MẪU ====
		/*
		 * // 1️⃣ Thêm hành khách
		 * System.out.println("\n[TEST 1] --- Thêm hành khách ---");
		 * ql.themHanhKhac("123", "Nam", "Hà Nội", 150000); ql.themHanhKhac("456",
		 * "Linh", "Đà Nẵng", 200000); ql.themHanhKhac("789", "Huy", "Hà Nội", 150000);
		 * System.out.println("Đã thêm 3 hành khách vào danh sách chờ vé.");
		 * 
		 * // 2️⃣ Hiển thị danh sách hành khách
		 * System.out.println("\n[TEST 2] --- Danh sách hành khách hiện tại ---");
		 * Queue<HanhKhach> dsChoVe1 = ql.danhsachHKCho(); String s =
		 * String.format("|%15s|%30s|%30s|%10s|", "CMND", "Tên Hành Khách", "Ga Đến",
		 * "Giá Tiền"); System.out.println(s); for (HanhKhach hk : dsChoVe1)
		 * System.out.println(hk.toString());
		 * 
		 * // 3️⃣ Bán vé (FIFO)
		 * System.out.println("\n[TEST 3] --- Bán vé cho hành khách đầu hàng ---");
		 * String run_CN3 = ql.banVe(); if (run_CN3 != null)
		 * System.out.println("Đã bán vé thành công!\n" + run_CN3);
		 * 
		 * // 4️⃣ Hiển thị lại danh sách sau khi bán
		 * System.out.println("\n[TEST 4] --- Danh sách sau khi bán vé ---");
		 * System.out.println(">> DS chờ vé:"); dsChoVe1 = ql.danhsachHKCho(); for
		 * (HanhKhach hk : dsChoVe1) System.out.println(hk.toString());
		 * System.out.println(">> DS có vé:"); for (HanhKhach hk : ql.danhsachHKCoVe())
		 * System.out.println(hk.toString());
		 * 
		 * // 5️⃣ Thống kê tình hình bán vé
		 * System.out.println("\n[TEST 5] --- Thống k ê bán vé ---");
		 * System.out.println("Số khách đang chờ vé: " + ql.slHKChoVe());
		 * System.out.println("Số khách đã có vé: " + ql.slHKCoVe());
		 * System.out.println("Tổng tiền đã thu: " + ql.tongTien());
		 * 
		 * // 6️⃣ Hiển thị danh sách ga đang chờ mua vé
		 * System.out.println("\n[TEST 6] --- Danh sách ga đang có hành khách chờ ---");
		 * for (String ga : ql.getDSGaHKCho()) System.out.println(ga);
		 * 
		 * // 7️⃣ Hiển thị danh sách ga + số lượng hành khách chờ System.out.
		 * println("\n[TEST 7] --- Số lượng hành khách chờ vé theo từng ga ---"); for
		 * (Map.Entry<String, Integer> entry : ql.getDSGaSoKhach().entrySet())
		 * System.out.println("Ga: " + entry.getKey() + " - Số khách chờ: " +
		 * entry.getValue());
		 * 
		 * // 8️⃣ Hủy một hành khách khỏi danh sách chờ
		 * System.out.println("\n[TEST 8] --- Hủy hành khách có CMND = 789 ---");
		 * HanhKhach xoa = ql.xoaHK_DSChoVe("789"); if (xoa != null)
		 * System.out.println("Đã hủy: " + xoa); else
		 * System.out.println("Không tìm thấy hành khách cần hủy!");
		 * 
		 * // 9️⃣ Hiển thị lại danh sách cuối cùng
		 * System.out.println("\n[TEST 9] --- Danh sách cuối cùng sau khi hủy ---");
		 * System.out.println(">> DS chờ vé:"); for (HanhKhach hk : ql.danhsachHKCho())
		 * System.out.println(hk.toString()); System.out.println(">> DS có vé:"); for
		 * (HanhKhach hk : ql.danhsachHKCoVe()) System.out.println(hk.toString());
		 */
		sc.close();
	}

}
