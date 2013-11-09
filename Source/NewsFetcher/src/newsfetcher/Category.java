/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.sql.*;
import java.util.*;
/**
 *
 * @author Duong Dieu Phap
 */
public class Category {
    
    public int _id;
    public int _websiteID;
    public String _name;
    public String _url;
    public String _xpathLayout;
    
    public String _link;
    public String _title;
    public String _image;
    public String _date;
    public String _description;
    public String _nextpage;
    public String _xpathNextPage;
    
    public List<Content> _contents;
    
    public Category()
    {
        this._id = 0;
        this._websiteID = 0;
        this._name = "";
        this._url = "";
        this._xpathLayout = "";
        
        this._link = "";
        this._title = "";
        this._image = "";
        this._date = "";
        this._description = "";
        this._nextpage = "";
        this._xpathNextPage = "";
        this._contents = new ArrayList<>();
    }
    
    /**
     * Lấy chuyên mục
     * @param id
     * @return
     * @throws Exception 
     */
    public static Category getCategory(int id) throws Exception {
        Category cate = new Category();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Category WHERE id = " + id;
            ResultSet rs = dp.ExecuteQuery(sql);
            
            if (rs.next()) {
                cate._id = rs.getInt("id");
                cate._websiteID = rs.getInt("WebsiteID");
                cate._name = rs.getString("name");
                cate._url = rs.getString("url");
                cate._xpathLayout = rs.getString("xpathlayout");
                
                cate._link = rs.getString("link");
                cate._title = rs.getString("title");
                cate._image = rs.getString("image");
                cate._date = rs.getString("date");
                cate._description = rs.getString("description");
                cate._nextpage = rs.getString("nextpage");
                cate._xpathNextPage = rs.getString("xpathnextpage");
                
                cate._contents = Content.getListContent(id);
            }
            
        } catch (Exception ex) {
            throw ex;
        }
        return cate;
    }
    
    /**
     * Lấy danh sách chuyên mục
     * @return
     * @throws Exception 
     */
    public static List<Category> getListCategory() throws Exception {
        List<Category> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Category";
            ResultSet rs = dp.ExecuteQuery(sql);
            
            while(rs.next()) {
                Category cate = new Category();
                cate._id = rs.getInt("id");
                cate._websiteID = rs.getInt("WebsiteID");
                cate._name = rs.getString("name");
                cate._url = rs.getString("url");
                cate._xpathLayout = rs.getString("xpathlayout");
                
                cate._link = rs.getString("link");
                cate._title = rs.getString("title");
                cate._image = rs.getString("image");
                cate._date = rs.getString("date");
                cate._description = rs.getString("description");
                cate._nextpage = rs.getString("nextpage");
                cate._xpathNextPage = rs.getString("xpathnextpage");
                
                cate._contents = Content.getListContent(cate._id);
                ls.add(cate);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return ls;
    }
    
    /**
     * Lấy danh sách chuyên mục
     * @param websiteID
     * @return
     * @throws Exception 
     */
    public static List<Category> getListCategory(int websiteID) throws Exception {
        List<Category> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Category WHERE WebsiteID = " + websiteID;
            ResultSet rs = dp.ExecuteQuery(sql);
            
            while(rs.next()) {
                Category cate = new Category();
                cate._id = rs.getInt("id");
                cate._websiteID = rs.getInt("WebsiteID");
                cate._name = rs.getString("name");
                cate._url = rs.getString("url");
                cate._xpathLayout = rs.getString("xpathlayout");
                
                cate._link = rs.getString("link");
                cate._title = rs.getString("title");
                cate._image = rs.getString("image");
                cate._date = rs.getString("date");
                cate._description = rs.getString("description");
                cate._nextpage = rs.getString("nextpage");
                cate._xpathNextPage = rs.getString("xpathnextpage");
                
                cate._contents = Content.getListContent(cate._id);
                ls.add(cate);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return ls;
    }
    
    /**
     * Thêm chuyên mục
     * @param cate
     * @return
     * @throws Exception 
     */
    public static int insertCategory(Category cate) throws Exception {
        int id = -1;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "INSERT INTO Category("
                    + "WebsiteID, "
                    + "name, "
                    + "url, "
                    + "xpathlayout, "
                    + "link, "
                    + "title, "
                    + "image, "
                    + "date, "
                    + "description, "
                    + "nextpage, "
                    + "xpathnextpage) VALUES ("
                    + cate._websiteID  + ", "
                    + "N'" + cate._name + "',"
                    + "'" + cate._url + "',"
                    + "'" + cate._xpathLayout + "',"
                    + "'" + cate._link + "',"
                    + "'" + cate._title + "',"
                    + "'" + cate._image + "',"
                    + "'" + cate._date + "',"
                    + "'" + cate._description + "',"
                    + "'" + cate._nextpage + "',"
                    + "'" + cate._xpathNextPage + "')";
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
     * Cập nhật chuyên mục
     * @param cate
     * @return
     * @throws Exception 
     */
    public static boolean updateCategory(Category cate) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "UPDATE Category SET "
                    + "WebsiteID = " + cate._websiteID + ", "
                    + "name = N'" + cate._name + "', "
                    + "url = '" + cate._url + "', "
                    + "xpathlayout = '" + cate._xpathLayout + "', "
                    + "link = '" + cate._link + "', "
                    + "title = '" + cate._title + "', "
                    + "image = '" + cate._image + "', "
                    + "date = '" + cate._date + "', "
                    + "description = '" + cate._description + "', "
                    + "nextpage = '" + cate._nextpage + "', "
                    + "xpathnextpage = '" + cate._xpathNextPage + "'"
                    + "WHERE id = " + cate._id;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
    
    /**
     * Xoá chuyên mục
     * @param id
     * @return
     * @throws Exception 
     */
    public static boolean deleteCategory(int id) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            Content.deleteContentByCategoryId(id);
            
            sql = "DELETE FROM Category WHERE id = " + id;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
    
    /**
     * Xoá chuyên mục qua Website ID
     * @param WebsiteID
     * @return
     * @throws Exception 
     */
    public static boolean deleteCategoryByWebsiteId(int websiteId) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            List<Category> ls = Category.getListCategory(websiteId);
            
            for(int i = 0; i < ls.size(); i++) {
                int categoryId = ls.get(i)._id;
                Content.deleteContentByCategoryId(categoryId);
            }
            
            sql = "DELETE FROM Category WHERE WebsiteID = " + websiteId;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
}
