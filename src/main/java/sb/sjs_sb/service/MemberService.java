package sb.sjs_sb.service;

import org.springframework.stereotype.Service;
import sb.sjs_sb.domain.Member;
import sb.sjs_sb.repository.MemberRepository;
import sb.sjs_sb.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    MemberRepository repository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);    // 중복 회원 검증
        repository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        repository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체회원조회
     */
    public List<Member> findMembers(){
        return repository.findAll();
    }

    public Optional<Member> findOne(Long memberId){
        return repository.findById(memberId);
    }
}
