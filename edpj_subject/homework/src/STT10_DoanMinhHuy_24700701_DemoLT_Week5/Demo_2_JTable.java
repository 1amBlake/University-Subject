package STT10_DoanMinhHuy_24700701_DemoLT_Week5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
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
	private JTextField txtGhiChu;

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
		lblHo.setPreferredSize(new Dimension(50, 25));
		lblHo.setAlignmentX(CENTER_ALIGNMENT);
		txtHo = new JTextField(15);
		txtHo.setMaximumSize(new Dimension(200, 25));
		pHo.add(lblHo);
		pHo.add(Box.createHorizontalStrut(47));
		pHo.add(txtHo);

		JPanel pTen = new JPanel();
		pTen.setLayout(new BoxLayout(pTen, BoxLayout.X_AXIS));
		pTop.add(pTen);

		JLabel lblTen = new JLabel("Tên: ");
		lblTen.setAlignmentX(CENTER_ALIGNMENT);
		lblTen.setPreferredSize(new Dimension(50, 25));
		txtTen = new JTextField(15);
		txtTen.setMaximumSize(new Dimension(200, 25));
		pTen.add(lblTen);
		pTen.add(Box.createHorizontalStrut(40));
		pTen.add(txtTen);

		JPanel pNote = new JPanel();
		pNote.setLayout(new BoxLayout(pNote, BoxLayout.X_AXIS));
		pTop.add(pNote);

		JLabel lblGhiChu = new JLabel("Ghi Chú: ");
		lblGhiChu.setPreferredSize(new Dimension(50, 25));
		lblGhiChu.setAlignmentX(CENTER_ALIGNMENT);
		txtGhiChu = new JTextField(30);
		txtGhiChu.setMaximumSize(new Dimension(200, 25));
		pNote.add(lblGhiChu);
		pNote.add(Box.createHorizontalStrut(20));
		pNote.add(txtGhiChu);

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
		table.addMouseListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo_2_JTable().setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = table.getSelectedRow();
		if (row >= 0) {
			txtHo.setText(table.getValueAt(row, 0).toString());
			txtTen.setText(table.getValueAt(row, 1).toString());
			txtGhiChu.setText(table.getValueAt(row, 2).toString());
		}

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
		String textNote = txtGhiChu.getText();
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
				Object[] obj = new Object[3];
				obj[0] = textHo;
				obj[1] = textTen;
				obj[2] = textNote;
				tableModel.addRow(obj);
			}
		} else if (o.equals(btnModify)) {
			if (table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
			else {
				int row = table.getSelectedRow();
				tableModel.setValueAt(textHo, row, 0);
				tableModel.setValueAt(textTen, row, 1);
				if (textNote.equals("") || textNote.isEmpty())
					tableModel.setValueAt("", row, 2);
				else
					tableModel.setValueAt(textNote, row, 2);

			}
		} else if (o.equals(btnDelete)) {
			if (table.getSelectedRow() == -1)
				JOptionPane.showMessageDialog(this, "Chọn dòng cần xóa");
			else {
				if (JOptionPane.showConfirmDialog(this, "Bạn có chắc xóa dòng này?", "Cảnh báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					tableModel.removeRow(table.getSelectedRow());
			}
		}
	}

}
