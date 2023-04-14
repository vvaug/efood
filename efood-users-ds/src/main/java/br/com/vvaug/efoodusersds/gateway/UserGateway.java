package br.com.vvaug.efoodusersds.gateway;

import br.com.vvaug.efoodusersds.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {

    Optional<User> findByUsername(String username);

    User save(User user);

    void deleteAll();
}
