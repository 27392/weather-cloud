package cn.haohaoli.weather.service.impl;

import cn.haohaoli.weather.service.WeatherDataService;
import cn.haohaoli.weather.service.WeatherReportService;
import cn.haohaoli.weather.vo.WeatherDetails;
import cn.haohaoli.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liwenhao
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public WeatherDetails getDataByCityId(String cityId, boolean update) {
        WeatherResponse weatherData = weatherDataService.getDataByCityId(cityId, update);
        return weatherData.getData();
    }
}
