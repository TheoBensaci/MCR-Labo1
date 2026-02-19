package ch.heig.render;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Window extends JFrame {
    private RenderCanvas _canvas;
    public Window(String title) {
        super(title);

        _canvas= new RenderCanvas();
        add(_canvas);

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

    public RenderCanvas getCanvas(){
        return _canvas;
    }
}