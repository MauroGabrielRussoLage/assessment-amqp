package ec.com.sofka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Value("${mongodb.logs.uri}")
    private String logsUri;

    @Bean(name = "logsMongoTemplate")
    public MongoTemplate logsMongoTemplate() {
        MongoDatabaseFactory logsFactory = new SimpleMongoClientDatabaseFactory(logsUri);
        return new MongoTemplate(logsFactory);
    }
}
