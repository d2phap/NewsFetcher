/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duong Dieu Phap
 */
public class Website {
    public int _id;
    public String _name;
    public String _url;
    public List<Category> _categories;
    
    public Website()
    {
        this._id = 0;
        this._name = "";
        this._url = "";
        this._categories = new ArrayList<>();
    }
    /*
     * Insert Website vào CSDL
     */
    public static int insertWebsite(Website website) throws Exception {
        int id = -1;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "INSERT INTO Website (name, url) VALUES (N'" + website._name + "', '" + website._url + "')";
            dp.ExecuteUpdate(sql);
            sql = "SELECT SCOPE_IDENTITY() AS id";
            ResultSet rs = dp.ExecuteQuery(sql);
            rs.next();
            id = rs.getInt("id");
            
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }
    /*
     * Cập nhật Website
     */
    public static boolean updateWebsite(Website website) throws Exception {
        boolean flag = false;
        
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "UPDATE Website SET "
                    + "name = N'" + website._name + ", "
                    + "url = '" + website._url + " WHERE "
                    + "id = " + website._id;
            
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch(Exception ex) {
            throw ex;
        }
        
        return flag;
    }
    
    /*
     * Xóa Website
     */
    public static boolean deleteWebsite(int id) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "DELETE FROM Website WHERE id = " + id;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
    
    /*
     * Lấy thông tin website
     */
    public static Website getWebsite(int id) throws Exception {
        Website web = new Website();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Website WHERE id = " + id;
            ResultSet rs = dp.ExecuteQuery(sql);
            if (rs.next()) {
                web._id = id;
                web._name = rs.getString("name");
                web._url = rs.getString("url");

                web._categories = Category.getListCategory(id);
            }
            
        } catch (Exception ex) {
            throw ex;
        }
        return web;
    }
    
    public static List<Website> getListWebsite() throws Exception {
        List<Website> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Website";
            ResultSet rs = dp.ExecuteQuery(sql);
            while (rs.next()) {
                Website web = new Website();
                web._id = rs.getInt("id");
                web._name = rs.getString("name");
                web._url = rs.getString("url");

                web._categories = Category.getListCategory(web._id);
                ls.add(web);
            }
        }catch (Exception ex) {
            throw ex;
        }
        return ls;
    }
}
