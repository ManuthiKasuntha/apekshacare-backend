package com.apekshacare.backend.service;

import com.apekshacare.backend.dto.AppointmentRequestDto;
import com.apekshacare.backend.dto.AppointmentResponseDto;

import java.util.List;

public interface AppointmentService {

    AppointmentResponseDto createAppointment(AppointmentRequestDto request);

    AppointmentResponseDto getAppointmentById(Long id);

    List<AppointmentResponseDto> getAllAppointments();

    AppointmentResponseDto updateAppointment(
            Long id,
            AppointmentRequestDto request
    );

    void deleteAppointment(Long id);
}