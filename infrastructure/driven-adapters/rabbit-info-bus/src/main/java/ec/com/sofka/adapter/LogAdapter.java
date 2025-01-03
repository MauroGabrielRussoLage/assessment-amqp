package ec.com.sofka.adapter;


import ec.com.sofka.Log;
import ec.com.sofka.data.LogDocument;


import ec.com.sofka.gateway.repository.LogRepository;
import ec.com.sofka.mapper.ModelToDocumentMapper;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class LogAdapter implements LogRepository {

    private final ReactiveMongoTemplate reactiveMongoTemplate;

    public LogAdapter(ReactiveMongoTemplate reactiveMongoTemplate) {
        this.reactiveMongoTemplate = reactiveMongoTemplate;
    }

    @Override
    public Mono<Void> createLog(Mono<Log> logMono) {
        return logMono.map(log -> {
            Query query = new Query(Criteria.where("_id").is(log.getTransactionId()));
            Update update = new Update().push("logs", ModelToDocumentMapper.toLog.apply(Mono.just(log)).subscribe());
            return reactiveMongoTemplate.updateFirst(query, update, LogDocument.class)
                    .map(result -> result.getModifiedCount() > 0
                            ? Mono.just(log)
                            : Mono.error(new RuntimeException("Failed to create log")));
        }).then();
    }
}