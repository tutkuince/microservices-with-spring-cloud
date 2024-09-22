package com.incetutku.restapidevelopmentbasics.repository;

import com.incetutku.restapidevelopmentbasics.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
