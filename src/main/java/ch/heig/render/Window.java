/**
 * Autheur: Theo Bensaci | Date: 18:06 12.11.2025 | Description: Class use to manage the window
 * where the ame is rendered
 */
package ch.heig.render;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Window extends JFrame {
    public Window(String title) {
        super(title);

        // create a empty canvas
        /*
        gameCanvas = new GameRender(this.game);
        add(gameCanvas);
        */


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}