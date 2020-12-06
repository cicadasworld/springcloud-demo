package com.jin.cloud.mapper;

import com.jin.cloud.pojo.Dept;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DeptMapper {

    boolean addDept(Dept dept);

    Dept getDeptById(Long id);

    List<Dept> listAll();
}
