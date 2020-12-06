package com.jin.cloud.service;

import com.jin.cloud.pojo.Dept;

import java.util.List;

public interface DeptService {

    boolean addDept(Dept dept);

    Dept getDeptById(Long id);

    List<Dept> listAll();
}
