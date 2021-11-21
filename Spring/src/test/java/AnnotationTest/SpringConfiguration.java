package AnnotationTest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
//<context:component-scan base-package="dao"/>
//<context:component-scan base-package="service"/>
@ComponentScan("dao")
@ComponentScan("service")
//<import resource="applicationContext-datasource.xml" />
@Import(DataSourceConfiguration.class)
public class SpringConfiguration {

}
