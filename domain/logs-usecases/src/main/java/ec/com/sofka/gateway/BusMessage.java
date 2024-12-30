package ec.com.sofka.gateway;

import ec.com.sofka.Log;
import reactor.core.publisher.Mono;

//7. New gateway to establish the link for the outside just as we do with repository
public interface BusMessage {
    //It's a void bc does an action
    void sendMsg(Mono<Log> message);
}
