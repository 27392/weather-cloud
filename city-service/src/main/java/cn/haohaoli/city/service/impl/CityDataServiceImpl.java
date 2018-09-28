package cn.haohaoli.city.service.impl;

import cn.haohaoli.city.service.CityDataService;
import cn.haohaoli.city.util.XmlUtil;
import cn.haohaoli.city.vo.City;
import cn.haohaoli.city.vo.CityList;
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
