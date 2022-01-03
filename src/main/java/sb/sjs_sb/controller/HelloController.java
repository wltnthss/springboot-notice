package sb.sjs_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){

        model.addAttribute("data", "hello!!!");
        model.addAttribute("name", "son");

        return "hello";
    }

    @GetMapping("hello-mvc")
    public String hello_mvc(@RequestParam("name") String name, Model model){

        model.addAttribute("name", name);

        return "hello-template";
    }
}
