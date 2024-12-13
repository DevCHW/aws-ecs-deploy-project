package com.devchw.cicdstudy.member.domain;

import com.devchw.cicdstudy.member.domain.model.CreateMember;
import com.devchw.cicdstudy.member.domain.model.Member;
import com.devchw.cicdstudy.member.domain.model.ModifyMember;
import com.devchw.cicdstudy.member.domain.persistence.MemberEntity;
import com.devchw.cicdstudy.member.domain.persistence.MemberRepository;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    public void setUp() {
        memberRepository.clear();
    }

    @Test
    void createMember() {
        // given
        CreateMember createMember = new CreateMember("hello", 20);

        // when
        Member result = memberService.save(createMember);

        // then
        assertThat(result.name()).isEqualTo(createMember.name());
        assertThat(result.age()).isEqualTo(createMember.age());
    }

    @Test
    void getMember() {
        // given
        MemberEntity memberEntity = memberRepository.save(new MemberEntity("userA", 20));

        // when
        var result = memberService.getMember(memberEntity.getId());

        // then
        assertThat(result.name()).isEqualTo(memberEntity.getName());
        assertThat(result.age()).isEqualTo(memberEntity.getAge());
    }

    @Test
    void getMembers() {
        // given
        MemberEntity memberEntity1 = memberRepository.save(new MemberEntity("userA", 20));
        MemberEntity memberEntity2 = memberRepository.save(new MemberEntity("userB", 21));

        // when
        var result = memberService.getMembers();

        // then
        assertThat(result)
                .hasSize(2)
                .extracting("name", "age")
                .containsExactlyInAnyOrder(
                        Tuple.tuple(memberEntity1.getName(), memberEntity1.getAge()),
                        Tuple.tuple(memberEntity2.getName(), memberEntity2.getAge())
                );
    }

    @Test
    void updateMember() {
        // given
        MemberEntity memberEntity = memberRepository.save(new MemberEntity("userA", 20));
        ModifyMember modifyMember = new ModifyMember(memberEntity.getId(), memberEntity.getName(), memberEntity.getAge());

        // when
        Member result = memberService.modifyMember(modifyMember);

        // then
        assertThat(result.name()).isEqualTo(memberEntity.getName());
        assertThat(result.age()).isEqualTo(memberEntity.getAge());
    }

    @Test
    void deleteMember() {
        // given
        MemberEntity memberEntity = memberRepository.save(new MemberEntity("userA", 20));
        memberService.deleteMember(memberEntity.getId());

        // when
        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(memberEntity.getId());

        // then
        assertThat(memberEntityOptional.isPresent()).isFalse();
    }
}