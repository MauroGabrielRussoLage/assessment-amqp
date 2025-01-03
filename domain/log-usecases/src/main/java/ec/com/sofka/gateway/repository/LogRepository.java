package ec.com.sofka.gateway.repository;

import ec.com.sofka.Log;
import reactor.core.publisher.Mono;

public interface LogRepository {
    Mono<Void> createLog(Mono<Log> log);
}
