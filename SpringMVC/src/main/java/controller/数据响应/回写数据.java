package controller.数据响应;

import com.fasterxml.jackson.databind.ObjectMapper;
import domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/response")
public class 回写数据 {
    @RequestMapping(value = "/springMVCServlet5")
    public void save1(HttpServletResponse response) throws IOException {
        response.getWriter().write("<h1>hello,response!!!</h1>");
    }
    @RequestMapping(value = "/springMVCServlet6",produces = {"text/html;charset=UTF-8"})
    @ResponseBody             //告诉SpringMVC不进行视图跳转
    public ResponseEntity<String> save2(HttpServletResponse response) throws IOException{
        response.setContentType("text/html;charset=utf-8");
        //当请求方法在带有返回值的情况下，在controller中设置content-type是无效的，会被消息转换器覆盖掉。用produces属性
        return ResponseEntity.ok("<h1>直接返回字符串方法</h1>");
    }

    /**
     * 回写json格式
     * @return
     */
    @RequestMapping(value = "/springMVCServlet7")
    @ResponseBody             //告诉SpringMVC不进行视图跳转
    public String save3() throws IOException{
        User user = new User();
        user.setUsername("zhangsan");
        user.setGender("man");
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        return json;
    }
    /**
     * 回写json（使用springMVC框架）
     * 回写对象
     * @return
     */
    @RequestMapping(value = "/springMVCServlet8")
    @ResponseBody             //可以实现对json格式的转换
    public User save4() throws IOException{
        User user = new User();
        user.setUsername("zhangsan");
        user.setGender("man");
        return user;
    }
}
