package com.apekshacare.backend.service.impl;

import com.apekshacare.backend.dto.AppointmentRequestDto;
import com.apekshacare.backend.dto.AppointmentResponseDto;
import com.apekshacare.backend.exception.ResourceNotFoundException;
import com.apekshacare.backend.mapper.AppointmentMapper;
import com.apekshacare.backend.model.Appointment;
import com.apekshacare.backend.repository.AppointmentRepository;
import com.apekshacare.backend.service.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public AppointmentResponseDto createAppointment(
            AppointmentRequestDto request
    ) {
        Appointment appointment = AppointmentMapper.toEntity(request);

        Appointment savedAppointment =
                appointmentRepository.save(appointment);

        return AppointmentMapper.toResponseDto(savedAppointment);
    }

    @Override
    public AppointmentResponseDto getAppointmentById(Long id) {
        Appointment appointment = findAppointmentById(id);

        return AppointmentMapper.toResponseDto(appointment);
    }

    @Override
    public List<AppointmentResponseDto> getAllAppointments() {
        return appointmentRepository.findAll()
                .stream()
                .map(AppointmentMapper::toResponseDto)
                .toList();
    }

    @Override
    public AppointmentResponseDto updateAppointment(
            Long id,
            AppointmentRequestDto request
    ) {
        Appointment appointment = findAppointmentById(id);

        appointment.setPatientName(request.patientName());
        appointment.setPatientReference(request.patientReference());
        appointment.setAppointmentType(request.appointmentType());
        appointment.setAppointmentDate(request.appointmentDate());
        appointment.setAppointmentTime(request.appointmentTime());
        appointment.setDepartment(request.department());
        appointment.setStatus(request.status());

        Appointment updatedAppointment =
                appointmentRepository.save(appointment);

        return AppointmentMapper.toResponseDto(updatedAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        Appointment appointment = findAppointmentById(id);

        appointmentRepository.delete(appointment);
    }

    private Appointment findAppointmentById(Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Appointment not found with id: " + id
                ));
    }
}