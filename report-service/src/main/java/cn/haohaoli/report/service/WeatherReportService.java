package cn.haohaoli.report.service;

import cn.haohaoli.report.vo.WeatherDetails;

/**
 * @author liwenhao
 */
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     * @param cityId    城市ID
     * @return
     */
    WeatherDetails getDataByCityId(String cityId);
}
