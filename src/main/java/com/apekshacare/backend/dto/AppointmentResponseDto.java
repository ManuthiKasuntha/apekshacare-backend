package com.apekshacare.backend.dto;

import com.apekshacare.backend.model.AppointmentStatus;
import com.apekshacare.backend.model.AppointmentType;

import java.time.LocalDate;
import java.time.LocalTime;

public record AppointmentResponseDto(
        Long id,
        String patientName,
        String patientReference,
        AppointmentType appointmentType,
        LocalDate appointmentDate,
        LocalTime appointmentTime,
        String department,
        AppointmentStatus status
) {
}