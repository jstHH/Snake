package jst.ascii_test;

import asciiPanel.AsciiPanel;

import javax.swing.*;
import java.awt.*;

public class AsciiTest extends JFrame {

    public AsciiTest(String title) throws HeadlessException {
        super(title);

        AsciiPanel myPanel = new AsciiPanel(80,80);
        add(myPanel);

        myPanel.write("Test", 40, 40);

        setVisible(true);
        pack();
    }
}
