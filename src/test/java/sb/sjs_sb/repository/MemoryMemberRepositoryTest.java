package sb.sjs_sb.repository;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import sb.sjs_sb.domain.Member;
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

        Member result = repository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }
}
