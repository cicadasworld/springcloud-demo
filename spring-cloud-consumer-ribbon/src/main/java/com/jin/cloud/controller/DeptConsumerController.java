package com.jin.cloud.controller;

import com.jin.cloud.pojo.Dept;

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
    private RestTemplate restTemplate;

//    private static final String REST_URL_PREFIX = "http://localhost:8001";
    private static final String REST_URL_PREFIX = "http://SPRING-CLOUD-PRODUCER";

    @GetMapping("/consumer/dept/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        String url = REST_URL_PREFIX + "/dept/" + id;
        return restTemplate.getForObject(url, Dept.class);
    }

    @PostMapping("/consumer/dept")
    public Boolean addDept(Dept dept) {
        String url = REST_URL_PREFIX + "/dept";
        return restTemplate.postForObject(url, dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/list")
    public List<Dept> listAll() throws Exception {
        String url = REST_URL_PREFIX + "/dept/list";
        Dept[] depts = restTemplate.getForObject(url, Dept[].class);
        if (depts == null) {
            throw new Exception("depts is null");
        }
        return Arrays.asList(depts);
    }
}
