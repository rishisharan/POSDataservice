package com.posdataservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.posdataservice.model.Users;

@Repository
public interface UserRepository extends MongoRepository<Users, String> {
//  Optional<User> findByUsername(String username);

  @Query("{username:'?0'}")
  Users findUserByUsername(String username);
  
  
  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}