/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

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
}
