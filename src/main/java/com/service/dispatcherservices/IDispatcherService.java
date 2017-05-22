package com.service.dispatcherservices;


import com.dto.DispatcherDto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface IDispatcherService {

    void addDispatcher(DispatcherDto dispatcherDto);
    List<DispatcherDto> getDispatchers();
    boolean updateDispatcher(String name, DispatcherDto dispatcherDto);
    void deleteDispatcher(String name);
}
