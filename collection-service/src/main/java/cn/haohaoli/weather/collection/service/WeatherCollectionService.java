package cn.haohaoli.weather.collection.service;

/**
 * @author liwenhao
 */
public interface WeatherCollectionService {

    /**
     * 根据城市ID同步天气
     * @param cityId    城市ID
     */
    void syncDataByCityId(String cityId);

}
