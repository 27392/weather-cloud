package cn.haohaoli.weather;

import cn.haohaoli.weather.service.WeatherDataService;
import cn.haohaoli.weather.util.JsonUtil;
import cn.haohaoli.weather.vo.WeatherResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

    /**
     * http://wthrcdn.etouch.cn/weather_mini?city=北京
     * 通过城市名字获得天气数据，json数据
     * http://wthrcdn.etouch.cn/weather_mini?citykey=101010100
     */

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherDataService weatherDataService;

    @Test
    public void contextLoads() throws IOException {

        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 支持中文编码
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://wthrcdn.etouch.cn/weather_mini?city=重庆", String.class);
        if (forEntity.getStatusCodeValue() == 200){
            System.out.println("success");
            String body = forEntity.getBody()
                    .replaceAll("fengli","fl")
                    .replaceAll("fengxiang","fx");
            System.out.println(body);
            ObjectMapper objectMapper = new ObjectMapper();
            WeatherResponse weatherResponse = objectMapper.readValue(body, WeatherResponse.class);
            System.out.println(JsonUtil.toJsonString(weatherResponse));
        }
    }

    /**
     * http://flash.weather.com.cn/wmaps/xml/china.xml      全国  pyName
     * http://flash.weather.com.cn/wmaps/xml/{pyName}.xml   省份  url
     * http://wthrcdn.etouch.cn/weather_mini?citykey={url}
     */
    /*@Test
    public void xmlTest() throws Exception {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 支持中文编码
        ResponseEntity<String> forEntity = restTemplate.getForEntity("http://flash.weather.com.cn/wmaps/xml/china.xml", String.class);
        if (forEntity.getStatusCodeValue() == 200){
            System.out.println("success");
            //字符串转Document对象
            Document document = DocumentHelper.parseText(forEntity.getBody());
            //根节点
            Element rootElement = document.getRootElement();
            System.out.println(rootElement.attribute(0));
            System.out.println("根节点：" + rootElement.getName());
            List<Element> elements = rootElement.elements();
            List<JSONObject> objectList = new ArrayList<>();
            if (!elements.isEmpty()) {
                for (Element element : elements) {
                    JSONObject jsonObject = new JSONObject();
                    List<Attribute> attrs = element.attributes();
                    if (!attrs.isEmpty()) {
                        for (int i = 0; i < attrs.size(); i++) {
                            jsonObject.put(attrs.get(i).getName(), attrs.get(i).getValue());
                        }
                    }
                    objectList.add(jsonObject);
//                    xmlTest1(jsonObject.getString("pyName"));
                }
            }
            System.out.println(objectList);
        }
    }*/
/*
    @Test
    public void test() throws Exception {
        xmlTest1("china");
    }*/

    /*public void xmlTest1(String rootName) throws Exception {
        String url = "";
        String attr = "";
        if (rootName.equals("china")) {
            url = "http://flash.weather.com.cn/wmaps/xml/china.xml";
            attr = "pyName";
        } else {
            url = "http://flash.weather.com.cn/wmaps/xml/" + rootName + ".xml";
            attr = "url";
        }
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory());
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8)); // 支持中文编码
        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        if (forEntity.getStatusCodeValue() == 200){
            System.out.println("success");
            //字符串转Document对象
            Document document = DocumentHelper.parseText(forEntity.getBody());
            //根节点
            Element rootElement = document.getRootElement();
            System.out.println("根节点：" + rootElement.getName());
            List<Element> elements = rootElement.elements();
            List<JSONObject> objectList = new ArrayList<>();
            if (!elements.isEmpty()) {
                for (Element element : elements) {
                    JSONObject jsonObject = new JSONObject();
                    List<Attribute> attrs = element.attributes();
                    if (!attrs.isEmpty()) {
                        for (int i = 0; i < attrs.size(); i++) {
                            jsonObject.put(attrs.get(i).getName(), attrs.get(i).getValue());
                        }
                    }
                    objectList.add(jsonObject);
                    if (attr != "") {
                        xmlTest1(jsonObject.getString(attr));
                    }
                }
            }
            System.out.println(objectList);
        }
    }*/





}
