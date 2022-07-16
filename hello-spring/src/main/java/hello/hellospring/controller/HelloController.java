package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!!");
        return "hello"; //templates 안에 있는 hello.html로 리턴
    }

    @GetMapping("hello-mvc")
    public  String helloMvc(@RequestParam("name") String name, Model model)//모델에 담으면 뷰에서 렌더링할때 사용
    {
        model.addAttribute("name", name);
        return "hello-template"; //templates 안에 있는 hello-template 리턴
    }

    @GetMapping("hello-string")
    @ResponseBody //http body 부분에 내용 삽입
    public  String helloString(@RequestParam("name") String name){
        return  "hello "+name;
    }

    @GetMapping("hello-api") //실무에서 Api 사용시 일반적으로 이 구조 사용 Json 스타일로 반환
    @ResponseBody
    public Hello HelloApi(@RequestParam("name") String name){
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
