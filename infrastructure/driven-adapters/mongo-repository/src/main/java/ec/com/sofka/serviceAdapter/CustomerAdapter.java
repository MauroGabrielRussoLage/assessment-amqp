package ec.com.sofka.serviceAdapter;

import ec.com.sofka.gateway.dto.CustomerDTO;
import ec.com.sofka.aggregate.Customer;
import ec.com.sofka.aggregate.value.object.*;
import ec.com.sofka.data.CustomerDocument;
import ec.com.sofka.gateway.repository.CustomerRepository;
import ec.com.sofka.generic.object.Status;
import ec.com.sofka.mapper.ModelToDocumentMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class CustomerAdapter implements CustomerRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public CustomerAdapter(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<CustomerDTO> createCustomer(Mono<CustomerDTO> customer) {
        return customer.flatMap(customerDTO -> {
                    Customer customerModel = new Customer(
                            new Address(customerDTO.getAddress()),
                            new Email(customerDTO.getEmail()),
                            new FirstName(customerDTO.getFirstName()),
                            new LastName(customerDTO.getLastName()),
                            new Phone(customerDTO.getPhone()),
                            new Status(customerDTO.getStatus())
                    );
            return ModelToDocumentMapper.toCustomer.apply(Mono.just(customerModel));
        })
                .flatMap(reactiveMongoTemplate::save)
                .flatMap(customerDocument -> {
                    CustomerDTO customerDTO = new CustomerDTO(
                            customerDocument.getId(),
                            customerDocument.getAddress(),
                            customerDocument.getEmail(),
                            customerDocument.getFirstName(),
                            customerDocument.getLastName(),
                            customerDocument.getPhone(),
                            customerDocument.getStatus()
                    );
                    return Mono.just(customerDTO);
                });
    }

    @Override
    public Mono<CustomerDTO> findCustomerById(Mono<Integer> id) {
        return id.flatMap(customerId -> reactiveMongoTemplate.findById(customerId, CustomerDocument.class))
                .flatMap(customerDocument -> {
                    CustomerDTO customerDTO = new CustomerDTO(
                            customerDocument.getId(),
                            customerDocument.getAddress(),
                            customerDocument.getEmail(),
                            customerDocument.getFirstName(),
                            customerDocument.getLastName(),
                            customerDocument.getPhone(),
                            customerDocument.getStatus()
                    );
                    return Mono.just(customerDTO);
                });
    }

    @Override
    public Mono<CustomerDTO> findCustomerByFirstName(Mono<String> first_name) {
        return first_name.flatMap(customerFirstName -> reactiveMongoTemplate
                        .findOne(Query.query(Criteria.where("firstName").is(customerFirstName)), CustomerDocument.class))
                .flatMap(customerDocument -> {
                    CustomerDTO customerDTO = new CustomerDTO(
                            customerDocument.getId(),
                            customerDocument.getAddress(),
                            customerDocument.getEmail(),
                            customerDocument.getFirstName(),
                            customerDocument.getLastName(),
                            customerDocument.getPhone(),
                            customerDocument.getStatus()
                    );
                    return Mono.just(customerDTO);
                });
    }

    @Override
    public Mono<CustomerDTO> findCustomerByLastName(Mono<String> last_name) {
        return last_name.flatMap(customerLastName -> reactiveMongoTemplate
                        .findOne(Query.query(Criteria.where("firstName").is(customerLastName)), CustomerDocument.class))
                .flatMap(customerDocument -> {
                    CustomerDTO customerDTO = new CustomerDTO(
                            customerDocument.getId(),
                            customerDocument.getAddress(),
                            customerDocument.getEmail(),
                            customerDocument.getFirstName(),
                            customerDocument.getLastName(),
                            customerDocument.getPhone(),
                            customerDocument.getStatus()
                    );
                    return Mono.just(customerDTO);
                });
    }

    @Override
    public Mono<CustomerDTO> findCustomerByEmail(Mono<String> email) {
        return email.flatMap(customerEmail -> reactiveMongoTemplate
                        .findOne(Query.query(Criteria.where("email").is(customerEmail)), CustomerDocument.class))
                .flatMap(customerDocument -> {
                    CustomerDTO customerDTO = new CustomerDTO(
                            customerDocument.getId(),
                            customerDocument.getAddress(),
                            customerDocument.getEmail(),
                            customerDocument.getFirstName(),
                            customerDocument.getLastName(),
                            customerDocument.getPhone(),
                            customerDocument.getStatus()
                    );
                    return Mono.just(customerDTO);
                });
    }

    @Override
    public Flux<CustomerDTO> findAll() {
        return reactiveMongoTemplate.findAll(CustomerDocument.class)
                .flatMap(customerDocument -> {
                    CustomerDTO customerDTO = new CustomerDTO(
                            customerDocument.getId(),
                            customerDocument.getAddress(),
                            customerDocument.getEmail(),
                            customerDocument.getFirstName(),
                            customerDocument.getLastName(),
                            customerDocument.getPhone(),
                            customerDocument.getStatus()
                    );
                    return Mono.just(customerDTO);
                });
    }

    @Override
    public Mono<CustomerDTO> updateCustomer(Mono<CustomerDTO> customer) {
        return null;
    }

    @Override
    public Mono<Void> deleteById(Mono<Integer> id) {
        return id.flatMap(customerId -> reactiveMongoTemplate
                        .remove(Query.query(Criteria.where("_id").is(customerId)), CustomerDocument.class))
                .then();
    }
}