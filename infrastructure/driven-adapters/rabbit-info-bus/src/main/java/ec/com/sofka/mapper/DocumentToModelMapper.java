package ec.com.sofka.mapper;

import ec.com.sofka.Log;
import ec.com.sofka.data.LogDocument;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class DocumentToModelMapper {
    public static final Function<Mono<LogDocument>, Mono<Log>> toLog = log ->
            log.map(logDocument -> {
                Log logModel = new Log();
                BeanUtils.copyProperties(logDocument, logModel);
                return logModel;
            });
}