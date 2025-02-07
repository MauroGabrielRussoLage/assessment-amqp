package ec.com.sofka.UC.create;

import ec.com.sofka.account.Account;
import ec.com.sofka.gateway.repository.AccountRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateAccountUseCase {
    private final AccountRepository repository;

    public CreateAccountUseCase(AccountRepository repository) {
        this.repository = repository;
    }

    public Mono<Account> apply(Mono<Account> account) {
        return repository.createAccount(account);
    }
}