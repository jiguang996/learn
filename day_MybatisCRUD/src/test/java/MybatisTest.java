import com.itheima.dao.IUserDao;
import com.itheima.model.QueryVo;
import com.itheima.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession ;
    private IUserDao userDao;
    @Before
    public  void  init() throws IOException {
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder= new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        sqlSession = factory.openSession();
        userDao=sqlSession.getMapper(IUserDao.class);
    }
    @After
    public  void destory() throws Exception {
        sqlSession.commit();
        sqlSession.close();;
        in.close();
    }


    @Test
    public void  testFindAll() {

        List<User> users= userDao.findAll();
        for (User  u:users){
            System.out.println(u);
        }
    }


    @Test
    public  void testSave() throws IOException {
        User user1= new User();
        user1.setAddress("1111111111");
        user1.setDate(new Date());
        user1.setSex("male");
        user1.setUsername("jijibooom");
        userDao.saveUser(user1);

    }

    @Test
    public  void testUpdateUser() throws IOException {
        User user1= new User();
        user1.setId(111);
        user1.setAddress("fujian");
        user1.setDate(new Date());
        user1.setSex("man");
        user1.setUsername("jijibooooooooom");
        userDao.updateUser(user1);

    }

    @Test
    public  void testDeleteUser()  {


        userDao.deleteUser(111);

    }

    @Test
    public  void testFindUsertById()  {


        User user=userDao.findUserByID(113);
        System.out.println(user);

    }

    @Test
    public  void testFindUsertByUsername()  {

        List<User> users=userDao.findByUsername("%ji");
        for(User u:users){
            System.out.println(u);
        }


    }

    @Test
    public  void testFindByVo()  {
        QueryVo vo= new QueryVo();
        User user =new User();
        user.setUsername("%ji");
        vo.setUser(user);
        List<User> users=userDao.findByVo(vo);
        for(User u:users){
            System.out.println(u);
        }


    }
}
