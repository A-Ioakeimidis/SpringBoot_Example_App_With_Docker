package com.anastasios.spring.microservices.app.dao;

import com.anastasios.spring.microservices.app.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
