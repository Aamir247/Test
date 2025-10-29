package org.example.member.services;
import org.example.member.models.Member;
import org.example.member.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
@Service
@Transactional
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;
    public Member createMember(Member member) {
        if (member.getJoinDate() == null) {
            member.setJoinDate(LocalDate.now());
        }
        memberRepository.save(member);
        return member;
    }

    public List<Member> createBulkMembers(List<Member> members) {
        for (Member m : members) {
            if (m.getJoinDate() == null) {
                m.setJoinDate(LocalDate.now());
            }
        }
        memberRepository.saveAll(members);
        return members;
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id);
    }

    public List<Member> getMembers(int page, int size) {
        int offset = page * size;
        return memberRepository.findAll(size, offset);
    }

    public Member updateMember(Member member) {
        Member existing = memberRepository.findById(member.getMemberId());
        if (existing == null) {
            return null;
        }
        existing.setFirstName(member.getFirstName());
        existing.setLastName(member.getLastName());
        existing.setEmail(member.getEmail());
        existing.setPhone(member.getPhone());
        existing.setJoinDate(member.getJoinDate());
        existing.setStatus(member.getStatus());
        memberRepository.update(existing);
        return existing;
    }

    public boolean deleteMember(Long id) {
        return memberRepository.deleteById(id) > 0;
    }

    public boolean deleteMembers(List<Long> ids) {
        return memberRepository.deleteByIds(ids) > 0;
    }

    public int countMembers() {
        return memberRepository.countAll();
    }
}

