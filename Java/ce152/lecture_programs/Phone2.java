package lectures_programs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Phone2 extends JFrame {
    public final int TEXT_AREA_SIZE = 13;
    public final JTextArea textArea = new JTextArea(1, TEXT_AREA_SIZE);

    public Phone2() {
        setTitle("Phone2");
        setLayout(new BorderLayout(5, 5));
        add(keypad(), BorderLayout.SOUTH);
        JButton owlImage = imageButton("data/greatOwl.png");
        add(owlImage, BorderLayout.NORTH);
        JPanel numberPanel = new JPanel();
        numberPanel.add(textArea);
        numberPanel.add(eraseButton());
        add(numberPanel, BorderLayout.CENTER);
    }

    public static JButton imageButton(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException ignored) {
        }
        assert image != null;
        JButton button = new JButton(new ImageIcon(image));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        return button;
    }

    public JButton eraseButton() {
        JButton eraseButton = imageButton("data/eraseToTheLeft.png");
        eraseButton.addActionListener(
                arg0 -> {
                    int len = textArea.getText().length();
                    if (len > 0)
                        textArea.replaceRange("", len - 1, len);
                });
        return eraseButton;
    }

    public JButton kbdButton(String symbol) {
        JButton jb = new JButton(symbol);
        jb.addActionListener(e -> {
            if (textArea.getText().length() < TEXT_AREA_SIZE) {
                JButton currentButton = (JButton) e.getSource();
                textArea.append(currentButton.getText());
            }
        });
        return jb;
    }

    public JPanel keypad() {
        JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(4, 3, 5, 5));
        for (int i = 1; i <= 9; i++)
            keypad.add(kbdButton("" + i));
        keypad.add(kbdButton("*"));
        keypad.add(kbdButton("0"));
        keypad.add(kbdButton("#"));
        return keypad;
    }

    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        phone.pack();
        phone.setVisible(true);
    }

}
