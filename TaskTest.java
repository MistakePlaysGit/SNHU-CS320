package contact_service;

/**
 * Contact class representing a contact with validation rules.
 * All fields are required and have specific constraints.
 */
public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    /**
     * Constructor for Contact object
     * @param contactId Unique identifier, max 10 characters, not null, not updatable
     * @param firstName First name, max 10 characters, not null
     * @param lastName Last name, max 10 characters, not null
     * @param phone Phone number, exactly 10 digits, not null
     * @param address Address, max 30 characters, not null
     */
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("Contact ID must not be null and must be 10 characters or less");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
        }
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    public String getContactId() { return contactId; }
    public String getFirstName()  { return firstName; }
    public String getLastName()   { return lastName; }
    public String getPhone()      { return phone; }
    public String getAddress()    { return address; }

    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("First name must not be null and must be 10 characters or less");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("Last name must not be null and must be 10 characters or less");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must not be null and must be exactly 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("Address must not be null and must be 30 characters or less");
        }
        this.address = address;
    }
}
