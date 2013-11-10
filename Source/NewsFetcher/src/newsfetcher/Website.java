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
    
    /**
     * Insert Website vào CSDL
     * @param website
     * @return
     * @throws Exception 
     */
    public static int insertWebsite(Website website) throws Exception {
        int id = -1;
        try {
            DataProvider dp = new DataProvider(".//config.xml");
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
    
    /**
     * Cập nhật Website
     * @param website
     * @return
     * @throws Exception 
     */
    public static boolean updateWebsite(Website website) throws Exception {
        boolean flag = false;
        
        try {
            DataProvider dp = new DataProvider(".//config.xml");
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
    
    /**
     * Xóa Website
     * @param id
     * @return
     * @throws Exception 
     */
    public static boolean deleteWebsite(int id) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            Category.deleteCategoryByWebsiteId(id);
            
            sql = "DELETE FROM Website WHERE id = " + id;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
    
    /**
     * Lấy thông tin website
     * @param id
     * @return
     * @throws Exception 
     */
    public static Website getWebsite(int id) throws Exception {
        Website web = new Website();
        try {
            DataProvider dp = new DataProvider(".//config.xml");
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
    
    /**
     * Lấy danh sách website
     * @return
     * @throws Exception 
     */
    public static List<Website> getListWebsite() throws Exception {
        List<Website> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider(".//config.xml");
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
