package components.rendering;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

public class MainPanel {

    private JPanel globalPanel = new JPanel();

    public MainPanel(CommandsBoard commandsBoard, VisualizationBoard visualizationBoard) {
        globalPanel.setLayout(new BorderLayout());
        globalPanel.add(visualizationBoard.init(), NORTH);
        globalPanel.add(commandsBoard.init(), SOUTH);
    }

    public JPanel init() {
        return globalPanel;
    }
}
