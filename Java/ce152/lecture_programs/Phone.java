package lectures_programs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Phone extends JFrame {
    public final int TEXT_AREA_SIZE = 13;
    public final JTextArea textArea = new JTextArea(1, TEXT_AREA_SIZE);

    public Phone() {
        setTitle("Phone");
        setLayout(new BorderLayout(5, 5));
        JButton owlImage = imageButton("data/greatOwl.png");
        add(owlImage, BorderLayout.NORTH);
        JPanel phoneNumberPanel = new JPanel();
        phoneNumberPanel.add(textArea);
        phoneNumberPanel.add(eraseButton());
        add(phoneNumberPanel, BorderLayout.CENTER);
        add(keypad(), BorderLayout.SOUTH);
    }

    public static JButton imageButton(String fileName) {
        Image image = null;
        try {
            image = ImageIO.read(new File(fileName));
        } catch (IOException e) {
        }
        JButton button = new JButton(new ImageIcon(image));
        button.setBorder(BorderFactory.createEmptyBorder());
        button.setContentAreaFilled(false);
        return button;
    }

    public JButton eraseButton() {
        JButton eraseButton = imageButton("data/eraseToTheLeft.png");
        eraseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int len = textArea.getText().length();
                if (len > 0)
                    textArea.replaceRange("", len - 1, len);
            }
        });
        return eraseButton;
    }

    public JButton kpdButton(final String symbol) {
        class Listener implements ActionListener {
            final String symbol;

            public Listener(String symbol) {
                this.symbol = symbol;
            }

            public void actionPerformed(ActionEvent e) {
                if (textArea.getText().length() < TEXT_AREA_SIZE) {
                    textArea.append(symbol);
                }
            }
        }
        JButton jb = new JButton(symbol);
        jb.addActionListener(new Listener(symbol));
        return jb;
    }

    public JPanel keypad() {
        JPanel keypad = new JPanel();
        keypad.setLayout(new GridLayout(4, 3, 5, 5));
        for (int i = 1; i <= 9; i++)
            keypad.add(kpdButton("" + i));
        keypad.add(kpdButton("*"));
        keypad.add(kpdButton("0"));
        keypad.add(kpdButton("#"));
        return keypad;
    }

    public static void main(String[] args) throws IOException {
        Phone phone = new Phone();
        phone.pack();
        phone.setVisible(true);
    }

    public static void NullPointerException(int q) {
        if (q < 0) {
            throw new NullPointerException("q = " + q);
        } else {
            System.out.println("All is fine.");
        }
    }
}
