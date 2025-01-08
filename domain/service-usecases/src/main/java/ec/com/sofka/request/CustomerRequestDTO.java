package ec.com.sofka.request;

import ec.com.sofka.generic.util.Request;

public class CustomerRequestDTO extends Request {
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;
    protected String address;
    protected String status;

    public CustomerRequestDTO(String aggregateId, String address, String email, String firstName, String id, String lastName, String phone, String status) {
        super(aggregateId);
        this.address = address;
        this.email = email;
        this.firstName = firstName;
        this.id = id;
        this.lastName = lastName;
        this.phone = phone;
        this.status = status;
    }

    public CustomerRequestDTO(String aggregateId) {
        super(aggregateId);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
