package ec.com.sofka.config;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "ec.com.sofka.eventAdapter",
        mongoTemplateRef = "eventMongoTemplate")
public class EventMongoConfig {
    @Bean(name = "eventsReactiveDatabaseFactory")
    public ReactiveMongoDatabaseFactory eventsDatabaseFactory(
            @Value("${spring.data.mongodb.events-uri}") String uri) {
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString(uri));
    }

    @Bean(name = "eventReactiveMongoTemplate")
    public ReactiveMongoTemplate eventsMongoTemplate(@Qualifier("eventsReactiveDatabaseFactory") ReactiveMongoDatabaseFactory eventsDatabaseFactory) {
        return new ReactiveMongoTemplate(eventsDatabaseFactory);
    }
}