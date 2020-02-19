/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PKG2;

/**
 *
 * @author Admin
 */
public class StockData {

    private String ProductID;
    private String ProductName;
    private double Price;
    private int AvQ;
    private String CatID;
    private String Name;

    public String getProductID() {
        return ProductID;
    }

    public void setProductID(String ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    public int getAvQ() {
        return AvQ;
    }

    public void setAvQ(int AvQ) {
        this.AvQ = AvQ;
    }

    public String getCatID() {
        return CatID;
    }

    public void setCatID(String CatID) {
        this.CatID = CatID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}
