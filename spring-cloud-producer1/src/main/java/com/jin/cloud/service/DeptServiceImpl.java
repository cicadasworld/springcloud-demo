package com.jin.cloud.service;

import com.jin.cloud.mapper.DeptMapper;
import com.jin.cloud.pojo.Dept;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper mapper;

    @Override
    public boolean addDept(Dept dept) {
        return mapper.addDept(dept);
    }

    @Override
    public Dept getDeptById(Long id) {
        return mapper.getDeptById(id);
    }

    @Override
    public List<Dept> listAll() {
        return mapper.listAll();
    }
}
