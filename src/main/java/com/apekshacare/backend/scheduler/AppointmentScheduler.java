package com.apekshacare.backend.scheduler;

import com.apekshacare.backend.model.Appointment;
import com.apekshacare.backend.model.AppointmentStatus;
import com.apekshacare.backend.repository.AppointmentRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class AppointmentScheduler {

    private final AppointmentRepository appointmentRepository;

    public AppointmentScheduler(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void checkTodaysAppointments() {
        LocalDate today = LocalDate.now();

        appointmentRepository.findAll()
                .stream()
                .filter(appointment ->
                        appointment.getAppointmentDate().equals(today))
                .filter(appointment ->
                        appointment.getStatus() == AppointmentStatus.SCHEDULED)
                .forEach(this::processAppointmentReminder);
    }

    private void processAppointmentReminder(Appointment appointment) {
        // Notification integration will be added later.
        System.out.println(
                "Reminder due for appointment: " + appointment.getId()
        );
    }
}