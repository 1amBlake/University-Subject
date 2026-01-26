package week1_exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;

public class Bai_3 extends JFrame implements ActionListener, ItemListener {
	private JButton btnSolve;
	private JButton btnDelete;
	private JButton btnExit;
	private JTextField txtB;
	private JTextField txtA;
	private JTextComponent txtResult;
	private JRadioButton rdoSub;
	private JRadioButton rdoAdd;
	private JRadioButton rdoMul;
	private JRadioButton rdoDiv;

	public Bai_3() {
		setTitle("Cộng - Trừ - Nhân - Chia");
		setSize(500, 400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		JPanel pTop = new JPanel();
		pTop.setLayout(new FlowLayout());
		p.add(pTop, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Cộng Trừ Nhân Chia");
		Font fTitle = lblTitle.getFont();
		lblTitle.setFont(new Font(fTitle.getName(), fTitle.BOLD, 30));
		lblTitle.setForeground(Color.blue);
		pTop.add(lblTitle);

		JPanel pLeft = new JPanel();
		pLeft.setLayout(new BoxLayout(pLeft, BoxLayout.Y_AXIS));
		pLeft.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		pLeft.setBackground(Color.LIGHT_GRAY);
		pLeft.setPreferredSize(new Dimension(100, 0));
		p.add(pLeft, BorderLayout.WEST);

		btnSolve = new JButton("Giải");
		btnSolve.setMaximumSize(new Dimension(80, 30));
		btnSolve.setAlignmentX(CENTER_ALIGNMENT);
		btnDelete = new JButton("Xóa");
		btnDelete.setMaximumSize(new Dimension(80, 30));
		btnDelete.setAlignmentX(CENTER_ALIGNMENT);
		btnExit = new JButton("Thoát");
		btnExit.setMaximumSize(new Dimension(80, 30));
		btnExit.setAlignmentX(CENTER_ALIGNMENT);

		pLeft.add(btnSolve);
		pLeft.add(Box.createVerticalStrut(10));
		pLeft.add(btnDelete);
		pLeft.add(Box.createVerticalStrut(10));
		pLeft.add(btnExit);

		JPanel pCenter = new JPanel();
		pCenter.setLayout(new BorderLayout());
		pCenter.setBorder(BorderFactory.createTitledBorder("Tính toán"));
		p.add(pCenter, BorderLayout.CENTER);

		JPanel pInput = new JPanel();
		pInput.setLayout(new GridLayout(2, 1));
		pCenter.add(pInput, BorderLayout.NORTH);

		JPanel pRow1 = new JPanel(new FlowLayout());
		JPanel pRow2 = new JPanel(new FlowLayout());
		pInput.add(pRow1);
		pInput.add(pRow2);

		JLabel lblA = new JLabel("Nhập a: ");
		JLabel lblB = new JLabel("Nhập b: ");
		txtA = new JTextField(20);
		txtB = new JTextField(20);

		pRow1.add(lblA);
		pRow1.add(txtA);
		pRow2.add(lblB);
		pRow2.add(txtB);

		JPanel pCal = new JPanel();
		pCal.setLayout(new GridLayout(2, 2, 5, 5));
		pCal.setBorder(BorderFactory.createTitledBorder("Phép toán"));
		// pCal.setPreferredSize(new Dimension(50, 50));
		pCenter.add(pCal, BorderLayout.CENTER);

		JPanel pResult = new JPanel();
		pResult.setLayout(new FlowLayout());
		pResult.setPreferredSize(new Dimension(0, 40));
		pCenter.add(pResult, BorderLayout.SOUTH);

		JLabel lblResult = new JLabel("Kết quả: ");
		JTextField txtResult = new JTextField(20);
		txtResult.setEditable(false);

		pResult.add(lblResult);
		pResult.add(txtResult);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bai_3().setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
