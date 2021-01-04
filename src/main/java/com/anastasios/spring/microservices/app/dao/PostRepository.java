package com.anastasios.spring.microservices.app.dao;

import com.anastasios.spring.microservices.app.beans.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
