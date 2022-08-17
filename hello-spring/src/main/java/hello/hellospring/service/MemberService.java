package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //class 에서 ctrl+shift+t를 통해 Test

    private final MemberRepository memberRepository; //ALT + INSERT

    //@AutoWire 여기서는 구현체로 있는 MemoryMemberRepository 를 넣어준다
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     *회원 가입
     */

    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) { //method 변환시 ctrl+shift+alt+t
        memberRepository.findByName(member.getName()) //Optional 안에 Member 객체가 있는것
                .ifPresent(m -> { //null 아니라 값이 있으면 아래 로직 동작 / Optional 이기에 가능
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}

