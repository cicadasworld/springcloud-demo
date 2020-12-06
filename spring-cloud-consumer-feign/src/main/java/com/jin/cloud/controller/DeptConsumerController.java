package com.jin.cloud.controller;

import com.jin.cloud.pojo.Dept;
import com.jin.cloud.servie.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptService service;

    @GetMapping("/consumer/dept/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        return service.getDeptById(id);
    }

    @PostMapping("/consumer/dept")
    public Boolean addDept(Dept dept) {
        return service.addDept(dept);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> listAll() throws Exception {
        return service.listAll();
    }
}
