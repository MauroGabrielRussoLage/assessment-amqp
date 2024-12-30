package ec.com.sofka.UC;

import ec.com.sofka.Log;
import ec.com.sofka.gateway.BusMessageListener;
import ec.com.sofka.gateway.LogRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

//18. UseCase for printing logs
@Component
public class PrintLogUseCase{

    private final LogRepository repository;

    public PrintLogUseCase(LogRepository repository) {
        this.repository = repository;
    }

    public void apply(Mono<Log> log) {
        log.subscribe(repository::save);
    }
}
