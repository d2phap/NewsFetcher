/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

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
    
    
    
    
    
}
