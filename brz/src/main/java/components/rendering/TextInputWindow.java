package components.rendering;

import components.Text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Toolkit.getDefaultToolkit;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class TextInputWindow implements ActionListener{

    private final Dimension screenSize = getDefaultToolkit().getScreenSize();
    private JFrame frame;
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton submitButton;
    private static Text text = new Text();


    public JButton openTextInputWindow() {
       frame = new JFrame ();
       frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
       frame.setLayout(new BorderLayout());
       centerInScreen();
       prepareSize();
       setComponents();
       frame.setResizable(false);
       frame.pack();
       frame.setVisible (true);
       frame.setAlwaysOnTop(true);
       return submitButton;
   }

    private void setComponents() {
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        JPanel southPanel = new JPanel();
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        southPanel.add(submitButton);
        frame.getContentPane().add(southPanel, BorderLayout.SOUTH);
    }

    private void centerInScreen() {
        int locationX = (screenSize.width / 2 - frame.getSize().width / 2)
                - (screenSize.width / 2 - frame.getSize().width / 2)/2;
        int locationY = (screenSize.height / 2 - frame.getSize().height / 2)
                - (screenSize.height / 2 - frame.getSize().height / 2)/2;
        frame.setLocation(locationX,locationY);
    }

    private void prepareSize() {
        int witdh = (int) (screenSize.width * 0.50);
        int height =(int) (screenSize.height * 0.50);
        frame.setPreferredSize(new Dimension(witdh,height));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        text.setContent(textArea.getText());
        frame.dispose();
    }
}
