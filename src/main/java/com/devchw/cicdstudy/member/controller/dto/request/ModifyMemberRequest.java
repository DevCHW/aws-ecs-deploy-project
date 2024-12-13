package com.devchw.cicdstudy.member.controller.dto.request;

import com.devchw.cicdstudy.member.domain.model.ModifyMember;

public record ModifyMemberRequest(
        String name,
        int age
) {

    public ModifyMember toDomain(Long memberId) {
        return new ModifyMember(memberId, name, age);
    }
}
