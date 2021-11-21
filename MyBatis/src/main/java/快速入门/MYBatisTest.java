package ��������;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MYBatisTest {
    /**
     * ��ѯ
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�ػ�����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        List<User> userList = sqlSession.selectList("userMapper.findAll");
        //��ӡ����
        System.out.println(userList);
        //�ͷ���Դ
        sqlSession.close();
    }

    /**
     * ����
     * @throws IOException
     */
    @Test
    public void test2() throws IOException {
        User user = new User();
        user.setUsername("ray");
        user.setPassword("abc");
        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        sqlSession.insert("userMapper.insert",user);
        //�ύ����
        sqlSession.commit();
        //�ͷ���Դ
        sqlSession.close();
    }
    /**
     * �޸�
     * @throws IOException
     */
    @Test
    public void test3() throws IOException {
        User user = new User();
        user.setId(6);
        user.setUsername("ray");
        user.setPassword("111");
        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        sqlSession.update("userMapper.update",user);
        //�ύ����
        sqlSession.commit();
        //�ͷ���Դ
        sqlSession.close();
    }
    /**
     * ɾ��
     * @throws IOException
     */
    @Test
    public void test4() throws IOException {
        //��ú��������ļ�
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //���session��������
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //���session�Ự����
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //ִ�в��� ������namespace+id
        sqlSession.delete("userMapper.delete",4);
        //�ύ����
        sqlSession.commit();
        //�ͷ���Դ
        sqlSession.close();
    }
}
