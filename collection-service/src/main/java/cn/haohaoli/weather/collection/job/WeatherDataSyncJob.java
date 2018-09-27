package cn.haohaoli.weather.collection.job;

import cn.haohaoli.weather.collection.service.WeatherCollectionService;
import cn.haohaoli.weather.collection.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 天气定时任务
 * @author liwenhao
 */
@Slf4j
public class WeatherDataSyncJob implements Job {

    @Autowired
    private WeatherCollectionService weatherCollectionService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Weather Data Sync Start");
        List<City> listCity = null;
        try {
            //TODO 改为由城市数据API微服务来提供数据
            listCity = new ArrayList<>();
            City city = new City();
            city.setCityCode("101040100");
            listCity.add(city);
        } catch (Exception e) {
            log.error("Exception", e);
        }
        for (City city : listCity) {
            String cityId = city.getCityId();
            if (log.isDebugEnabled()) {
                log.debug("Weather Data Sync Job. CityId: {}, CityName: {}", cityId, city.getCityName());
            }
            weatherCollectionService.syncDataByCityId(cityId);
        }
        log.info("Weather Data Sync End");
    }

}
