package demo_Chapter4;

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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Demo_3 extends JFrame implements ActionListener, ItemListener {

	private JTextArea txaBoard;
	private JCheckBox chkBold;
	private JCheckBox chkItalic;
	private JRadioButton radLeft;
	private JRadioButton radRight;
	private JRadioButton radCenter;
	private JRadioButton radBottom;
	private JTextField txtResult;
	private JButton btnDone;

	public Demo_3() {
		setTitle("Demo 3 - Thử Nghiệm Chuyển Trái Phải Bằng Radio Button (Notepad Demo)");
		setSize(800, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

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
		pBar.setBackground(Color.BLUE);
		p.add(pBar, BorderLayout.NORTH);

		chkBold = new JCheckBox("Bold");
		chkItalic = new JCheckBox("Italic");
		// radio button can le trai phai tren duoi
		radLeft = new JRadioButton("Left");
		radRight = new JRadioButton("Right");
		radCenter = new JRadioButton("Center");

		pBar.add(chkBold);
		pBar.add(chkItalic);
		pBar.add(radLeft);
		pBar.add(radCenter);
		pBar.add(radRight);

		// group
		ButtonGroup horiGroup = new ButtonGroup();
		horiGroup.add(radLeft);
		horiGroup.add(radCenter);
		horiGroup.add(radRight);

		JPanel pBottom = new JPanel();
		pBottom.setLayout(new BorderLayout());
		pBottom.setPreferredSize(new Dimension(0, 120));
		p.add(pBottom, BorderLayout.SOUTH);

		txtResult = new JTextField();
		txtResult.setEditable(false);
		pBottom.add(txtResult, BorderLayout.CENTER);

		JPanel pLeft = new JPanel();
		pLeft.setLayout(new GridLayout(0, 1, 10, 3));
		p.add(pLeft, BorderLayout.WEST);

		btnDone = new JButton("Done");
		pLeft.add(btnDone);

		chkBold.addItemListener(this);
		chkItalic.addItemListener(this);
		radLeft.addActionListener(this);
		radRight.addActionListener(this);
		radCenter.addActionListener(this);
		btnDone.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo_3().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(radLeft))
			txtResult.setHorizontalAlignment(SwingConstants.LEFT);
		else if (o.equals(radRight))
			txtResult.setHorizontalAlignment(SwingConstants.RIGHT);
		else if (o.equals(radCenter))
			txtResult.setHorizontalAlignment(SwingConstants.CENTER);
		else if (o.equals(btnDone)) {
			String txtCopy = txaBoard.getText();
			txtResult.setText(txtCopy);
		}

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		Font fTextArea = txaBoard.getFont();
		Font fTextField = txtResult.getFont();
		if (e.getItem() == chkBold) { // kiem tra in dam, va lam in dam
			txaBoard.setFont(new Font(fTextArea.getName(), fTextArea.getStyle() ^ Font.BOLD, fTextArea.getSize()));
			txtResult.setFont(new Font(fTextField.getName(), fTextField.getStyle() ^ Font.BOLD, fTextField.getSize()));
		}
		if (e.getItem() == chkItalic) {
			txaBoard.setFont(new Font(fTextArea.getName(), fTextArea.getStyle() ^ Font.ITALIC, fTextArea.getSize()));
			txtResult
					.setFont(new Font(fTextField.getName(), fTextField.getStyle() ^ Font.ITALIC, fTextField.getSize()));
		}
		// neu khong dung '^'
		/*
		 * Font f = txaBoard.getFont(); if (e.getStateChange() == ItemEvent.SELECTED)
		 * //duoc chon txaBoard.setFont(new Font(f.getName(), Font.ITALIC,
		 * f.getSize())); else txaBoard.setFont(new Font(f.getName(), Font.PLAIN,
		 * f.getSize()));
		 */
	}
}
