package demo_week3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class Demo_GUI_1 extends JFrame implements ActionListener {
	public Demo_GUI_1() {
		setTitle("This is my first JFrame");
		setSize(300, 200); // set size of frame
		setDefaultCloseOperation(EXIT_ON_CLOSE); // exit when click
		setLocale(null); // center off screen
		setResizable(false); // do not allow resized
		// other
	}

	public static void main(String[] args) throws Exception {
		new Demo_GUI_1().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
