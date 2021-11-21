package controller;

import domain.Role;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.RoleService;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {
    @Resource(name = "roleService")
    private RoleService roleService;
    @RequestMapping("/list")
    public ModelAndView rolelist(){
        ModelAndView model = new ModelAndView();
        List<Role> roleList = roleService.list();
        //添加模型数据
        model.addObject("roleList",roleList);
        //设置视图名称
        model.setViewName("/pages/role-list");
        return model;
    }
    @RequestMapping("/save")
    public String save(Role role){
        roleService.save(role);
        return "redirect:/role/list";
    }
}
