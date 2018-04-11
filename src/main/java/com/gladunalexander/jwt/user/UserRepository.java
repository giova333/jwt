package com.gladunalexander.jwt.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Alexander Gladun
 */
public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);
}
