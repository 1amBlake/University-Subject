package demo_Chapter5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Demo_2_JTable extends JFrame implements ActionListener, MouseListener {
	private JTextField txtHo;
	private JTextField txtTen;
	private JButton btnAdd;
	private JButton btnModify;
	private JButton btnDelete;
	private JButton btnExit;
	private DefaultTableModel tableModel;
	private JTable table;

	public Demo_2_JTable() {
		setTitle("Demo JTable");
		setSize(600, 600);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		JPanel pTop = new JPanel();
		pTop.setLayout(new BoxLayout(pTop, BoxLayout.Y_AXIS));
		p.add(pTop, BorderLayout.NORTH);

		JPanel pHo = new JPanel();
		pHo.setLayout(new BoxLayout(pHo, BoxLayout.X_AXIS));
		pTop.add(pHo);

		JLabel lblHo = new JLabel("Họ: ");
		txtHo = new JTextField(15);
		pHo.add(lblHo);
		pHo.add(txtHo);

		JPanel pTen = new JPanel();
		pTen.setLayout(new BoxLayout(pTen, BoxLayout.X_AXIS));
		pTop.add(pTen);

		JLabel lblTen = new JLabel("Tên: ");
		txtTen = new JTextField(15);
		pTen.add(lblTen);
		pTen.add(txtTen);

		JPanel pButton = new JPanel();
		pButton.setLayout(new FlowLayout());
		pTop.add(pButton);

		btnAdd = new JButton("Thêm");
		btnModify = new JButton("Sửa");
		btnDelete = new JButton("Xóa");
		btnExit = new JButton("Thoát");

		pButton.add(btnAdd);
		pButton.add(btnModify);
		pButton.add(btnDelete);
		pButton.add(btnExit);

		// phan moi
		String[] header = { "Họ", "Tên", "Ghi Chú" };
		// tao table model voi header và 0 dong
		tableModel = new DefaultTableModel(header, 0);
		table = new JTable(tableModel); // create table base on model
		table.setDefaultEditor(Object.class, null);
		JScrollPane sp = new JScrollPane(table);
		p.add(sp, BorderLayout.CENTER);
		// them mot dong vao table, thong qua model
		/*
		 * String []row = {"data_col_1", "data_col_2", "data_col3"};
		 * tableModel.addRow(row);
		 */

		btnAdd.addActionListener(this);
		btnModify.addActionListener(this);
		btnDelete.addActionListener(this);
		btnExit.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo_2_JTable().setVisible(true);
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		String textHo = txtHo.getText();
		String textTen = txtTen.getText();
		if (o.equals(btnExit))
			System.exit(0);
		else if (o.equals(btnAdd)) {
			if (textHo.equals("") || textHo.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Họ!");
				txtHo.requestFocus();
			} else if (textTen.equals("") || textTen.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập Tên");
				txtTen.requestFocus();
			} else {
				Object[] obj = new Object[2];
				obj[0] = textHo;
				obj[1] = textTen;
				tableModel.addRow(obj);
			}
		} else if (o.equals(btnModify)) {
			if (table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Chọn ô cần sửa");
			else {
				int row = table.getSelectedRow();
				txtHo.setText(tableModel.getValueAt(row, 0));
			}
		}
	}

}
