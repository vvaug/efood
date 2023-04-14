package br.com.vvaug.efoodusersds.gateway;

import br.com.vvaug.efoodusersds.entity.UserRole;

import java.util.Optional;

public interface UserRoleGateway {

    Optional<UserRole> findByName(String name);
    void deleteAll();
    UserRole save(UserRole userRole);
}
