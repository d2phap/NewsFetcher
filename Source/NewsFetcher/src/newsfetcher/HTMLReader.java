/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Duong Dieu Phap
 */
public class HTMLReader {
    
    /**
     * Lấy nội dung HTML
     * @param url địa chỉ  liên kết
     * @return nội dùung HTML
     * @throws Exception 
     */
    public static String getHTMLContent(URL url) throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.toURI());
        HttpResponse response = client.execute(request);
        
        Reader reader = null;
        try {
            reader = new InputStreamReader(response.getEntity().getContent());

            StringBuilder sb = new StringBuilder();
            {
                int read;
                char[] cbuf = new char[1024];
                while ((read = reader.read(cbuf)) != -1) {
                    sb.append(cbuf, 0, read);
                }
            }

            return sb.toString();

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
    }
    
    
    
    
    public static String abc(URL url) throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.toURI());
        HttpResponse response = client.execute(request);
        
        Reader reader = null;
        try {
            //reader = new InputStreamReader(response.getEntity().getContent());

            
            try {

                XPathFactory xpf = XPathFactory.newInstance();
                XPath xPath = xpf.newXPath();
                
                InputSource doc = new InputSource(new InputStreamReader(response.getEntity().getContent()));
                
                String expression = "//*[@id=\"divChannelList\"]/ul/li[3]/h3/a";
                XPathExpression xpe = xPath.compile(expression);
                
                NodeList nl = (NodeList) xpe.evaluate(doc, XPathConstants.NODESET);
                xpe = xPath.compile("@href");
                
                for (int i = 0; i < nl.getLength(); i++) {
                    System.out.println(xpe.evaluate(nl.item(i), XPathConstants.STRING));
                }
                
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            
            return "";//sb.toString();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }
        return null;
    }
    
    
    
}
