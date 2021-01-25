package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService; // new 대신 컨테이너에 등록해서 사용함

    @Autowired //연결해줌, dependency injection
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }


    @GetMapping("/members/new")
    public String CreateForm(){

        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        //System.out.println("member = " + member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMember();
        model.addAttribute("members", members);

        return "members/memberList";
    }
    /*
    @Autowired
    public void setMemberService(MemberService memberService){
        this.memberService = memberService;
    }
     set injection : public 하게 노출이 됨
     */
}
