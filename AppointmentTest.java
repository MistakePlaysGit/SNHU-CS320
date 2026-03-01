package appointment_service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * AppointmentService class for managing appointments.
 * Provides functionality to add and delete appointments.
 */
public class AppointmentService {
    private final Map<String, Appointment> appointments;

    public AppointmentService() {
        this.appointments = new HashMap<>();
    }

    public void addAppointment(String appointmentId, Date appointmentDate, String description) {
        if (appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        Appointment appointment = new Appointment(appointmentId, appointmentDate, description);
        appointments.put(appointmentId, appointment);
    }

    public void deleteAppointment(String appointmentId) {
        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }
        appointments.remove(appointmentId);
    }

    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}
