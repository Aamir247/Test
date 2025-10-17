package org.example.member.services;

import org.example.member.models.Member;
import org.example.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
    @Autowired MemberRepository memberRepository;
    public Member createMember(Member member){
        memberRepository.save(member);
        return member;
    }

}
