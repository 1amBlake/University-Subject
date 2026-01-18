package week2;
import java.util.Scanner;

class Rational {
    private int tuSo;   
    private int mauSo;  

    public Rational() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    public Rational(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mẫu số không được bằng 0!");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        toiGian();
    }

    public int getTuSo() { 
    	return tuSo;
    }
    public int getMauSo() { 
    	return mauSo; 
    }

    private int gcd(int a, int b) {
        return (b == 0) ? Math.abs(a) : gcd(b, a % b);
    }

    public void toiGian() {
        int ucln = gcd(tuSo, mauSo);
        tuSo /= ucln;
        mauSo /= ucln;
        if (mauSo < 0) { 
            tuSo = -tuSo;
            mauSo = -mauSo;
        }
    }

    public Rational nghichDao() {
        if (tuSo == 0) {
            throw new ArithmeticException("Không thể nghịch đảo phân số có tử số bằng 0!");
        }
        return new Rational(mauSo, tuSo);
    }

    public Rational cong(Rational other) {
        int tu = this.tuSo * other.mauSo + other.tuSo * this.mauSo;
        int mau = this.mauSo * other.mauSo;
        return new Rational(tu, mau);
    }

    public Rational tru(Rational other) {
        int tu = this.tuSo * other.mauSo - other.tuSo * this.mauSo;
        int mau = this.mauSo * other.mauSo;
        return new Rational(tu, mau);
    }


    public Rational nhan(Rational other) {
        int tu = this.tuSo * other.tuSo;
        int mau = this.mauSo * other.mauSo;
        return new Rational(tu, mau);
    }

    public Rational chia(Rational other) {
        if (other.tuSo == 0) {
            throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0!");
        }
        int tu = this.tuSo * other.mauSo;
        int mau = this.mauSo * other.tuSo;
        return new Rational(tu, mau);
    }

    public boolean bangNhau(Rational other) {
        double val1 = (double) this.tuSo / this.mauSo;
        double val2 = (double) other.tuSo / other.mauSo;
        return Math.abs(val1 - val2) <= 0.0001;
    }

    public String toString() {
        return tuSo + "/" + mauSo;
    }
}

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập phân số thứ nhất:");
        System.out.print("Tử số: "); int tu1 = sc.nextInt();
        System.out.print("Mẫu số: "); int mau1 = sc.nextInt();
        Rational p1 = new Rational(tu1, mau1);

        System.out.println("Nhập phân số thứ hai:");
        System.out.print("Tử số: "); int tu2 = sc.nextInt();
        System.out.print("Mẫu số: "); int mau2 = sc.nextInt();
        Rational p2 = new Rational(tu2, mau2);

        int choice;
        do {
            System.out.println("\n1. Tối giản phân số 1");
            System.out.println("2. Nghịch đảo phân số 1");
            System.out.println("3. Cộng hai phân số");
            System.out.println("4. Trừ hai phân số");
            System.out.println("5. Nhân hai phân số");
            System.out.println("6. Chia hai phân số");
            System.out.println("7. So sánh hai phân số");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    p1.toiGian();
                    System.out.println("Phân số 1 sau tối giản: " + p1);
                    break;
                case 2:
                    try {
                        System.out.println("Nghịch đảo phân số 1: " + p1.nghichDao());
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Cộng: " + p1.cong(p2));
                    break;
                case 4:
                    System.out.println("Trừ: " + p1.tru(p2));
                    break;
                case 5:
                    System.out.println("Nhân: " + p1.nhan(p2));
                    break;
                case 6:
                    try {
                        System.out.println("Chia: " + p1.chia(p2));
                    } catch (ArithmeticException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Hai phân số " + (p1.bangNhau(p2) ? "bằng nhau" : "khác nhau"));
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        sc.close();
    }
}
