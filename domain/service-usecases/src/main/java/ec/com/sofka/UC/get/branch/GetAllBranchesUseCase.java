package ec.com.sofka.UC.get.branch;

import ec.com.sofka.Branch;
import ec.com.sofka.Log;
import ec.com.sofka.gateway.repository.BranchRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class GetAllBranchesUseCase {
    private final BranchRepository repository;

    public GetAllBranchesUseCase(BranchRepository repository) {
        this.repository = repository;
    }

    public Flux<Branch> apply() {
        return createLog()
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
