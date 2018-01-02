package com.example.dao.mapper;

import com.example.pojo.Root;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value = "rootMapper")
public interface RootMapper {
    Root getRoot(@Param("admin") String admin,@Param("password") String password);
}
