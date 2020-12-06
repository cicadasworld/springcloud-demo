package com.jin.cloud.controller;

import com.jin.cloud.pojo.Dept;
import com.jin.cloud.service.DeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService service;

    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept")
    public boolean addDept(Dept dept) {
        return service.addDept(dept);
    }

    @GetMapping("/dept/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        return service.getDeptById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> listAll() {
        return service.listAll();
    }

    @GetMapping("/dept/discovery")
    public void discovery() {
        List<String> services = client.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = client.getInstances("SPRING-CLOUD-PRODUCER");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + "\t" +
                    instance.getPort() + "\t" +
                    instance.getUri() + "\t" +
                    instance.getServiceId());
        }
    }
}
