package components.buttons;

import javax.swing.*;
import java.awt.*;

public class PauseButton {

    private JButton button;

    public PauseButton() {
        button = new JButton();
        prepareButtonGraphics();
    }

    public Component init() {
        return button;
    }

    public void prepareButtonGraphics() {
        button.setIcon(new ImageIcon("src/main/resources/pause.png"));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }
}
