package com.gyf.dao.Impl;

import com.gyf.dao.UserDao;
import com.gyf.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public void save(User user) {
        System.out.println("Dao"+user);
    }
}
