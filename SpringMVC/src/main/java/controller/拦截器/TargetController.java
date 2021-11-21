package controller.拦截器;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView save(){
        System.out.println("目标资源被执行了！");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","ray");
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
