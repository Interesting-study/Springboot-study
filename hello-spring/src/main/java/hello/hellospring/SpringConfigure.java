package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigure {

    //private EntityManager em;
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfigure(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    //@Autowired
    /*public SpringConfigure(EntityManager em) {
        this.em = em;
    }*/

    /*private DataSource dataSource;

    @Autowired
    public SpringConfigure(DataSource dataSource) {

        this.dataSource = dataSource;
    }*/

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository);
    }

    /* Aop 첫번째 방법
    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }*/

    /*@Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }*/
}
