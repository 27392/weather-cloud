package cn.haohaoli.weather.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 天气详情
 * @author liwenhao
 */
@Getter
@Setter
public class WeatherDetails implements Serializable {

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private Weather yesterday;
    private List<Weather> forecast;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
}
