package br.com.vvaug.efooddataservice.repository;

import br.com.vvaug.efooddataservice.entity.Store;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {
}
