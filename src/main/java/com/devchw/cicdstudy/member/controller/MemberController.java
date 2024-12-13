package com.devchw.cicdstudy.member.controller;

import com.devchw.cicdstudy.member.controller.dto.request.CreateMemberRequest;
import com.devchw.cicdstudy.member.controller.dto.request.ModifyMemberRequest;
import com.devchw.cicdstudy.member.controller.dto.response.CreateMemberResponse;
import com.devchw.cicdstudy.member.controller.dto.response.MemberResponse;
import com.devchw.cicdstudy.member.controller.dto.response.MembersResponse;
import com.devchw.cicdstudy.member.controller.dto.response.ModifyMemberResponse;
import com.devchw.cicdstudy.member.domain.MemberService;
import com.devchw.cicdstudy.member.domain.model.Member;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/api/v1/members/{memberId}")
    public MemberResponse getMember(@PathVariable Long memberId) {
        var data = memberService.getMember(memberId);
        return MemberResponse.from(data);
    }

    @GetMapping("/api/v1/members")
    public List<MembersResponse> getMembers() {
        var data = memberService.getMembers();
        return data.stream()
                .map(MembersResponse::from)
                .toList();
    }

    @PostMapping("/api/v1/members")
    public CreateMemberResponse createMember(@RequestBody CreateMemberRequest request) {
        var data = memberService.save(request.toDomain());
        return CreateMemberResponse.from(data);
    }


    @PutMapping("/api/v1/members/{memberId}")
    public ModifyMemberResponse modifyMember(
            @PathVariable Long memberId,
            @RequestBody ModifyMemberRequest request) {
        var data = memberService.modifyMember(request.toDomain(memberId));
        return ModifyMemberResponse.from(data);
    }

    @DeleteMapping("/api/v1/members/{memberId}")
    public void deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
    }
}
