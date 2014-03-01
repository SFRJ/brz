package components.buttons;

import components.Text;
import components.rendering.TextInputWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoadButton implements ActionListener {

    private JButton button;

    //Pass the JLabel that will be modified
    public LoadButton() {
        button = new JButton();
        prepareButtonGraphics();
        button.addActionListener(this);
    }

    public Component init() {
        return button;
    }

    public void prepareButtonGraphics() {
        button.setIcon(new ImageIcon("src/main/resources/load.png"));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        TextInputWindow textInputWindow = new TextInputWindow();
        textInputWindow.openTextInputWindow();
    }
}
