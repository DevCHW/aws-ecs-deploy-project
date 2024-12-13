package com.devchw.cicdstudy.member.domain;

import com.devchw.cicdstudy.member.domain.model.CreateMember;
import com.devchw.cicdstudy.member.domain.model.Member;
import com.devchw.cicdstudy.member.domain.model.ModifyMember;
import com.devchw.cicdstudy.member.domain.persistence.MemberEntity;
import com.devchw.cicdstudy.member.domain.persistence.MemberRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member save(CreateMember createMember) {
        MemberEntity memberEntity = memberRepository.save(createMember.toEntity());
        return Member.from(memberEntity);
    }

    public Member getMember(Long memberId) {
        MemberEntity memberEntity = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        return Member.from(memberEntity);
    }

    public List<Member> getMembers() {
        List<MemberEntity> memberEntities = memberRepository.findAll();
        return memberEntities.stream()
                .map(Member::from)
                .toList();
    }

    public Member modifyMember(ModifyMember modifyMember) {
        var memberEntity = memberRepository.merge(modifyMember.toEntity(), modifyMember.id());
        return Member.from(memberEntity);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

}
