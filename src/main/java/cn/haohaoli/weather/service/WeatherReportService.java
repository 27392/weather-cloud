package cn.haohaoli.weather.service;

import cn.haohaoli.weather.vo.WeatherDetails;

/**
 * @author liwenhao
 */
public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     * @param cityId    城市ID
     * @param update    是否更新数据
     * @return
     */
    WeatherDetails getDataByCityId(String cityId, boolean update);
}
