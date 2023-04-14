package br.com.vvaug.efoodusersds.gateway.impl;

import br.com.vvaug.efoodusersds.entity.User;
import br.com.vvaug.efoodusersds.gateway.UserGateway;
import br.com.vvaug.efoodusersds.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;


    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
