package appointment_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

class AppointmentTest {

    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    @Test
    void testAppointmentCreation() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Annual checkup");
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Annual checkup", appointment.getDescription());
    }

    @Test
    void testAppointmentIdNull() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment(null, futureDate, "Description"));
    }

    @Test
    void testAppointmentIdTooLong() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("12345678901", futureDate, "Description"));
    }

    @Test
    void testAppointmentIdExactly10Characters() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("1234567890", futureDate, "Description");
        assertEquals("1234567890", appointment.getAppointmentId());
    }

    @Test
    void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("12345", null, "Description"));
    }

    @Test
    void testAppointmentDateInPast() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = calendar.getTime();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("12345", pastDate, "Description"));
    }

    @Test
    void testDescriptionNull() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("12345", futureDate, null));
    }

    @Test
    void testDescriptionTooLong() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            new Appointment("12345", futureDate,
                "This is a very long description that exceeds fifty characters"));
    }

    @Test
    void testDescriptionExactly50Characters() {
        Date futureDate = getFutureDate();
        String description = "12345678901234567890123456789012345678901234567890";
        Appointment appointment = new Appointment("12345", futureDate, description);
        assertEquals(description, appointment.getDescription());
    }

    @Test
    void testSetAppointmentDateValid() {
        Date futureDate1 = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate1, "Description");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        Date futureDate2 = calendar.getTime();
        appointment.setAppointmentDate(futureDate2);
        assertEquals(futureDate2, appointment.getAppointmentDate());
    }

    @Test
    void testSetAppointmentDateNull() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(null));
    }

    @Test
    void testSetAppointmentDatePast() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = calendar.getTime();
        assertThrows(IllegalArgumentException.class, () -> appointment.setAppointmentDate(pastDate));
    }

    @Test
    void testSetDescriptionValid() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Original description");
        appointment.setDescription("Updated description");
        assertEquals("Updated description", appointment.getDescription());
    }

    @Test
    void testSetDescriptionNull() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        assertThrows(IllegalArgumentException.class, () -> appointment.setDescription(null));
    }

    @Test
    void testSetDescriptionTooLong() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        assertThrows(IllegalArgumentException.class, () ->
            appointment.setDescription("This is a very long description that exceeds fifty characters"));
    }

    @Test
    void testAppointmentIdNotUpdatable() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("12345", futureDate, "Description");
        String originalId = appointment.getAppointmentId();
        appointment.setDescription("New Description");
        assertEquals(originalId, appointment.getAppointmentId());
    }
}
