package com.xyxz.service;

import java.util.List;

import com.xyxz.model.sys_user;

public interface UserService {
      public void saveUser(sys_user user);
      public void updateUser(sys_user user);
      public void deleteUser(Long id);
      public sys_user queryUserById(long id);
      public List<sys_user> queryUserListPaged(sys_user user, Integer page, Integer pageSize);
      public List<sys_user> queryUserList();
}
