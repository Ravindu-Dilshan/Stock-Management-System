/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PKG2;

import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Manager extends UserData {

    @Override
    public void message() {
        JOptionPane.showMessageDialog(null, "Welcome You Have Full Access to the System");
    }
}
