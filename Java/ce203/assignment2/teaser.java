package assignment2;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class teaser {
    private JComponent ui = null;

    teaser() {
        initUI();
    }

    public void initUI() {
        if (ui != null) return;

        ui = new JPanel(new BorderLayout(4, 4));
        ui.setBorder(new TitledBorder("BorderLayout"));

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);
        cards.setBorder(new TitledBorder("CardLayout"));
        ui.add(cards);

        JPanel lineStart = new JPanel(new GridBagLayout());
        lineStart.setBorder(new TitledBorder("GridBagLayout"));
        // will appear on the left, in an LTR text orientation locale
        ui.add(lineStart, BorderLayout.LINE_START);

        JPanel buttonsCentered = new JPanel(new GridLayout(0, 1, 10, 10));
        buttonsCentered.setBorder(new TitledBorder("GridLayout"));
        // as single component added w/no constraint, will be centered
        lineStart.add(buttonsCentered);
        for (int ii = 1; ii < 5; ii++) {
            JButton b = new JButton("Button " + ii);
            buttonsCentered.add(b);
        }
    }

    public JComponent getUI() {
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = () -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception useDefault) {
                useDefault.printStackTrace();
            }
            teaser o = new teaser();

            JFrame f = new JFrame(o.getClass().getSimpleName());
            f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            f.setLocationByPlatform(true);

            f.setContentPane(o.getUI());
            f.pack();
            f.setMinimumSize(f.getSize());

            f.setVisible(true);
        };
        SwingUtilities.invokeLater(r);
    }
}
