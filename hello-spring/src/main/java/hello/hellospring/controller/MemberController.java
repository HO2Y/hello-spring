package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired//spring bin에 저장된 필요한 @Component 넣어준다.
    public MemberController(MemberService memberService) { //alt + insert
        this.memberService = memberService;
    }
}
