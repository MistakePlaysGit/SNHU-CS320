package appointment_service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

class AppointmentServiceTest {

    private AppointmentService service;

    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    @BeforeEach
    void setUp() {
        service = new AppointmentService();
    }

    @Test
    void testAddAppointmentSuccess() {
        Date futureDate = getFutureDate();
        service.addAppointment("12345", futureDate, "Dental cleaning");
        Appointment appointment = service.getAppointment("12345");
        assertNotNull(appointment);
        assertEquals("12345", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("Dental cleaning", appointment.getDescription());
    }

    @Test
    void testAddMultipleAppointments() {
        Date futureDate1 = getFutureDate();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 2);
        Date futureDate2 = calendar.getTime();
        service.addAppointment("12345", futureDate1, "First appointment");
        service.addAppointment("67890", futureDate2, "Second appointment");
        assertNotNull(service.getAppointment("12345"));
        assertNotNull(service.getAppointment("67890"));
        assertEquals("First appointment", service.getAppointment("12345").getDescription());
        assertEquals("Second appointment", service.getAppointment("67890").getDescription());
    }

    @Test
    void testAddAppointmentDuplicateId() {
        Date futureDate = getFutureDate();
        service.addAppointment("12345", futureDate, "First appointment");
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment("12345", futureDate, "Second appointment"));
    }

    @Test
    void testAddAppointmentNullId() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment(null, futureDate, "Description"));
    }

    @Test
    void testAddAppointmentIdTooLong() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment("12345678901", futureDate, "Description"));
    }

    @Test
    void testAddAppointmentNullDate() {
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment("12345", null, "Description"));
    }

    @Test
    void testAddAppointmentPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        Date pastDate = calendar.getTime();
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment("12345", pastDate, "Description"));
    }

    @Test
    void testAddAppointmentNullDescription() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment("12345", futureDate, null));
    }

    @Test
    void testAddAppointmentDescriptionTooLong() {
        Date futureDate = getFutureDate();
        assertThrows(IllegalArgumentException.class, () ->
            service.addAppointment("12345", futureDate,
                "This is a very long description that exceeds fifty characters"));
    }

    @Test
    void testDeleteAppointmentSuccess() {
        Date futureDate = getFutureDate();
        service.addAppointment("12345", futureDate, "Appointment to delete");
        assertNotNull(service.getAppointment("12345"));
        service.deleteAppointment("12345");
        assertNull(service.getAppointment("12345"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () ->
            service.deleteAppointment("99999"));
    }

    @Test
    void testDeleteAlreadyDeletedAppointment() {
        Date futureDate = getFutureDate();
        service.addAppointment("12345", futureDate, "Appointment");
        service.deleteAppointment("12345");
        assertThrows(IllegalArgumentException.class, () ->
            service.deleteAppointment("12345"));
    }

    @Test
    void testGetNonExistentAppointmentReturnsNull() {
        assertNull(service.getAppointment("99999"));
    }
}
