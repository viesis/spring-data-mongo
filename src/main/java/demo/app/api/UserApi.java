package demo.app.api;

import demo.app.domain.User;
import demo.app.domain.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
class UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApi.class);

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String allUsers() {
        log.debug("Listing all users");
        return "All users:" + printAllUsers();
    }

    private String printAllUsers() {
        List<User> users = userRepository.findAll();
        StringBuilder printedUsers = new StringBuilder();
        for (User user : users) {
            printedUsers.append(String.format(" {id: %s, username: %s}", user.getId(), user.getUsername()));
        }

        return printedUsers.toString();
    }

}