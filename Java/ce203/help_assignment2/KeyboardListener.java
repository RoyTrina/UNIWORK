package help_assignment2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private final Game game; // game passed through to allow for game manipulation

    public KeyboardListener(Game game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //                this.game.repaint();
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP -> System.out.println("Up");
            case KeyEvent.VK_DOWN -> System.out.println("Down");
            case KeyEvent.VK_LEFT -> System.out.println("Left");
            case KeyEvent.VK_RIGHT -> System.out.println("Right");
            case KeyEvent.VK_SPACE -> {
                System.out.println("Spacebar");
                this.game.initialise();
                this.game.revalidate(); // repaints node children, rather than node
            }
            default -> System.out.println("Other");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
