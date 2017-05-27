package com.dto;

public class DispatcherDto {

    private String dispatcherName;
    private String dispatcherFrase;
    private Long createTime;

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

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DispatcherDto{" +
                "dispatcherName='" + dispatcherName + '\'' +
                ", dispatcherFrase='" + dispatcherFrase + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
