package jdbcDemo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCTemplateDemo {
    @Test
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate template = app.getBean(JdbcTemplate.class);
        //int row = template.update("insert into db1.account (name,balance) values(?,?)", "lei", 10000);
        int row = template.update("insert into db1.account values(?,?,?)", null,"www", 10000);
        System.out.println(row);
    }

}
