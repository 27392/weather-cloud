package cn.haohaoli.weather.service.impl;

import cn.haohaoli.weather.service.CityDataService;
import cn.haohaoli.weather.service.WeatherDataService;
import cn.haohaoli.weather.util.JsonUtil;
import cn.haohaoli.weather.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author liwenhao
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    /**
     * 天气api
     */
    private static final String WEATHER_API_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    /**
     * HTTP成功状态码
     */
    private static final int SUCCESS_STATUS = 200;
    /**
     * 天气数据成功状态吗
     */
    private static final int WEATHER_SUCCESS_STATUS = 1000;
    /**
     * 天气数据缓存时间
     */
    private static final long TIME_OUT = 3600L;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityName(String cityName, boolean update) {
        String url = WEATHER_API_URI + "city=" + cityName;
        return doWeather(url, update);
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId, boolean update) {
        String url = WEATHER_API_URI + "citykey=" + cityId;
        return doWeather(url, update);
    }

    @Override
    public void syncDataByCityId(String cityId) {
        getDataByCityId(cityId, true);
    }

    /**
     * 统一请求
     * @param url       请求url
     * @param update    是否需要更新数据
     * @return
     */
    private WeatherResponse doWeather(String url, boolean update){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String strBody = null;
        WeatherResponse resp = null;
        //先从redis中查询数据
        if (stringRedisTemplate.hasKey(url) && !update) {
            strBody = opsForValue.get(url);
            resp = JsonUtil.toObject(strBody, WeatherResponse.class);
            log.info("redis data");
        } else {
            ResponseEntity<String> forEntity = restTemplate.getForEntity(url, String.class);
            //日志
            if (log.isDebugEnabled()) {
                log.debug("url: {} ", url);
            }
            if (forEntity.getStatusCodeValue() == SUCCESS_STATUS) {
                strBody = format(forEntity.getBody());
                resp = JsonUtil.toObject(strBody, WeatherResponse.class);
                log.info("message : {} ", resp.getDesc());
                if (resp.getStatus() == WEATHER_SUCCESS_STATUS) {
                    //设置更新时间
                    resp.getData().setUpdateTime(new Date());
                    opsForValue.set(url, JsonUtil.toJsonString(resp), TIME_OUT, TimeUnit.SECONDS);
                }
            }
        }
        return resp;
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
