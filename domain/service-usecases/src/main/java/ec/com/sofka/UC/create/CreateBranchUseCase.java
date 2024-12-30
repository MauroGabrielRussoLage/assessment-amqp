package ec.com.sofka.UC.create;

import ec.com.sofka.Branch;
import ec.com.sofka.Log;
import ec.com.sofka.UC.PrintLogUseCase;
import ec.com.sofka.gateway.BranchRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class CreateBranchUseCase {
    private final BranchRepository repository;
    private final PrintLogUseCase printLogUseCase;

    public CreateBranchUseCase(BranchRepository repository, PrintLogUseCase printLogUseCase) {
        this.repository = repository;
        this.printLogUseCase = printLogUseCase;
    }

    public Mono<Branch> apply(Mono<Branch> branch) {
        return createLog()
                .doOnNext(log ->  printLogUseCase.apply(Mono.just(log)))
                .then(repository.createBranch(branch));
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
