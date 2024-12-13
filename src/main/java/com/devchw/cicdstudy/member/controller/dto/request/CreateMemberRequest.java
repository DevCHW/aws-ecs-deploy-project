package com.devchw.cicdstudy.member.controller.dto.request;

import com.devchw.cicdstudy.member.domain.model.CreateMember;

public record CreateMemberRequest(
        String name,
        int age
) {
    public CreateMember toDomain() {
        return new CreateMember(name, age);
    }
}
