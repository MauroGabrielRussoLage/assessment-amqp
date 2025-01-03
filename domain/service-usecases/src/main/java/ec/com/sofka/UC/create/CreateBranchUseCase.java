package ec.com.sofka.UC.create;

import ec.com.sofka.Branch;
import ec.com.sofka.Log;
import ec.com.sofka.gateway.repository.BranchRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Component
public class CreateBranchUseCase {
    private final BranchRepository repository;

    public CreateBranchUseCase(BranchRepository repository) {
        this.repository = repository;}

    public Mono<Branch> apply(Mono<Branch> branch) {
        return createLog()
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
