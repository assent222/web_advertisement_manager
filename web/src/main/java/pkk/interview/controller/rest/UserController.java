package pkk.interview.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pkk.interview.entity.User;
import pkk.interview.service.UserService;

import java.util.List;

/**
 * Created by root on 24.01.2017.
 */

//@RepositoryRestController
@Controller
@RequestMapping(path = "/")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @RequestMapping(path = "/users")
    @ResponseBody
    public Object findAllOperator(PersistentEntityResourceAssembler esm) {
        User user = service.find(1);

//        ResponseEntity<List> responseEntity = new ResponseEntity<List>(users, HttpStatus.OK);
        return esm.toFullResource(user);
    }

}
