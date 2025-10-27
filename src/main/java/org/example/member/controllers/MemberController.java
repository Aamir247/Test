package org.example.member.controllers;
import org.example.member.models.Member;
import org.example.member.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    @PostMapping
    public String createMember(@RequestBody Member member) {
        memberService.save(member);
        return "Member added successfully!";
    }
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.findAll();
    }
    @GetMapping("/api/member")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.findById(id);
    }
    @PutMapping("/api/member")
    public String updateMember(@PathVariable Long id, @RequestBody Member member) {
        member.setMemberId(id);
        boolean updated = memberService.update(member);
        return updated ? "Member updated successfully!" : "Member not found!";
    }
    @DeleteMapping("/api/member")
    public String deleteMember(@PathVariable Long id) {
        boolean deleted = memberService.delete(id);
        return deleted ? "Member deleted successfully!" : "Member not found!";
    }
}

