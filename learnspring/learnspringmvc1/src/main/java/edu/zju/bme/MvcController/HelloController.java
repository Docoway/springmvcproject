package main.java.edu.zju.bme.MvcController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/hello")
public class HelloController {

    @GetMapping(value="/")
    public String printHello(){
        return "hello";
    }

}
