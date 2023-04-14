package br.com.vvaug.efoodusersds.config.startup;

import br.com.vvaug.efoodusersds.domain.Address;
import br.com.vvaug.efoodusersds.entity.User;
import br.com.vvaug.efoodusersds.entity.UserRole;
import br.com.vvaug.efoodusersds.gateway.UserGateway;
import br.com.vvaug.efoodusersds.gateway.UserRoleGateway;
import br.com.vvaug.efoodusersds.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Configuration
@RequiredArgsConstructor
public class LoadUser implements CommandLineRunner {

    private final UserGateway userGateway;
    private final UserRoleGateway userRoleGateway;

    @Override
    public void run(String... args) throws Exception {
        userGateway.deleteAll();
        userRoleGateway.deleteAll();

        var userRole = userRoleGateway.save(UserRole.builder()
                .name("ROLE_USER")
                .build());

        userGateway.save(
                User.builder()
                        .username("vvaug")
                        .password("$2a$04$FPZ1ZZ5oEWnF/VVpM8plcuGMZr.7B1xaqG/B2.Glq9ZrX5OyLhFkK")
                        .name("John")
                        .addresses(List.of(
                                Address.builder()
                                        .id(UUID.randomUUID().toString())
                                        .street("Main Street")
                                        .number("1234")
                                        .mainAddress(true)
                                        .build(),
                                Address.builder()
                                        .id(UUID.randomUUID().toString())
                                        .street("8 Mile Road")
                                        .number("1000")
                                        .mainAddress(false)
                                        .build()
                        ))
                        .roles(Arrays.asList(userRole)
                        ).build());
    }
}
