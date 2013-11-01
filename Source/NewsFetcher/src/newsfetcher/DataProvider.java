/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.io.BufferedReader;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.*;

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
            String user, String pass) {
        
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
    
    
    public DataProvider(String _filename)
    {
        File f = new File(_filename);
        try {
            
            //Đọc tất cả nội dung của file config
            String strConnection = "";
            
            if(f.exists())
            {
                BufferedReader reader = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
                String line = null;                
                
                while((line = reader.readLine()) != null)
                {
                    strConnection = line;
                    break;
                }
                reader.close();
            }
            
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                con = DriverManager.getConnection(strConnection, "sa", "");
                
                _isConnected = true;
            } catch (ClassNotFoundException | SQLException ex) {
                _isConnected = false;
            }
            
        } catch (Exception ex) {
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
