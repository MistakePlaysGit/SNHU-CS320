package appointment_service;

import java.util.Date;

/**
 * Appointment class representing a single appointment with ID, date, and description.
 */
public class Appointment {
    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    /**
     * @param appointmentId Unique ID, max 10 characters, not null, not updatable
     * @param appointmentDate Date of appointment, cannot be in past, not null
     * @param description Description, max 50 characters, not null
     */
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Appointment ID must not be null and must be 10 characters or less");
        }
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date must not be null");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    public String getAppointmentId()   { return appointmentId; }
    public Date getAppointmentDate()   { return appointmentDate; }
    public String getDescription()     { return description; }

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Appointment date must not be null");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Appointment date cannot be in the past");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Description must not be null and must be 50 characters or less");
        }
        this.description = description;
    }
}
