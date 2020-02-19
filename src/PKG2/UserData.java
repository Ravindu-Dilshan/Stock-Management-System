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
public class UserData {

    protected String username;
    protected String password;
    protected String userID;
    protected String AccessR;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getAccessR() {
        return AccessR;
    }

    public void setAccessR(String AccessR) {
        this.AccessR = AccessR;
    }

    protected void message() {
        JOptionPane.showMessageDialog(null, "Welcome");
    }
}
