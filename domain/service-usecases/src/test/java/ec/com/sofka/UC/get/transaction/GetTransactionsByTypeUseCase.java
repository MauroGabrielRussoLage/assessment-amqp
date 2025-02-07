package ec.com.sofka.UC.get.transaction;

import ec.com.sofka.transaction.Transaction;
import ec.com.sofka.gateway.repository.TransactionRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
public class GetTransactionsByTypeUseCase {
    private final TransactionRepository repository;

    public GetTransactionsByTypeUseCase(TransactionRepository repository) {
        this.repository = repository;
    }

    public Flux<Transaction> apply(String type) {
        return null;
    }
}
