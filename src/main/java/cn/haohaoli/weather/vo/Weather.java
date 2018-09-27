package cn.haohaoli.weather.vo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 天气
 * @author liwenhao
 */
@Getter
@Setter
public class Weather implements Serializable {
    private String date;
    private String high;
    private String low;
    private String type;
    private String fx;
    private String fl;
}
