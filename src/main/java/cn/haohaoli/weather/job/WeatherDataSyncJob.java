package cn.haohaoli.weather.job;

import cn.haohaoli.weather.service.CityDataService;
import cn.haohaoli.weather.service.WeatherDataService;
import cn.haohaoli.weather.vo.City;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 天气定时任务
 * @author liwenhao
 */
@Slf4j
public class WeatherDataSyncJob implements Job {

    @Autowired
    private CityDataService cityDataService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        log.info("Weather Data Sync Start");
        try {
            List<City> listCity = cityDataService.getListCity();
            for (City city : listCity) {
                String cityId = city.getCityId();
                if (log.isDebugEnabled()) {
                    log.debug("Weather Data Sync Job. CityId: {}, CityName: {}", cityId, city.getCityName());
                }
                weatherDataService.syncDataByCityId(cityId);
            }
        } catch (Exception e) {
            log.error("Exception", e);
        }
        log.info("Weather Data Sync End");
    }

}
