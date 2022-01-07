package sb.sjs_sb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sb.sjs_sb.repository.MemberRepository;
import sb.sjs_sb.repository.MemoryMemberRepository;
import sb.sjs_sb.service.MemberService;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
