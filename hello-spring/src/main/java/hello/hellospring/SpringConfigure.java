package hello.hellospring;

import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfigure {

    private DataSource datasource;

    @Autowired
    public SpringConfigure(DataSource datasource) {

        this.datasource = datasource;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(datasource);
    }
}
