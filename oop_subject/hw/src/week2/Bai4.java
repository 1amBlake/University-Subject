package week2;
import java.util.*;

class Account {
    private long accNum;
    private String accName;
    private double accBalance;
    final double interest_Rate = 0.035;

    public Account(long accNum, String accName) {
        this.accNum = accNum;
        this.accName = accName;
        this.accBalance = 50;
    }

    public void setANum(long num) {
        this.accNum = num;
    }
    public void setAName(String name) {
        this.accName = name;
    }
    public void setABalance(double balance) {
        this.accBalance = balance;
    }

    public long getANum() {
        return this.accNum;
    }
    public String getAName() {
        return this.accName;
    }
    public double getABalance() {
        return this.accBalance;
    }

    public void accDeposit(Scanner sc) {
        double money;
        do {
            System.out.print("Nhập số tiền cần nạp: ");
            money = sc.nextDouble();
            if (money <= 0) {
                System.out.println("Số tiền nạp không hợp lệ! Hãy thử lại");
                sc.nextLine();
            }
        } while (money <= 0);
        setABalance(getABalance() + money);
        System.out.println("Số dư còn lại: " + getABalance());
    }

    public void accWithdraw(Scanner sc) {
        double money;
        double fee = 1; 
        double balance;
        do {
            balance = getABalance();
            System.out.print("Nhập số tiền cần rút (Chi phí: 1): ");
            money = sc.nextDouble();
            if (money <= 0) {
                System.out.println("Số tiền rút không hợp lệ! Hãy thử lại");
                sc.nextLine();
            } else if (balance - (money + fee) < 0) {
                System.out.println("Số dư không đủ! Hãy thử lại");
                sc.nextLine();
            }
        } while (money <= 0 || balance - (money + fee) < 0);
        setABalance(balance - (money + fee));
        System.out.println("Số dư còn lại: " + getABalance());
    }

    public void accMaturity() {
        setABalance(getABalance() + (getABalance() * interest_Rate));
        System.out.println("Số dư còn lại: " + getABalance());
    }

    public void accTransfer(ArrayList<Account> list, Scanner sc) {
        System.out.print("Nhập số tài khoản cần chuyển khoản: ");
        long accNumTrans = sc.nextLong();

        Account acc = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getANum() == accNumTrans) {
                acc = list.get(i);
                break;
            }
        }
        if (acc == null) {
            System.out.println("Số tài khoản không tồn tại!");
            return;
        }
        if (acc.getANum() == this.accNum) {
            System.out.println("Không thể chuyển khoản cho chính mình!");
            return;
        }

        double money;
        do {
            System.out.print("Nhập số tiền cần chuyển: ");
            money = sc.nextDouble();
            if (money <= 0) {
                System.out.println("Số tiền cần chuyển không hợp lệ! Hãy nhập lại");
            } else if (getABalance() - money < 0) {
                System.out.println("Số dư tài khoản không đủ! Hãy nhập lại");
            }
        } while (money <= 0 || getABalance() - money < 0);

        setABalance(getABalance() - money);
        acc.setABalance(acc.getABalance() + money);
        System.out.println("Chuyển khoản thành công! Số dư còn lại: " + getABalance());
    }

    public String toString() {
        return String.format("%-30s%-20d%-20.2f", getAName(), getANum(), getABalance());
    }
}

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cfm = 1;
        ArrayList<Account> accList = new ArrayList<>();
        accList.add(new Account(15052006, "Doan Minh Huy"));
        Account acc = accList.get(0);

        do {
            System.out.print("Tạo số tài khoản: ");
            long num = sc.nextLong();
            sc.nextLine();
            System.out.print("Tạo tên tài khoản: ");
            String name = sc.nextLine();
            accList.add(new Account(num, name));

            System.out.print("Bấm 1 để thêm tài khoản. Số khác để thoát: ");
            cfm = sc.nextInt();
        } while (cfm == 1);

        int choice;
        do {
            System.out.print(
                "\nChọn tính năng muốn sử dụng:\n" +
                " 1. Nạp tiền vào tài khoản\n" +
                " 2. Rút tiền khỏi tài khoản\n" +
                " 3. Đáo hạn\n" +
                " 4. Chuyển tiền\n" +
                " 5. Xem thông tin tài khoản\n" +
                " 0. Thoát\n" +
                "Lựa chọn: "
            );
            choice = sc.nextInt();

            if (choice == 1) acc.accDeposit(sc);
            else if (choice == 2) acc.accWithdraw(sc);
            else if (choice == 3) acc.accMaturity();
            else if (choice == 4) acc.accTransfer(accList, sc);
            else if (choice == 5) System.out.println(acc);
        } while (choice != 0);

        sc.close();
    }
}

