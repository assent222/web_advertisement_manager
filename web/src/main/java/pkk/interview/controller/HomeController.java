package pkk.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by root on 19.01.2017.
 */

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }
}
