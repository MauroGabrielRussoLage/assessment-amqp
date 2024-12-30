package ec.com.sofka.adapter;

import com.fasterxml.jackson.databind.deser.std.StackTraceElementDeserializer;
import ec.com.sofka.Account;
import ec.com.sofka.Log;
import ec.com.sofka.data.LogDocument;
import ec.com.sofka.gateway.LogRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import reactor.core.publisher.Mono;

public class LogAdapter implements LogRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public LogAdapter(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<Account> createLog(Mono<Account> account) {
        return account.flatMap(acc -> {
            Query query = new Query(Criteria.where("_id").is(acc.getId()));
            Update update = new Update().push("accounts", ModelToDocumentMapper.toAccount.apply(Mono.just(acc)));
            return reactiveMongoTemplate.updateFirst(query, update, CustomerDocument.class)
                    .flatMap(result -> result.getModifiedCount() > 0
                            ? Mono.just(acc)
                            : Mono.error(new RuntimeException("Failed to create account")));
        });
    }

    @Override
    public Mono<Void> createLog(Mono<Log> log) {
        return log.flatMap(acc -> {
            Query query = new Query(Criteria.where("_id").is(acc.getId()));
            Update update = new Update().push("logs", ModelToDocumentMapper.toAccount.apply(Mono.just(acc)));
            return reactiveMongoTemplate.updateFirst(query, update, LogDocument.class)
                    .flatMap(result -> result.getModifiedCount() > 0
                            ? Mono.just(acc)
                            : Mono.error(new RuntimeException("Failed to create log")));
        });
    }
}
