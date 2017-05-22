package com.converter;


import com.dto.DispatcherDto;
import com.domain.Dispatcher;
import org.springframework.stereotype.Component;

import java.util.function.Function;


@Component
public class DispatcherDtoToDispatcherConverter implements Function<DispatcherDto, Dispatcher> {

    @Override
    public Dispatcher apply(DispatcherDto dispatcherDto) {
        Dispatcher entity = new Dispatcher();
        entity.setDispatcherFrase(dispatcherDto.getDispatcherFrase());
        entity.setDispatcherName(dispatcherDto.getDispatcherName());
        entity.setCreateDate(dispatcherDto.getCreateTime());
        return entity;
    }
}
