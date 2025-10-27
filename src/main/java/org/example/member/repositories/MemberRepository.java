package org.example.member.repositories;
import org.apache.ibatis.annotations.*;
import org.example.member.models.Member;
import java.util.List;
@Mapper
public interface MemberRepository {

    @Insert("INSERT INTO meta.member (first_name, last_name, email, phone, join_date, status) " +
            "VALUES (#{firstName}, #{lastName}, #{email}, #{phone}, #{joinDate}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "memberId", keyColumn = "member_id")
    void save(Member member);

    @Insert({
            "<script>",
            "INSERT INTO meta.member (first_name, last_name, email, phone, join_date, status) VALUES",
            "<foreach collection='list' item='m' separator=','>",
            "(#{m.firstName}, #{m.lastName}, #{m.email}, #{m.phone}, #{m.joinDate}, #{m.status})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true, keyProperty = "memberId", keyColumn = "member_id")
    void saveAll(@Param("list") List<Member> members);

    @Select("SELECT member_id AS memberId, first_name AS firstName, last_name AS lastName, " +
            "email, phone, join_date AS joinDate, status " +
            "FROM meta.member WHERE member_id = #{memberId}")
    Member findById(@Param("memberId") Long memberId);

    @Select("SELECT member_id AS memberId, first_name AS firstName, last_name AS lastName, " +
            "email, phone, join_date AS joinDate, status " +
            "FROM meta.member ORDER BY member_id LIMIT #{limit} OFFSET #{offset}")
    List<Member> findAll(@Param("limit") int limit, @Param("offset") int offset);

    @Update("UPDATE meta.member SET first_name = #{firstName}, last_name = #{lastName}, " +
            "email = #{email}, phone = #{phone}, join_date = #{joinDate}, status = #{status} " +
            "WHERE member_id = #{memberId}")
    int update(Member member);

    @Delete("DELETE FROM meta.member WHERE member_id = #{memberId}")
    int deleteById(@Param("memberId") Long memberId);

    @Delete({
            "<script>",
            "DELETE FROM meta.member WHERE member_id IN ",
            "<foreach collection='ids' item='id' open='(' separator=',' close=')'>",
            "#{id}",
            "</foreach>",
            "</script>"
    })
    int deleteByIds(@Param("ids") List<Long> ids);

    // COUNT: Total records
    @Select("SELECT COUNT(*) FROM meta.member")
    int countAll();
}
