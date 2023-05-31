package workflow.presentaion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HomeController {

    @GetMapping("home")
    String home() {
        return "home";
    }

    @GetMapping
    String index() {
        return "home";
    }
}
