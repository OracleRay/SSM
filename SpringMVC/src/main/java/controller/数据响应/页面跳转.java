package controller.数据响应;

/**
 * 页面跳转
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/response")
public class 页面跳转 {
    /**
     * 返回字符串方法
     * @return
     */
    //params为必须携带的参数
    @RequestMapping(value = "/springMVCServlet1",method = RequestMethod.GET,params = {"username"})
    public String save1(){
        System.out.println("返回字符串方法");
        //默认为forward：，若需要重定向，则需要在""里加redirece:
        return "success";                       //已配置内部资源适配器，无需写前缀和后缀
    }

    /**
     * 返回ModelAndView对象方法
     * Model:作为封装数据
     * View：作为展示数据
     * @return
     */
    @RequestMapping(value = "/springMVCServlet2")
    public ModelAndView save2(){
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("username","返回ModelAndView对象方法");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    /**
     * 返回Model对象
     * @param model
     * @return
     */
    @RequestMapping(value = "/springMVCServlet3")
    public String save3(Model model){
        //添加模型数据
        model.addAttribute("username","返回Model对象");
        return "success";
    }
    /**
     * 调用request域对象
     * @return
     */
    @RequestMapping(value = "/springMVCServlet4")
    public String save4(HttpServletRequest request){
        //添加模型数据
        request.setAttribute("username","调用request域对象");
        return "success";
    }
}
