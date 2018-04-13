package philosopher.paradise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@EnableAsync(proxyTargetClass=true)
public class SecurityConfig {

    @Bean
    SecurityWebFilterChain springWebFilterChain(final ServerHttpSecurity http) throws Exception {
        http.csrf().disable();

        return http
                .authorizeExchange()
                .anyExchange()
                .authenticated()
                .and()
                .httpBasic()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .build()
                ;
    }

    private PasswordEncoder encoder =
            PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {

        UserDetails user = User.withUsername("reese")
                .password(encoder.encode("user"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("finch")
                .password(encoder.encode("admin"))
                .roles("USER", "ADMIN")
                .build();

        return new MapReactiveUserDetailsService(user, admin);
    }
}
