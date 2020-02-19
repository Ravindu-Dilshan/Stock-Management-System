/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PKG2;

import java.awt.Desktop;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Common extends Exit {

    @Override
    public void exit() {
        int x = JOptionPane.showConfirmDialog(null, "Are you Sure", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (x == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public static void manual() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("manual\\manual.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: Cannot open the File");
            }
        }
    }

    public static void about() {
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("manual\\about.txt");
                Desktop.getDesktop().open(myFile);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error: Cannot open the File");
            }
        }
    }
}
