package org.example.member.controllers;
import org.example.member.models.Member;
import org.example.member.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member){
        Member createdMember = memberService.createMember(member);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdMember);
    }

    @GetMapping
    public List<Member> getAllMembers(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        return memberService.getMembers(page, size);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Member> updateMember(@PathVariable Long id, @RequestBody Member member) {
        member.setMemberId(id);
        Member updated = memberService.updateMember(member);
        return updated != null ?
                ResponseEntity.ok(updated) :
                ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.deleteMember(id);
        return deleted ?
                ResponseEntity.ok("Member deleted successfully!") :
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Member not found!");
    }
}
