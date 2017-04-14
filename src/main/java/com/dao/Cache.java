package com.dao;

import com.model.Dispatcher;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class Cache {
    private static Map<String, Dispatcher> cache = new HashMap();

    public static Map getCache() {
        return cache;
    }
    public Cache() {
        initCache();
    }

    private void initCache() {
        Dispatcher baseDisp = new Dispatcher();
        baseDisp.setCreateDate(System.nanoTime());
        baseDisp.setDispatcherFrase("Not enough minerals ");
        baseDisp.setDispatcherName("Custom");
        cache.put("custoom",baseDisp);
    }
}
