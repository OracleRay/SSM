package SpringJunitTest;

/**
 *  让SpringJunit负责创建Spring容器，但是需要将配置文件的名称告诉它
 *  将需要进行测试Bean直接在测试类中进行注入
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
//导入spring集成Junit的坐标,使用@Runwith注解替换原来的运行期
@RunWith(SpringJUnit4ClassRunner.class)
//使用@ContextConfiguration指定配置文件或配置类
@ContextConfiguration("classpath:applicationContext.xml")
//@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {
    //使用@Autowired注入需要测试的对象
    @Autowired
    private UserService userService;
    @Autowired
    private DataSource dataSource;
    //创建测试方法进行测试
    @Test
    public void test1() throws SQLException {
        userService.save();
        System.out.println(dataSource.getConnection());
    }
}
