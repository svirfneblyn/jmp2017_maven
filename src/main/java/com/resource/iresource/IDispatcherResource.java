package com.resource.iresource;

import com.dto.DispatcherDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Component
public interface IDispatcherResource {

    @RequestMapping(value = "/dispatcher", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    ResponseEntity<?> addDispatcher(@RequestBody DispatcherDto dispatcherDto);

    @GetMapping(value = "/dispatcher", produces = "application/json")
    List<DispatcherDto> getDispatchers();

    @RequestMapping(value = "/dispatcher/{name}", method = RequestMethod.PUT, consumes = "application/json", produces = "application/json")
    ResponseEntity<?> updateDispatcher(@PathVariable("name") String name, @RequestBody DispatcherDto dispatcherDto);

    @RequestMapping(value = "/dispatcher/{name}", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    ResponseEntity<?> deleteDispatcher(@PathVariable("name") String name);

}
