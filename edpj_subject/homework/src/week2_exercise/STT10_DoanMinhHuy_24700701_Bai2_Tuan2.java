package week2_exercise;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class STT10_DoanMinhHuy_24700701_Bai2_Tuan2 extends JFrame implements ActionListener, MouseListener, ListSelectionListener, ItemListener {
	private static final long serialVersionUID = 1L;
	private DefaultListModel<Integer> dfModel;
	private JList<Integer> list;
	private JButton btnBoldEven;
	private JButton btnBoldOdd;
	private JButton btnBoldPrime;
	private JButton btnDeleteBold;
	private JButton btnUnBold;
	private JButton btnTotal;
	private JButton btnExit;
	private JButton btnInput;
	private JTextField txtInput;
	private JCheckBox chkAllowNeg;
	private JButton btnRandomNum;

	public STT10_DoanMinhHuy_24700701_Bai2_Tuan2() {
		setTitle("Thao Tác Trên JList");
		setSize(750, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		JPanel pBot = new JPanel();
		pBot.setLayout(new FlowLayout());
		pBot.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
		pBot.setBackground(Color.LIGHT_GRAY);
		p.add(pBot, BorderLayout.SOUTH);
		btnExit = new JButton("Đóng Chương Trình");

		pBot.add(btnExit);

		JPanel pTop = new JPanel();
		pTop.setLayout(new FlowLayout());
		p.add(pTop, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("Thao Tác Trên JList - Checkbox");
		Font fTitle = lblTitle.getFont();
		lblTitle.setFont(new Font(fTitle.getName(), fTitle.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);

		pTop.add(lblTitle);

		JPanel pFeature = new JPanel();
		pFeature.setLayout(new GridLayout(10, 1));
		pFeature.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Chọn tác vụ"));
		p.add(pFeature, BorderLayout.WEST);

		btnBoldEven = new JButton("Tô Đen Số Chẵn");
		btnBoldOdd = new JButton("Tô Đen Số Lẻ");
		btnBoldPrime = new JButton("Tô Đen Số Nguyên Tố");
		btnUnBold = new JButton("Bỏ Tô Đen");
		btnDeleteBold = new JButton("Xóa Các Giá trị Đang Tô Đen");
		btnTotal = new JButton("Tính Tổng Giá Trị Trong JList");

		pFeature.add(btnBoldEven);
		pFeature.add(btnBoldOdd);
		pFeature.add(btnBoldPrime);
		pFeature.add(btnUnBold);
		pFeature.add(btnDeleteBold);
		pFeature.add(btnTotal);

		JPanel pInput = new JPanel();
		pInput.setLayout(new BorderLayout());
		pInput.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED, 2), "Chọn tác vụ"));
		p.add(pInput, BorderLayout.CENTER);

		JPanel pInput_Top = new JPanel();
		pInput_Top.setLayout(new FlowLayout());
		pInput.add(pInput_Top, BorderLayout.NORTH);

		btnInput = new JButton("Nhập");
		txtInput = new JTextField(15);
		chkAllowNeg = new JCheckBox("Cho nhập số âm");
		btnRandomNum = new JButton("Số ngẫu nhiên");

		pInput_Top.add(btnInput);
		pInput_Top.add(txtInput);
		pInput_Top.add(chkAllowNeg);
		pInput_Top.add(btnRandomNum);

		JPanel pInput_Main = new JPanel();
		pInput.add(pInput_Main);

		// khoi tao model va jlist
		dfModel = new DefaultListModel<Integer>();
		list = new JList<Integer>(dfModel);

		pInput_Main.add(new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));

		list.setVisibleRowCount(15);
		list.setFixedCellWidth(450);
		list.setFixedCellHeight(19);

		btnExit.addActionListener(this);
		btnInput.addActionListener(this);
		btnRandomNum.addActionListener(this);
		btnBoldEven.addActionListener(this);
		btnBoldOdd.addActionListener(this);
		btnBoldPrime.addActionListener(this);
		btnDeleteBold.addActionListener(this);
		btnUnBold.addActionListener(this);
		btnTotal.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new STT10_DoanMinhHuy_24700701_Bai2_Tuan2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnExit))
			System.exit(0);
		else if (o.equals(btnInput)) {
			validateInput();
		} else if (o.equals(btnRandomNum)) {
			randomNumberCreator();
		} else if (o.equals(btnBoldEven)) {
			selectBoldEven();
		} else if (o.equals(btnBoldOdd)) {
			selectBoldOdd();
		} else if (o.equals(btnBoldPrime)) {
			selectBoldPrime();
		} else if (o.equals(btnDeleteBold)) {
			deleteBold();
		} else if (o.equals(btnUnBold)) {
			unselectBold();
		} else if (o.equals(btnTotal)) {
			sumValue();
		}
	}
//24700701 Doan Minh Huy
	private void sumValue() {
		long sum = 0;
		if (dfModel.size() == 0)
			JOptionPane.showMessageDialog(null, "Danh sách đang trống!");
		else {
			for (int i = 0; i < dfModel.size(); i++)
				sum += dfModel.getElementAt(i);
			JOptionPane.showMessageDialog(null, "Kết quả: " + sum);
		}
	}

	private void unselectBold() {
		list.clearSelection();
	}

	private void deleteBold() {
		int sizeOfSelection = list.getSelectedValuesList().size();

		for (int i = 0; i < sizeOfSelection; i++) {
			dfModel.removeElementAt(list.getSelectedIndex());
		}
	}

	private void selectBoldPrime() {
		list.clearSelection();
		int count = 0;
		for (int i = 0; i < dfModel.size(); i++) {
			int number = dfModel.getElementAt(i);
			if (checkPrime(number)) {
				list.addSelectionInterval(i, i);
				count++;
			}
		}
		if (count == 0)
			JOptionPane.showMessageDialog(null, "Không có số nguyên tố");
	}

	private boolean checkPrime(int n) {
		n = Math.abs(n);
		if (n <= 2)
			return false;
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private void selectBoldOdd() {
		list.clearSelection();
		int count = 0;
		for (int i = 0; i < dfModel.size(); i++) {
			if (dfModel.getElementAt(i) % 2 != 0) {
				count++;
				list.addSelectionInterval(i, i);
			}
		}
		if (count == 0)
			JOptionPane.showMessageDialog(null, "Không có số lẻ");
	}

	private void selectBoldEven() {
		list.clearSelection();
		int count = 0;
		for (int i = 0; i < dfModel.size(); i++) {
			if (dfModel.getElementAt(i) % 2 == 0) {
				list.addSelectionInterval(i, i);
				count++;
			}
		}
		if (count == 0)
			JOptionPane.showMessageDialog(this, "Không có số chẵn!");
	}

	private void randomNumberCreator() {
		String sizeRandom = JOptionPane.showInputDialog(null, "Nhập số lượng số lượng số (>0 và<=100)");
		if (sizeRandom != null) {
			try {
				int sizeRan = Integer.parseInt(sizeRandom);
				if (sizeRan > 100 || sizeRan <= 0)
					JOptionPane.showMessageDialog(null, "Số lượng không hợp lệ! (>0 và <=100)");
				else {
					for (int i = 0; i < sizeRan; i++) {
						if (chkAllowNeg.isSelected())
							dfModel.addElement(new Random().nextInt(1000 - (-1000) + 1) + (-1000));
						else
							dfModel.addElement(new Random().nextInt(1000 - 1));
					}
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void validateInput() {
		try {
			int numA = Integer.parseInt(txtInput.getText());
			if (!chkAllowNeg.isSelected() && numA < 0) {
				JOptionPane.showMessageDialog(null, "Chỉ được nhập số dương");
				txtInput.selectAll();
				txtInput.requestFocus();
			} else {
				dfModel.addElement(numA);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Chỉ được nhập số");
			txtInput.setText("");
			txtInput.requestFocus();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub

	}

}
