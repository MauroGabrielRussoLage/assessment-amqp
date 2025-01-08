package ec.com.sofka.gateway.repository;

import ec.com.sofka.account.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepository {
    Mono<Account> createAccount(Mono<Account> account);

    Mono<Account> findAccountById(Mono<Integer> id);

    Flux<Account> getAccountsByCustomerId(Mono<String> customer_id);

    Flux<Account> findAll();

    Mono<Account> updateAccount(Mono<Account> account);

    Mono<Void> deleteById(Mono<Integer> id);
}