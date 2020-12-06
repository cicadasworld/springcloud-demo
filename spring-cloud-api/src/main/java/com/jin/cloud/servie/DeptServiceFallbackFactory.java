package com.jin.cloud.servie;

import com.jin.cloud.pojo.Dept;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import feign.hystrix.FallbackFactory;

@Component
public class DeptServiceFallbackFactory implements FallbackFactory {

    @Override
    public DeptService create(Throwable cause) {
        return new DeptService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept getDeptById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("Id为" + id + "的部门不存在")
                        .setDb_source("no database source");
            }

            @Override
            public List<Dept> listAll() {
                return new ArrayList<>();
            }
        };
    }
}
