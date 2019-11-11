package com.itheima.dao;

import com.itheima.model.QueryVo;
import com.itheima.model.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
    void saveUser(User user);
    void updateUser(User user);

    /**
     * 根据id删除
     * @param id
     */
    void deleteUser(Integer id);
    /**
     * 根据id删除
     * @param id
     * @return
     */
    User  findUserByID(Integer id);

    /**
     * 根据username模糊查询
     * @param username
     * @return
     */
    List<User> findByUsername(String username);

    List<User> findByVo(QueryVo  vo);

}
