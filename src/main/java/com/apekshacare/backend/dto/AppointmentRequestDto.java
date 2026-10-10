package com.apekshacare.backend.dto;

import com.apekshacare.backend.model.AppointmentStatus;
import com.apekshacare.backend.model.AppointmentType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentRequestDto(

        @NotBlank
        @Size(max = 100)
        String patientName,

        @NotBlank
        @Size(max = 30)
        String patientReference,

        @NotNull
        AppointmentType appointmentType,

        @NotNull
        @FutureOrPresent
        LocalDate appointmentDate,

        @NotNull
        LocalTime appointmentTime,

        @NotBlank
        @Size(max = 100)
        String department,

        @NotNull
        AppointmentStatus status

) {
}