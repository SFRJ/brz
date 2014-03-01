import components.buttons.LoadButton;
import components.buttons.PauseButton;
import components.buttons.PlayButton;
import components.buttons.SpeedSelectionTool;
import components.rendering.CommandsBoard;
import components.rendering.MainPanel;
import components.rendering.MainWindow;
import components.rendering.VisualizationBoard;

public class Main {


    public static void main(String[] args) {
        CommandsBoard commandsBoard = new CommandsBoard(new PlayButton(), new PauseButton(),
                new LoadButton(), new SpeedSelectionTool());
        VisualizationBoard visualizationBoard = new VisualizationBoard();
        MainPanel mainPanel = new MainPanel(commandsBoard,visualizationBoard);
        MainWindow mainWindow = new MainWindow(mainPanel);
    }
}
