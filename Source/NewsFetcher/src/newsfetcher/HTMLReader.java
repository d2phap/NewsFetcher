/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package newsfetcher;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.*;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.htmlcleaner.*;
import org.w3c.dom.*;
import org.w3c.dom.NodeList;

/**
 *
 * @author Duong Dieu Phap
 */
public class HTMLReader {

    private org.w3c.dom.Document _document;
    private String _nextPageLink = "";

    /**
     * Lấy đối tượng document
     *
     * @return
     */
    public Document getDocument() {
        return _document;
    }

    /**
     * Gán đối tượng document
     *
     * @param doc
     */
    public void setDocument(Document doc) {
        _document = doc;
    }
    
    /**
     * Tạo tài liệu doc từ đường dẫn url
     * @param url
     * @throws IOException
     * @throws ParserConfigurationException 
     */
    public void setDocument(URL url) throws IOException, ParserConfigurationException
    {
        TagNode tagNode = new HtmlCleaner().clean(url);
        _document = new DomSerializer(new CleanerProperties()).createDOM(tagNode);
    }

    /**
     * Khởi tạo đối tượng HTMLReader
     *
     * @param url địa chỉ của trang tin tức
     * @throws IOException
     * @throws ParserConfigurationException
     */
    public HTMLReader(URL url) throws IOException, ParserConfigurationException {
        setDocument(url);
    }

    /**
     * Khởi tạo đối tượng HTMLReader
     *
     * @param doc đối tượng document
     */
    public HTMLReader(Document doc) {
        _document = doc;
    }

    
    /**
     * Lấy nội dung HTML
     *
     * @param url địa chỉ liên kết
     * @return nội dung HTML
     * @throws Exception
     */
    public static String getHTMLContent(URL url) throws Exception {

        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url.toURI());
        HttpResponse response = client.execute(request);

        Reader reader = null;
        StringBuilder sb = new StringBuilder();

        try {
            reader = new InputStreamReader(response.getEntity().getContent());

            int read;
            char[] cbuf = new char[1024];

            while ((read = reader.read(cbuf)) != -1) {
                sb.append(cbuf, 0, read);
            }

        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                }
            }
        }

        return sb.toString();
    }

    
    /**
     * Lấy nội dung của tin tức
     *
     * @param cat loại chuyên mục
     * @return danh sách bài viết
     */
    public List<Content> getTextContent(Category cat) {
        return getTextContent(_document, cat);
    }

    
    /**
     * Lấy nội dung của tin tức
     *
     * @param doc tài liệu HTML document
     * @param cat loại chuyên mục
     * @return danh sách bài viết
     * @throws Exception
     */
    public List<Content> getTextContent(org.w3c.dom.Document doc, Category cat) {

        List<Content> ds = new ArrayList<>();
        Category catTemp = new Category();

        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        //Danh sach xpath
        NodeList nodeList;

        //XPath chung cua bai viet
        String expression = cat._xpathLayout;

        //Loc ra xpath cua tung thuoc tinh
        catTemp._link = cat._link.substring(expression.length());
        catTemp._link = catTemp._link.substring(catTemp._link.indexOf("/"));

        catTemp._image = cat._image.substring(expression.length());
        catTemp._image = catTemp._image.substring(catTemp._image.indexOf("/"));

        catTemp._title = cat._title.substring(expression.length());
        catTemp._title = catTemp._title.substring(catTemp._title.indexOf("/"));

        catTemp._date = cat._date.substring(expression.length());
        catTemp._date = catTemp._date.substring(catTemp._date.indexOf("/"));

        catTemp._description = cat._description.substring(expression.length());
        catTemp._description = catTemp._description.substring(catTemp._description.indexOf("/"));


        try {
            //Lay danh sach bai viet
            nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            //Loc lay tag html cuoi cung
            expression = expression.substring(expression.lastIndexOf("/"));
            expression = "/newRoot" + expression;

            for (int i = 0; i < nodeList.getLength(); i++) {

                try {
                    Content co = new Content();

                    //Tao document XML moi
                    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                    dbf.setValidating(false);
                    DocumentBuilder db = dbf.newDocumentBuilder();

                    //tao file XML moi, node goc la <newRoot>
                    Document docNew = db.newDocument();
                    Element newRoot = docNew.createElement("newRoot");
                    docNew.appendChild(newRoot);

                    //Them node bai viet vao node goc
                    newRoot.appendChild(docNew.importNode(nodeList.item(i), true));

                    //For testing: in ra danh sach xml
                    
                     Transformer tf = TransformerFactory.newInstance().newTransformer();
                     tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                     tf.setOutputProperty(OutputKeys.INDENT, "yes");
                     Writer out = new StringWriter();
                     tf.transform(new DOMSource(docNew), new StreamResult(out));
                     System.out.println(out.toString());
                     


                    //Lay noi dung cua link
                    String x = expression + catTemp._link;
                    NodeList node = (NodeList) xpath.evaluate(x, docNew, XPathConstants.NODESET);
                    co._link = StringEscapeUtils.unescapeHtml4(node.item(0).getTextContent());
                    
                    //Lay noi dung cua title
                    x = expression + catTemp._title;
                    node = (NodeList) xpath.evaluate(x, docNew, XPathConstants.NODESET);
                    co._title = StringEscapeUtils.unescapeHtml4(node.item(0).getTextContent());

                    //Lay noi dung cua image
                    x = expression + catTemp._image;
                    node = (NodeList) xpath.evaluate(x, docNew, XPathConstants.NODESET);
                    if (node.getLength() > 0) {
                        co._image = StringEscapeUtils.unescapeHtml4(node.item(0).getTextContent());
                    }

                    //Lay noi dung cua date
                    x = expression + catTemp._date;
                    node = (NodeList) xpath.evaluate(x, docNew, XPathConstants.NODESET);
                    if (node.getLength() > 0) {
                        co._date = StringEscapeUtils.unescapeHtml4(node.item(0).getTextContent());
                    }

                    //Lay noi dung cua description
                    x = expression + catTemp._description;
                    node = (NodeList) xpath.evaluate(x, docNew, XPathConstants.NODESET);
                    if (node.getLength() > 0) {
                        co._description = StringEscapeUtils.unescapeHtml4(node.item(0).getTextContent());
                    }

                    //Them bai viet vua lay duoc vao danh sach
                    ds.add(co);

                } catch (Exception ex) {
                    continue;
                }
            }


        } catch (XPathExpressionException ex) {
        }


        return ds;
    }

    
    /**
     * Tìm node trang tiếp theo (lần đầu tiên)
     * @param cat
     * @return 
     */
    public Node findNextPageNode(Category cat) {
        return findNextPageNode(_document, cat);
    }
    
    
    /**
     * Tìm node trang tiếp theo (lần đầu tiên)
     * @param doc
     * @param cat
     * @return 
     */
    public Node findNextPageNode(org.w3c.dom.Document doc, Category cat) {
        
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();
        Category catTemp = new Category();

        //Danh sach xpath
        NodeList nodeList;

        //Node NextPage ke tiep
        Node nNextPageNext = null;

        //XPath chung cua phan trang
        String expression = cat._xpathNextPage;

        //Loc ra xpath cua tung thuoc tinh
        catTemp._nextpage = cat._nextpage.substring(expression.length());
        catTemp._nextpage = catTemp._nextpage.substring(catTemp._nextpage.indexOf("/"));
        
        
        try {
            //Lay tag chua danh sach page
            nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            if (nodeList.getLength() > 0) {
                //Tao document XML moi
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setValidating(false);
                DocumentBuilder db = dbf.newDocumentBuilder();

                //tao file XML moi
                Document docNew = db.newDocument();

                //root la nodeList
                Node root = docNew.appendChild(docNew.importNode(nodeList.item(0), true));

                //For testing: in ra danh sach xml
                
                Transformer tf = TransformerFactory.newInstance().newTransformer();
                tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                Writer out = new StringWriter();
                tf.transform(new DOMSource(docNew), new StreamResult(out));
                System.out.println(out.toString());


                NodeList dsNodePage = root.getChildNodes();


                //Loc lay tag html cuoi cung
                expression = "/" + root.getNodeName();

                //Lay node NextPage
                String x = expression + catTemp._nextpage;
                NodeList node = (NodeList) xpath.evaluate(x, docNew, XPathConstants.NODESET);
                Node nNextPage = null;
                String nNextPageLink = "";

                if (node.getLength() > 0) {
                    nNextPage = node.item(0);
                }

                //Duyet danh sach node Page
                for (int i = 0; i < dsNodePage.getLength(); i++) {

                    if (dsNodePage.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        
                        Element el = (Element) dsNodePage.item(i);
                        Element elNext = (Element) nNextPage;
                        
                        //Tim the <a> , lay @href
                        //Neu co node con
                        if(el.hasChildNodes())
                        {
                            //tao file XML moi
                            Document docNextPage = db.newDocument();
                            //tao file XML moi, node goc la <newRoot>
                            Element newRootNextPage = docNextPage.createElement("rootNextPage");
                            docNextPage.appendChild(newRootNextPage);

                            //Them node bai viet vao node goc
                            newRootNextPage.appendChild(docNextPage.importNode(dsNodePage.item(i), true));
                            
                            
                            //For testing: in ra danh sach xml
                            tf = TransformerFactory.newInstance().newTransformer();
                            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                            tf.setOutputProperty(OutputKeys.INDENT, "yes");
                            out = new StringWriter();
                            tf.transform(new DOMSource(docNextPage), new StreamResult(out));
                            System.out.println(out.toString());
                            
                            //Truy van xpath
                            x = "/rootNextPage//a";
                            NodeList nlNewNextPage = (NodeList) xpath.evaluate(x, docNextPage, XPathConstants.NODESET);
                            Node nNewNextPage = nlNewNextPage.item(0);
                            el = (Element) nNewNextPage;
                        }
                        
                        
                        //Neu da tim thay node NextPage
                        if (nNextPageLink.compareTo("") != 0) {
                            //Thi lay node NextPageNext
                            nNextPageNext = (Node) el;//dsNodePage.item(i);

                            //Thoat vong lap
                            break;
                        }
                        
                        String tempHref = el.getAttribute("href");
                        String tempHrefNext = elNext.getAttribute("href");
                        
                        System.out.println(tempHref);

                        //Neu node hien tai la node NextPage
                        if (tempHrefNext.compareTo(tempHref) == 0)
                        {
                            nNextPageLink = tempHref;

                            //Tim node NextPage ke tiep                            
                        }

                    }
                }//end for

                //Lưu link của node NextPage
                this._nextPageLink = nNextPageLink;
                
            }//end if

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return nNextPageNext;

    }
    
    
    /**
     * Tìm node trang tiếp theo (lần thứu 2 trở đi)
     * @param doc
     * @param cat
     * @param nNextPage node trang tiếp theo hiện tại, dùng để so sánh tìm vị trí node trang tiếp theo
     * @return 
     */
    public Node findNextPageNode(org.w3c.dom.Document doc, Category cat, Node nNextPage) {
        
        //Node NextPage ke tiep
        Node nNextPageNext = null;
        
        
        XPathFactory factory = XPathFactory.newInstance();
        XPath xpath = factory.newXPath();

        //Danh sach xpath
        NodeList nodeList;
        
        //XPath chung cua phan trang
        String expression = cat._xpathNextPage;
        
        try {
            
            //B1. Lay noi dung HTML cua xpathPage
            //Lay tag chua danh sach page
            nodeList = (NodeList) xpath.evaluate(expression, doc, XPathConstants.NODESET);

            if (nodeList.getLength() > 0) {
                
                //B2. Convert document moi de truy van xpath
                //Tao document XML moi
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                dbf.setValidating(false);
                DocumentBuilder db = dbf.newDocumentBuilder();

                //tao file XML moi
                Document docNew = db.newDocument();

                //root la nodeList
                Node root = docNew.appendChild(docNew.importNode(nodeList.item(0), true));

                //For testing: in ra danh sach xml
                /*
                 Transformer tf = TransformerFactory.newInstance().newTransformer();
                 tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                 tf.setOutputProperty(OutputKeys.INDENT, "yes");
                 Writer out = new StringWriter();
                 tf.transform(new DOMSource(docNew), new StreamResult(out));
                 System.out.println(out.toString());
                 */
                
                //B3. Lay tat ca nodePage
                NodeList dsNodePage = root.getChildNodes();

                //B4. Lay nodeNextPage trong doc
                //Lay node NextPage
                String nNextPageLink = "";

                //B5. Tim nodeNextPage trong danh sach nodePage
                //Duyet danh sach node Page
                for (int i = 0; i < dsNodePage.getLength(); i++) {

                    if (dsNodePage.item(i).getNodeType() == Node.ELEMENT_NODE) {
                        
                        
                        Element el = (Element) dsNodePage.item(i);
                        Element elNext = (Element) nNextPage;
                        
                        //Tim the <a> , lay @href
                        //Neu co node con
                        if(el.hasChildNodes())
                        {
                            //tao file XML moi
                            Document docNextPage = db.newDocument();
                            //tao file XML moi, node goc la <newRoot>
                            Element newRootNextPage = docNextPage.createElement("rootNextPage");
                            docNextPage.appendChild(newRootNextPage);

                            //Them node bai viet vao node goc
                            newRootNextPage.appendChild(docNextPage.importNode(dsNodePage.item(i), true));
                            
                            
                            //For testing: in ra danh sach xml
                            Transformer tf = TransformerFactory.newInstance().newTransformer();
                            tf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
                            tf.setOutputProperty(OutputKeys.INDENT, "yes");
                            Writer out = new StringWriter();
                            tf.transform(new DOMSource(docNextPage), new StreamResult(out));
                            System.out.println(out.toString());
                            
                            //Truy van xpath
                            String x = "/rootNextPage//a";
                            NodeList nlNewNextPage = (NodeList) xpath.evaluate(x, docNextPage, XPathConstants.NODESET);
                            Node nNewNextPage = nlNewNextPage.item(0);
                            el = (Element) nNewNextPage;
                        }
                        
                        
                        //B6. Lay nodeNextPageNext
                        //Neu da tim thay node NextPage
                        if (nNextPageLink.compareTo("") != 0) {
                            //Thi lay node NextPageNext
                            nNextPageNext = (Node) el;//dsNodePage.item(i);

                            //Thoat vong lap
                            break;
                        }
                        
                        
                        String tempHref = el.getAttribute("href");
                        String tempHrefNext = elNext.getAttribute("href");
                        
                        //System.out.println(tempHref);

                        //Neu node hien tai la node NextPage
                        if (tempHrefNext.compareTo(tempHref) == 0)
                        {
                            nNextPageLink = tempHref;

                            //Tim node NextPage ke tiep                            
                        }

                    }
                }//end for

                //Lưu link của node NextPage
                this._nextPageLink = nNextPageLink;
                
            }//end if

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        return nNextPageNext;
    }
    
    
    /**
     * Lấy nội dung danh sách bài viết
     * @param webLink link trang chủ
     * @param cat chuyên mục cần lấy
     * @param numPage số trang của chuyên mục sẽ lấy
     * @return
     * @throws IOException
     * @throws ParserConfigurationException 
     */
    public List<Content> fetchNews(String webLink, Category cat, int numPage) throws IOException, ParserConfigurationException
    {
        List<Content> ds = new ArrayList<>();
        int soTrang = 0;
        Node nNextPage = null;
        
        do 
        {
            //Lay danh sach tin tuc cua trang dau tien
            List<Content> dsBaiViet = getTextContent(cat);
            ds.addAll(dsBaiViet);
            
            soTrang++;
            //Dieu kien dung
            if(soTrang >= numPage)
            {
                break;
            }
            
            //Tim Node cua trang tiep theo
            if(soTrang == 1)
            {
                nNextPage = findNextPageNode(this.getDocument(), cat);
            }
            else
            {
                nNextPage = findNextPageNode(this.getDocument(), cat, nNextPage);
            }
            
            //Cap nhat url cua trang tiep theo
            if(!this._nextPageLink.contains(webLink))
            {
                cat._url = webLink + this._nextPageLink;
            }
            
            //Cap nhat document cho trang moi
            this.setDocument(new URL(cat._url));
            
            
        } while (soTrang < numPage);
        
        
        return ds;
    }
    
    
    
    
}
