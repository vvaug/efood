package br.com.vvaug.efoodusersds.gateway.impl;

import br.com.vvaug.efoodusersds.entity.UserRole;
import br.com.vvaug.efoodusersds.gateway.UserRoleGateway;
import br.com.vvaug.efoodusersds.repository.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserRoleGatewayImpl implements UserRoleGateway {

    private final UserRoleRepository userRoleRepository;

    @Override
    public Optional<UserRole> findByName(String name) {
        return userRoleRepository.findByName(name);
    }

    @Override
    public void deleteAll() {
        userRoleRepository.deleteAll();
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }
}
