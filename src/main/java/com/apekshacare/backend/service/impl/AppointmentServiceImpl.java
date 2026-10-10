package com.apekshacare.backend.service.impl;

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
    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment existingAppointment =
                appointmentRepository.findById(id).orElse(null);

        if (existingAppointment == null) {
            return null;
        }

        existingAppointment.setPatientName(appointment.getPatientName());
        existingAppointment.setPatientReference(appointment.getPatientReference());
        existingAppointment.setAppointmentType(appointment.getAppointmentType());
        existingAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existingAppointment.setAppointmentTime(appointment.getAppointmentTime());
        existingAppointment.setDepartment(appointment.getDepartment());
        existingAppointment.setStatus(appointment.getStatus());

        return appointmentRepository.save(existingAppointment);
    }

    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }
}