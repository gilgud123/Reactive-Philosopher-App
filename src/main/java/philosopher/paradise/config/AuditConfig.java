package philosopher.paradise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import philosopher.paradise.audit.AuditorAwareImpl;

@Configuration
@EnableMongoAuditing(auditorAwareRef = "auditorAware")
public class AuditConfig {

    @Bean(name = "auditorAware")
    public AuditorAware<String> auditor(){
        return new AuditorAwareImpl();
    }
}
