package util.file;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * @Author: zhangj
 * @Date: 2019-10-10
 * @Version 1.0
 */
public enum XmlUtil {
    ;

    /**
     * xml 转换成String
     *
     * @param filePath
     * @return
     */
    public static String getXmlString(String filePath) {
        SAXReader reader = new SAXReader();
        reader.setValidation(false);
        reader.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String publicId, String systemId) throws SAXException, IOException {
                return new InputSource(new ByteArrayInputStream("".getBytes()));
            }
        });
        File sqlmapFile = new File(filePath);
        String xmlStr = "";
        try {
            Document d = reader.read(sqlmapFile);
            xmlStr = d.asXML();
        } catch (Exception e) {

        }
        return xmlStr;
    }


}
