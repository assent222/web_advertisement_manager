package pkk.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 18.01.2017.
 */

@Controller
public class HelloController {

    @RequestMapping("/hello/")
    public String hello(){
        return "index";
    }
}
