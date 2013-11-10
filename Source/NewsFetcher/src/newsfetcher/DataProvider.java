/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.*;
import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 *
 * @author Duong Dieu Phap
 */
public class DataProvider {
    
    private Connection con = null;
    private boolean _isConnected = false;
    
    public boolean isConnected()
    {
        return  _isConnected;
    }
    
    public DataProvider(String tenServer, String tenCSDL, int port, boolean isIntegratedSecurity, 
            String user, String pass, String k) {
        
        SQLServerDataSource ds = new SQLServerDataSource();
        ds.setIntegratedSecurity(isIntegratedSecurity);
        ds.setServerName(tenServer);
        ds.setPortNumber(port);
        ds.setDatabaseName(tenCSDL);
        ds.setUser(user);
        ds.setPassword(pass);
        
        try {
            con = ds.getConnection();
            String s = con.toString();
            
            _isConnected = true;
        } catch (SQLServerException ex) {
            _isConnected = false;
        }
    }
    
    /**
     * Kết nối CSDL bằng tập tin config.xml
     * @param _filename 
     */
    public DataProvider(String _filename)
    {
        SAXBuilder saxBuilder = new SAXBuilder();

        try {

            Document document = saxBuilder.build(new File(_filename));

            //TODO Lấy node root
            // <_1241350_1241363_1241378_1241431>
            Element rootNode = document.getRootElement();

            //TODO Lấy nội dung connect string <con>
            String strConnection = rootNode.getChildText("con");
            
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(strConnection, "sa", "");
                
                _isConnected = true;
            } catch (ClassNotFoundException | SQLException ex) {
                _isConnected = false;
            }
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            _isConnected = false;
            
        }
    }

    public Connection GetConnection() {
        return con;
    }

    public void Close() throws Exception {
        con.close();
    }

    public ResultSet ExecuteQuery(String sql) throws SQLException {
        Statement s = con.createStatement();
        return s.executeQuery(sql);
    }

    public int ExecuteUpdate(String sql) throws SQLException {
        Statement s = con.createStatement();
        return s.executeUpdate(sql);
    }
}
