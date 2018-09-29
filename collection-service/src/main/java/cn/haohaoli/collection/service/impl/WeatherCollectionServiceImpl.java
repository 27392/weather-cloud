package cn.haohaoli.collection.service.impl;

import cn.haohaoli.collection.service.WeatherCollectionService;
import cn.haohaoli.collection.util.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @author liwenhao
 */
@Slf4j
@Service
public class WeatherCollectionServiceImpl implements WeatherCollectionService {

    /**
     * 天气api
     */
    private static final String WEATHER_API_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    /**
     * HTTP成功状态码
     */
    private static final int SUCCESS_STATUS = 200;
    /**
     * 天气数据缓存时间
     */
    private static final long TIME_OUT = 3600L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Override
    public void syncDataByCityId(String cityId) {
        String url = WEATHER_API_URI + "citykey=" + cityId;
        saveWeatherData(url);
    }

    /**
     * 统一请求
     * @param url       请求url
     * @return
     */
    private void saveWeatherData(String url) {
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String strBody = null;

        ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
        //日志
        if (log.isDebugEnabled()) {
            log.debug("url: {} ", url);
        }
        if (forEntity.getStatusCodeValue() == SUCCESS_STATUS) {
            strBody = format(forEntity.getBody());
            //设置更新时间
            opsForValue.set(url, JsonUtil.toJsonString(strBody), TIME_OUT, TimeUnit.SECONDS);
        }
    }

    /**
     * 格式化字符串
     * @param s
     * @return
     */
    private String format(String s){
        return s.replaceAll("fengli", "fl")
                .replaceAll("fengxiang", "fx");
    }
}
