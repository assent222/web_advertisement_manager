package pkk.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pkk.interview.controller.message.UserJson;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by root on 20.01.2017.
 */

@Controller
@RequestMapping(path = "/ajax")
public class AjaxController {

    @RequestMapping("/get_json")
    @ResponseBody
    public Map getJson() {
        Map map = new HashMap();
        map.put("hello", "world");
        return map;
    }

    @RequestMapping("/echo")
    @ResponseBody
    public UserJson echo(@RequestBody UserJson obj) {
        return obj;
    }

    /*
    $.ajax({
        type: 'post',
                url: 'http://localhost:8080/test/ajax/echo',
                data: JSON.stringify({"a":"123"}),
        contentType: "application/json; charset=utf-8",
    }).done(function (data) {
        console.dir(data);
    });
    */
}
