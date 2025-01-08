package ec.com.sofka.gateway.repository;

import ec.com.sofka.DTO.response.TransactionDTO;
import ec.com.sofka.transaction.Transaction;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

public interface TransactionRepository {

    Mono<Transaction> createTransaction(Mono<Transaction> transaction);

    Mono<Transaction> findTransactionById(Mono<Integer> id);

    Flux<Transaction> findAll();

    Flux<Transaction> findTransactionsByDestinationAccountId(Mono<Integer> id);

    Flux<Transaction> findTransactionsBySourceAccountId(Mono<Integer> id);

    Flux<Transaction> findTransactionsByBranchId(Mono<Integer> id);

    Flux<Transaction> findTransactionsByDate(Mono<LocalDateTime> date);

    Flux<Transaction> findTransactionsByType(Mono<String> type);

    Mono<Transaction> updateTransaction(Mono<Transaction> transaction);

    Mono<Void> deleteById(Mono<Integer> id);
}
