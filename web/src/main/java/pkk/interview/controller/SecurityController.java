package pkk.interview.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by root on 19.01.2017.
 */

@Controller
public class SecurityController {

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    public ModelAndView login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            @RequestParam(value = "session_invalid", required = false) String sessionInvalid) {

        ModelAndView model = new ModelAndView();
        if (error != null) {
            model.addObject("error", "Invalid username or password.");
        }

        if (logout != null) {
            model.addObject("msg", "You've been logged out successfully.");
        }

        if (sessionInvalid != null) {
            model.addObject("error", "Your session has been expired.");
        }

        model.setViewName("/login");

        return model;
    }
}
