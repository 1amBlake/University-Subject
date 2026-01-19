package demo_week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Demo_2_PanelandButton extends JFrame implements ActionListener {
	private JTextField txtUser;
	private JTextField txtPass;
	private JButton btnLogin;
	private JButton btnExit;

	public Demo_2_PanelandButton() {
		// phan1
		setTitle("Demo pannel");
		setSize(300, 150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		JPanel p = new JPanel(); // create Jpannel
		// set border of jpannel
		p.setBorder(BorderFactory.createTitledBorder("This is my panel"));
		this.add(p); // put panel to jframe

		// phan2
		JLabel lblUser = new JLabel("user name: ");
		JLabel lblPass = new JLabel("password: ");
		txtUser = new JTextField(15);
		txtPass = new JTextField(15);
		p.add(lblUser);
		p.add(txtUser);
		p.add(lblPass);
		p.add(txtPass);

		btnLogin = new JButton("login");
		btnExit = new JButton("exit");
		p.add(btnLogin);
		p.add(btnExit);

		// dk su kien
		btnExit.addActionListener(this);
		btnLogin.addActionListener(this);
	}

	public static void main(String[] args) throws Exception {
		new Demo_2_PanelandButton().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnExit))
			System.exit(0);
		else {
			String pass = txtPass.getText();
			if (pass.equals("123"))
				JOptionPane.showMessageDialog(this, "dung pass");
			else {
				JOptionPane.showMessageDialog(this, "sai pass");
				// txtPass.setText("");
				txtPass.selectAll();
				txtPass.requestFocus();
			}
		}
	}
}
