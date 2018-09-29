package cn.haohaoli.report.controller;

import cn.haohaoli.report.client.DataClient;
import cn.haohaoli.report.service.WeatherReportService;
import cn.haohaoli.report.vo.City;
import cn.haohaoli.report.vo.WeatherDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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

    @Resource
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView byCityId(@PathVariable String cityId, Model model) throws Exception {
        WeatherDetails weatherDetails = weatherReportService.getDataByCityId(cityId);
        List<City> listCity = dataClient.listCity();
        //页面设值
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", listCity);
        model.addAttribute("report", weatherDetails);
        return new ModelAndView("weather/report", "reportModel", model);
    }

}
