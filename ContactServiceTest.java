package contact_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ContactTest {

    @Test
    void testContactCreationSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("5551234567", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }

    @Test
    void testContactIdNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact(null, "John", "Doe", "5551234567", "123 Main St"));
    }

    @Test
    void testContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("12345678901", "John", "Doe", "5551234567", "123 Main St"));
    }

    @Test
    void testContactIdExactly10Characters() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertEquals("1234567890", contact.getContactId());
    }

    @Test
    void testFirstNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", null, "Doe", "5551234567", "123 Main St"));
    }

    @Test
    void testFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "VeryLongFirstName", "Doe", "5551234567", "123 Main St"));
    }

    @Test
    void testFirstNameExactly10Characters() {
        Contact contact = new Contact("1234567890", "JohnJohnJo", "Doe", "5551234567", "123 Main St");
        assertEquals("JohnJohnJo", contact.getFirstName());
    }

    @Test
    void testLastNameNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", null, "5551234567", "123 Main St"));
    }

    @Test
    void testLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "VeryLongLastName", "5551234567", "123 Main St"));
    }

    @Test
    void testLastNameExactly10Characters() {
        Contact contact = new Contact("1234567890", "John", "DoeDoeDoeD", "5551234567", "123 Main St");
        assertEquals("DoeDoeDoeD", contact.getLastName());
    }

    @Test
    void testPhoneNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", null, "123 Main St"));
    }

    @Test
    void testPhoneTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "555123456", "123 Main St"));
    }

    @Test
    void testPhoneTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "55512345678", "123 Main St"));
    }

    @Test
    void testPhoneNotDigits() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "555-123456", "123 Main St"));
    }

    @Test
    void testPhoneExactly10Digits() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertEquals("5551234567", contact.getPhone());
    }

    @Test
    void testAddressNull() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "5551234567", null));
    }

    @Test
    void testAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
            new Contact("1234567890", "John", "Doe", "5551234567",
                "This is a very long address that exceeds thirty characters"));
    }

    @Test
    void testAddressExactly30Characters() {
        String address = "123456789012345678901234567890";
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", address);
        assertEquals(address, contact.getAddress());
    }

    @Test
    void testSetFirstNameSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setFirstName("Jane");
        assertEquals("Jane", contact.getFirstName());
    }

    @Test
    void testSetFirstNameNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
    }

    @Test
    void testSetFirstNameTooLong() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("VeryLongFirstName"));
    }

    @Test
    void testSetLastNameSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setLastName("Smith");
        assertEquals("Smith", contact.getLastName());
    }

    @Test
    void testSetLastNameNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
    }

    @Test
    void testSetLastNameTooLong() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setLastName("VeryLongLastName"));
    }

    @Test
    void testSetPhoneSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setPhone("5559876543");
        assertEquals("5559876543", contact.getPhone());
    }

    @Test
    void testSetPhoneNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
    }

    @Test
    void testSetPhoneInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setPhone("123"));
    }

    @Test
    void testSetAddressSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        contact.setAddress("456 Oak Ave");
        assertEquals("456 Oak Ave", contact.getAddress());
    }

    @Test
    void testSetAddressNull() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
    }

    @Test
    void testSetAddressTooLong() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        assertThrows(IllegalArgumentException.class, () ->
            contact.setAddress("This is a very long address that exceeds thirty characters"));
    }

    @Test
    void testContactIdNotUpdatable() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        String originalId = contact.getContactId();
        contact.setFirstName("Jane");
        contact.setLastName("Smith");
        contact.setPhone("5559876543");
        contact.setAddress("456 Oak Ave");
        assertEquals(originalId, contact.getContactId());
    }
}
