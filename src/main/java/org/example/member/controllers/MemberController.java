package org.example.member.controllers;

import org.example.member.models.Member;
import org.example.member.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    MemberService memberService;
    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member createMember=memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(createMember);
    }
}
