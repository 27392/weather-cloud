package cn.haohaoli.weather.data.service;

import cn.haohaoli.weather.data.vo.WeatherResponse;

/**
 * @author liwenhao
 */
public interface WeatherDataService {

    /**
     * 根据城市名称查询天气数据
     * @param cityName  城市名称
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);

    /**
     * 根据城市ID查询天气数据
     * @param cityId    城市ID
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);
}
