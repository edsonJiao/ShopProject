package com.example.service;

import com.example.pojo.Root;
import org.apache.ibatis.annotations.Param;

public interface RootLoginService {
    Root login( String admin, String password);
}
