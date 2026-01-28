package STT10_DoanMinhHuy_24700701_DemoLT_Week5;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Demo_1_JList extends JFrame implements ActionListener, ListSelectionListener {

	private DefaultListModel listmodelName;
	private JList listName;
	private JButton btnAdd;
	private JButton btnRename;
	private JButton btnDelete;
	private JTextField txtName;

	public Demo_1_JList() throws HeadlessException {
		setTitle("Demo 1 - JList");
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		listmodelName = new DefaultListModel();
		listName = new JList(listmodelName);
		JScrollPane sp = new JScrollPane(listName);
		p.add(sp, BorderLayout.CENTER);

		JPanel pEast = new JPanel();
		pEast.setLayout(new FlowLayout());
		pEast.setPreferredSize(new Dimension(310, 0));
		p.add(pEast, BorderLayout.EAST);

		JLabel lblName = new JLabel("Input Name");
		txtName = new JTextField(15);
		txtName.setToolTipText("Nhập tên của bạn!");
		btnAdd = new JButton("Add Name");
		btnAdd.setToolTipText("Thêm tên!");
		btnAdd.setPreferredSize(new Dimension(90, 30));
		btnRename = new JButton("Rename");
		btnRename.setPreferredSize(new Dimension(90, 30));
		btnRename.setToolTipText("Đổi tên!");
		btnDelete = new JButton("Delete Name");
		btnDelete.setPreferredSize(new Dimension(90, 30));
		btnDelete.setToolTipText("Xóa tên!");

		pEast.add(lblName);
		pEast.add(txtName);
		pEast.add(btnAdd);
		pEast.add(btnRename);
		pEast.add(btnDelete);

		btnAdd.addActionListener(this);
		btnRename.addActionListener(this);
		btnDelete.addActionListener(this);
		txtName.addActionListener(this);
		listName.addListSelectionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo_1_JList().setVisible(true);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (!e.getValueIsAdjusting()) {
			String selected = (String) listName.getSelectedValue();
			if (selected != null) {
				txtName.setText(selected);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnAdd)) {
			String name = txtName.getText().trim();
			if (name.isEmpty())
				JOptionPane.showMessageDialog(this, "Please input name!");
			else {
				listmodelName.addElement(name);
				txtName.setText("");
			}
		} else if (o.equals(btnRename)) {
			int index = listName.getSelectedIndex();
			if (index == -1) {
				JOptionPane.showMessageDialog(this, "Please select a name!");
				return;
			} else {
				String name = txtName.getText().trim();
				if (name.isEmpty())
					JOptionPane.showMessageDialog(this, "Please input name!");
				else
					listmodelName.setElementAt(txtName.getText(), listName.getSelectedIndex());
			}

		} else if (o.equals(btnDelete)) {
			int index = listName.getSelectedIndex();
			if (index == -1) {
				JOptionPane.showMessageDialog(this, "Please select a name!");
				return;
			} else
				listmodelName.removeElement(listName.getSelectedValue());
		}
	}

}
