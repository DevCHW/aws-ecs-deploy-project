package com.devchw.cicdstudy.member.domain.model;

import com.devchw.cicdstudy.member.domain.persistence.MemberEntity;

public record Member(
        Long id,
        String name,
        int age
) {
    public static Member from(MemberEntity memberEntity) {
        return new Member(memberEntity.getId(), memberEntity.getName(), memberEntity.getAge());
    }
}
