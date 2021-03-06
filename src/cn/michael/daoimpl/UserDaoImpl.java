package cn.michael.daoimpl;

import cn.michael.dao.UserDao;
import cn.michael.entity.User;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private SqlSessionTemplate sqlSession;

    @Override
    public List<User> selectUser() {
        User user = new User();
        user.setName("Hehe");
        user.setPwd("dddddd");
        sqlSession.insert("cn.michael.entity.UserMapper.addUser", user);
        sqlSession.delete("cn.michael.entity.UserMapper.deleteUser", 20);
        return sqlSession.selectList("cn.michael.entity.UserMapper.selectAll");
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        UserDao userDao = (UserDao) context.getBean("userDao");
        List<User> users = userDao.selectUser();
        System.out.println(users);
    }
}
