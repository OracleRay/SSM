package controller.获得请求;

import domain.User;
import domain.VO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/request")
public class Demo {
    /**
     * 获得基本类型参数
     * @param username
     * @param age
     */
    @RequestMapping("/demo1")
    @ResponseBody
    public void save1(String username,int age){
        System.out.println(username);          //zhangsan
        System.out.println(age);          //11
    }
    /**
     * 获得POJO类型
     * POJO的属性名与请求参数的name一致，参数会自动映射匹配
     */
    @RequestMapping("/demo2")
    @ResponseBody
    public void save2(User user){
        System.out.println(user);      //User{username=zhangsan, gender='男'}
    }
    /**
     * 请求数组形式
     */
    @RequestMapping("/demo3")
    @ResponseBody
    public void save3(String[] strs){
        System.out.println(Arrays.asList(strs));       //[aaa, bbb, ccc]
    }
    /**
     * 请求集合类型1
     * 把集合封装到一个POJO中
     */
    @RequestMapping("/demo4")
    @ResponseBody
    public void save4(VO vo) {
        System.out.println(vo);          //加全局过滤器配置可以显示中文
    }
    /**
     * 请求集合类型2
     * 当使用ajax提交时，可以指定contenttype为json属性，
     * 那么方法参数位置使用@RequestBody可以直接接收集合数据而无需使用POJO包装
     */
    @RequestMapping("/demo5")
    @ResponseBody
    public void save5(@RequestBody List<User> userList) {
        System.out.println(userList);  //[User{username=zhangsan, gender='男'}, User{username=lisi, gender='女'}]
    }
    /**
     * 参数绑定注解
     * @param username
     */
    @RequestMapping("/demo6")
    @ResponseBody
    //value:更换提交参数   required：是否必须携带参数     default：默认参数
    public void save6(@RequestParam(value = "name",required = false,defaultValue = "ray") String username){
        System.out.println(username);
    }
    /**
     * Restful风格的参数获取
     * http://localhost:8080/SpringMVC/request/demo7/ray
     */
    @RequestMapping("/demo7/{name}")
    @ResponseBody
    public void save7(@PathVariable(value = "name") String username){
        System.out.println(username);
    }
    /**
     * 自定义类型转换器
     */
    @RequestMapping("/demo8")
    @ResponseBody
    public void save8(Date date){
        System.out.println(date);
    }
}
