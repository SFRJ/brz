package components.rendering;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.PLAIN;
import static java.awt.Font.SANS_SERIF;

public class VisualizationBoard {

    private JPanel visualizationPanel;
    private static JLabel outputLabel;


    public VisualizationBoard() {
        visualizationPanel = new JPanel(new BorderLayout());
        initializeTextSettings();
    }

    public Component init() {
        return visualizationPanel;
    }

    private void initializeTextSettings() {
        outputLabel = new JLabel("" +
                "<html>" +
                "<span style='color: black;'>Re</span>" +
                "<span style='color: red;'>a</span>" +
                "<span style='color: black;'>dy</span>" +
                "</html>");
        outputLabel.setFont(new Font(SANS_SERIF, PLAIN, 40));
        outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
        visualizationPanel.add(outputLabel, BorderLayout.CENTER);
    }

    public static JLabel outputLabel() {
        return outputLabel;
    }
}
