package com.example.service;

import com.example.pojo.Root;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public interface RootLoginService {
    Root login( String admin, String password);
}
