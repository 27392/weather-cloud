package cn.haohaoli.report.report.service.impl;

import cn.haohaoli.report.report.client.DataClient;
import cn.haohaoli.report.report.service.WeatherReportService;
import cn.haohaoli.report.report.vo.Weather;
import cn.haohaoli.report.report.vo.WeatherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liwenhao
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Resource
    private DataClient dataClient;

    @Override
    public WeatherDetails getDataByCityId(String cityId) {
        return dataClient.byCityId(cityId).getData();
    }
}
