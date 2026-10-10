package com.apekshacare.backend.service;

import com.apekshacare.backend.model.Appointment;

import java.util.List;

public interface AppointmentService {

    Appointment createAppointment(Appointment appointment);

    Appointment getAppointmentById(Long id);

    List<Appointment> getAllAppointments();

    Appointment updateAppointment(Long id, Appointment appointment);

    void deleteAppointment(Long id);
}