package com.converter;


import com.dto.DispatcherDto;
import com.model.Dispatcher;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DispatcherToDispatcherDtoConverter implements Function<Dispatcher, DispatcherDto> {

    @Override
    public DispatcherDto apply(Dispatcher dispatcher) {
        DispatcherDto entity = new DispatcherDto();
        entity.setDispatcherFrase(dispatcher.getDispatcherFrase());
        entity.setDispatcherName(dispatcher.getDispatcherName());
        entity.setCreateTime(dispatcher.getCreateDate());
        return entity;
    }
}
