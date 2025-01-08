package ec.com.sofka.config;

import com.mongodb.ConnectionString;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "ec.com.sofka.serviceAdapter",
        mongoTemplateRef = "accountMongoTemplate")
public class AccountMongoConfig {
    @Primary
    @Bean(name = "accountsReactiveDatabaseFactory")
    public ReactiveMongoDatabaseFactory accountsDatabaseFactory(
            @Value("${spring.data.mongodb.accounts-uri}") String uri) {
        return new SimpleReactiveMongoDatabaseFactory(new ConnectionString(uri));
    }

    @Primary
    @Bean(name = "accountReactiveMongoTemplate")
    public ReactiveMongoTemplate accountsMongoTemplate(@Qualifier("accountsReactiveDatabaseFactory") ReactiveMongoDatabaseFactory accountsDatabaseFactory) {
        return new ReactiveMongoTemplate(accountsDatabaseFactory);
    }
}