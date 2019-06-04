package com.zh.seat.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseBean {
    private Integer errCode;
    private String errMsg;
    private Object data;
}
