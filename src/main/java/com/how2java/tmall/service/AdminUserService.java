package com.how2java.tmall.service;

import com.how2java.tmall.pojo.AdminUser;

import java.util.List;

public interface AdminUserService {

    void add(AdminUser adminUser);

    void delete(int id);

    void update(AdminUser adminUser);

    AdminUser get(int id);

    List<AdminUser> list();

    boolean isExist(String name);

    AdminUser get(String name,String password);

}
