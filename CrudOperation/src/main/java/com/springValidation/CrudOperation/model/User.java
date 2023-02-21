package com.springValidation.CrudOperation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "crud_op")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @NotNull(message = "Please Enter User Id")
    private int userId;

    @Column(name = "user_name", nullable = false)
    @Size(min = 4, max = 16, message = "username must be between 4 to 16 characters")
    @NotNull(message = "Please Enter User Name")
    private String username;

    @Column(name = "date_Of_Birth", nullable = false)
    @NotNull(message = "Please Enter Date of Birth")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date of birth should be in the format DD-MM-YYYY")
    private String dateOfBirth;

    @Column(name = "email", nullable = false)
    @NotNull(message = "Please Enter Email address")
    @Email(message = "Invalid Email format ")
    private String email;

    @Column(name = "phone_number", nullable = false)
    @NotNull(message = "Please Enter Phone Number")
    @Pattern(regexp = "\\d{2}-\\d{10}", message = "Phone number should be in format xx-xxxxxxxxxx with first two digits as country code")
    private String phoneNumber;

    @Column(name = "date", nullable = false)
    @NotNull(message = "Please Enter Date")
    @Pattern(regexp = "\\d{2}-\\d{2}-\\d{4}", message = "Date should be in the format DD-MM-YYYY")
    private String date;

    @Column(name = "time", nullable = false)
    @NotNull(message = "please Enter Time")
    @Pattern(regexp = "\\d{2}:\\d{2}", message = "Time should be in the format hh:MM")
    private String time;

}
