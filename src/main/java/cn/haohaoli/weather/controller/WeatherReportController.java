package cn.haohaoli.weather.controller;

import cn.haohaoli.weather.service.CityDataService;
import cn.haohaoli.weather.service.WeatherReportService;
import cn.haohaoli.weather.vo.City;
import cn.haohaoli.weather.vo.WeatherDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author liwenhao
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private CityDataService cityDataService;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView byCityId(@PathVariable String cityId,
                                 @RequestParam(required = false,defaultValue = "false") boolean update,
                                 Model model) throws Exception {
        WeatherDetails weatherDetails = weatherReportService.getDataByCityId(cityId, update);
        List<City> listCity = cityDataService.getListCity();
        //页面设值
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", listCity);
        model.addAttribute("report", weatherDetails);
        return new ModelAndView("weather/report", "reportModel", model);
    }


}
