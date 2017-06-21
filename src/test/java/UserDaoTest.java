import com.dy.dao.UserDao;
import com.dy.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * Created by shaoyongkai on 2017/6/21.
 */
public class UserDaoTest {

    @Test
    public void findUserById() {
        SqlSession sqlSession = getSessionFactory().openSession();
        UserDao userMapper = sqlSession.getMapper(UserDao.class);
        User user = userMapper.findUserById(2);
        System.out.println("查找某个用户：" + user.getName());
//        Assert.assertNotNull("没找到数据", user);
    }

    // mybatis会通过mapper文件配置把保存后的主键放到当前对象的id里面
//    @Test
//    public void insert() throws Exception {
//        sqlSession = sqlSessionFactory.openSession();
//        User user = new User("je-ge", 22);
//        System.out.println("保存之前：" + user);
//
//        sqlSession.insert(NAME_SPACE + ".insert", user);
//        sqlSession.commit();
//
//        System.out.println("保存之后：" + user);
//        System.out.println("+++++++++++++++");
//    }
//
//    @Test
//    public void update() throws Exception {
//        insert();
//
//        User user = sqlSession.selectOne(NAME_SPACE + ".findByKey", 1L);
//        System.out.println("修改前：" + user);
//
//        user.setName("JE-GE");
//        user.setAge(18);
//        sqlSession.update(NAME_SPACE + ".update", user);
//        sqlSession.commit();
//
//        user = sqlSession.selectOne(NAME_SPACE + ".findByKey", 1L);
//        System.out.println("修改后：" + user);
//    }
//
//    @Test
//    public void findByKey() throws Exception {
//        User user = sqlSession.selectOne(NAME_SPACE + ".findByKey", 1L);
//        System.out.println(user);
//    }
//
//    @Test
//    public void findAll() throws Exception {
//        List<User> users = sqlSession.selectList(NAME_SPACE + ".findAll");
//        for (User user : users) {
//            System.out.println(user);
//        }
//    }
//
//    @Test
//    public void delete() throws Exception {
//        User user = sqlSession.selectOne(NAME_SPACE + ".findByKey", 1L);
//        System.out.println("删除前：" + user);
//
//        sqlSession.delete(NAME_SPACE + ".delete", 1L);
//        sqlSession.commit();
//
//        user = sqlSession.selectOne(NAME_SPACE + ".findByKey", 1L);
//        System.out.println("删除后：" + user);
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        if (sqlSession != null)
//            sqlSession.close();
//    }

    //Mybatis 通过SqlSessionFactory获取SqlSession, 然后才能通过SqlSession与数据库进行交互
    private static SqlSessionFactory getSessionFactory() {
        SqlSessionFactory sessionFactory = null;
        String resource = "configuration.xml";
        try {
            sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sessionFactory;
    }

}

