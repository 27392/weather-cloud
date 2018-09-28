package cn.haohaoli.weather.data.service.impl;

import cn.haohaoli.weather.data.service.WeatherDataService;
import cn.haohaoli.weather.data.util.JsonUtil;
import cn.haohaoli.weather.data.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String url = WEATHER_API_URI + "city=" + cityName;
        return doWeather(url);
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String url = WEATHER_API_URI + "citykey=" + cityId;
        return doWeather(url);
    }

    /**
     * 统一请求
     * @param url       请求url
     * @return
     */
    private WeatherResponse doWeather(String url){
        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        String strBody = null;
        WeatherResponse resp = null;
        //先从redis中查询数据
        if (stringRedisTemplate.hasKey(url)) {
            strBody = opsForValue.get(url);
            resp = JsonUtil.toObject(strBody, WeatherResponse.class);
            log.info("Redis has data");
        } else {
            throw new RuntimeException("Redis don't has data");
        }
        return resp;
    }
}
