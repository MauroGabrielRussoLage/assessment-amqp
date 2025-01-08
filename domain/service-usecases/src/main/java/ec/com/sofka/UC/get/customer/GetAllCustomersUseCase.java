package ec.com.sofka.UC.get.customer;

import ec.com.sofka.response.CustomerDTO;
import ec.com.sofka.gateway.repository.CustomerRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class GetAllCustomersUseCase {
    private final CustomerRepository repository;

    public GetAllCustomersUseCase(CustomerRepository repository) {
        this.repository = repository;
    }

    public Flux<CustomerDTO> apply() {
        return null;
    }
}
