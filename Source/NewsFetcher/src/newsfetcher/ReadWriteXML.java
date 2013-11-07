/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
/**
 *
 * @author LEEYOOL
 */
public class ReadWriteXML {
    
    public ReadWriteXML() {
        
    }
    
    public static int ReadXML(File file) {
        
        SAXBuilder saxBuilder = new SAXBuilder();
        
        try {
            
            Document document = saxBuilder.build(file);
            
            //TODO Lấy node root
            // <_1241350_1241363_1241378_1241431>
            Element rootNode = document.getRootElement();
            
            //TODO Lấy nội dung website
            Website web = new Website();
            web._name = rootNode.getChildText("website");
            web._url = rootNode.getChildText("url");
            web._id = Website.insertWebsite(web);
            
            //TODO Lấy node <category>
            Element nodeCategory = rootNode.getChild("category");
            
            //TODO Lấy tất cả node <item>
            List<Element> categoryList = nodeCategory.getChildren("item");
            
            //TODO Lấy tất cả thông tin của item
            for (int i = 0; i < categoryList.size(); i++) {
                Element element = categoryList.get(i);
                
                Category cate = new Category();
                
                cate._name = element.getAttributeValue("name");
                cate._url = element.getAttributeValue("url");
                cate._link = element.getChildText("link");
                cate._title = element.getChildText("title");
                cate._image = element.getChildText("image");
                cate._date = element.getChildText("date");
                cate._description = element.getChildText("description");
                cate._nextpage = element.getChildText("nextpage");
                cate._websiteID = web._id;
                
                Category.insertCategory(cate);
            }
            
            return web._id;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
    }
    
    public static boolean WriteXML(int websiteID, String filePath) {
        boolean flag = false;
        try {
            Website web = Website.getWebsite(websiteID);
            
            //TODO Tao the root
            Element root = new Element("_1241350_1241363_1241378_1241431");
            Document document = new Document(root);
            
            //TODO Tao the website
            Element website = new Element("website");
            website.setText(web._name);
            
            document.getRootElement().addContent(website);
            
            //TODO Tao the url
            Element url = new Element("url");
            url.setText(web._url);
            
            document.getRootElement().addContent(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        return flag;
    }
}
