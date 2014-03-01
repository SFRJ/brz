package components.buttons;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.PLAIN;
import static java.awt.Font.SANS_SERIF;

public class SpeedSelectionTool {

    private JComboBox comboBox;

    public SpeedSelectionTool() {
        comboBox = new JComboBox();
        prepareGraphics();
    }

    public Component init() {
        return comboBox;
    }

    public void prepareGraphics() {
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement("Select speed...");
        comboBoxModel.addElement("250wpm");
        comboBoxModel.addElement("300wpm");
        comboBoxModel.addElement("350wpm");
        comboBoxModel.addElement("400wpm");
        comboBoxModel.addElement("500wpm");
        comboBox.setFont(new Font(SANS_SERIF, PLAIN, 15));
        comboBox.setModel(comboBoxModel);
    }

    public JComboBox getSpeedSelectionTool() {
        return comboBox;
    }

}
