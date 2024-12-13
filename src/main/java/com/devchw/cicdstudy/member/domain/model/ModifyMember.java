package com.devchw.cicdstudy.member.domain.model;

import com.devchw.cicdstudy.member.domain.persistence.MemberEntity;

public record ModifyMember(
        Long id,
        String name,
        int age
) {
    public MemberEntity toEntity() {
        return new MemberEntity(name, age);
    }
}
