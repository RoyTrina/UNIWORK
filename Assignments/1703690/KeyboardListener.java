package assignment2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardListener implements KeyListener {

    private Sudoku game; // game passed through to allow for game manipulation

    public KeyboardListener(Sudoku game) {
        this.game = game;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        displayInfo(e, "KEY TYPED: ");

    }

    private void displayInfo(KeyEvent e, String keyStatus){

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_0:
                System.out.println("0");
                break;
            case KeyEvent.VK_1:
                System.out.println("1");
                break;
            case KeyEvent.VK_2:
                System.out.println("2");
                break;
            case KeyEvent.VK_3:
                System.out.println("3");
                break;
            case KeyEvent.VK_4:
                System.out.println("4");
                break;
            case KeyEvent.VK_5:
                System.out.println("5");
                break;
            case KeyEvent.VK_6:
                System.out.println("6");
                break;
            case KeyEvent.VK_7:
                System.out.println("7");
                break;
            case KeyEvent.VK_8:
                System.out.println("8");
                break;
            case KeyEvent.VK_9:
                System.out.println("9");
            case KeyEvent.VK_SPACE:
                System.out.println("Spacebar");
                this.game.initialise();
//                this.game.repaint();
                this.game.revalidate(); // repaints node children, rather than node
                break;
            default:
                System.out.println("Other");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
