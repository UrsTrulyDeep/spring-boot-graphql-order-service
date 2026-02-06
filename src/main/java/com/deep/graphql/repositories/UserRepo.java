package com.deep.graphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deep.graphql.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    //custom query methods
    //custom query methods
}
