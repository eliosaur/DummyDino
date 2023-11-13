import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class justanemptybasis extends JPanel {
    //gpt basis oke?
    private int y = 150;
    private int yVelocity = 0;
    private boolean jump = false;
    private Timer timer;

    public justanemptybasis() {
        timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleJump();
                repaint();
            }
        });
        timer.setInitialDelay(0); // Set initial delay to 0 for immediate start
    }

    private void handleJump() {
        if (jump) {
            // going up
            System.out.println("Jumping " + y);
            if (y >= -20) {
                yVelocity = -10;
                y += yVelocity;
                System.out.println("Going up " + y);
            } else {
                jump = false;
                System.out.println("Done jumping " + y);
                handleJump();
            }
        } else {
            // going down
            if (y <= 150) {
                yVelocity = 15;
                y += yVelocity;
                System.out.println("Going down " + y);
            } else {
                System.out.println("On Ground");
                timer.stop(); // Stop the timer when the animation is done
            }
        }
    }

    public void startAnimation() {
        timer.start();
    }

    // Other methods...

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Paint your component using the updated y value
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Your Frame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            justanemptybasis component = new justanemptybasis();
            frame.getContentPane().add(component);
            frame.setSize(400, 400);
            frame.setVisible(true);
            component.startAnimation();
        });
    }
}
