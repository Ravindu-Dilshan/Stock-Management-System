/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PKG2;

/**
 *
 * @author Admin
 */
public class SaleData {

    private String SaleID;
    private String date;
    private String time;
    private int qnt;
    private double tlt;

    public String getSaleID() {
        return SaleID;
    }

    public void setSaleID(String SaleID) {
        this.SaleID = SaleID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }

    public double getTlt() {
        return tlt;
    }

    public void setTlt(double tlt) {
        this.tlt = tlt;
    }
}
