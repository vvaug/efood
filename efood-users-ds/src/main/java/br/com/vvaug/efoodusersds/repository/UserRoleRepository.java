package br.com.vvaug.efoodusersds.repository;

import br.com.vvaug.efoodusersds.entity.UserRole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRoleRepository extends MongoRepository<UserRole, String> {

    Optional<UserRole> findByName(String name);
}
