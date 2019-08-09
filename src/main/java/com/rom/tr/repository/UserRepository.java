package com.rom.tr.repository;

import com.rom.tr.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByToken(String token);
    User findByEmailAndPassword(String email, String password);
}
