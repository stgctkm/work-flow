package workflow.presentaion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class HelloController {
    @GetMapping("hello")
    String hello() {
        return "hello";
    }
}
