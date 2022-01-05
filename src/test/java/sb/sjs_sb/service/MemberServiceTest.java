package sb.sjs_sb.service;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sb.sjs_sb.domain.Member;
import sb.sjs_sb.repository.MemberRepository;
import sb.sjs_sb.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

// test 코드 작성 시 MemberService파일에서 단축키 Ctrl + Shift + T를 통해서 바로 생성
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    // DI 설정
    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void clear(){
        memoryMemberRepository.clearInfor();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long result = memberService.join(member);

        //then
        Member findName = memoryMemberRepository.findById(result).get();
        assertEquals(findName.getName(), member.getName());
    }

    @Test
    void 중복회원검증(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);

        // memberservice.join(member2)로직을 넣었을 때 예외가 발생
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");



//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e){
//            Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then
    }

    @Test
    void findMembers() {

    }

    @Test
    void findOne() {
    }
}