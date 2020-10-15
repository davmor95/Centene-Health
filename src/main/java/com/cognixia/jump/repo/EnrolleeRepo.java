package com.cognixia.jump.repo;

import com.cognixia.jump.model.Enrollee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Enrollees
 * @author David Morales
 * @version v3 (10/14/20)
 */
@Repository
public interface EnrolleeRepo extends MongoRepository<Enrollee, Long> {
}
