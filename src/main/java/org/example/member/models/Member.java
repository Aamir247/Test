package org.example.member.models;

import java.time.LocalDate;

public class Member {

    private Long memberId;

    private String firstName;

    private String lastName;

    private String email;

    private String phone;
    private LocalDate joinDate = LocalDate.now();
    private String status = "active";

    // --- Constructors ---
    public Member() {
    }

    public Member(String firstName, String lastName, String email, String phone, LocalDate joinDate, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.joinDate = joinDate;
        this.status = status;
    }

    // --- Getters and Setters ---
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // --- toString() ---
    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", joinDate=" + joinDate +
                ", status='" + status + '\'' +
                '}';
    }
}