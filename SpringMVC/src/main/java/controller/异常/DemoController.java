package controller.异常;

import exception.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DemoService;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

@Controller
public class DemoController {

    @Resource(name = "demoService")
    private DemoService demoService;

    @RequestMapping(value = "/show")
    public String show() throws FileNotFoundException, MyException {
        System.out.println("show running......");
        demoService.show1();
        /*demoService.show2();
        demoService.show3();
        demoService.show4();*/
//        demoService.show5();
        return "index";
    }

}
