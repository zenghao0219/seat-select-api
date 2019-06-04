package com.zh.seat.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Seats {
    private List<SeatObj> seats;
    private String templeteName;
    private Integer templeteId;
    private BigDecimal templetePrice;
}