package cn.haohaoli.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.net.URL;

/**
 * @author liwenhao
 */
public class XmlUtil {

    public static Object xmlToObject(Class<?> clazz, URL url) throws Exception {
        JAXBContext context = JAXBContext.newInstance(clazz);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(url);
    }
}
