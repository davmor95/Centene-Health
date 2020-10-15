package com.cognixia.jump.repo;

import com.cognixia.jump.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *The repository for Users
 * @author David Morales
 * @version v3 (10/14/20)
 */
@Repository
public interface UserRepo extends MongoRepository<User, Long> {
}
