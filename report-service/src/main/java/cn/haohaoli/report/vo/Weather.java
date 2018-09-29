package cn.haohaoli.report.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * 天气
 * @author liwenhao
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Weather implements Serializable {
    private String date;
    private String high;
    private String low;
    private String type;
    private String fx;
    private String fl;
}
