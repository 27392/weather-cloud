package cn.haohaoli.report.report.service.impl;

import cn.haohaoli.report.report.service.WeatherReportService;
import cn.haohaoli.report.report.vo.Weather;
import cn.haohaoli.report.report.vo.WeatherDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liwenhao
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Override
    public WeatherDetails getDataByCityId(String cityId, boolean update) {
        List<Weather> weathers = new ArrayList<>();
        weathers.add(new Weather("28日星期五", "21","16","小雨","南风","1级"));
        weathers.add(new Weather("29日星期六", "21","16","小雨","南风","1级"));
        weathers.add(new Weather("30日星期日", "21","16","小雨","南风","1级"));
        weathers.add(new Weather("1日星期一", "21","16","小雨","南风","1级"));
        weathers.add(new Weather("2日星期二", "21","16","小雨","南风","1级"));
        Weather weather = new Weather("27日星期四", "18", "13", "小于", "南方", "2级");
        //TODO 改为由天气数据API微服务来提供
        WeatherDetails weatherDetails = new WeatherDetails("重庆", "90", "容易感冒", "21", weather, weathers, new Date());
        return weatherDetails;
    }
}
