package com.apekshacare.backend.mapper;

import com.apekshacare.backend.dto.AppointmentRequestDto;
import com.apekshacare.backend.dto.AppointmentResponseDto;
import com.apekshacare.backend.model.Appointment;

public final class AppointmentMapper {

    private AppointmentMapper() {
        // Utility class - prevent object creation
    }

    public static Appointment toEntity(AppointmentRequestDto dto) {
        Appointment appointment = new Appointment();

        appointment.setPatientName(dto.patientName());
        appointment.setPatientReference(dto.patientReference());
        appointment.setAppointmentType(dto.appointmentType());
        appointment.setAppointmentDate(dto.appointmentDate());
        appointment.setAppointmentTime(dto.appointmentTime());
        appointment.setDepartment(dto.department());
        appointment.setStatus(dto.status());

        return appointment;
    }

    public static AppointmentResponseDto toResponseDto(Appointment appointment) {
        return new AppointmentResponseDto(
                appointment.getId(),
                appointment.getPatientName(),
                appointment.getPatientReference(),
                appointment.getAppointmentType(),
                appointment.getAppointmentDate(),
                appointment.getAppointmentTime(),
                appointment.getDepartment(),
                appointment.getStatus()
        );
    }
}