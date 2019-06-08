package com.how2java.tmall.service.impl;

import com.how2java.tmall.mapper.AdminUserMapper;
import com.how2java.tmall.pojo.AdminUser;
import com.how2java.tmall.pojo.AdminUserExample;
import com.how2java.tmall.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    AdminUserMapper adminUserMapper;

    @Override
    public void add(AdminUser adminUser) {
        adminUserMapper.insert(adminUser);
    }

    @Override
    public void delete(int id) {
        adminUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void update(AdminUser adminUser) {
        adminUserMapper.updateByPrimaryKeySelective(adminUser);
    }

    @Override
    public AdminUser get(int id) {
        return adminUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<AdminUser> list() {
        AdminUserExample example = new AdminUserExample();
        example.setOrderByClause("id desc");
        return adminUserMapper.selectByExample(example);
    }

    @Override
    public boolean isExist(String name) {
        boolean flag = false;
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andNameEqualTo(name);
        example.setOrderByClause("id desc");
        List<AdminUser> aus = adminUserMapper.selectByExample(example);
        if(!aus.isEmpty()){
           flag = true;
        }
        return flag;
    }

    @Override
    public AdminUser get(String name, String password) {
        if(null == name || null == password){
            return null;
        }
        AdminUserExample example = new AdminUserExample();
        example.createCriteria().andNameEqualTo(name).andPasswordEqualTo(password);
        List<AdminUser> aus  = adminUserMapper.selectByExample(example);
        if (aus.isEmpty()){
            return null;
        }
        return aus.get(0);
    }
}
