package com.devchw.cicdstudy.member.controller.dto.response;

import com.devchw.cicdstudy.member.domain.model.Member;

public record MembersResponse(
        Long id,
        String name,
        int age
) {
    public static MembersResponse from(Member member) {
        return new MembersResponse(member.id(), member.name(), member.age());
    }

}
