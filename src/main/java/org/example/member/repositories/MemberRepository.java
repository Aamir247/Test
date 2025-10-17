package org.example.member.repositories;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.example.member.models.Member;

@Mapper
public interface MemberRepository {
    @Insert("INSERT INTO meta.member (first_name, last_name, email, phone, join_date, status) " +
            "VALUES (#{firstName}, #{lastName}, #{email}, #{phone}, #{joinDate}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "memberId")

    void save(Member member);


}
