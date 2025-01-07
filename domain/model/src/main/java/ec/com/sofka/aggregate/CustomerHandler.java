package ec.com.sofka.aggregate;

import ec.com.sofka.account.Account;
import ec.com.sofka.aggregate.events.CustomerCreated;
import ec.com.sofka.aggregate.value.object.*;
import ec.com.sofka.generic.domain.DomainActionsContainer;
import ec.com.sofka.generic.object.Status;

//6. Create the handler for the Aggregate root that will be on the Agreggate root constructor
public class CustomerHandler extends DomainActionsContainer {
    //7. Add the actions to the handler
    public CustomerHandler(Customer customer) {
        //8. Add the actions to the handler

        addDomainActions((CustomerCreated event) -> {
            customer.firstName = new FirstName(event.getFirstName());
            customer.lastName = new LastName(event.getLastName());
            customer.email = new Email(event.getEmail());
            customer.phone = new Phone(event.getPhone());
            customer.address = new Address(event.getAddress());
            customer.status = new Status(event.getStatus());
        });
    }
}