package SpringJunitTest;

/**
 *  ��SpringJunit���𴴽�Spring������������Ҫ�������ļ������Ƹ�����
 *  ����Ҫ���в���Beanֱ���ڲ������н���ע��
 */

import AnnotationTest.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.UserService;

import javax.sql.DataSource;
import java.sql.SQLException;
//����spring����Junit������,ʹ��@Runwithע���滻ԭ����������
@RunWith(SpringJUnit4ClassRunner.class)
//ʹ��@ContextConfigurationָ�������ļ���������
@ContextConfiguration("classpath:applicationContext.xml")
//@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    //ʹ��@Autowiredע����Ҫ���ԵĶ���
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
    //�������Է������в���
    @Test
    public void test1() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
