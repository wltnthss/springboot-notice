package sb.sjs_sb.repository;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sb.sjs_sb.domain.Member;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void clearInfor(){
        repository.clearInfor();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();  //optional에서 값을 꺼낼 때 get을 사용
        assertThat(result).isEqualTo(member);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //rename 단축키 : alt + shift + r
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        // 변수 자동생성 ctrl + alt + v
        List<Member> result = repository.findAll();
        assertThat(result.size()).isEqualTo(2);
    }
}
