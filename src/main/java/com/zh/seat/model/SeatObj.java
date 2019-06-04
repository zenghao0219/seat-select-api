package com.zh.seat.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SeatObj {
    private Integer id;

    private Integer x;

    private Integer y;

    private String row;

    private String col;

    private BigDecimal price;

    private String type;

    private String flag = "0";

    private String templeteId;

    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date createTime;

    @JSONField(format="yyyy-MM-dd")//数据库导出页面时json格式化
    private Date updateTime;
}