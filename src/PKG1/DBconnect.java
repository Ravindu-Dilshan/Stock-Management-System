/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PKG1;

import java.awt.HeadlessException;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Admin
 */
public class DBconnect {

    public static Connection con;
    public static Statement st;
    public static ResultSet rs;

    public static void connect() {
        String name = "jdbc:mysql://localhost/ioop_sp_db";
        String user = "root";
        String password = "";
        
        try {
            File file = new File(System.getProperty("user.dir") + "\\DBCONFIG.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document xmlDoc = (Document) builder.parse(file);
            XPath xpath = XPathFactory.newInstance().newXPath();

            Object res = xpath.evaluate("/CONFIG", xmlDoc, XPathConstants.NODESET);
            NodeList nlist = (NodeList) res;
            for (int i = 0; i < nlist.getLength(); i++) {
                Node node = nlist.item(i);
                name = "jdbc:mysql://"+getTextContent(node, "server")+"/"+getTextContent(node, "dbname")+"";
                user = getTextContent(node, "username");
                password = getTextContent(node, "password");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
              
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(name, user, password);
            System.out.println("Connected");
            st = con.createStatement();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
    static private String getTextContent(Node parentNode, String childName) {
        NodeList nlist = parentNode.getChildNodes();
        for (int i = 0; i < nlist.getLength(); i++) {
            Node n = nlist.item(i);
            String name = n.getNodeName();
            if (name != null && name.equals(childName)) {
                return n.getTextContent();
            }
        }
        return "";
    }

    public static ResultSet executeQ(String sql) {
        try {
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void updateQ(String sql, String msg) {
        try {
            int x = st.executeUpdate(sql);
            if (x == 1) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            if (ex.getErrorCode() == 1062) {
                JOptionPane.showMessageDialog(null, "ID Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getErrorCode() == 1452) {
                JOptionPane.showMessageDialog(null, "Customer ID doesn't Exists", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (ex.getErrorCode() == 1451) {
                JOptionPane.showMessageDialog(null, "Cannot delete ITEM IN USE", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data Entry Error", "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex.getMessage());
                System.out.println("" + ex.getErrorCode());
            }
        }
    }

    public static void updateQ(String sql) {
        try {
            int x = st.executeUpdate(sql);
            if (x == 1) {
                System.out.println("Hidden message");
            }
        } catch (SQLException | HeadlessException ex) {
            JOptionPane.showMessageDialog(null, "Error", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
        }
    }

    public static ResultSet executeQ(PreparedStatement pst) {
        try {
            rs = pst.executeQuery();
            return rs;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Entry Error", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
