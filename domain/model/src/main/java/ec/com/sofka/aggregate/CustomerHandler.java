package ec.com.sofka.aggregate;

import ec.com.sofka.account.Account;
import ec.com.sofka.aggregate.events.AccountCreated;
import ec.com.sofka.aggregate.events.CustomerCreated;
import ec.com.sofka.aggregate.events.CustomerUpdated;
import ec.com.sofka.aggregate.value.object.*;
import ec.com.sofka.generic.domain.DomainActionsContainer;
import ec.com.sofka.generic.object.Status;

public class CustomerHandler extends DomainActionsContainer {
    public CustomerHandler(Customer customer) {
        addDomainActions((CustomerCreated event) -> {
            customer.firstName = new FirstName(event.getFirstName());
            customer.lastName = new LastName(event.getLastName());
            customer.email = new Email(event.getEmail());
            customer.phone = new Phone(event.getPhone());
            customer.address = new Address(event.getAddress());
            customer.status = new Status(event.getStatus());
        });
        addDomainActions((AccountCreated event) -> {
            Account account = new Account(event.getAccountNumber(), event.getAccountType(), event.getBalance(), event.getStatus());
            customer.accounts.add(account);

        });
        addDomainActions((CustomerUpdated event) -> {
            customer.firstName = new FirstName(event.getFirstName());
            customer.lastName = new LastName(event.getLastName());
            customer.email = new Email(event.getEmail());
            customer.phone = new Phone(event.getPhone());
            customer.address = new Address(event.getAddress());
            customer.status = new Status(event.getStatus());
        });
    }
}