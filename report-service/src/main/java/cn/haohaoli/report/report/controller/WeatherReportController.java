package cn.haohaoli.report.report.controller;

import cn.haohaoli.report.report.service.WeatherReportService;
import cn.haohaoli.report.report.vo.City;
import cn.haohaoli.report.report.vo.WeatherDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liwenhao
 */
@Slf4j
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;


    @GetMapping("/cityId/{cityId}")
    public ModelAndView byCityId(@PathVariable String cityId,
                                 @RequestParam(required = false,defaultValue = "false") boolean update,
                                 Model model) throws Exception {
        WeatherDetails weatherDetails = weatherReportService.getDataByCityId(cityId, update);
        //TODO 改为由城市API微服务来提供数据
//        List<City> listCity = cityDataService.getListCity();
        List<City> listCity = null;
        try {
            listCity = new ArrayList<>();
            City city = new City();
            city.setCityCode("101040100");
            city.setCityName("重庆");
            listCity.add(city);
        } catch (Exception e) {
            log.error("Exception", e);
        }
        //页面设值
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", listCity);
        model.addAttribute("report", weatherDetails);
        return new ModelAndView("weather/report", "reportModel", model);
    }


}
