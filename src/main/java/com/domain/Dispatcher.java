package com.domain;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Data
@Accessors(chain = true)
public class Dispatcher implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dispatcherName;
    private String dispatcherFrase;
    private Long createDate;
}
