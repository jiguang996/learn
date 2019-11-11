package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.model.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

public class MybatisTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");

        //2.创建sqlsessionfactory对象
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory=builder.build(in);
        //3.使用工厂创建Sqlsession对象
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //4.使用sqlsession创建Dao接口的代理对象
        IUserDao iUserDao=sqlSession.getMapper(IUserDao.class);
        //5.使用代理对象执行方法
        List<User> users=iUserDao.findAll();
        for (User u:users){
            System.out.println(u);
        }
        //6.释放资源
        sqlSession.close();
        in.close();
    }
}
