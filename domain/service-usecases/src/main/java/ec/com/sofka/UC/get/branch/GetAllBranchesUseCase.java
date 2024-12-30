package ec.com.sofka.UC.get.branch;

import ec.com.sofka.Branch;
import ec.com.sofka.Log;
import ec.com.sofka.UC.PrintLogUseCase;
import ec.com.sofka.gateway.BranchRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class GetAllBranchesUseCase {
    private final BranchRepository repository;
    private final PrintLogUseCase printLogUseCase;

    public GetAllBranchesUseCase(BranchRepository repository, PrintLogUseCase printLogUseCase) {
        this.repository = repository;
        this.printLogUseCase = printLogUseCase;
    }

    public Flux<Branch> apply() {
        return createLog()
                .doOnNext(log ->  printLogUseCase.apply(Mono.just(log)))
                .thenMany(repository.findAll());
    }

    private Mono<Log> createLog() {
        return Mono.fromSupplier(() -> {
            Log log = new Log();
            log.setAction("getAllBranches");
            log.setLevel("1");
            log.setMessage("test");
            log.setTimestamp(LocalDateTime.now());
            return log;
        });
    }
}
