package com.resource;


import com.dto.DispatcherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.resource.iresource.IDispatcherResource;
import com.service.impl.DispatcherServiceImpl;

import java.util.List;

@RestController
public class DispatcherResourceImpl implements IDispatcherResource {

    @Autowired
    private DispatcherServiceImpl service;

    @Override
    public ResponseEntity<?> addDispatcher(@RequestBody DispatcherDto dispatcherDto) {
        service.addDispatcher(dispatcherDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public List<DispatcherDto> getDispatchers() {
        return service.getDispatchers();
    }

    @Override
    public ResponseEntity<?> updateDispatcher(@PathVariable("name") String name, @RequestBody DispatcherDto dispatcherDto) {
        if (service.updateDispatcher(name, dispatcherDto)) {
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @Override
    public ResponseEntity<?> deleteDispatcher(@PathVariable("name") String name) {
        service.deleteDispatcher(name);
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
}
