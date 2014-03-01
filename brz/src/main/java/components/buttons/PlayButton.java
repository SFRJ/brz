package components.buttons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static components.Text.text;
import static components.rendering.VisualizationBoard.outputLabel;

public class PlayButton implements ActionListener {

    private JButton button;
    private int delay;
    private SpeedSelectionTool speedSelectionTool;
    private String[] words;

    public PlayButton() {
        button = new JButton();
        prepareButtonGraphics();
    }

    public Component init() {
        return button;
    }

    public void prepareButtonGraphics() {
        button.setIcon(new ImageIcon("src/main/resources/play.png"));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //TODO
        updateDelay();
        words = text().split(" ");
        try {
            displayText(words);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private synchronized void displayText(final String[] words) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (this) {

                        String markup = "";
                        for (String word : words) {
                            if (text() != null) {
                                markup = getMarkup(word);
                                outputLabel().setText(markup);
                                try {
                                    wait(delay);
                                    if(word.contains(".") ||
                                            word.contains(",") ||
                                            word.contains(":") ||
                                            word.contains("...") ||
                                            word.contains(";")) {
                                        wait(350);
                                    }
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                }
            }
        });
        thread.start();
    }

    public void setWordDelay(SpeedSelectionTool speedSelectionTool) {
        this.speedSelectionTool = speedSelectionTool;
        switch (speedSelectionTool.getSpeedSelectionTool().getSelectedIndex()) {
            case 1:
                delay = 320;
                break;
            case 2:
                delay = 250;
                break;
            case 3:
                delay = 200;
                break;
            case 4:
                delay = 150;
                break;
            case 5:
                delay = 100;
                break;
        }
    }

    public void updateDelay() {
        switch (speedSelectionTool.getSpeedSelectionTool().getSelectedIndex()) {
            case 1:
                delay = 320;
                break;
            case 2:
                delay = 250;
                break;
            case 3:
                delay = 200;
                break;
            case 4:
                delay = 150;
                break;
            case 5:
                delay = 100;
                break;
        }
    }

    private String getMarkup(String word) {
        boolean wordLengthIs1 = word.length() == 1;
        boolean wordLengthIs2 = word.length() == 2;
        boolean wordLengthIs3 = word.length() == 3;
        boolean wordLengthIsGreaterThan3 = word.length() > 3;

        if (wordLengthIsGreaterThan3) {
            return "<html>" +
                    "<span style='color: black;'>" + word.substring(0, 2) + "</span>" +
                    "<span style='color: red;'>" + word.charAt(2) + "</span>" +
                    "<span style='color: black;'>" + word.substring(3) + "</span>" +
                    "</html>";
        } else if (wordLengthIs1) {
            return "<html><span style='color: red;'>" + word + "</span></html>";
        } else if (wordLengthIs2) {
            return "<html>" +
                    "<span style='color: red;'>" + word.charAt(0) + "</span>" +
                    "<span style='color: black;'>" + word.charAt(1) + "</span>" +
                    "</html>";
        } else if (wordLengthIs3) {
            return "<html>" +
                    "<span style='color: black;'>" + word.charAt(0) + "</span>" +
                    "<span style='color: red;'>" + word.charAt(1) + "</span>" +
                    "<span style='color: black;'>" + word.charAt(2) + "</span>" +
                    "</html>";
        }
        return "";
    }
}
