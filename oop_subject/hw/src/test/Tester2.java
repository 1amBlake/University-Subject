package test;
import java.util.ArrayList;
class Vehicles {
    private String owner;
    private String type;

    public Vehicles(String owner, String type) {
        this.owner = owner;
        this.type = type;
    }

    public void display() {
        System.out.println("Owner: " + owner + ", Type: " + type);
    }
}


public class Tester2 {

	public static void main(String[] args) {
        // Tạo ArrayList chứa Vehicle
        ArrayList<Vehicles> list = new ArrayList<>();

        // Thêm object vào list
        list.add(new Vehicles("Huy", "Car"));
        list.add(new Vehicles("Blake", "Motorbike"));

        // Duyệt danh sách
        for (Vehicles v : list) {
            v.display();
        }
    }

}
