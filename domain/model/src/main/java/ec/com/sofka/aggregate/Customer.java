package ec.com.sofka.aggregate;

import ec.com.sofka.aggregate.events.CustomerCreated;
import ec.com.sofka.aggregate.value.CustomerId;
import ec.com.sofka.aggregate.value.object.*;
import ec.com.sofka.generic.object.Status;
import ec.com.sofka.generic.util.AggregateRoot;

public class Customer extends AggregateRoot<CustomerId> {
    protected FirstName firstName;
    protected LastName lastName;
    protected Email email;
    protected Phone phone;
    protected Address address;
    protected Status status;

    private Customer(final String id) {
        super(CustomerId.of(id));
        setSubscription(new CustomerHandler(this));
    }

    public Customer( Address address, Email email, FirstName firstName, LastName lastName, Phone phone, Status status) {
        super(new CustomerId());
        setSubscription(new CustomerHandler(this));
        addEvent(new CustomerCreated(address.getValue(), email.getValue(), firstName.getValue(), lastName.getValue(), phone.getValue(), status.getValue())).apply();
    }

    public Customer() {
        super(new CustomerId());
        setSubscription(new CustomerHandler(this));
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public FirstName getFirstName() {
        return firstName;
    }

    public void setFirstName(FirstName firstName) {
        this.firstName = firstName;
    }

    public LastName getLastName() {
        return lastName;
    }

    public void setLastName(LastName lastName) {
        this.lastName = lastName;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
