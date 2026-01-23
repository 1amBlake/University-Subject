package week1_exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bai_1 extends JFrame implements ActionListener {
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtResult;
	private JButton btnSolve;
	private JButton btnClear;
	private JButton btnExit;

	public Bai_1() {
		setTitle("^-^");
		setSize(640, 480);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel pMain = new JPanel();
		pMain.setLayout(new BorderLayout());
		add(pMain);

		// header
		JPanel pTop = new JPanel();
		pTop.setLayout(new FlowLayout());
		pTop.setBackground(Color.cyan);
		pMain.add(pTop, BorderLayout.NORTH);

		JLabel lblHeading = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC 2");
		Font fHeading = lblHeading.getFont();
		lblHeading.setFont(new Font(fHeading.getFontName(), fHeading.BOLD, 26));

		pTop.add(lblHeading);

		// body, input
		JPanel pCenter = new JPanel();
		pCenter.setLayout(new GridLayout(4, 2, 10, 70));
		pMain.add(pCenter, BorderLayout.CENTER);

		JLabel lblInputA = new JLabel("Nhập a: ");
		JLabel lblInputB = new JLabel("Nhập b: ");
		JLabel lblInputC = new JLabel("Nhập c: ");
		JLabel lblResult = new JLabel("Kết quả: ");

		txtA = new JTextField(15);
		txtB = new JTextField(15);
		txtC = new JTextField(15);
		txtResult = new JTextField(15);
		txtResult.setEditable(false);

		pCenter.add(lblInputA);
		pCenter.add(txtA);
		pCenter.add(lblInputB);
		pCenter.add(txtB);
		pCenter.add(lblInputC);
		pCenter.add(txtC);
		pCenter.add(lblResult);
		pCenter.add(txtResult);

		// tac vu
		JPanel pBottom = new JPanel();
		pBottom.setLayout(new FlowLayout());
		pBottom.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pMain.add(pBottom, BorderLayout.SOUTH);

		btnSolve = new JButton("Giải");
		btnClear = new JButton("Xóa rỗng");
		btnExit = new JButton("Thoát");

		pBottom.add(btnSolve);
		pBottom.add(btnClear);
		pBottom.add(btnExit);

		btnSolve.addActionListener(this);
		btnClear.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bai_1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnExit))
			System.exit(0);
		else if (o.equals(btnClear)) {
			txtA.setText("");
			txtB.setText("");
			txtC.setText("");
			txtResult.setText("");
			txtA.requestFocus();
		} else if (o.equals(btnSolve)) {
			double numA;
			double numB;
			double numC;
			try {
				numA = Double.parseDouble(txtA.getText());
				numB = Double.parseDouble(txtB.getText());
				numC = Double.parseDouble(txtC.getText());

				txtResult.setText(giaiPTB2(numA, numB, numC));
			} catch (Exception E) {
				JOptionPane.showMessageDialog(this, "Số Nhập Vào Không Hợp Lệ!");
				txtResult.setText("Không hợp lệ!");
			}
		}
	}

	private String giaiPTB2(double A, double B, double C) {

		if (A == 0) {
			if (B == 0) {
				if (C == 0)
					return "Phương trình vô số nghiệm";
				else
					return "Phương trình vô nghiệm";
			} else {
				double x = -C / B;
				return String.format("Phương trình bậc 1: x = %.2f", x);
			}
		}

		double delta = B * B - 4 * A * C;

		if (delta < 0) {
			return "Phương trình vô nghiệm";
		} else if (Math.abs(delta) < 1e-9) {
			double x = -B / (2 * A);
			return String.format("Phương trình có nghiệm kép: x = %.2f", x);
		} else {
			double x1 = (-B + Math.sqrt(delta)) / (2 * A);
			double x2 = (-B - Math.sqrt(delta)) / (2 * A);
			return String.format("Phương trình có 2 nghiệm phân biệt: x1 = %.2f, x2 = %.2f", x1, x2);
		}
	}

}
