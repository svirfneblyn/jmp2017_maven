package com.service.impl;

import com.converter.DispatcherDtoToDispatcherConverter;
import com.converter.DispatcherToDispatcherDtoConverter;
import com.dao.Cache;
import com.dto.DispatcherDto;
import com.model.Dispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.IDispatcherService;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispatcherServiceImpl implements IDispatcherService {
    @Autowired
    DispatcherDtoToDispatcherConverter converter;
    @Autowired
    DispatcherToDispatcherDtoConverter converterToDto;

    public void addDispatcher(DispatcherDto dispatcherDto) {
        Dispatcher disp = converter.apply(dispatcherDto);
        Cache.getCache().put(disp.getDispatcherName(), disp);
    }

    public List<DispatcherDto> getDispatchers() {
        List<DispatcherDto> dtoList = new ArrayList<>();
        Cache.getCache().forEach((k, v) -> {
            dtoList.add(converterToDto.apply((Dispatcher) v));
        });
        return dtoList;
    }

    public boolean updateDispatcher(String name, DispatcherDto dispatcherDto) {
        if (Cache.getCache().containsValue(name)) {
            addDispatcher(dispatcherDto);
            return true;
        } else {
            return false;
        }
    }

    public void deleteDispatcher(String name) {
        if (Cache.getCache().containsValue(name)) {
            Cache.getCache().remove(name);
        }
    }
}
