package co.edu.unicolombo.s3.poo.inventory.library.Main;

import co.edu.unicolombo.s3.poo.inventory.library.Guis.MainView;
import javax.swing.*;

/**
 *
 * @author Juan
 */
public class Main {

    private final MainView mainView;

    public Main() {
        this.mainView = new MainView();
        mainView.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainView.setVisible(true); 
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Main();
            }
        });
    }
}
