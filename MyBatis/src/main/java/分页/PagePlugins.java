package ��ҳ;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.UserDao;
import domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PagePlugins {
    @Test
    public void test() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        //���÷�ҳ��ز���:��2ҳÿҳ��ʾ3��
        PageHelper.startPage(2,3);
        List<User> userList = mapper.findAll();
        for (User user:userList){
            System.out.println(user);
        }
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println("��ǰҳ�룺" + pageInfo.getPageNum());
        System.out.println("��ҳ����" + pageInfo.getPages());
        System.out.println("�Ƿ������һҳ��" + pageInfo.isIsLastPage());
        sqlSession.close();
    }
}
