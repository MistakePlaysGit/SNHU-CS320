package contact_service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    void setUp() {
        service = new ContactService();
    }

    @Test
    void testAddContactSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        Contact retrieved = service.getContact("1234567890");
        assertEquals("John", retrieved.getFirstName());
        assertEquals("Doe", retrieved.getLastName());
    }

    @Test
    void testAddContactNull() {
        assertThrows(IllegalArgumentException.class, () -> service.addContact(null));
    }

    @Test
    void testAddContactDuplicateId() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        Contact contact2 = new Contact("1234567890", "Jane", "Smith", "5559876543", "456 Oak Ave");
        service.addContact(contact1);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    void testAddMultipleUniqueContacts() {
        Contact contact1 = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        Contact contact2 = new Contact("0987654321", "Jane", "Smith", "5559876543", "456 Oak Ave");
        service.addContact(contact1);
        service.addContact(contact2);
        assertEquals("John", service.getContact("1234567890").getFirstName());
        assertEquals("Jane", service.getContact("0987654321").getFirstName());
    }

    @Test
    void testDeleteContactSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        service.deleteContact("1234567890");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("1234567890"));
    }

    @Test
    void testDeleteContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("9999999999"));
    }

    @Test
    void testDeleteContactNullId() {
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact(null));
    }

    @Test
    void testUpdateFirstNameSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1234567890", "Jane");
        assertEquals("Jane", service.getContact("1234567890").getFirstName());
    }

    @Test
    void testUpdateFirstNameContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("9999999999", "Jane"));
    }

    @Test
    void testUpdateFirstNameInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateFirstName("1234567890", null));
    }

    @Test
    void testUpdateLastNameSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        service.updateLastName("1234567890", "Smith");
        assertEquals("Smith", service.getContact("1234567890").getLastName());
    }

    @Test
    void testUpdateLastNameContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("9999999999", "Smith"));
    }

    @Test
    void testUpdateLastNameInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updateLastName("1234567890", "VeryLongLastName"));
    }

    @Test
    void testUpdatePhoneSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        service.updatePhone("1234567890", "5559876543");
        assertEquals("5559876543", service.getContact("1234567890").getPhone());
    }

    @Test
    void testUpdatePhoneContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("9999999999", "5559876543"));
    }

    @Test
    void testUpdatePhoneInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.updatePhone("1234567890", "123"));
    }

    @Test
    void testUpdateAddressSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        service.updateAddress("1234567890", "456 Oak Ave");
        assertEquals("456 Oak Ave", service.getContact("1234567890").getAddress());
    }

    @Test
    void testUpdateAddressContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.updateAddress("9999999999", "456 Oak Ave"));
    }

    @Test
    void testUpdateAddressInvalid() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () ->
            service.updateAddress("1234567890", "This is a very long address that exceeds thirty characters"));
    }

    @Test
    void testGetContactSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        Contact retrieved = service.getContact("1234567890");
        assertNotNull(retrieved);
        assertEquals("1234567890", retrieved.getContactId());
    }

    @Test
    void testGetContactNotFound() {
        assertThrows(IllegalArgumentException.class, () -> service.getContact("9999999999"));
    }

    @Test
    void testGetContactNullId() {
        assertThrows(IllegalArgumentException.class, () -> service.getContact(null));
    }

    @Test
    void testUpdateMultipleFieldsSuccess() {
        Contact contact = new Contact("1234567890", "John", "Doe", "5551234567", "123 Main St");
        service.addContact(contact);
        service.updateFirstName("1234567890", "Jane");
        service.updateLastName("1234567890", "Smith");
        service.updatePhone("1234567890", "5559876543");
        service.updateAddress("1234567890", "456 Oak Ave");
        Contact updated = service.getContact("1234567890");
        assertEquals("Jane", updated.getFirstName());
        assertEquals("Smith", updated.getLastName());
        assertEquals("5559876543", updated.getPhone());
        assertEquals("456 Oak Ave", updated.getAddress());
        assertEquals("1234567890", updated.getContactId());
    }
}
