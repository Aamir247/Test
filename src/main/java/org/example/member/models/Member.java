package org.example.member.models;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
public class Member {
    private Long memberId;
    @NotBlank(message = "firstName is mandatory")
    @Size(max = 100)
    private String firstName;
    @NotBlank(message = "lastName is mandatory")
    @Size(max = 100)
    private String lastName;
    @NotBlank(message = "email is mandatory")
    @Email(message = "email must be valid")
    private String email;
    @NotBlank(message = "mobileNumber is mandatory")
    @Pattern(regexp = "^\\+?[0-9]{7,15}$", message = "mobileNumber must be valid")
    private String phone;
    private LocalDate joinDate = LocalDate.now();
    private String status = "active";
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
