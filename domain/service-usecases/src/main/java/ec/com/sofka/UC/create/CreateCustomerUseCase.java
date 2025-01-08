package ec.com.sofka.UC.create;

import ec.com.sofka.request.CustomerRequestDTO;
import ec.com.sofka.response.CustomerDTO;
import ec.com.sofka.aggregate.Customer;
import ec.com.sofka.aggregate.value.object.*;
import ec.com.sofka.gateway.EventStore;
import ec.com.sofka.gateway.repository.CustomerRepository;
import ec.com.sofka.generic.object.Status;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateCustomerUseCase {
    private final EventStore repository;
    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(EventStore repository, CustomerRepository customerRepository) {
        this.repository = repository;
        this.customerRepository = customerRepository;
    }

    public Mono<CustomerDTO> apply(Mono<CustomerRequestDTO> customerRequest) {
        return customerRequest.flatMap(customerRequestDTO -> {
            Customer customer = new Customer(
                    new Address(customerRequestDTO.getAddress()),
                    new Email(customerRequestDTO.getEmail()),
                    new FirstName(customerRequestDTO.getFirstName()),
                    new LastName(customerRequestDTO.getLastName()),
                    new Phone(customerRequestDTO.getPhone()),
                    new Status(customerRequestDTO.getStatus())
            );
            customer.getUncommittedEvents().forEach(domainEvent -> {
                repository.save(Mono.just(domainEvent));
            });
            customer.markEventsAsCommitted();
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getId().getValue(),
                    customer.getAddress().getValue(),
                    customer.getEmail().getValue(),
                    customer.getFirstName().getValue(),
                    customer.getLastName().getValue(),
                    customer.getPhone().getValue(),
                    customer.getStatus().getValue()
            );
            return customerRepository.createCustomer(Mono.just(customerDTO));
        }
        );
    }
}
