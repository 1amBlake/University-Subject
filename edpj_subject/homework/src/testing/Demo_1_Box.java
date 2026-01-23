package testing;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Demo_1_Box extends JFrame implements ActionListener {
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtResult;
	private JButton btnSolve;
	private JButton btnClear;
	private JButton btnExit;

	public Demo_1_Box() {
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
		pCenter.setLayout(new GridLayout(4, 2, 20, 20)); // giảm khoảng cách
		pMain.add(pCenter, BorderLayout.CENTER);

		// Labels
		JLabel lblInputA = new JLabel("Nhập a:");
		JLabel lblInputB = new JLabel("Nhập b:");
		JLabel lblInputC = new JLabel("Nhập c:");
		JLabel lblResult = new JLabel("Kết quả:");

		// TextFields
		txtA = new JTextField(20);
		txtB = new JTextField(20);
		txtC = new JTextField(20);
		txtResult = new JTextField(20);
		txtResult.setEditable(false);

		// Panel bọc JTextField (để không bị kéo dài)
		JPanel pA = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pB = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pC = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel pR = new JPanel(new FlowLayout(FlowLayout.LEFT));

		pA.add(txtA);
		pB.add(txtB);
		pC.add(txtC);
		pR.add(txtResult);

		// Add vào center
		pCenter.add(lblInputA);
		pCenter.add(pA);

		pCenter.add(lblInputB);
		pCenter.add(pB);

		pCenter.add(lblInputC);
		pCenter.add(pC);

		pCenter.add(lblResult);
		pCenter.add(pR);

		/*
		 * // body, input JPanel pCenter = new JPanel(); pCenter.setLayout(new
		 * GridLayout(4, 2, 10, 15)); pMain.add(pCenter, BorderLayout.CENTER);
		 * 
		 * JLabel lblInputA = new JLabel("Nhập a: "); JLabel lblInputB = new
		 * JLabel("Nhập b: "); JLabel lblInputC = new JLabel("Nhập c: "); JLabel
		 * lblResult = new JLabel("Kết quả: ");
		 * 
		 * txtA = new JTextField(15); txtB = new JTextField(15); txtC = new
		 * JTextField(15); txtResult = new JTextField(15); txtResult.setEditable(false);
		 * 
		 * pCenter.add(lblInputA); pCenter.add(txtA); pCenter.add(lblInputB);
		 * pCenter.add(txtB); pCenter.add(lblInputC); pCenter.add(txtC);
		 * pCenter.add(lblResult); pCenter.add(txtResult);
		 * 
		 * 
		 */
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
		new Demo_1_Box().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
