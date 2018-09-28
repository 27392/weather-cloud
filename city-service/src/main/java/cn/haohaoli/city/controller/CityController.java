package cn.haohaoli.city.controller;

import cn.haohaoli.city.service.CityDataService;
import cn.haohaoli.city.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liwenhao
 * @sign 2018/9/28 10:10
 */
@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/list")
    public List<City> getListCity() throws Exception {
        return cityDataService.getListCity();
    }


}
