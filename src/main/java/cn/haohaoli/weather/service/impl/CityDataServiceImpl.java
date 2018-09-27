package cn.haohaoli.weather.service.impl;

import cn.haohaoli.weather.service.CityDataService;
import cn.haohaoli.weather.util.XmlUtil;
import cn.haohaoli.weather.vo.City;
import cn.haohaoli.weather.vo.CityList;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.List;

/**
 * @author liwenhao
 */
@Service
public class CityDataServiceImpl implements CityDataService {

    @Override
    public List<City> getListCity() throws Exception {
        URL resource  = this.getClass().getClassLoader().getResource("city.xml");
        CityList cityList = (CityList) XmlUtil.xmlToObject(CityList.class, resource);
        return cityList.getCityList();
    }
}
