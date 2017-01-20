package pkk.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pkk.interview.controller.message.UserJson;

/**
 * Created by root on 20.01.2017.
 */

@Controller
@RequestMapping(path = "/ajax")
public class AjaxController {

    @RequestMapping(path = "/echo", method = RequestMethod.GET)
    @ResponseBody
    public UserJson echo(@RequestBody UserJson obj) {
        return obj;
    }
}
