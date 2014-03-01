package components.rendering;

import components.buttons.LoadButton;
import components.buttons.PauseButton;
import components.buttons.PlayButton;
import components.buttons.SpeedSelectionTool;

import javax.swing.*;
import java.awt.*;

public class CommandsBoard {

    private JPanel commandsPanel;
    private PlayButton playButton;
    private PauseButton pauseButton;
    private LoadButton loadButton;
    private SpeedSelectionTool speedSelectionTool;

    public CommandsBoard(PlayButton playButton, PauseButton pauseButton, LoadButton loadButton, SpeedSelectionTool speedSelectionTool) {
        this.playButton = playButton;
        this.playButton.setWordDelay(speedSelectionTool);
        this.pauseButton = pauseButton;
        this.loadButton = loadButton;
        this.speedSelectionTool = speedSelectionTool;
    }

    public JPanel init() {
        commandsPanel = new JPanel(new FlowLayout());
        commandsPanel.add(playButton.init());
        commandsPanel.add(pauseButton.init());
        commandsPanel.add(loadButton.init());
        commandsPanel.add(speedSelectionTool.init());
        return commandsPanel;
    }
}
