/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

/**
 *
 * @author Duong Dieu Phap
 */
public class Category {
    public int _id;
    public int _websiteID;
    public String _name;
    public String _url;
    
    public String _link;
    public String _title;
    public String _image;
    public String _date;
    public String _description;
    public String _nextpage;
    
    public Category()
    {
        this._id = 0;
        this._websiteID = 0;
        this._name = "";
        this._url = "";
        
        this._link = "";
        this._title = "";
        this._image = "";
        this._date = "";
        this._description = "";
        this._nextpage = "";
    }
}
