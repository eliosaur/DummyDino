import java.awt.*;

import java.awt.event.*;
import javax.swing.*;

public class MyPanel extends JPanel implements ActionListener {
	final int PANEL_WIDTH = 850;
	final int PANEL_HEIGHT = 450;
	Image dino;
	Image backgroundImage;
	Timer timer;

	int xVelocity = 5;
	int yVelocity = 1;
	int x = -20;
	int y = 105;
	public int i = 0;
	boolean jump = false;

	MyPanel() {
		this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setBackground(Color.white);
		dino = new ImageIcon("textures\\dino.png").getImage();
		backgroundImage = new ImageIcon("textures\\background.jpg").getImage();
		timer = new Timer(10, this);
		//timer.start();
	}

	public void paint(Graphics g) {

		super.paintComponent(g); // paint background. super.paint(g) ang initial ani

		Graphics2D g2D = (Graphics2D) g;

		g2D.drawImage(backgroundImage, 0, 0, null);
		g2D.drawImage(dino, x, y, null);
	}

	public void jump() {
		jump = true;
		System.out.println("Jumped! " + y);
		timer.start();
	}

	public void jumphandling() {
		if (jump) {
			// going up
			if(y >= -20) {
				yVelocity = -5; //-10 is the original
				y += yVelocity;
				System.out.println("Going up " + y);
			}
			else{
				jump = false;
				System.out.println("Done jumping " + y);
			}
		} else {
			// going down
			if(y <= 150){
				yVelocity = 15;
				y += yVelocity;
				System.out.println("Going down " + y);
			}else{
				System.out.println("On Ground");
				timer.stop();
			}
		}

		// TO ANIMATE (this is working)
		/* 
		if (y + yVelocity > y) {
			// going down
			yVelocity = 15;
		} else {
			// going up
			yVelocity = -10; //-10 original
		}

		if (y < -200 || y > 105) {
			yVelocity = yVelocity * -1;
			jump = false;
			// (PANEL_HEIGHT + 150)-enemy.getHeight(null) a basis for other things
		}

		y = y + yVelocity;
		*/
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		jumphandling();
		repaint();
		revalidate();
	}
}
