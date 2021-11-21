package controller.获得请求;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/request")
public class Uplode {
    @RequestMapping("/uplode")
    @ResponseBody
    public void uplode(String username, MultipartFile uplodeFile) throws IOException {
        System.out.println(username);
        System.out.println(uplodeFile);
        String originalFilename = uplodeFile.getOriginalFilename();
        uplodeFile.transferTo(new File("D:\\" + originalFilename));
    }
}
