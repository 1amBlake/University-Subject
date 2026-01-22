package demo_Chapter4;

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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Demo_1 extends JFrame implements ActionListener {
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JButton btnHuy;

	public Demo_1() {
		setTitle("Demo 1 - Thử Nghiệm Che Password");
		setSize(380, 210);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// panel tong
		JPanel p = new JPanel();
		p.setLayout(new BorderLayout());
		add(p);

		// title
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(JLabel.CENTER);
		Font fontDoDam = new Font("Arial", Font.BOLD, 30);
		lblLogin.setFont(fontDoDam);
		lblLogin.setForeground(Color.BLUE);
		p.add(lblLogin, BorderLayout.NORTH);

		// tendangnhap va mat khau
		JPanel pTKMK = new JPanel();
		pTKMK.setLayout(new GridLayout(2, 2, 3, 3));
		pTKMK.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

		JLabel lblTaiKhoan = new JLabel("Tài Khoản: ");
		JLabel lblMatKhau = new JLabel("Mật Khẩu: ");
		txtTaiKhoan = new JTextField(8);
		txtMatKhau = new JPasswordField(8);

		p.add(pTKMK, BorderLayout.CENTER);
		pTKMK.add(lblTaiKhoan);
		pTKMK.add(txtTaiKhoan);
		pTKMK.add(lblMatKhau);
		pTKMK.add(txtMatKhau);

		// dang nhap va huy
		JPanel pBut = new JPanel();
		pBut.setLayout(new FlowLayout());

		btnDangNhap = new JButton("Đăng Nhập");
		btnHuy = new JButton("Hủy");

		p.add(pBut, BorderLayout.SOUTH);
		pBut.add(btnDangNhap);
		pBut.add(btnHuy);

		// dang ky action
		btnDangNhap.addActionListener(this);
		btnHuy.addActionListener(this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Demo_1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnHuy))
			System.exit(0);
		else {
			char[] password = txtMatKhau.getPassword();
			String passString = new String(password);
			if (passString.equals("123"))
				JOptionPane.showMessageDialog(this, "Đăng nhập thành công!");
			else {
				JOptionPane.showMessageDialog(this, "Sai mật khẩu! Gợi Ý: 123");
				txtMatKhau.selectAll();
				txtMatKhau.requestFocus();
			}
		}
	}

}
