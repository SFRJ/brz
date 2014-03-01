package components.rendering;

import javax.swing.*;

import java.awt.*;

import static java.awt.Toolkit.getDefaultToolkit;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MainWindow {

    //TODO : Make sure there is only one application instance running
    // http://www.rbgrn.net/content/43-java-single-application-instance
    private JFrame outerFrame;
    private final Dimension screenSize = getDefaultToolkit().getScreenSize();

    public MainWindow(MainPanel mainPanel) {
        outerFrame = new JFrame("Brz    version 1.0");
        if(!outerFrame.isShowing())
        initializeFrame(mainPanel);
    }


    private void initializeFrame(MainPanel mainPanel) {
        outerFrame.getContentPane().add(mainPanel.init());
        outerFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        centerInScreen();
        prepareSize();
        outerFrame.pack();
        outerFrame.setVisible(true);
        outerFrame.setResizable(false);
    }

    private void centerInScreen() {
        int locationX = (screenSize.width / 2 - outerFrame.getSize().width / 2)
                - (screenSize.width / 2 - outerFrame.getSize().width / 2)/2;
        int locationY = (screenSize.height / 2 - outerFrame.getSize().height / 2)
                - (screenSize.height / 2 - outerFrame.getSize().height / 2)/2;
        outerFrame.setLocation(locationX,locationY);
    }

    private void prepareSize() {
        int witdh = (int) (screenSize.width * 0.40);
        int height =(int) (screenSize.height * 0.20);
        outerFrame.setPreferredSize(new Dimension(witdh,height));
    }
}
