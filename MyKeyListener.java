import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener extends MyPanel implements KeyListener{

    @Override
    public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_SPACE && !jump){ 
            //jump == false to prevent 2nd jumping while in air
            i++;
            jump();
         }
    }

    @Override
    public void keyTyped(KeyEvent e) { 
    }

    @Override
    public void keyReleased(KeyEvent e) {     
    }
}