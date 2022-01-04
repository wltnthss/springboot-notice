package sb.sjs_sb.repository;

import sb.sjs_sb.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> infor = new HashMap<>();
    private static Long sequence = 1L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        infor.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(infor.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return infor.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(infor.values());
    }

    public void clearInfor(){
        infor.clear();
    }
}
