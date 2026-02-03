package week2_ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Bai1 extends JFrame implements ActionListener, MouseListener {
	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JRadioButton radGioiTinh;
	private JTextField txtSalary;
	private DefaultTableModel tableModel;
	private JTable table;
	private JButton btnFind;
	private JTextField txtFind;
	private JButton btnAdd;
	private JButton btnClear;
	private JButton btnDelete;
	private JButton btnSave;

	public Bai1() {
		setTitle("^-^");
		setSize(960, 800);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		JPanel pTop = new JPanel();
		pTop.setLayout(new BorderLayout());
		p.add(pTop, BorderLayout.NORTH);

		JPanel pTitle = new JPanel();
		pTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
		pTop.add(pTitle, BorderLayout.NORTH);

		JLabel lblTitile = new JLabel("THÔNG TIN NHÂN VIÊN");
		Font fTitle = lblTitile.getFont();
		lblTitile.setAlignmentX(CENTER_ALIGNMENT);
		lblTitile.setFont(new Font(fTitle.getName(), fTitle.BOLD, 30));
		lblTitile.setForeground(Color.BLUE);
		pTitle.add(lblTitile);

		JPanel pInputData = new JPanel();
		pInputData.setLayout(new BoxLayout(pInputData, BoxLayout.Y_AXIS));
		pTop.add(pInputData, BorderLayout.CENTER);

		JPanel pRow_1 = new JPanel(new FlowLayout());
		pInputData.add(pRow_1);

		JLabel lblMaNV = new JLabel("Mã Nhân Viên: ");
		txtMaNV = new JTextField(30);
		pRow_1.add(lblMaNV);
		pRow_1.add(txtMaNV);

		JPanel pRow_2 = new JPanel();
		pRow_2.setLayout(new BoxLayout(pRow_2, BoxLayout.X_AXIS));
		pInputData.add(pRow_2);

		JLabel lblHo = new JLabel("Họ: ");
		JLabel lblTen = new JLabel("Tên nhân viên: ");
		txtHo = new JTextField(15);
		txtTen = new JTextField(15);
		pRow_2.add(lblHo);
		pRow_2.add(txtHo);
		pRow_2.add(lblTen);
		pRow_2.add(txtTen);

		JPanel pRow_3 = new JPanel();
		pRow_3.setLayout(new BoxLayout(pRow_3, BoxLayout.X_AXIS));
		pInputData.add(pRow_3);

		JLabel lblTuoi = new JLabel("Tuổi: ");
		JLabel lblGioiTinh = new JLabel("Phái: ");
		txtTuoi = new JTextField(15);
		radGioiTinh = new JRadioButton("Nữ");
		pRow_3.add(lblTuoi);
		pRow_3.add(txtTuoi);
		pRow_3.add(lblGioiTinh);
		pRow_3.add(radGioiTinh);

		ButtonGroup sexGroup = new ButtonGroup();
		sexGroup.add(radGioiTinh);

		JPanel pRow_4 = new JPanel();
		pRow_4.setLayout(new BoxLayout(pRow_4, BoxLayout.X_AXIS));
		pInputData.add(pRow_4);

		JLabel lblSalary = new JLabel("Tiền lương: ");
		txtSalary = new JTextField(15);
		pRow_4.add(lblSalary);
		pRow_4.add(txtSalary);

		String[] header = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel);
		table.setDefaultEditor(Object.class, null);
		JScrollPane sp = new JScrollPane(table);
		sp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		p.add(sp, BorderLayout.CENTER);

		JPanel pBot = new JPanel();
		pBot.setLayout(new BoxLayout(pBot, BoxLayout.X_AXIS));
		p.add(pBot, BorderLayout.SOUTH);

		JPanel pFind = new JPanel();
		pFind.setLayout(new BoxLayout(pFind, BoxLayout.X_AXIS));
		pFind.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pBot.add(pFind);

		JLabel lblFind = new JLabel("Nhập mã số cần tìm: ");
		txtFind = new JTextField(15);
		btnFind = new JButton("Tìm");
		pFind.add(lblFind);
		pFind.add(txtFind);
		pFind.add(btnFind);

		JPanel pFeature = new JPanel();
		pFeature.setLayout(new BoxLayout(pFeature, BoxLayout.X_AXIS));
		pFeature.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pBot.add(pFeature);

		btnAdd = new JButton("Thêm");
		btnClear = new JButton("Xóa trắng");
		btnDelete = new JButton("Xóa");
		btnSave = new JButton("Lưu");
		pFeature.add(btnAdd);
		pFeature.add(btnClear);
		pFeature.add(btnDelete);
		pFeature.add(btnSave);

		table.addMouseListener(this);
		btnAdd.addActionListener(this);
		btnClear.addActionListener(this);
		btnDelete.addActionListener(this);
		btnFind.addActionListener(this);
		btnSave.addActionListener(this);
	}

	public static void main(String[] args) {
		new Bai1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnAdd)) {
			String maNV = txtMaNV.getText();
			String hoNV = txtHo.getText();
			String tenNV = txtTen.getText();
			int tuoiNV = Integer.parseInt(txtTuoi.getSelectedText());
			double luongNV = Double.parseDouble(txtSalary.getText());
			if 
			
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

}
