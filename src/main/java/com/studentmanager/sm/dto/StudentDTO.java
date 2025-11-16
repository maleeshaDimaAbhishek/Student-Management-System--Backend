package com.studentmanager.sm.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record StudentDTO(
        @NotBlank(message = "NIC is required")
        String nic,

        @NotBlank(message = "Name is required")
        String name,

        @NotNull(message = "Date of birth is required")
        @Past(message = "Date of birth must be in the past")
        LocalDate dob,

        @NotBlank(message = "Address is required")
        String address,

        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        String email,

        @NotBlank(message = "Phone number is required")
        @Size(min = 7, max = 15, message = "Phone number must be between 7 and 15 characters")
        String phoneNumber,

        @NotBlank(message = "Gender is required")
        String gender
) {
}
