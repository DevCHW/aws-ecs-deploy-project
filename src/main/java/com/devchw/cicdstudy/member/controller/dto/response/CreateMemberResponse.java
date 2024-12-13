package com.devchw.cicdstudy.member.controller.dto.response;

import com.devchw.cicdstudy.member.domain.model.Member;

public record CreateMemberResponse(
        Long id,
        String name,
        int age
) {
    public static CreateMemberResponse from(Member member) {
        return new CreateMemberResponse(member.id(), member.name(), member.age());
    }
}
