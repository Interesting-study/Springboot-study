package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService; // new 대신 컨테이너에 등록해서 사용함

    @Autowired //연결해줌, dependency injection
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /*
    @Autowired
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }
     set injection : public 하게 노출이 됨
     */
}
