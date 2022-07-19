package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository()); //ctrl + p
    }

    @Bean
    public MemberRepository memberRepository() {
        return  new MemoryMemberRepository(); // interface는 new가 안됨 | 구현체로 리턴
    }
}
