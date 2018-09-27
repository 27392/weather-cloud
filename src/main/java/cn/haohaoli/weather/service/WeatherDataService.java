package cn.haohaoli.weather.service;

import cn.haohaoli.weather.vo.WeatherResponse;

/**
 * @author liwenhao
 */
public interface WeatherDataService {

    /**
     * 根据城市名称查询天气数据
     * @param cityName  城市名称
     * @param update    是否更新
     * @return
     */
    WeatherResponse getDataByCityName(String cityName, boolean update);

    /**
     * 根据城市ID查询天气数据
     * @param cityId    城市ID
     * @param update    是否更新
     * @return
     */
    WeatherResponse getDataByCityId(String cityId, boolean update);

    /**
     * 根据城市ID同步天气
     * @param cityId    城市ID
     */
    void syncDataByCityId(String cityId);

}
