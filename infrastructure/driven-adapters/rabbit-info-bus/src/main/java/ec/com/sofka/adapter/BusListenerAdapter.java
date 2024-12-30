package ec.com.sofka.adapter;

import ec.com.sofka.Log;
import ec.com.sofka.gateway.BusMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BusListenerAdapter implements BusMessageListener {

    private final RabbitTemplate rabbitTemplate;

    public BusListenerAdapter(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void receiveMsg(Mono<Log> log) {
        Mono<Log> reactiveLog = log;
    }
}
