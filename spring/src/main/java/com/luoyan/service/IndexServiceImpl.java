package com.luoyan.service;

import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public String index() {
        return "hello luoyan!!!";
    }
}
