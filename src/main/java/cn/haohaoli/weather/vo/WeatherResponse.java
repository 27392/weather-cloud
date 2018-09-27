package cn.haohaoli.weather.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author liwenhao
 */
@Getter
@Setter
public class WeatherResponse implements Serializable {

    private WeatherDetails data;
    private Integer status;
    private String desc;
}
