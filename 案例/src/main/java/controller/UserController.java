package controller;

import domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource(name = "userService")
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView userlist(){
        ModelAndView model = new ModelAndView();
        List<User> userList = userService.list();
        //添加模型数据
        model.addObject("userList",userList);
        //设置视图名称
        model.setViewName("/pages/user-list");
        return model;
    }
    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = userService.login(username,password);
        if(user != null){
            //登录成功
            session.setAttribute("user",user);
            return "redirect:/index";
        }else{
            return "redirect:/login";
        }
    }
}
