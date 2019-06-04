package com.zh.seat.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class SeatTemplete {
    private Integer id;

    private String name;

    private String flag;

    private BigDecimal price;


    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date createTime;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm", timezone="GMT+8")
    private Date updateTime;
}