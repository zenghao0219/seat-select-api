package com.zh.seat.controller;

import com.google.gson.Gson;
import com.zh.seat.model.*;
import com.zh.seat.services.SeatService;
import com.zh.seat.services.SeatTempleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class mainController {
    @Autowired
    private SeatService seatService;
    @Autowired
    private SeatTempleteService seatTempleteService;
        @RequestMapping(value="/insertSeat",method= RequestMethod.POST)
        @ResponseBody
        public Object insertSeat (@RequestBody Seats seats){
            if(seats!=null){
                List<SeatObj> processedList = new ArrayList<>();
                List<SeatObj> seatList = seats.getSeats();
                List<Integer> yList = seatList.stream()
                        .map(SeatObj::getY)
                        .sorted()
                        .distinct()
                        .collect(Collectors.toList());
                int row = 1;
                for (Integer y : yList) {
                    int col = 1;
                    List<SeatObj> rowList = seatList.stream().filter(t->t.getY().equals(y)).collect(Collectors.toList());
                    rowList = rowList.stream().sorted(Comparator.comparing(SeatObj::getX)).collect(Collectors.toList());
                    for (SeatObj seat: rowList) {
                        seat.setRow(row+"");
                        seat.setCol(col+"");
                        col++;
                    }
                    row++;
                    processedList.addAll(rowList);
                }
                if(processedList.size()>0){
                    SeatTemplete seatTemplete = new SeatTemplete();
                    seatTemplete.setName(seats.getTempleteName());
                    seatTemplete.setPrice(seats.getTempletePrice());
                    seatTemplete.setId(seats.getTempleteId());
                    seatTemplete.setFlag("0");
                    try {
                        seatService.insertSeatAndReplace(processedList,seatTemplete);
                        ResponseBean responseBean = new ResponseBean();
                        responseBean.setErrCode(0);
                        responseBean.setErrMsg("成功");
                        return responseBean;
                    } catch (Exception e) {
                        ResponseBean responseBean = new ResponseBean();
                        responseBean.setErrCode(1);
                        responseBean.setErrMsg("失败");
                        return responseBean;
                    }
                }

            }
            return "success";
        }
    @RequestMapping(value="/findTempleteList",method= RequestMethod.POST)
    @ResponseBody
    public Object findTempleteList (){
        try {
            List<SeatTemplete> list = seatTempleteService.findByTempleteList();
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(0);
            responseBean.setErrMsg("成功");
            responseBean.setData(list);
            return responseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(1);
            responseBean.setErrMsg("失败");
            return responseBean;
        }
    }
    @RequestMapping(value="/deleteTemplete",method= RequestMethod.POST)
    @ResponseBody
    public Object deleteTemplete (@RequestBody SeatsIdList idList){
        try {
            seatTempleteService.deleteTemplete(idList.getIdList());
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(0);
            responseBean.setErrMsg("成功");
            return responseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(1);
            responseBean.setErrMsg("失败");
            return responseBean;
        }
    }
    @RequestMapping(value="/findSeatListByTempleteId",method= RequestMethod.GET)
    @ResponseBody
    public Object findSeatListByTempleteId (@RequestParam(value = "id") Integer id){
        try {
            Seats seats = seatService.findSeatListByTempleteId(id);
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(0);
            responseBean.setErrMsg("成功");
            responseBean.setData(seats);
            return responseBean;
        } catch (Exception e) {
            ResponseBean responseBean = new ResponseBean();
            responseBean.setErrCode(1);
            responseBean.setErrMsg("失败");
            return responseBean;
        }
    }
}
