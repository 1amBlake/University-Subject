package demo_Chapter4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Demo_2 extends JFrame implements ActionListener, ItemListener {

	private JTextArea txaBoard;
	private JCheckBox chkBold;
	private JCheckBox chkItalic;

	public Demo_2() {
		setTitle("Demo 2 - Mô Phỏng Notepad Đơn Giản (Tính Năng In Đậm In Nghiên Bằng Checkbox");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setResizable(false);
		setLocationRelativeTo(null);

		// khai bao panel chinh
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		// khai bao txtarea
		txaBoard = new JTextArea(8, 10);
		txaBoard.setLineWrap(true); // tu xuong dong, tham khao AI
		txaBoard.setWrapStyleWord(true); // xuong dong giu nguyen tu, tham khao AI
		p.add(txaBoard, BorderLayout.CENTER);

		// khai bao checkbox
		JPanel pBar = new JPanel();
		pBar.setLayout(new FlowLayout());
		p.add(pBar, BorderLayout.NORTH);

		chkBold = new JCheckBox("Bold");
		chkItalic = new JCheckBox("Italic");
		pBar.add(chkBold);
		pBar.add(chkItalic);

		chkBold.addItemListener(this);
		chkItalic.addItemListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo_2().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Font f = txaBoard.getFont();
		if (e.getItem() == chkBold) // kiem tra in dam, va lam in dam
			txaBoard.setFont(new Font(f.getName(), f.getStyle() ^ Font.BOLD, f.getSize()));
		if (e.getItem() == chkItalic)
			txaBoard.setFont(new Font(f.getName(), f.getStyle() ^ Font.ITALIC, f.getSize()));

	}

}
