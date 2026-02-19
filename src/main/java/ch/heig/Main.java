package ch.heig;

import ch.heig.render.Window;

public class Main {
    public static void main(String[] args) {
        Window win = new Window("Bouncers");



        // shape update
        while(win.isVisible()){

            // update shape
            

            // repaint
            win.repaint();
        }
    }
}