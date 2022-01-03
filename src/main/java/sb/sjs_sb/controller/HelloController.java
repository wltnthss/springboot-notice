package sb.sjs_sb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @GetMapping("hello-string")
    @ResponseBody   // http 바디부에 데이터를 직접 넣어줌, 문자열 그대로 반환
    public String hello_string(@RequestParam("name") String name){

        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody   // 안붙어잇으면 view로 넘기지만 있을 시에 문자 또는 객체를 json 방식으로 넘겨줌
    public Hello hello_api(@RequestParam("name") String name){

        Hello hello = new Hello();
        hello.setName(name);

        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
