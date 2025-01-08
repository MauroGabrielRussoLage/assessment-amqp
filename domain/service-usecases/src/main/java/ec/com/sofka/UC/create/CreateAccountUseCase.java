package ec.com.sofka.UC.create;

import ec.com.sofka.account.value.AccountNumber;
import ec.com.sofka.account.value.AccountType;
import ec.com.sofka.account.value.Balance;
import ec.com.sofka.aggregate.Customer;
import ec.com.sofka.gateway.EventStore;
import ec.com.sofka.gateway.repository.AccountRepository;
import ec.com.sofka.generic.object.Status;
import ec.com.sofka.request.CreateAccountRequest;
import ec.com.sofka.response.CreateAccountResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateAccountUseCase {
    private final AccountRepository accountRepository;
    private final EventStore eventRepository;

    public CreateAccountUseCase(AccountRepository accountRepository, EventStore eventRepository) {
        this.accountRepository = accountRepository;
        this.eventRepository = eventRepository;
    }

    public Mono<CreateAccountResponse> apply(Mono<CreateAccountRequest> createAccountRequest) {
        return createAccountRequest.flatMap(request -> {
            return eventRepository.findAggregate(Mono.just(request.getAggregateId()))
                    .collectList()
                    .flatMap(events -> {
                        Customer customer = Customer.from(request.getAggregateId(), events);

                        customer.addAccount(
                                new AccountNumber(request.getAccountNumber()),
                                new AccountType(request.getAccountType()),
                                new Balance(request.getBalance()),
                                new Status(request.getStatus())
                        );

                        customer.getUncommittedEvents().forEach(domainEvent -> {
                            eventRepository.save(Mono.just(domainEvent)).subscribe();
                        });
                        customer.markEventsAsCommitted();
                    });
        }
    }
}