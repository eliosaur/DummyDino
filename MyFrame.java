import java.awt.*;

import javax.swing.*;

public class MyFrame extends JFrame {

	MyPanel panel;

	MyFrame() {
		MyKeyListener keyListener = new MyKeyListener();
		ImageIcon icon = new ImageIcon("textures\\icon.png");

		panel = new MyPanel();

		addKeyListener(keyListener);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(icon.getImage());
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
		this.setTitle("Dino Jump");
	}
}