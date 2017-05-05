package com.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Dispatcher implements Serializable {
    private static final long serialVersionUID = 1L;
    private String dispatcherName;
    private String dispatcherFrase;
    private Long createDate;

    public Dispatcher() {

    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getDispatcherName() {
        return dispatcherName;
    }

    public void setDispatcherName(String dispatcherName) {
        this.dispatcherName = dispatcherName;
    }

    public String getDispatcherFrase() {
        return dispatcherFrase;
    }

    public void setDispatcherFrase(String dispatcherFrase) {
        this.dispatcherFrase = dispatcherFrase;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }


}
