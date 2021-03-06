package com.example.service.impl;

import com.example.dao.mapper.RootMapper;
import com.example.pojo.Root;
import com.example.service.RootLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("rootLoginService")
public class RootLoginServiceImpl implements RootLoginService{
    @Autowired
    private  RootMapper rootMapper;

    @Override
    public Root login(String admin, String password) {
        Root root=rootMapper.getRoot(admin,password);
        if (root!=null){
            return root;
        }
        return null;
    }
}
