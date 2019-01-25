package ed.trabalho;

import ed.trabalho.resources.menu.JMenu;
import javax.swing.JFrame;

/**
 * Social Graph main entrypoint.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /**
         * Starts menu using Swing
         */
        JFrame menu = new JMenu();
        menu.setVisible(true);
    }
}
