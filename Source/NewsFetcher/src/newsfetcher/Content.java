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
    
    public static int ROW_PER_PAGE = 20;
    
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
    
    /**
     * Lấy bài viết
     * @param id
     * @return
     * @throws Exception 
     */
    public static Content getContent(int id) throws Exception {
        Content con = new Content();
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            sql = "SELECT * FROM Content WHERE id = " + id;
            ResultSet rs = dp.ExecuteQuery(sql);
            if (rs.next()) {
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
    
    public static int getCountOfContentByCategoryId(int categoryID) throws Exception {
        int count = 0;
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            sql = "SELECT COUNT(*) AS count FROM Content WHERE categoryID = " + categoryID;
            ResultSet rs = dp.ExecuteQuery(sql);
            if (rs.next()) {
                count = rs.getInt("count");
            }
            
        } catch (Exception ex) {
            throw ex;
        }
        return count;
    }
    
    /**
     * Lấy danh sách bài viết
     * @return
     * @throws Exception 
     */
    public static List<Content> getListContent() throws Exception {
        List<Content> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            sql = "SELECT * FROM Content";
            ResultSet rs = dp.ExecuteQuery(sql);
            
            while(rs.next()) {
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
    
    /**
     * Lấy danh sách bài viết
     * @param categoryID
     * @return
     * @throws Exception 
     */
    public static List<Content> getListContent(int categoryID) throws Exception {
        List<Content> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            sql = "SELECT * FROM Content WHERE categoryID = " + categoryID;
            ResultSet rs = dp.ExecuteQuery(sql);
            
            while(rs.next()) {
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
    
    /**
     * 
     * @param categoryID
     * @param page
     * @return
     * @throws Exception 
     */
    public static List<Content> getListContent(int categoryID, int page) throws Exception {
        List<Content> ls = new ArrayList<>();
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            int count = Content.getCountOfContentByCategoryId(categoryID);
            int start = ROW_PER_PAGE * (page - 1);
            
            sql = "SELECT TOP(" + ROW_PER_PAGE + ") * " +
                  "FROM  " +
                  "(" +
                  "SELECT * , ROW_NUMBER() OVER (ORDER BY id DESC) as num " +
                  "FROM Content " + 
                  "WHERE categoryID = " + categoryID +
                  ") AS a " +
                  "WHERE num > " + start;
            ResultSet rs = dp.ExecuteQuery(sql);
            
            while(rs.next()) {
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
    
    
    /**
     * Thêm bài viết
     * @param con
     * @return
     * @throws Exception 
     */
    public static int insertContent (Content con) throws Exception {
        int id = -1;
        try {
            DataProvider dp = new DataProvider(".//config.xml");
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
                    + "'" + con._nextpage + "')";
            
            dp.ExecuteUpdate(sql);
            //rs.next();
            //id = rs.getInt("id");
            
        } catch (Exception ex) {
            throw ex;
        }
        return id;
    }
    
    /**
     * Cập nhật bài viết
     * @param con
     * @return
     * @throws Exception 
     */
    public static boolean updateContent(Content con) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider(".//config.xml");
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
    
    /**
     * Xoá bài viết
     * @param id
     * @return
     * @throws Exception 
     */
    public static boolean deleteContent(int id) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            sql = "DELETE FROM Content WHERE id = " + id;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
    
    /**
     * Xoá bài viết trên CategoryID
     * @param categoryId
     * @return
     * @throws Exception 
     */
    public static boolean deleteContentByCategoryId(int categoryId) throws Exception {
        boolean flag = false;
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            sql = "DELETE FROM Content WHERE categoryID = " + categoryId;
            dp.ExecuteUpdate(sql);
            flag = true;
        } catch (Exception ex) {
            throw ex;
        }
        return flag;
    }
    
    /**
     * Kiểm tra bài viết có tồn tại tỏng CSDL ko?
     * @param url link của bài viết
     * @param catID mã chuyên mục
     * @param webID mã trang web
     * @return 
     */
    public static boolean isExisted(String url, int catID, int webID) {
        
        try {
            DataProvider dp = new DataProvider(".//config.xml");
            String sql = "";
            
            sql = "SELECT * " +
                "FROM Content con, Category ca " +
                "WHERE con.categoryID = ca.id AND " +
                "	con.categoryID = " + catID + " AND " +
                "	ca.WebsiteID = " + webID + " AND " +
                "	con.link = N'" + url + "' ";
            
            
            ResultSet rs = dp.ExecuteQuery(sql);
            
            if (rs.next()) {
                return true;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return false;
    }
}
