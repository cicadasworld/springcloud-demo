package com.jin.cloud.controller;

import com.jin.cloud.pojo.Dept;
import com.jin.cloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

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

    @HystrixCommand(fallbackMethod = "getDeptByIdWithHystrix")
    @GetMapping("/dept/{id}")
    public Dept getDeptById(@PathVariable("id") Long id) {
        Dept dept = service.getDeptById(id);
        if (dept == null) {
            throw new RuntimeException("部门Id: " + id + "不存在");
        }
        return dept;
    }

    public Dept getDeptByIdWithHystrix(Long id) {
        return new Dept()
                .setDeptno(id)
                .setDname("Id为" + id + "的部门不存在")
                .setDb_source("no database source");
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
