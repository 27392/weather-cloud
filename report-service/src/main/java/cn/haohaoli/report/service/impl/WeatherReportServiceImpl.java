package cn.haohaoli.report.service.impl;

import cn.haohaoli.report.client.DataClient;
import cn.haohaoli.report.service.WeatherReportService;
import cn.haohaoli.report.vo.WeatherDetails;
import cn.haohaoli.report.vo.WeatherResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liwenhao
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Resource
    private DataClient dataClient;

    @Override
    public WeatherDetails getDataByCityId(String cityId) {
        WeatherResponse weatherResponse = dataClient.byCityId(cityId);
        if (weatherResponse != null) {
            return weatherResponse.getData();
        }
        return null;
    }
}
