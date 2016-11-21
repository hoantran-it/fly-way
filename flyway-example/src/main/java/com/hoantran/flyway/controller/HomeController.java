/**
 * Created by Hoan Tran @ http://hoantran-it.blogspot.com
 *
 * Any modifications to this file must keep this entire header intact.
 *
 */
package com.hoantran.flyway.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hoantran.flyway.entity.UserEntity;
import com.hoantran.flyway.repository.UserRepository;

/**
 * Home controller.
 * 
 * @author HoanTran
 */
@Controller
public class HomeController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(ModelMap model) {

        String message = "Welcome to Spring Framework";
        LOGGER.info("Home controller with welcome message: {}", message);
        model.addAttribute("message", message);

        return "index";

    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    public String getAllUser(ModelMap model) {

        List<UserEntity> userList = userRepository.findAll();
        String message = String.format("User name: %s (Age: %s)", userList.get(0).getUserName(), userList.get(0).getAge());
        model.addAttribute("message", message);
        return "index";

    }
}
