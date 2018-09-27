package cn.haohaoli.weather.service;

import cn.haohaoli.weather.vo.City;

import java.util.List;

/**
 * @author liwenhao
 */
public interface CityDataService {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    List<City> getListCity() throws Exception;
}
