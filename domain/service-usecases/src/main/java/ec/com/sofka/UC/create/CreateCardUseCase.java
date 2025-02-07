package ec.com.sofka.UC.create;

import ec.com.sofka.card.Card;
import ec.com.sofka.gateway.repository.CardRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateCardUseCase {
    private final CardRepository repository;

    public CreateCardUseCase(CardRepository repository) {
        this.repository = repository;
    }

    public Mono<Card> apply(Mono<Card> apply) {
        return repository.createCard(apply);
    }
}
