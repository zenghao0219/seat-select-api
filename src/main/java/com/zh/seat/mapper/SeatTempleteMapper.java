package com.zh.seat.mapper;

import com.zh.seat.model.SeatTemplete;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatTempleteMapper {
    void insertTemplete(@Param("seatTemplete")SeatTemplete seatTemplete);

    List<SeatTemplete> findByTempleteList();

    void deleteTemplete(@Param("idList")List<Integer> idList);

    SeatTemplete findTempleteById(@Param("id")Integer id);
}