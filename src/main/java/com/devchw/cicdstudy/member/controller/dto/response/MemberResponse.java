package com.devchw.cicdstudy.member.controller.dto.response;

import com.devchw.cicdstudy.member.domain.model.Member;

public record MemberResponse(
        Long id,
        String name,
        int age
) {
    public static MemberResponse from(Member member) {
        return new MemberResponse(member.id(), member.name(), member.age());
    }
}
