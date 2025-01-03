package ec.com.sofka;

import ec.com.sofka.UC.PrintLogUseCase;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

//20. Create the BusListener class
@Service
public class BusListener {
    private final PrintLogUseCase printLogUseCase;

    public BusListener(PrintLogUseCase printLogUseCase) {
        this.printLogUseCase = printLogUseCase;
    }

    //23. Implement the receiveMsg method with the usecase
    @RabbitListener(queues = "example.queue")
    public void receiveMsg(Log message) {
        printLogUseCase.apply(Mono.just(message)).subscribe();
    }
}