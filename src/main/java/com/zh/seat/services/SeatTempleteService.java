package com.zh.seat.services;
import com.zh.seat.mapper.SeatObjMapper;
import com.zh.seat.mapper.SeatTempleteMapper;
import com.zh.seat.model.SeatObj;
import com.zh.seat.model.SeatTemplete;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class SeatTempleteService {

    @Autowired
    private SeatTempleteMapper seatTempleteMapper;
    @Transactional
    public List<SeatTemplete> findByTempleteList() {
        return seatTempleteMapper.findByTempleteList();
    }
    @Transactional
    public void deleteTemplete(List<Integer> idList) {
         seatTempleteMapper.deleteTemplete(idList);
    }
}
