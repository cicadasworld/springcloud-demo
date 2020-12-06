package com.jin.cloud.servie;

import com.jin.cloud.pojo.Dept;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
@FeignClient(value = "SPRING-CLOUD-PRODUCER", fallbackFactory = DeptServiceFallbackFactory.class)
public interface DeptService {

    @PostMapping("/dept")
    boolean addDept(Dept dept);

    @GetMapping("/dept/{id}")
    Dept getDeptById(Long id);

    @GetMapping("/dept/list")
    List<Dept> listAll();
}
