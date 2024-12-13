package com.devchw.cicdstudy.member.controller.dto.response;

import com.devchw.cicdstudy.member.domain.model.Member;

public record ModifyMemberResponse(
        Long id,
        String name,
        int age
) {
    public static ModifyMemberResponse from(Member member) {
        return new ModifyMemberResponse(member.id(), member.name(), member.age());
    }
}
