package notification.presentaion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class AdminController {
    @GetMapping("admin")
    String admin() {
        return "admin";
    }
}
