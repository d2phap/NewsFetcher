/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.sql.ResultSet;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Duong Dieu Phap
 */
public class Content {
    
    public int _id;
    public int _categoryID;
    
    public String _link;
    public String _title;
    public String _image;
    public String _date;
    public String _description;
    public String _nextpage;
    
    public Content()
    {
        this._id = 0;
        this._categoryID = 0;
        
        this._link = "";
        this._title = "";
        this._image = "";
        this._date = "";
        this._description = "";
        this._nextpage = "";
    }
    
    public static Content getContent(int id) throws Exception {
        Content con = new Content();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Content WHERE id = " + id;
            ResultSet rs = dp.ExecuteQuery(sql);
            if (!rs.next()) {
                con._id = rs.getInt("id");
                con._categoryID = rs.getInt("categoryID");
                con._link = rs.getString("link");
                con._title = rs.getString("title");
                con._image = rs.getString("image");
                con._date = rs.getString("date");
                con._description = rs.getString("description");
                con._nextpage = rs.getString("nextpage");
            }
            
        } catch (Exception ex) {
            throw ex;
        }
        return con;
    }
    
    public static List<Content> getListContent() throws Exception {
        List<Content> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Content";
            ResultSet rs = dp.ExecuteQuery(sql);
            
            while(!rs.next()) {
                Content con = new Content();
                con._id = rs.getInt("id");
                con._categoryID = rs.getInt("categoryID");
                con._link = rs.getString("link");
                con._title = rs.getString("title");
                con._image = rs.getString("image");
                con._date = rs.getString("date");
                con._description = rs.getString("description");
                con._nextpage = rs.getString("nextpage");
                ls.add(con);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return ls;
    }
    
    public static List<Content> getListContent(int categoryID) throws Exception {
        List<Content> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "SELECT * FROM Content WHERE categoryID = " + categoryID;
            ResultSet rs = dp.ExecuteQuery(sql);
            
            while(!rs.next()) {
                Content con = new Content();
                con._id = rs.getInt("id");
                con._categoryID = rs.getInt("categoryID");
                con._link = rs.getString("link");
                con._title = rs.getString("title");
                con._image = rs.getString("image");
                con._date = rs.getString("date");
                con._description = rs.getString("description");
                con._nextpage = rs.getString("nextpage");
                ls.add(con);
            }
        } catch (Exception ex) {
            throw ex;
        }
        return ls;
    }
    
    public static int insertContent (Content con) throws Exception {
        int id = -1;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "INSERT INTO Content ("
                    + "categoryID, "
                    + "link, "
                    + "title, "
                    + "image, "
                    + "date, "
                    + "description, "
                    + "nextpage) VALUES ("
                    + con._categoryID + ", "
                    + "'" + con._link + "', "
                    + "N'" + con._title + "', "
                    + "'" + con._image + "', "
                    + "'" + con._date + "', "
                    + "N'" + con._description + "', "
                    + "'" + con._nextpage + "') SELECT SCOPE_IDENTITY() AS id;";
            
            ResultSet rs = dp.ExecuteQuery(sql);
            rs.next();
            id = rs.getInt("id");
            
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }
    
    public static boolean updateContent(Content con) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "UPDATE Content SET "
                    + "category = " + con._categoryID + ", "
                    + "link = '" + con._link + "', "
                    + "title = 'N" + con._title + "', "
                    + "image = '" + con._image + "', "
                    + "date = '" + con._date + "', "
                    + "description = 'N" + con._description + "', "
                    + "nextpage = '" + con._nextpage + "' WHERE "
                    + "id = " + con._id;
            dp.ExecuteQuery(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
    
    public static boolean deleteContent(int id) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider("localhost", "dbNewsFetcher", 1433, true, "sa", "");
            String sql = "";
            
            sql = "DELETE FROM Content WHERE id = " + id;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
}
